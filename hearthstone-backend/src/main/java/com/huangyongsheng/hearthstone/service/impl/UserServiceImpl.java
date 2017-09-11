package com.huangyongsheng.hearthstone.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyongsheng.hearthstone.dao.UserDao;
import com.huangyongsheng.hearthstone.pojo.dto.UserInfo;
import com.huangyongsheng.hearthstone.pojo.po.User;
import com.huangyongsheng.hearthstone.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public Long addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(DigestUtils.md5Hex(password));
		user.setRegDate(new Date());
		userDao.addUser(user);
		return user.getUserId();
	}

	@Override
	public Boolean deleteUser(Long userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public User getUserById(Long userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public Boolean updateUsername(Long userId, String username) {
		return userDao.updateUsername(userId, username);
	}

	@Override
	public List<UserInfo> getUsers(Integer pageNumber, Integer pageSize) {
		Integer start = (pageNumber - 1) * pageSize;
		return userDao.getUserInfos(start, pageSize);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

}
