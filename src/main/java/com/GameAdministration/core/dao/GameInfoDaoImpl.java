package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameInfoDaoImpl implements GameInfoDao{
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	private JdbcTemplate gameJdbcTemplate;

	@Override
	public List<Map<String, Object>> findAllGames() {
		String sql = "select * from gameinfo where code = 1";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public List<Map<String, Object>> findGamesByCode(String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from gameinfo where code = 1 and title = '").append(title).append("' ");
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql.toString());
		return list;
	}

	@Override
	public int offGame(BigInteger gameId) {
		StringBuilder sql = new StringBuilder();
		sql.append("update gameinfo set code = 2 where gameId = '").append(gameId).append("' ");
		int update = gameJdbcTemplate.update(sql.toString());
		return update;
	}

	@Override
	public List<Map<String, Object>> findAllExamineGames() {
		String sql = "select * from gameinfo where code = 0";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public int examineGames(BigInteger gameId) {
		StringBuilder sql = new StringBuilder();
		sql.append("update gameinfo set code = 1 where gameId = '").append(gameId).append("' ");
		int update = gameJdbcTemplate.update(sql.toString());
		return update;
	}

	@Override
	public List<Map<String, Object>> findExamineGamesById(BigInteger gameId) {
		String sql = "select * from gameinfo where code = 0 and gameId = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql, gameId);
		return list;
	}

	@Override
	public int addProp(BigInteger uid,String prop) {
		StringBuilder sql = new StringBuilder();
		sql.append("update gameuser set props = '");
		if(prop != null){
			sql.append(prop).append(",");
		}
		sql.append("飞天猪' where uid = ").append(uid);
		int update = gameJdbcTemplate.update(sql.toString());
		return update;
	}

	@Override
	public int getBug(BigInteger gameId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select safe from gameinfo where gameId = ").append(gameId);
		int safe = gameJdbcTemplate.queryForObject(sql.toString(), Integer.class);
		return safe;
	}

	@Override
	public int updateBug(BigInteger gameId, int bugGrade) {
		String sql = "update gameinfo set safe = ? where gameId = ?";
		int update = gameJdbcTemplate.update(sql,bugGrade,gameId);
		return update;
	}

	@Override
	public int reexAmine(BigInteger gameId) {
		StringBuilder sql = new StringBuilder();
		sql.append("update gameinfo set code = 0 where gameId = '").append(gameId).append("' ");
		int update = gameJdbcTemplate.update(sql.toString());
		return update;
	}
	
	

}
