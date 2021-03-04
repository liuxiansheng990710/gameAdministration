package com.GameAdministration.exception;

public enum GlobalCode implements ErrorCode{
	
	/*
	 * 登录状态提示
	 * */
	SIGN_SUCCESS(200,"登录成功"),
	SIGN_FAILED(400,"账号或密码不能为空"),
	SIGN_ERROR(500,"登录异常,请重新登录"),
	ACCOUNT_NONTHING(600,"账号不存在，请先注册"),
	PASSWORD_WRONG(700,"密码错误，请重新输入"),
	STATE_ERROE(100,"您的账号尚未权限登录，请联系吟轩为您审核"),
	
	/*
	 * 注册状态提示
	 * */
	REGISTER_ERROR(300,"注册异常"),
	REGISTER_SUCESS(800,"注册成功，请联系吟轩为您审核"),
	ACCONUT_EXISTS(900,"账号已经存在，无需重复注册"),
	
	/*
	 * 用户信息修改提示
	 * */
	UPDATE_SUCCESS(10001,"密码修改成功，请重新登录"),
	UPDATE_FAILED(10002,"修改失败"),
	PASSWORD_SIMILAR(10003,"新密码与旧密码相似或一致，出于安全考虑，请更换"),
	
	
	/*
	 * 执行状态提示
	 * */
	SUCCESSFUL(20001,"执行成功"),
	FAILED(20002,"执行失败"),
	OFF_SUCESS(20003,"下线成功"),
	OFF_FAILED(20004,"下线失败"),
	EXAMINE_SUCCESS(20005,"审核成功，游戏已上线"),
	EXAMINE_FAILED(20006,"审核失败"),
	
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
