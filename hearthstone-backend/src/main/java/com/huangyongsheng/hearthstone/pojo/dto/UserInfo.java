package com.huangyongsheng.hearthstone.pojo.dto;

public class UserInfo {
	private Long userId;
	private String username;

	public UserInfo(Long userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public UserInfo() {
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

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", username=" + username + "]";
	}

}
