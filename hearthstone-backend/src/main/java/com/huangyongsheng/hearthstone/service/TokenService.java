package com.huangyongsheng.hearthstone.service;

public interface TokenService {
	String addToken(Long userId);
	String getToken(Long userId);
	boolean checkToken(String token);
	Boolean logout(Long userId);

}
