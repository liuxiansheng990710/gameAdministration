package com.GameAdministration.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.auxiliary.Constants;
import com.GameAdministration.core.dao.UserLoginDao;
import com.GameAdministration.util.MD5Util;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	UserLoginDao userLoginDao;
	
	@Override
	public String checkUserLogin(String userName) {
		List<Map<String,Object>> list = userLoginDao.getUserLoginInfo(userName);
		if(list.size() > 0 && list != null){
			String password = list.get(0).get("password").toString();
			String base64Decoder = MD5Util.getBase64Decoder(password);
			return base64Decoder;
		}
		return Constants.noInformation;
	}

	@Override
	public boolean registerUserLoginInfo(String userName, String password) {
		String md5Password = MD5Util.createBase64Encoder(password);
		int registerUserLoginInfo = userLoginDao.registerUserLoginInfo(userName, md5Password);
		if(registerUserLoginInfo != 0){
			return true;
		}
		return false;
	}

}
