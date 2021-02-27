package com.GameAdministration.core.service;

public interface UserInfoSerivce {

	//修改密码
	public boolean updateUserPassword(String userName , String password);

	//获取用户原密码
	public String getOldPassword(String userName);
}
