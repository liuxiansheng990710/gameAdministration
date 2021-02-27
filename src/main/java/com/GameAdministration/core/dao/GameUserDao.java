package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface GameUserDao {

	//获取所有游戏用户信息
	public List<Map<String,Object>> allGameUsers();
	
	//用户充值
	public int balanceRecharge(BigInteger uid);
	
	//核查用户是否是会员
	public boolean checkVip(BigInteger uid);
	
	//添加会员
	public boolean addVip(BigInteger uid);
	
	//更改用户状态
	public int updateState(BigInteger uid);
	
	//根据用户id获取用户信息
	public List<Map<String,Object>> getUsersById(BigInteger uid);
	
	//根据用户名获取用户信息
	public List<Map<String,Object>> getUsersByName(String name);
	
	//获取所有黑名单用户
	public List<Map<String,Object>> getBlankList();
	
	//注销用户
	public int cancellUser(BigInteger uid);
	
	//解封用户
	public int lifitUser(BigInteger uid);
	
	//根据用户id获取黑名单用户信息
	public List<Map<String,Object>> getBlankListById(BigInteger uid);
		
	//根据用户名获取黑名单用户信息
	public List<Map<String,Object>> getBlankListByName(String name);
}
