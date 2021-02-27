package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameUserDaoImpl implements GameUserDao{
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	private JdbcTemplate gameJdbcTemplate;

	@Override
	public List<Map<String, Object>> allGameUsers() {
		String sql = "select * from gameuser where state = 1";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public int balanceRecharge(BigInteger uid) {
		String sql = "update gameuser set balance = balance+1000 where uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public boolean checkVip(BigInteger uid) {
		StringBuilder sql = new StringBuilder();
		sql.append("select vip from gameuser where uid = ").append(uid);
		int queryForObject = gameJdbcTemplate.queryForObject(sql.toString(),int.class).intValue();
		if(queryForObject == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean addVip(BigInteger uid) {
		String sql = "update gameuser set vip = 1 where uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		if(update>0){
			return true;
		}
		return false;
	}

	@Override
	public int updateState(BigInteger uid) {
		String sql = "update gameuser set state = 2 where uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public List<Map<String, Object>> getUsersById(BigInteger uid) {
		String sql = "select * from gameuser where state = 1 and uid = ?";
		List<Map<String,Object>> queryForList = gameJdbcTemplate.queryForList(sql,uid);
		return queryForList;
	}

	@Override
	public List<Map<String, Object>> getUsersByName(String name) {
		String sql = "select * from gameuser where state = 1 and name = ?";
		List<Map<String,Object>> queryForList = gameJdbcTemplate.queryForList(sql,name);
		return queryForList;
	}

	@Override
	public List<Map<String, Object>> getBlankList() {
		String sql = "select * from gameuser where state = 2";
		List<Map<String,Object>> queryForList = gameJdbcTemplate.queryForList(sql);
		return queryForList;
	}

	@Override
	public int cancellUser(BigInteger uid) {
		String sql = "update gameuser set state = 0 where uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public int lifitUser(BigInteger uid) {
		String sql = "update gameuser set state = 1 where uid = ?";
		int update = gameJdbcTemplate.update(sql,uid);
		return update;
	}

	@Override
	public List<Map<String, Object>> getBlankListById(BigInteger uid) {
		String sql = "select * from gameuser where state = 2 and uid = ?";
		List<Map<String,Object>> queryForList = gameJdbcTemplate.queryForList(sql,uid);
		return queryForList;
	}

	@Override
	public List<Map<String, Object>> getBlankListByName(String name) {
		String sql = "select * from gameuser where state = 2 and name = ?";
		List<Map<String,Object>> queryForList = gameJdbcTemplate.queryForList(sql,name);
		return queryForList;
	}

}
