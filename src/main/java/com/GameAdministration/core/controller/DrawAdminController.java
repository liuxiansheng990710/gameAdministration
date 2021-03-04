package com.GameAdministration.core.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.auxiliary.ResultMessage;
import com.GameAdministration.core.service.DrawAdminService;
import com.GameAdministration.exception.GlobalCode;

@RestController
@RequestMapping(value = "api")
public class DrawAdminController {
	
	@Autowired
	DrawAdminService drawAdminService;
	
	@GetMapping(value = "/allDraw")
	public ResultMessage<Map<String,Object>> allDraw(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allDraw = drawAdminService.allDraw();
		if(allDraw!=null && allDraw.size()>0){
			map.put("data", allDraw);
			message.setOk(true);
			message.setData(map);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(false);
		message.setData(map);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/getDraw")
	public ResultMessage<Map<String,Object>> getDraw(String str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allDraw = drawAdminService.getDraw(str);
		if(allDraw!=null && allDraw.size()>0){
			map.put("data", allDraw);
			message.setOk(true);
			message.setData(map);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(false);
		message.setData(map);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/offDraw")
	public ResultMessage<Map<String,Object>> offDraw(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean offDraw = drawAdminService.offDraw(gameId);
		if(offDraw != false){
			message.setOk(offDraw);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(offDraw);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/addNumber")
	public ResultMessage<Map<String,Object>> addNumber(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean addNumber = drawAdminService.addNumber(gameId);
		if(addNumber != false){
			message.setOk(addNumber);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(addNumber);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/reduceProbability")
	public ResultMessage<Map<String,Object>> reduceProbability(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean reduceProbability = drawAdminService.reduceProbability(gameId);
		if(reduceProbability != false){
			message.setOk(reduceProbability);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(reduceProbability);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/upProbability")
	public ResultMessage<Map<String,Object>> upProbability(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean upProbability = drawAdminService.upProbability(gameId);
		if(upProbability != false){
			message.setOk(upProbability);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(upProbability);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/addTime")
	public ResultMessage<Map<String,Object>> addTime(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean addTime = drawAdminService.addTime(gameId);
		if(addTime != false){
			message.setOk(addTime);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(addTime);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}

}
