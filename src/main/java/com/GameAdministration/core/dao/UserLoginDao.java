package com.GameAdministration.core.dao;

import java.util.List;
import java.util.Map;

public interface UserLoginDao {
	
	//查找用户登录信息
	public List<Map<String,Object>> getUserLoginInfo(String userName);
	
}
