package com.GameAdministration.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class Test {
	
	@RequestMapping(value = "hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping(value = "love")
	public String love(){
		return "我爱你";
	}

}
