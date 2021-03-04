package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DrawAdminDaoImpl implements DrawAdminDao{
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	private JdbcTemplate gameJdbcTemplate;

	@Override
	public List<Map<String, Object>> allDraw() {
		String sql = "select  * from gamedraw where state = 1";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public List<Map<String, Object>> getDrawById(BigInteger gameId) {
		String sql = "select * from gamedraw where state = 1 and gameId = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,gameId);
		return list;
	}

	@Override
	public List<Map<String, Object>> getDrawByName(String name) {
		String sql = "select * from gamedraw where state = 1 and name = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,name);
		return list;
	}

	@Override
	public int offDraw(BigInteger gameId) {
		String sql = "update gamedraw set state = 2 where gameId = ?";
		int update = gameJdbcTemplate.update(sql,gameId);
		return update;
	}

	@Override
	public int addNumber(BigInteger gameId) {
		String sql = "update gamedraw set number = number + 3 where gameId = ?";
		int update = gameJdbcTemplate.update(sql,gameId);
		return update;
	}

	@Override
	public int reduceProbability(BigInteger gameId) {
		String sql = "update gamedraw set nowprobability = nowprobability - 0.0008 where gameId = ?";
		int update = gameJdbcTemplate.update(sql,gameId);
		return update;
	}

	@Override
	public int upProbability(BigInteger gameId) {
		String sql = "update gamedraw set nowprobability = nowprobability + 0.0002 where gameId = ?";
		int update = gameJdbcTemplate.update(sql,gameId);
		return update;
	}

	@Override
	public int addTime(BigInteger gameId) {
		String sql = "update gamedraw set time = time + 1440 where gameId = ?";
		int update = gameJdbcTemplate.update(sql,gameId);
		return update;
	}

}
