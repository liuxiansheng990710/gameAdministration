package com.GameAdministration.auxiliary;

/**
 * 
 * @author YP
 * @Description: 消息体规定
 * @param:
 * @date: 2021年2月18日下午1:43:21
 * 
 */
public class ResultMessage<T> {

	private boolean isOk;
	private int code;
	private String codeMessage;
	private T data;
	private String context;

	public ResultMessage() {
	}

	public ResultMessage(boolean isOk, int code, String codeMessage, T data,String context) {
		this.isOk = isOk;
		this.code = code;
		this.codeMessage = codeMessage;
		this.data = data;
		this.context = context;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
