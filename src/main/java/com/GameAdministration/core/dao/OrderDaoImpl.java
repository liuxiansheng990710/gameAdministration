package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	private JdbcTemplate gameJdbcTemplate;

	@Override
	public List<Map<String, Object>> allOrders() {
		String sql  = "select * from gameuser where state = 1 and orderstate = 1 and orderlist is not null";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public int deleteOrder(BigInteger uid) {
		String sql = "update gameuser set orderlist = null where orderstate = 1 and uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public int timeOrder(BigInteger uid) {
		String sql = "update gameuser set remainingtime = remainingtime + 30 where uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public List<Map<String, Object>> getOrderByUid(BigInteger uid) {
		String sql  = "select * from gameuser where state = 1 and orderstate = 1 and orderlist is not null and uid = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,uid);
		return list;
	}

	@Override
	public List<Map<String, Object>> getOrderByNumber(BigInteger orderlist) {
		String sql = ("select * from gameuser where state = 1 and orderstate = 1 and orderlist = ?");
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,orderlist);
		return list;
	}

	@Override
	public List<Map<String, Object>> allPaidOrders() {
		String sql  = "select * from gameuser where state = 1 and orderstate = 2 and orderlist is not null";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public int updateOrderState(BigInteger uid,int orderamount) {
		String sql = "update gameuser set orderstate = 1 , balance = balance + ? where uid = ?";
		int update = gameJdbcTemplate.update(sql,orderamount,uid);
		return update;
	}

	@Override
	public int getOrderaMount(BigInteger uid) {
		StringBuilder sql  =  new StringBuilder("select orderamount from gameuser where uid = ");
		sql.append(uid);
		int orderamount = gameJdbcTemplate.queryForObject(sql.toString(), Integer.class);
		return orderamount;
	}

	@Override
	public int deletePaidOrder(BigInteger uid, int orderMount) {
		String sql = "update gameuser set orderlist = null,balance = balance + ? where orderstate = 2 and uid = ?";
		int update = gameJdbcTemplate.update(sql,orderMount,uid);
		return update;
	}

	@Override
	public List<Map<String, Object>> getPaidOrderByUid(BigInteger uid) {
		String sql  = "select * from gameuser where state = 1 and orderstate = 2 and orderlist is not null and uid = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,uid);
		return list;
	}

	@Override
	public List<Map<String, Object>> getPaidOrderByNumber(BigInteger orderlist) {
		String sql = ("select * from gameuser where state = 1 and orderstate = 2 and orderlist = ?");
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,orderlist);
		return list;
	}

}
