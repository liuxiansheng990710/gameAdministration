package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.core.dao.GameInfoDao;
import com.GameAdministration.core.dao.GameUserDao;

@Service
@Transactional
public class GameInfoServiceImpl implements GameInfoService{
	
	@Autowired
	GameInfoDao gameInfoDao;
	
	@Autowired
	GameUserDao gameUserDao;

	@Override
	public List<Map<String, Object>> findAllGames() {
		List<Map<String,Object>> findAllGames = gameInfoDao.findAllGames();
		return findAllGames;
	}

	@Override
	public List<Map<String, Object>> findGamesByCode(String title) {
		List<Map<String,Object>> list = gameInfoDao.findGamesByCode(title);
		return list;
	}

	@Override
	public boolean offGame(BigInteger gameId) {
		int offGame = gameInfoDao.offGame(gameId);
		if(offGame>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> findAllExamineGames() {
		List<Map<String,Object>> findAllExamineGames = gameInfoDao.findAllExamineGames();
		return findAllExamineGames;
	}

	@Override
	public boolean examineGames(BigInteger gameId) {
		int bug = gameInfoDao.getBug(gameId);
		if(bug > 0){
			return false;
		}
		int examineGames = gameInfoDao.examineGames(gameId);
		if(examineGames>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> findExamineGamesById(BigInteger gameId) {
		List<Map<String,Object>> findExamineGamesById = gameInfoDao.findExamineGamesById(gameId);
		return findExamineGamesById;
	}

	@Override
	public boolean addProp(BigInteger uid) {
		List<Map<String,Object>> usersById = gameUserDao.getUsersById(uid);
		String prop = usersById.get(0).get("props").toString();
		if(prop.contains("飞天猪")){
			return false;
		}
		int addProp = gameInfoDao.addProp(uid, prop);
		if(addProp>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean solveBug(BigInteger gameId) {
		int bug = gameInfoDao.getBug(gameId);
		if(bug>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBug(BigInteger gameId) {
		int bug = gameInfoDao.getBug(gameId);
		if(bug == 2){
			int updateBug = gameInfoDao.updateBug(gameId, 1);
			if(updateBug>0){
				return true;
			}
			return false;
		}else if(bug ==1){
			int updateBug = gameInfoDao.updateBug(gameId, 0);
			if(updateBug>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean upBug(BigInteger gameId) {
		int bug = gameInfoDao.getBug(gameId);
		if(bug == 0){
			int updateBug = gameInfoDao.updateBug(gameId, 1);
			if(updateBug>0){
				return true;
			}
			return false;
		}
		if(bug == 1){
			int updateBug = gameInfoDao.updateBug(gameId, 2);
			if(updateBug>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean reexAmine(BigInteger gameId) {
		int reexAmine = gameInfoDao.reexAmine(gameId);
		if(reexAmine>0){
			return true;
		}
		return false;
	}

}
