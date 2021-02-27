package com.GameAdministration.core.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.auxiliary.Constants;
import com.GameAdministration.auxiliary.ResultMessage;
import com.GameAdministration.baseinfo.UserInfo;
import com.GameAdministration.core.service.UserLoginService;
import com.GameAdministration.exception.GlobalCode;

@RestController
@CrossOrigin
public class UserLoginController {
	
	@Autowired
	UserLoginService	userLoginService;
	
	@PostMapping(value = "api/login")
	public ResultMessage<Map<String,Object>> login(@RequestBody UserInfo userInfo , HttpSession session){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		String checkUserLogin = userLoginService.checkUserLogin(userInfo.getUsername());
		boolean equals = userInfo.getPassword().equals(checkUserLogin);
		if(StringUtils.isBlank(userInfo.getUsername()) || StringUtils.isBlank(userInfo.getPassword())){
			message.setOk(false);
			message.setCode(GlobalCode.SIGN_FAILED.getCode());
			message.setCodeMessage(GlobalCode.SIGN_FAILED.getMessage());
			return message; 
		}else if(checkUserLogin.equals(Constants.noInformation)){
			message.setOk(false);
			message.setCode(GlobalCode.ACCOUNT_NONTHING.getCode());
			message.setCodeMessage(GlobalCode.ACCOUNT_NONTHING.getMessage());
			return message;
		}else if(equals == false){
			message.setOk(false);
			message.setCode(GlobalCode.PASSWORD_WRONG.getCode());
			message.setCodeMessage(GlobalCode.PASSWORD_WRONG.getMessage());
			return message;
		}else if(!checkUserLogin.equals(Constants.noInformation) && equals != false){
			message.setOk(true);
			message.setCode(GlobalCode.SIGN_SUCCESS.getCode());
			message.setCodeMessage(GlobalCode.SIGN_SUCCESS.getMessage());
			return message;
		}
//		session.setAttribute("username", userInfo.getUsername());
		return message;
	}
	
}
