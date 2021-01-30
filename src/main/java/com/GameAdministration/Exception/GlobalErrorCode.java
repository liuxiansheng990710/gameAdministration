package com.GameAdministration.Exception;

public enum GlobalErrorCode implements ErrorCode{
	
	
	/*
	 * 登录状态提示
	 * */
	SUCCESS("000000","成功"),
	
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
	
	GlobalErrorCode(String code,String message){
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}
