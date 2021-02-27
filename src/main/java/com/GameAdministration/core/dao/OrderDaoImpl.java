package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Map<String, Object>> allOrders() {
		String sql  = "select * from gameuser where not is null(orderlist) and state = 1";
		
		return null;
	}

	@Override
	public int deleteOrder(BigInteger uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int timeOrder(BigInteger uid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
