package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface UserLoginService {
	
	//检查用户登录
	public String checkUserLogin(String userName);
	
	//校验用户状态
	public boolean checkState(String userName);
	
	//用户信息注册
	public boolean registerUserLoginInfo(String userName,String password);
	
	//获取所有待审登录用户
	public List<Map<String,Object>> getAllLoginExamine();
	
	//审核用户登录
	public boolean loginExamine(BigInteger uid);
	
	//回收权限
	public boolean recall(BigInteger uid);
}
