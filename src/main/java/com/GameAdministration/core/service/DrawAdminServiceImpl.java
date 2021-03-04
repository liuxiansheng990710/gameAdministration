package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.core.dao.DrawAdminDao;

@Service
@Transactional
public class DrawAdminServiceImpl implements DrawAdminService{
	
	@Autowired
	DrawAdminDao drawAdminDao;

	@Override
	public List<Map<String, Object>> allDraw() {
		List<Map<String,Object>> allDraw = drawAdminDao.allDraw();
		return allDraw;
	}

	@Override
	public List<Map<String, Object>> getDraw(String str) {
		List<Map<String,Object>> drawByName = drawAdminDao.getDrawByName(str);
		if(drawByName!=null && drawByName.size()>0){
			return drawByName;
		}
		List<Map<String,Object>> drawById = drawAdminDao.getDrawById(BigInteger.valueOf(Long.parseLong(str)));
		return drawById;
	}

	@Override
	public boolean offDraw(BigInteger gameId) {
		int offDraw = drawAdminDao.offDraw(gameId);
		if(offDraw > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addNumber(BigInteger gameId) {
		int addNumber = drawAdminDao.addNumber(gameId);
		if(addNumber > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean reduceProbability(BigInteger gameId) {
		int reduceProbability = drawAdminDao.reduceProbability(gameId);
		if(reduceProbability > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean upProbability(BigInteger gameId) {
		int upProbability = drawAdminDao.upProbability(gameId);
		if(upProbability > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addTime(BigInteger gameId) {
		int addTime = drawAdminDao.addTime(gameId);
		if(addTime > 0){
			return true;
		}
		return false;
	}

}
