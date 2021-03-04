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
import com.GameAdministration.core.service.ShoppingService;
import com.GameAdministration.exception.GlobalCode;

@RestController
@RequestMapping(value = "/api")
public class ShoppingController {
	
	@Autowired
	ShoppingService shoppingService;
	
	@GetMapping(value = "/allCommodity")
	public ResultMessage<Map<String,Object>> allCommodity(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allCommodity = shoppingService.allCommodity();
		if(allCommodity != null && allCommodity.size()>0){
			map.put("data", allCommodity);
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
	
	@GetMapping(value = "/getCommodity")
	public ResultMessage<Map<String,Object>> getCommodity(String str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> getCommodity = shoppingService.getCommodity(str);
		if(getCommodity != null && getCommodity.size()>0){
			map.put("data", getCommodity);
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
	
	@PostMapping(value = "/offCommodity")
	public ResultMessage<Map<String,Object>> offCommodity(BigInteger id){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean offCommodity = shoppingService.offCommodity(id);
		if(offCommodity != false){
			message.setOk(offCommodity);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(offCommodity);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/addSaleTime")
	public ResultMessage<Map<String,Object>> addSaleTime(BigInteger id){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean addSaleTime = shoppingService.addSaleTime(id);
		if(addSaleTime != false){
			message.setOk(addSaleTime);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(addSaleTime);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}

}
