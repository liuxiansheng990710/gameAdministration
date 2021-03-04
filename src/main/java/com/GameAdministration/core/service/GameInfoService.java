package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface GameInfoService {

	//获取所有游戏信息
	public List<Map<String,Object>> findAllGames();
	
	//根据类型获取所有游戏信息
	public List<Map<String,Object>> findGamesByCode(String title);
	
	//下线游戏
	public boolean offGame(BigInteger gameId);
	
	// 获取待审核游戏
	public List<Map<String, Object>> findAllExamineGames();

	// 审核游戏
	public boolean examineGames(BigInteger gameId);
	
	//根据游戏Id获取待审核游戏
	public List<Map<String,Object>> findExamineGamesById(BigInteger gameId);
	
	//赠送永久道具
	public boolean addProp(BigInteger uid);
	
	//下放BUG
	public boolean solveBug(BigInteger gameId);
	
	//下降当前游戏bug程度
	public boolean updateBug(BigInteger gameId);
	
	//提升当前游戏bug程度
	public boolean upBug(BigInteger gameId);
	
	//已上线游戏打回重审
	public boolean reexAmine(BigInteger gameId);
}
