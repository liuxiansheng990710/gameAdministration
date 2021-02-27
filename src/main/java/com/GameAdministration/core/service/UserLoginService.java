package com.GameAdministration.core.service;

public interface UserLoginService {
	
	//检查用户登录
	public String checkUserLogin(String userName);
	
	//用户信息注册
	public boolean registerUserLoginInfo(String userName,String password); 
}
