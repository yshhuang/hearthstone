package com.huangyongsheng.hearthstone.global;

public class Constant {

	// redis用来存储信息的key
	public static enum Redis {
		LOGIN_MAP("loginMap", "存储用户ID和token的map");

		private final String value;
		private final String description;

		private Redis(String value, String name) {
			this.value = value;
			this.description = name;
		}

		public String getValue() {
			return value;
		}

		public String getDescription() {
			return description;
		}
	}

	// 统一日期时间格式
	public static interface DateFormat {
		static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";// "标准日期+时间格式");
	}

	public static interface User {
		static final String TOKEN = "token";// 登录验证参数
		static final String USERID_TOKEN_SPLIT = "#";// authentication 验证时,userId和真实token的分隔符
	}
}
