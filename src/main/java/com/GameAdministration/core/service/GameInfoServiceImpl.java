package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.core.dao.GameInfoDao;

@Service
@Transactional
public class GameInfoServiceImpl implements GameInfoService{
	
	@Autowired
	GameInfoDao gameInfoDao;

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

}
