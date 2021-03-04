package com.GameAdministration.core.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.auxiliary.Constants;
import com.GameAdministration.auxiliary.ResultMessage;
import com.GameAdministration.baseinfo.UserInfo;
import com.GameAdministration.core.service.UserInfoSerivce;
import com.GameAdministration.core.service.UserLoginService;
import com.GameAdministration.exception.GlobalCode;

@RestController
@RequestMapping(value = "/api")
public class UserInfoController {

	@Autowired
	UserInfoSerivce userInfoService;
	
	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping(value = "/changePassword")
	public ResultMessage<Map<String,Object>> changePassword(@RequestBody UserInfo userInfo){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		String userName = userInfo.getUsername();
		String password = userInfo.getPassword();
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			message.setOk(false);
			message.setCode(GlobalCode.SIGN_FAILED.getCode());
			message.setCodeMessage(GlobalCode.SIGN_FAILED.getMessage());
			return message; 
		}
		String checkUserLogin = userLoginService.checkUserLogin(userName);
		if(checkUserLogin.endsWith(Constants.noInformation)){
			message.setOk(false);
			message.setCode(GlobalCode.ACCOUNT_NONTHING.getCode());
			message.setCodeMessage(GlobalCode.ACCOUNT_NONTHING.getMessage());
			return message;
		}
		if(password.contains(checkUserLogin)){
			message.setOk(false);
			message.setCode(GlobalCode.PASSWORD_SIMILAR.getCode());
			message.setCodeMessage(GlobalCode.PASSWORD_SIMILAR.getMessage());
			return message;
		}
		boolean updateUserPassword = userInfoService.updateUserPassword(userName, password);
		if(updateUserPassword != false){
			message.setOk(true);
			message.setCode(GlobalCode.UPDATE_SUCCESS.getCode());
			message.setCodeMessage(GlobalCode.UPDATE_SUCCESS.getMessage());
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.UPDATE_FAILED.getCode());
		message.setCodeMessage(GlobalCode.UPDATE_FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/getAllLoginExamine")
	public ResultMessage<Map<String,Object>> getAllLoginExamine(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allLoginExamine = userLoginService.getAllLoginExamine();
		if(allLoginExamine != null && allLoginExamine.size()>0){
			map.put("data", allLoginExamine);
			message.setOk(true);
			message.setData(map);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/loginExamine")
	public ResultMessage<Map<String,Object>> loginExamine(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean loginExamine = userLoginService.loginExamine(uid);
		if(loginExamine != false){
			message.setOk(loginExamine);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(loginExamine);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/recall")
	public ResultMessage<Map<String,Object>> recall(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean recall = userLoginService.recall(uid);
		if(recall != false){
			message.setOk(recall);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(recall);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
}
