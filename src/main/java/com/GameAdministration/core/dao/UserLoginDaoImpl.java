package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginDaoImpl implements UserLoginDao{

	@Autowired
	@Qualifier(value = "userJdbcTemplate")
	private JdbcTemplate userJdbcTemplate;

	@Override
	public List<Map<String,Object>> getUserLoginInfo(String userName) {
		String sql = "select * from userinfo where username = ?";
		List<Map<String,Object>> list = userJdbcTemplate.queryForList(sql,userName);
		return list;
	}

	@Override
	public int registerUserLoginInfo(String userName, String password) {
		String sql = "insert into userinfo (username,password) values(?,?)";
		int update = userJdbcTemplate.update(sql,userName,password);
		return update;
	}

	@Override
	public int getUserState(String userName) {
		StringBuilder sql = new StringBuilder();
		sql.append("select state from userinfo where username = '").append(userName).append("' ");
		int queryForObject = userJdbcTemplate.queryForObject(sql.toString(), Integer.class).intValue();
		return queryForObject;
	}

	@Override
	public List<Map<String, Object>> getAllLoginExamine() {
		String sql = "select * from userinfo where uid <> 1003";
		List<Map<String,Object>> queryForList = userJdbcTemplate.queryForList(sql);
		return queryForList;
	}

	@Override
	public int loginExamine(BigInteger uid) {
		String sql = "update userinfo set state = 1 where uid = ?";
		int update = userJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public int recall(BigInteger uid) {
		String sql = "update userinfo set state = 0 where uid = ?";
		int update = userJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public int getStateByUid(BigInteger uid) {
		StringBuilder  sql = new StringBuilder();
		sql.append("select state from userinfo where uid = ").append(uid);
		int intValue = userJdbcTemplate.queryForObject(sql.toString(), Integer.class).intValue();
		return intValue;
	}
	
}
