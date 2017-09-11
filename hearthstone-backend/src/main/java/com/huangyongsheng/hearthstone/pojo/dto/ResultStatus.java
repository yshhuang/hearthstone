package com.huangyongsheng.hearthstone.pojo.dto;

public enum ResultStatus {

	OK(200), 
	USERNAME_ALREADY_EXISTS(10001, "Can not add user", "用户名已存在"), 
	USERNAME_OR_PASSWORD_ERROR(10002, "Can not add token", "用户名或密码错误"), 
	NOT_LOGIN(401, "not login", "未登录");

	private final int code;
	private final String error;
	private final String info;

	ResultStatus(int code) {
		this.code = code;
		this.error = null;
		this.info = null;
	}

	ResultStatus(int code, String info) {
		this.code = code;
		this.error = null;
		this.info = info;
	}

	ResultStatus(int code, String error, String info) {
		this.code = code;
		this.error = error;
		this.info = info;
	}

	public int getCode() {
		return code;
	}

	public String getError() {
		return error;
	}

	public String getInfo() {
		return info;
	}

}
