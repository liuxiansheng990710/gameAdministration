package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface GameUserService {

	//获取所有游戏用户信息
	public List<Map<String,Object>> allGameUsers();
	
	//用户充值
	public boolean balanceRecharge(BigInteger uid);
	
	//添加会员
	public boolean addVip(BigInteger uid);
	
	//更改用户状态
	public boolean updateState(BigInteger uid);
	
	//根据uid或者用户名获取用户信息
	public List<Map<String,Object>> getUsersByUidOrName(String str);
	
	//获取所有黑名单用户
	public Object getBlankList();
	
	//注销用户
	public boolean cancellUser(BigInteger uid);
		
	//解封用户
	public boolean lifitUser(BigInteger uid);
	
	//根据uid或者用户名获取黑名单用户信息
	public List<Map<String,Object>> getBlankListByUidOrName(String str);
	
	//刷新黑名单缓存
	public boolean refreshBlackList();
	
}
