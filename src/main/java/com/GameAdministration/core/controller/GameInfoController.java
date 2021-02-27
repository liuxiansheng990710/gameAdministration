package com.GameAdministration.core.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameAdministration.auxiliary.ResultMessage;
import com.GameAdministration.core.service.GameInfoService;
import com.GameAdministration.exception.GlobalCode;

@RestController
@RequestMapping("/api")
public class GameInfoController {

	@Autowired
	GameInfoService gameInfoService;
	
	@GetMapping(value = "/allGames")
	public ResultMessage<Map<String,Object>> allGames(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		List<Map<String,Object>> findAllGames = gameInfoService.findAllGames();
		Map<String,Object> map = new HashMap<String, Object>();
		if(findAllGames != null && findAllGames.size()>0){
			map.put("data", findAllGames);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/offGame")
	public ResultMessage<Map<String,Object>> offGame(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean offGame = gameInfoService.offGame(gameId);
		if(offGame != false){
			message.setOk(offGame);
			message.setCode(GlobalCode.OFF_SUCESS.getCode());
			message.setCodeMessage(GlobalCode.OFF_SUCESS.getMessage());
			return message;
		}
		message.setOk(offGame);
		message.setCode(GlobalCode.OFF_FAILED.getCode());
		message.setCodeMessage(GlobalCode.OFF_FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/findGamesByCode")
	public ResultMessage<Map<String,Object>> findGamesByCode(String title){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(title)){
			ResultMessage<Map<String,Object>> message2 = allGames();
			return message2;
		}
		List<Map<String,Object>> list = gameInfoService.findGamesByCode(title);
		if(list != null && list.size()>0){
			map.put("data", list);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/allExamineGames")
	public ResultMessage<Map<String,Object>> allExamineGames(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		List<Map<String,Object>> findAllExamineGames = gameInfoService.findAllExamineGames();
		Map<String,Object> map = new HashMap<String, Object>();
		if(findAllExamineGames != null && findAllExamineGames.size()>0){
			map.put("data", findAllExamineGames);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/examineGames")
	public ResultMessage<Map<String,Object>> examineGames(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean examineGames = gameInfoService.examineGames(gameId);
		if(examineGames != false){
			message.setOk(examineGames);
			message.setCode(GlobalCode.EXAMINE_SUCCESS.getCode());
			message.setCodeMessage(GlobalCode.EXAMINE_SUCCESS.getMessage());
			return message;
		}
		message.setOk(examineGames);
		message.setCode(GlobalCode.EXAMINE_FAILED.getCode());
		message.setCodeMessage(GlobalCode.EXAMINE_FAILED.getMessage());
		return message;
	}
	
	@GetMapping(value = "/findExamineGamesById")
	public ResultMessage<Map<String,Object>> findExamineGamesById(BigInteger gameId){
		ResultMessage<Map<String, Object>> message = new ResultMessage<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> findExamineGamesById = gameInfoService.findExamineGamesById(gameId);
		if (findExamineGamesById != null && findExamineGamesById.size() > 0) {
			map.put("data", findExamineGamesById);
			message.setOk(true);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			message.setData(map);
			return message;
		}
		message.setOk(false);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	
}
