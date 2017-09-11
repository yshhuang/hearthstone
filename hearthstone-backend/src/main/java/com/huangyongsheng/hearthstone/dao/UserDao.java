package com.huangyongsheng.hearthstone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huangyongsheng.hearthstone.annotation.MyBatisRepository;
import com.huangyongsheng.hearthstone.pojo.dto.UserInfo;
import com.huangyongsheng.hearthstone.pojo.po.User;

@MyBatisRepository
public interface UserDao {
	void addUser(User user);
	Boolean deleteUser(Long userId);
	User getUserById(Long userId);
	Boolean updateUsername(@Param(value= "userId" )Long userId, @Param(value="username")String username);
	List<UserInfo> getUserInfos(@Param(value = "start")Integer start, @Param(value = "size")Integer pageSize);
	User getUserByUsername(String username);
}
