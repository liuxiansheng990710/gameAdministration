package com.GameAdministration.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateConfig {

	@Primary
	@Bean(name = "userJdbcTemplate")
	public JdbcTemplate userJdbcTemplate(@Qualifier("ds1DataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "gameJdbcTemplate")
	public JdbcTemplate gameJdbcTemplate(@Qualifier("ds2DataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
}
