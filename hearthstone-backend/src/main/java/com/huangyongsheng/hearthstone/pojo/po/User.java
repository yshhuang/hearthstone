package com.huangyongsheng.hearthstone.pojo.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huangyongsheng.hearthstone.global.Constant;

import lombok.Data;

@JsonIgnoreProperties({ "password" })
public @Data class User {
	private Long userId;
	private String username;
	private String password;
	private @JsonFormat(pattern = Constant.DateFormat.DATE_TIME) Date regDate;

	
}
