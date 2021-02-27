package com.GameAdministration.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.core.dao.UserInfoDao;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoSerivce{
	
	@Autowired
	UserInfoDao userInfoDao;

	@Override
	public boolean updateUserPassword(String userName, String password) {
		int updateUserPassword = userInfoDao.updateUserPassword(userName, password);
		if(updateUserPassword>0){
			return true;
		}
		return false;
	}

	@Override
	public String getOldPassword(String userName) {
		String oldPassword = userInfoDao.getOldPassword(userName);
		return oldPassword;
	}

}
