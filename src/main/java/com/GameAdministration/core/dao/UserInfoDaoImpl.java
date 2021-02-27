package com.GameAdministration.core.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.GameAdministration.util.MD5Util;

@Repository
public class UserInfoDaoImpl implements UserInfoDao{
	
	@Autowired
	@Qualifier(value = "userJdbcTemplate")
	private JdbcTemplate userJdbcTemplate;

	@Override
	public int updateUserPassword(String userName,String password) {
		String sql = "update userinfo set password = ? where username = ?";
		String newPassword = MD5Util.createBase64Encoder(password);
		int update = userJdbcTemplate.update(sql, newPassword,userName);
		return update;
	}

	@Override
	public String getOldPassword(String userName) {
		String sql = "select password from userinfo where username = ?";
		Map<String, Object> map = userJdbcTemplate.queryForMap(sql, userName);
		String oldPassword = map.get("password").toString();
		return oldPassword;
	}
}
