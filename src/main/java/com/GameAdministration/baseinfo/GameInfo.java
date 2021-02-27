package com.GameAdministration.baseinfo;

import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author YP
 * @Description: 游戏基本信息
 * @param:  
 * @date:     2021年2月25日下午4:50:06
 * 
 */
@Getter
@Setter
public class GameInfo {

	private BigInteger gameId;
	private String name;
	private String author;
	private String title;
	private int code;
	private Date date;
	private int version;
	private String brief;
	private int safe;
	
}
