package com.GameAdministration.Auxiliary;

/**
 * 
 * @author YP
 * @Description: 消息体规定
 * @param:
 * @date: 2021年2月18日下午1:43:21
 * 
 */
public class Message {

	private String code;
	private String codeMessage;
	private String context;

	public Message() {
		this.code = "2000";
		this.codeMessage = "执行成功";
		this.context = "";
	}

	public Message(String code, String codeMessage, String context) {
		this.code = code;
		this.codeMessage = codeMessage;
		this.context = context;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
