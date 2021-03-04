package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface DrawAdminService {
	
	//获取所有抽奖信息
	public List<Map<String,Object>> allDraw();
	
	//根据id或名字获取抽奖信息
	public List<Map<String,Object>> getDraw(String str);
		
	//下线抽奖
	public boolean offDraw(BigInteger gameId);
		
	//增加大量数量
	public boolean addNumber(BigInteger gameId);
		
	//降低概率
	public boolean reduceProbability(BigInteger gameId);
		
	//提高概率
	public boolean upProbability(BigInteger gameId);
		
	//延长时间
	public boolean addTime(BigInteger gameId);

}
