package com.GameAdministration.core.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.auxiliary.Constants;
import com.GameAdministration.auxiliary.ResultMessage;
import com.GameAdministration.baseinfo.UserInfo;
import com.GameAdministration.core.service.UserLoginService;
import com.GameAdministration.exception.ApplicationException;
import com.GameAdministration.exception.GlobalCode;

@RestController
@RequestMapping(value = "/api")
public class UserLoginController {
	
	@Autowired
	UserLoginService	userLoginService;
	
	@PostMapping(value = "/login")
	public ResultMessage<Map<String,Object>> login(@RequestBody UserInfo userInfo , HttpSession session){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		String checkUserLogin = userLoginService.checkUserLogin(userInfo.getUsername());
		boolean equals = userInfo.getPassword().equals(checkUserLogin);
		try {
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
			}
			else if(!checkUserLogin.equals(Constants.noInformation) && equals != false){
				message.setOk(true);
				message.setCode(GlobalCode.SIGN_SUCCESS.getCode());
				message.setCodeMessage(GlobalCode.SIGN_SUCCESS.getMessage());
				return message;
			}
		} catch (Exception e) {
			throw new ApplicationException(GlobalCode.SIGN_ERROR);
		}
		message.setOk(false);
		message.setCode(GlobalCode.SIGN_ERROR.getCode());
		message.setCodeMessage(GlobalCode.SIGN_ERROR.getMessage());
		return message;
	}
	
	@PostMapping(value = "/register")
	public ResultMessage<Map<String,Object>> register(@RequestBody UserInfo userInfo){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		String checkUserLogin = userLoginService.checkUserLogin(userInfo.getUsername());
		try {
			if(StringUtils.isBlank(userInfo.getUsername()) || StringUtils.isBlank(userInfo.getPassword())){
				message.setOk(false);
				message.setCode(GlobalCode.SIGN_FAILED.getCode());
				message.setCodeMessage(GlobalCode.SIGN_FAILED.getMessage());
				return message; 
			}
			if( !checkUserLogin.equals(Constants.noInformation)){
				message.setOk(false);
				message.setCode(GlobalCode.ACCONUT_EXISTS.getCode());
				message.setCodeMessage(GlobalCode.ACCONUT_EXISTS.getMessage());
				return message;
			}
			boolean register = userLoginService.registerUserLoginInfo(userInfo.getUsername(), userInfo.getPassword());
			message.setOk(register);
			message.setCode(GlobalCode.REGISTER_SUCESS.getCode());
			message.setCodeMessage(GlobalCode.REGISTER_SUCESS.getMessage());
			return message;
		} catch (Exception e) {
			throw new ApplicationException(GlobalCode.REGISTER_ERROR);
		}
	}
	
}
