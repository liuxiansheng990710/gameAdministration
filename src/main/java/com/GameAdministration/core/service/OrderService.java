package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface OrderService {
	
	//获取所有订单信息
	public List<Map<String,Object>> allOrders();
		
	//取消已支付订单订单
	public boolean deleteOrder(BigInteger uid);
		
	//订单延时
	public boolean timeOrder(BigInteger uid);
	
	//根据uid，订单号查询待支付订单信息
	public List<Map<String,Object>> getOrdersByThing(BigInteger str);
	
	//获取所有已支付订单信息
	public List<Map<String,Object>> allPaidOrders();
	
	//回退订单到支付状态
	public boolean backOrder(BigInteger uid);
	
	//取消已支付订单
	public boolean cancelOrder(BigInteger uid);
	
	//根据uid，订单号查询已支付订单信息
	public List<Map<String,Object>> getPaidOrdersByThing(BigInteger str);

}
