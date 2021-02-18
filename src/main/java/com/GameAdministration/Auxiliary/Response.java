package com.GameAdministration.Auxiliary;

/**
 * 
 * @author YP
 * @Description: 响应体规定
 * @param: @param <T> 一般用Map<String,Object>
 * @date: 2021年2月18日下午1:31:41
 * 
 */
public class Response<T> {
	// 初始化赋默认值
	private boolean isOk = true;
	private Message message;
	private T data;

	public Response() {
		this.message = new Message();
		this.isOk = true;
		this.data = null;
	}
	
	public Response(T data) {
		this.isOk = true;
		this.message = new Message();
		this.data = data;
	}

	public boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
