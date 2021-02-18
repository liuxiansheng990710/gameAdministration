package com.GameAdministration.Exception;

public enum GlobalCode implements ErrorCode{
	
	/*
	 * 登录状态提示
	 * */
	SIGN_SUCCESS("200","登录成功"),
	SIGN_FAILED("400","登陆失败"),
	
	/*
	 * 执行状态提示
	 * */
	SUCCESSFUL("10001","执行成功"),
	FAILED("10002","执行失败"),
	
	/*
	 * 时间异常提示
	 * */
	TIME_ISEMPTY("20001","时间为空"),
	
	/*
	 * token错误提示
	 * */
	CREATE_TOKEN_ERROR("30001","token生成失败"),
	
	;
	
	private final String code;
	private final String message;
	
	GlobalCode(String code,String message){
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
