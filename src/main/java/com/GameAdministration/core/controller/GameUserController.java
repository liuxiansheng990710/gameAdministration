package com.GameAdministration.core.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.Auxiliary.ResultMessage;
import com.GameAdministration.core.service.GameUserService;
import com.GameAdministration.Exception.GlobalCode;


@RestController
@RequestMapping(value = "/api")
public class GameUserController {
	
	@Autowired
	GameUserService gameUserService;
	
	@GetMapping(value = "/allGameUsers")
	public ResultMessage<Map<String,Object>> allGameUsers(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allGameUsers = gameUserService.allGameUsers();
		if(allGameUsers != null && allGameUsers.size()>0){
			map.put("data", allGameUsers);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/balanceRecharge")
	public ResultMessage<Map<String,Object>> balanceRecharge(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean balanceRecharge = gameUserService.balanceRecharge(uid);
		if(balanceRecharge != false){
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/addvip")
	public ResultMessage<Map<String,Object>> addVip(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean addVip = gameUserService.addVip(uid);
		if(addVip != false){
			message.setOk(addVip);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(addVip);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/updateState")
	public ResultMessage<Map<String,Object>> updateState(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean updateState = gameUserService.updateState(uid);
		if(updateState != false){
			message.setOk(updateState);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(updateState);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/findUsersByUidOrName")
	public ResultMessage<Map<String,Object>> findUsersByUidOrName(String str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(str)){
			ResultMessage<Map<String,Object>> message2 = allGameUsers();
			return message2;
		}
		List<Map<String,Object>> usersByUidOrName = gameUserService.getUsersByUidOrName(str);
		if(usersByUidOrName != null && usersByUidOrName.size()>0){
			map.put("data", usersByUidOrName);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}

	@GetMapping(value = "/getBlankList")
	public ResultMessage<Map<String,Object>> getBlankList(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> blankList = gameUserService.getBlankList();
		if(blankList != null && blankList.size()>0){
			map.put("data", blankList);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/cancellUser")
	public ResultMessage<Map<String,Object>> cancellUser(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean cancellUser = gameUserService.cancellUser(uid);
		if(cancellUser != false){
			message.setOk(cancellUser);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(cancellUser);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/lifitUser")
	public ResultMessage<Map<String,Object>> lifitUser(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean lifitUser = gameUserService.lifitUser(uid);
		if(lifitUser != false){
			message.setOk(lifitUser);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(lifitUser);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/findBlankListByUidOrName")
	public ResultMessage<Map<String,Object>> findBlankListByUidOrName(String str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(str)){
			ResultMessage<Map<String,Object>> message2 = getBlankList();
			return message2;
		}
		List<Map<String,Object>> usersByUidOrName = gameUserService.getBlankListByUidOrName(str);
		if(usersByUidOrName != null && usersByUidOrName.size()>0){
			map.put("data", usersByUidOrName);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
}
