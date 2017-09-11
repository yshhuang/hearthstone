package com.huangyongsheng.hearthstone.service;

import java.util.List;

import com.huangyongsheng.hearthstone.pojo.dto.UserInfo;
import com.huangyongsheng.hearthstone.pojo.po.User;

public interface UserService {
	Long addUser(String username, String password);
	Boolean deleteUser(Long userId);
	User getUserById(Long userId);
	Boolean updateUsername(Long userId, String username);
	List<UserInfo> getUsers(Integer pageNumber, Integer pageSize);
	User getUserByUsername(String username);
}
