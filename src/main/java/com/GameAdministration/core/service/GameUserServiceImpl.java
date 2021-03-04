package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.Auxiliary.Constants;
import com.GameAdministration.core.dao.GameUserDao;

@Service
@Transactional
public class GameUserServiceImpl implements GameUserService{
	
	@Autowired
	GameUserDao gameUserDao;
	
	@Autowired
	@Qualifier(value = "myRedisTemplate")
	private RedisTemplate<String, Object> myRedisTemplate;

	@Override
	public List<Map<String, Object>> allGameUsers() {
		List<Map<String,Object>> allGameUsers = gameUserDao.allGameUsers();
		return allGameUsers;
	}

	@Override
	public boolean balanceRecharge(BigInteger uid) {
		int balanceRecharge = gameUserDao.balanceRecharge(uid);
		if(balanceRecharge>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addVip(BigInteger uid) {
		boolean checkVip = gameUserDao.checkVip(uid);
		if(checkVip != true){
			boolean addVip = gameUserDao.addVip(uid);
			return addVip;
		}
		return false;
	}

	@Override
	public boolean updateState(BigInteger uid) {
		int updateState = gameUserDao.updateState(uid);
		if(updateState>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getUsersByUidOrName(String str) {
		List<Map<String,Object>> byName = gameUserDao.getUsersByName(str);
		if(byName != null && byName.size()>0){
			return byName;
		}
		List<Map<String,Object>> usersById = gameUserDao.getUsersById(BigInteger.valueOf(Long.parseLong(str)));
		return usersById;
	}

	@Override
	public Object getBlankList() {
		Object object = myRedisTemplate.opsForHash().get(Constants.blankListKey, "data");
		if(object != null){
			return object;
		}
		List<Map<String,Object>> blankList = gameUserDao.getBlankList();
		if(blankList!=null&&blankList.size()>0){
			return blankList;
		}
		return null;
	}

	@Override
	public boolean cancellUser(BigInteger uid) {
		int cancellUser = gameUserDao.cancellUser(uid);
		if(cancellUser > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean lifitUser(BigInteger uid) {
		int lifitUser = gameUserDao.lifitUser(uid);
		if(lifitUser > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getBlankListByUidOrName(String str) {
		List<Map<String,Object>> byName = gameUserDao.getBlankListByName(str);
		if(byName != null && byName.size()>0){
			return byName;
		}
		List<Map<String,Object>> usersById = gameUserDao.getBlankListById(BigInteger.valueOf(Long.parseLong(str)));
		return usersById;
	}

	@Override
	public boolean refreshBlackList() {
		List<Map<String,Object>> blankList = gameUserDao.getBlankList();
		myRedisTemplate.delete(Constants.blankListKey);
		HashMap<String,Object> map2 = new HashMap<String,Object>();
		map2.putIfAbsent("data", blankList);
		myRedisTemplate.opsForHash().putAll(Constants.blankListKey, map2);
		return true;
	}
	
}
