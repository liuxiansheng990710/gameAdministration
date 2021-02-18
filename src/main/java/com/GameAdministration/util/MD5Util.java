package com.GameAdministration.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import sun.misc.BASE64Encoder;

import com.GameAdministration.Auxiliary.Constants;
import com.GameAdministration.Exception.ApplicationException;
import com.GameAdministration.Exception.GlobalCode;

/**
 * 
 * @author YP
 * @Description: MD5加密工具类
 * @param:  MD5
 * @date:     2021年1月29日下午1:40:32
 * 
 */
public class MD5Util {
	
	/**
	 * @param str
	 * @return	spring封装的MD5加密方式
	 */
	public static String springMd5(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
	/**
	 * @param md5
	 * @return 截取MD5前N位
	 */
	public static String getTopN(String md5, int index){
		if(StringUtils.isBlank(md5)){
			return null;
		}
		String substring = md5.substring(0, index);
		return substring;
	}
	
	/**
	 * @return 生成Token
	 */
	public static String createToken(){
		String token = (System.currentTimeMillis() + new Random().nextInt(999999999))+"";
		try{
			MessageDigest instance = MessageDigest.getInstance("md5");
			byte[] md5 = instance.digest(token.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		}catch(NoSuchAlgorithmException e){
			throw new ApplicationException(GlobalCode.CREATE_TOKEN_ERROR);
		}
	}
	
	/**
	 * @param token
	 * @return 对字符串token进行base64加密
	 */
	public static String createBase64Encoder(String token){
		if(StringUtils.isBlank(token)){
			return null;
		}
		return Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8))+Constants.salt;
	}
	
	/**
	 * @param token
	 * @return 对token进行解密
	 */
	public static String getBase64Decoder(String token){
		if(StringUtils.isBlank(token)){
			return null;
		}
		String newToken = token.replace(Constants.salt, "");
		return new String(Base64.getDecoder().decode(newToken),StandardCharsets.UTF_8);
	}
}
