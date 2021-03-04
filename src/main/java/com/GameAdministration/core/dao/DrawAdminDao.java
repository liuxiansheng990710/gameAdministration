package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface DrawAdminDao {
	
	//获取所有抽奖信息
	public List<Map<String,Object>> allDraw();
	
	//根据id获取抽奖信息
	public List<Map<String,Object>> getDrawById(BigInteger gameId);
	
	//根据名字获取抽奖信息
	public List<Map<String,Object>> getDrawByName(String name);
	
	//下线抽奖
	public int offDraw(BigInteger gameId);
	
	//增加大量数量
	public int addNumber(BigInteger gameId);
	
	//降低概率
	public int reduceProbability(BigInteger gameId);
	
	//提高概率
	public int upProbability(BigInteger gameId);
	
	//延长时间
	public int addTime(BigInteger gameId);

}
