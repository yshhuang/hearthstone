package com.huangyongsheng.hearthstone.pojo.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huangyongsheng.hearthstone.global.Constant;

@JsonIgnoreProperties({ "password" })
public class User {
	private Long userId;
	private String username;
	private String password;
	private @JsonFormat(pattern = Constant.DateFormat.DATE_TIME) Date regDate;

	public User(Long userId, String username, String password, Date regDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.regDate = regDate;
	}

	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", regDate=" + regDate
				+ "]";
	}
}
