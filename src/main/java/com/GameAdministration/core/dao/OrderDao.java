package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface OrderDao {
	
	//获取所有订单信息
	public List<Map<String,Object>> allOrders();
	
	//取消订单
	public int deleteOrder(BigInteger uid);
	
	//订单延时
	public int timeOrder(BigInteger uid);

}
