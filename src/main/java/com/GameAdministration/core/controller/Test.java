package com.GameAdministration.core.controller;


import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.Exception.ApplicationException;
import com.GameAdministration.Exception.GlobalErrorCode;
import com.GameAdministration.util.MD5Util;


@Slf4j
@RestController
@RequestMapping(value = "/test")
public class Test {
	
	@Autowired
	@Qualifier(value = "userJdbcTemplate")
	private JdbcTemplate userJdbcTemplate;
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	private JdbcTemplate gameJdbcTemplate;
	
	@Autowired
	@Qualifier(value = "myRedisTemplate")
	private RedisTemplate<String, Object> myRedisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping(value = "/index")
	public Object index(){
		String sql = "select name from game where uid = 1";
		return gameJdbcTemplate.queryForObject(sql, String.class);
	}
	
	@RequestMapping(value = "/login")
	public Object login(){
		String sql = "select password from userinfo where uid = 10006";
		String object = userJdbcTemplate.queryForObject(sql, String.class);
		return MD5Util.getBase64Decoder(object);
	}
	
	@RequestMapping(value = "/redisTest")
	public Boolean redisTest(){
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add("亚鹏的小可爱1号");
		arrayList.add("密码");
		arrayList.add(21);
		Boolean isok = false;
		myRedisTemplate.opsForValue().set("Test", arrayList);
		isok = true;
		return isok;
	}
	
	@RequestMapping(value = "/exceptionTest")
	public Object exceptionTest(){
		throw new ApplicationException(GlobalErrorCode.SUCCESS);
	}

	@RequestMapping(value = "/md5Test")
	public String md5Test(){
		String str = "liu1069823632";
		String base64Encoder = MD5Util.createBase64Encoder(str);
		System.out.println(base64Encoder);
		String base64Decoder = MD5Util.getBase64Decoder(base64Encoder);
		System.out.println(base64Decoder);
		return base64Decoder;
	}
	
	@RequestMapping(value = "/insertTest")
	public Boolean insertTest(String username,String password){
		if(StringUtils.isBlank(username)){
			return false;
		}
		if(StringUtils.isBlank(password)){
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("insert into userinfo(username,password) values(?,?)");
		String passMD5 = MD5Util.createBase64Encoder(password);
		log.info(passMD5);
		int update = userJdbcTemplate.update(sql.toString(), username,passMD5);
		if(update>=0){
			return true;
		}
		return false;
	}
	
}
