package com.huangyongsheng.hearthstone.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyongsheng.hearthstone.dao.impl.RedisClientTemplate;
import com.huangyongsheng.hearthstone.global.Constant;
import com.huangyongsheng.hearthstone.service.TokenService;

@Service("TokenServiceImpl")
public class TokenServiceImpl implements TokenService {
	@Autowired
	private RedisClientTemplate redisClientTemplate;

	@Override
	public String addToken(Long userId) {
		String token = UUID.randomUUID().toString().replace("-", "");
		redisClientTemplate.hset(Constant.Redis.LOGIN_MAP.getValue(), userId.toString(), token);
		return token;
	}

	@Override
	public String getToken(Long userId) {
		return redisClientTemplate.hmget(Constant.Redis.LOGIN_MAP.getValue(), userId.toString()).get(0);
	}

	@Override
	public boolean checkToken(String token) {// 此方法传入的参数应为userId+#+token
		if (token == null || token.isEmpty()) {
			return false;
		}
		String[] params = token.split(Constant.User.USERID_TOKEN_SPLIT);
		if (params.length < 2) {
			return false;
		}
		String userId = params[0];
		token = params[1];
		return token.equals(redisClientTemplate.hmget(Constant.Redis.LOGIN_MAP.getValue(), userId).get(0));
	}

	@Override
	public Boolean logout(Long userId) {
		return redisClientTemplate.hdel(Constant.Redis.LOGIN_MAP.getValue(), userId.toString()) > 0;
	}

}
