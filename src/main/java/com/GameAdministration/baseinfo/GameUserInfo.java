package com.GameAdministration.baseinfo;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author YP
 * @Description: 游戏用户基本信息
 * @param:  
 * @date:     2021年2月25日下午4:50:19
 * 
 */

@Getter
@Setter
public class GameUserInfo {
	
	private BigInteger uid;
	private String name;
	private int state;
	private String order;
	private String balance;
	private String consumption;
	private int vip;

}
