package com.GameAdministration.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class Test {
	
	@Autowired
	@Qualifier(value = "userJdbcTemplate")
	JdbcTemplate userJdbcTemplate;
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	JdbcTemplate gameJdbcTemplate;
	
	@RequestMapping(value = "hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping(value = "love")
	public String love(){
		String sql = "select username from userinfo where uid = 10001";
		return userJdbcTemplate.queryForObject(sql, String.class);
	}
	
	@RequestMapping(value = "love2")
	public String love2(){
		String sql = "select name from game where uid = 1";
		return gameJdbcTemplate.queryForObject(sql, String.class);
	}

}
