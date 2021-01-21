package com.GameAdministration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.service.testser;

@RestController
@RequestMapping(value = "/test")
public class jdbcController {
	
	@Autowired
	testser te;
	
	@RequestMapping(value = "/jdcon")
	public String jdcon(){
		return "hello";
	}
	
	@RequestMapping(value = "/love")
	public String love(){
		String love = te.love();
		return love;
	}

}
