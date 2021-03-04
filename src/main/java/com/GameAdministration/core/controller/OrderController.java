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

import com.GameAdministration.Auxiliary.ResultMessage;
import com.GameAdministration.core.service.OrderService;
import com.GameAdministration.Exception.GlobalCode;

@RestController
@RequestMapping(value = "/api")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(value = "/allOrders")
	public ResultMessage<Map<String,Object>> allOrders(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allOrders = orderService.allOrders();
		if(allOrders != null &&allOrders.size() > 0){
			map.put("data", allOrders);
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
	
	@PostMapping(value = "/offOrder")
	public ResultMessage<Map<String,Object>> offOrder(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		boolean deleteOrder = orderService.deleteOrder(uid);
		if(deleteOrder != false ){
			message.setOk(deleteOrder);
			message.setData(map);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(deleteOrder);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/timeOrder")
	public ResultMessage<Map<String,Object>> timeOrder(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean timeOrder = orderService.timeOrder(uid);
		if(timeOrder != false ){
			message.setOk(timeOrder);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(timeOrder);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/getOrder")
	public ResultMessage<Map<String,Object>> getOrder(BigInteger str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> ordersByThing = orderService.getOrdersByThing(str);
		if(ordersByThing != null && ordersByThing.size()>0 ){
			map.put("data", ordersByThing);
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
	
	@GetMapping(value = "/allPaidOrders")
	public ResultMessage<Map<String,Object>> allPaidOrders(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> allPaidOrders = orderService.allPaidOrders();
		if(allPaidOrders != null && allPaidOrders.size()>0 ){
			map.put("data", allPaidOrders);
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
	
	@PostMapping(value = "/backOrder")
	public ResultMessage<Map<String,Object>> backOrder(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean backOrder = orderService.backOrder(uid);
		if(backOrder != false ){
			message.setOk(backOrder);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(backOrder);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/cancelOrder")
	public ResultMessage<Map<String,Object>> cancelOrder(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean cancelOrder = orderService.cancelOrder(uid);
		if(cancelOrder != false ){
			message.setOk(cancelOrder);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(cancelOrder);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/getPaidOrder")
	public ResultMessage<Map<String,Object>> getPaidOrder(BigInteger str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> ordersByThing = orderService.getPaidOrdersByThing(str);
		if(ordersByThing != null && ordersByThing.size()>0 ){
			map.put("data", ordersByThing);
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
}
