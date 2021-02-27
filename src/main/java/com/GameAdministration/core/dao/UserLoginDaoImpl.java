package com.GameAdministration.core.dao;

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
	
}
