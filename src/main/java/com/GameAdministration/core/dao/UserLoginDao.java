package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface UserLoginDao {
	
	//查找用户登录信息
	public List<Map<String,Object>> getUserLoginInfo(String userName);
	
	//查找用户状态信息
	public int getUserState(String userName);
	
	//用户信息注册
	public int registerUserLoginInfo(String userName,String password);
	
	//获取所有待审用户
	public List<Map<String,Object>> getAllLoginExamine();
	
	//审核用户
	public int loginExamine(BigInteger uid);
	
	//回收权限
	public int recall(BigInteger uid);
	
	//根据uid获取用户状态
	public int getStateByUid(BigInteger uid);
}
