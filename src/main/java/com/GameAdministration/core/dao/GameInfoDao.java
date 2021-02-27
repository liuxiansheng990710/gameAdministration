package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface GameInfoDao {

	//获取所有游戏信息
	public List<Map<String,Object>> findAllGames();
	
	//根据类型获取所有游戏信息
	public List<Map<String,Object>> findGamesByCode(String title);
	
	//下线游戏
	public int offGame(BigInteger gameId);
	
	//获取待审核游戏
	public List<Map<String,Object>> findAllExamineGames();
	
	//审核游戏
	public int examineGames(BigInteger gameId);
	
	//根据游戏Id获取待审核游戏
	public List<Map<String,Object>> findExamineGamesById(BigInteger gameId);
}
