package com.GameAdministration.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author YP
 * @Description: Reids配置类		包含redisTemplate以及StringredisTemplate
 * @param:  
 * @date:     2021年1月26日下午3:13:58
 * 
 */

@Configuration
public class RedisConfig {

	@Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
        RedisCacheConfiguration defaultCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                 //设置key为String
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getStringSerializer()))
                 //设置value 为自动转Json的Object
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                 //不缓存null
                .disableCachingNullValues()
                 //缓存数据保存1小时
                .entryTtl(Duration.ofHours(1));
        RedisCacheManager redisCacheManager = RedisCacheManagerBuilder
                 //Redis 连接工厂
                .fromConnectionFactory(redisTemplate.getConnectionFactory())
                 //缓存配置
                .cacheDefaults(defaultCacheConfiguration)
                 //配置同步修改或删除 put/evict
                .transactionAware()
                .build();
        return redisCacheManager;
    }

	
	/**
	 * @param factory	设置redisTemplate<String,Object>形式且设置序列化方式为jackson
	 * @return 
	 */
	@SuppressWarnings("all")
	@Bean(name = "myRedisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    	RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    	template.setConnectionFactory(factory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
	
	
}
