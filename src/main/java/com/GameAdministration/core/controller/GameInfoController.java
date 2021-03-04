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

import com.GameAdministration.Auxiliary.Constants;
import com.GameAdministration.Auxiliary.ResultMessage;
import com.GameAdministration.core.service.GameInfoService;
import com.GameAdministration.core.service.GameUserService;
import com.GameAdministration.Exception.GlobalCode;
import com.GameAdministration.util.MD5Util;

@RestController
@RequestMapping("/api")
public class GameInfoController {

	@Autowired
	GameInfoService gameInfoService;
	
	@Autowired
	GameUserService gameUserService;
	
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
	
	@GetMapping(value = "/allProps")
	public ResultMessage<Map<String,Object>> allProps(){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		List<Map<String,Object>> allGameUsers = gameUserService.allGameUsers();
		Map<String,Object> map = new HashMap<String, Object>();
		if(allGameUsers != null && allGameUsers.size()>0){
			map.put("data", allGameUsers);
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
	
	@GetMapping(value = "/getUserProps")
	public ResultMessage<Map<String,Object>> getUserProps(String str){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		List<Map<String,Object>> getUsersByUidOrName = gameUserService.getUsersByUidOrName(str);
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(str)){
			ResultMessage<Map<String,Object>> message2 = allProps();
			return message2;
		}
		if(getUsersByUidOrName != null && getUsersByUidOrName.size()>0){
			map.put("data", getUsersByUidOrName);
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
	
	@PostMapping(value = "/addProp")
	public ResultMessage<Map<String,Object>> addProp(BigInteger uid){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean addProp = gameInfoService.addProp(uid);
		if(addProp != false){
			message.setOk(addProp);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(addProp);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/solveBug")
	public ResultMessage<Map<String,Object>> solveBug(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean solveBug = gameInfoService.solveBug(gameId);
		if(solveBug != false){
			message.setOk(solveBug);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(solveBug);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/updateBug")
	public ResultMessage<Map<String,Object>> updateBug(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean updateBug = gameInfoService.updateBug(gameId);
		if(updateBug != false){
			message.setOk(updateBug);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(updateBug);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/upBug")
	public ResultMessage<Map<String,Object>> upBug(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean upBug = gameInfoService.upBug(gameId);
		if(upBug != false){
			message.setOk(upBug);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(upBug);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/reexAmine")
	public ResultMessage<Map<String,Object>> reexAmine(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		boolean reexAmine = gameInfoService.reexAmine(gameId);
		if(reexAmine != false){
			message.setOk(reexAmine);
			message.setCode(GlobalCode.SUCCESSFUL.getCode());
			message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
			return message;
		}
		message.setOk(reexAmine);
		message.setCode(GlobalCode.FAILED.getCode());
		message.setCodeMessage(GlobalCode.FAILED.getMessage());
		return message;
	}
	
	@PostMapping(value = "/grantCDK")
	public ResultMessage<Map<String,Object>> grantCDK(BigInteger gameId){
		ResultMessage<Map<String,Object>> message = new ResultMessage<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("data", MD5Util.createBase64Encoder(Constants.baseCDK).toString());
		message.setOk(true);
		message.setCode(GlobalCode.SUCCESSFUL.getCode());
		message.setCodeMessage(GlobalCode.SUCCESSFUL.getMessage());
		return message;
	}
	
	
}
