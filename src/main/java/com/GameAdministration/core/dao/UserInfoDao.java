package com.GameAdministration.core.dao;

public interface UserInfoDao {

	//修改密码
	public int updateUserPassword(String userName , String password);
	
	//获取用户原密码
	public String getOldPassword(String userName);
}
