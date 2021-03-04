package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.core.dao.OrderDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;

	@Override
	public List<Map<String, Object>> allOrders() {
		List<Map<String,Object>> list = orderDao.allOrders();
		return list;
	}

	@Override
	public boolean deleteOrder(BigInteger uid) {
		int deleteOrder = orderDao.deleteOrder(uid);
		if(deleteOrder>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean timeOrder(BigInteger uid) {
		int timeOrder = orderDao.timeOrder(uid);
		if(timeOrder>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getOrdersByThing(BigInteger str) {
		List<Map<String, Object>> orderByNumber = orderDao.getOrderByNumber(str);
		if(orderByNumber != null && orderByNumber.size()>0){
			return orderByNumber;
		}
		List<Map<String,Object>> orderByUid = orderDao.getOrderByUid(str);
		return orderByUid;
	}
	
	@Override
	public List<Map<String, Object>> allPaidOrders() {
		List<Map<String,Object>> allPaidOrders = orderDao.allPaidOrders();
		return allPaidOrders;
	}

	@Override
	public boolean backOrder(BigInteger uid) {
		int orderamount = orderDao.getOrderaMount(uid);
		int updateOrderState = orderDao.updateOrderState(uid, orderamount);
		if(updateOrderState > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean cancelOrder(BigInteger uid) {
		int orderamount = orderDao.getOrderaMount(uid);
		int deletePaidOrder = orderDao.deletePaidOrder(uid, orderamount);
		if(deletePaidOrder > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getPaidOrdersByThing(BigInteger str) {
		List<Map<String, Object>> orderByNumber = orderDao.getPaidOrderByUid(str);
		if(orderByNumber != null && orderByNumber.size()>0){
			return orderByNumber;
		}
		List<Map<String,Object>> orderByUid = orderDao.getPaidOrderByNumber(str);
		return orderByUid;
	}
	
	

}
