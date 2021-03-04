package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingDaoImpl implements ShoppingDao{
	
	@Autowired
	@Qualifier(value = "gameJdbcTemplate")
	private JdbcTemplate gameJdbcTemplate;

	@Override
	public List<Map<String, Object>> allCommodity() {
		String sql = "select * from shopping where state = 1";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public int offCommodity(BigInteger id) {
		String sql = "update shopping set state = 2 where id = ?";
		int update = gameJdbcTemplate.update(sql,id);
		return update;
	}

	@Override
	public int addSaleTime(BigInteger id) {
		String sql = "update shopping set time = time + 1440 where id = ?";
		int update = gameJdbcTemplate.update(sql,id);
		return update;
	}

	@Override
	public List<Map<String, Object>> getCommodityById(BigInteger id) {
		String sql = "select * from shopping where state = 1 and id = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,id);
		return list;
	}

	@Override
	public List<Map<String, Object>> getCommodityByName(String name) {
		String sql = "select * from shopping where state = 1 and name = ?";
		List<Map<String,Object>> list = gameJdbcTemplate.queryForList(sql,name);
		return list;
	}

}
