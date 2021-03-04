package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface OrderDao {
	
	//获取所有待支付订单信息
	public List<Map<String,Object>> allOrders();
	
	//取消待支付订单
	public int deleteOrder(BigInteger uid);
	
	//待支付订单延时
	public int timeOrder(BigInteger uid);
	
	//根据uid查询待支付订单信息
	public List<Map<String,Object>> getOrderByUid(BigInteger uid);
	
	//根据订单号查询待支付订单信息
	public List<Map<String,Object>> getOrderByNumber(BigInteger orderlist);
	
	//获取所有已支付订单信息
	public List<Map<String,Object>> allPaidOrders();
	
	//更改订单状态并将消费金额累加至余额
	public int updateOrderState(BigInteger uid,int orderamount);
	
	//获取消费金额信息
	public int getOrderaMount(BigInteger uid);
	
	//取消已支付订单
	public int deletePaidOrder(BigInteger uid,int orderMount);
	
	//根据uid查询已支付订单信息
	public List<Map<String,Object>> getPaidOrderByUid(BigInteger uid);
		
	//根据订单号查询已支付订单信息
	public List<Map<String,Object>> getPaidOrderByNumber(BigInteger orderlist);

}
