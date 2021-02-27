package com.GameAdministration.exception;

public enum GlobalCode implements ErrorCode{
	
	/*
	 * 登录状态提示
	 * */
	SIGN_SUCCESS(200,"登录成功"),
	SIGN_FAILED(400,"账号或密码不能为空"),
	ACCOUNT_NONTHING(600,"账号不存在，请先注册"),
	PASSWORD_WRONG(700,"密码错误，请重新输入"),
	
	/*
	 * 执行状态提示
	 * */
	SUCCESSFUL(10001,"执行成功"),
	FAILED(10002,"执行失败"),
	
	/*
	 * 时间异常提示
	 * */
	TIME_ISEMPTY(20001,"时间为空"),
	
	/*
	 * token错误提示
	 * */
	CREATE_TOKEN_ERROR(30001,"token生成失败"),
	
	;
	
	private final int code;
	private final String message;
	
	GlobalCode(int code,String message){
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
