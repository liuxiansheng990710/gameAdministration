package com.GameAdministration.baseinfo;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author YP
 * @Description: 后台管理系统用户基本信息
 * @param:  
 * @date:     2021年2月19日下午3:13:11
 * 
 */
@Getter
@Setter
public class UserInfo {
	
	private BigInteger id;
	private String username;
	private String password;

}
