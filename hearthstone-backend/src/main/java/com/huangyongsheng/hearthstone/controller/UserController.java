package com.huangyongsheng.hearthstone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huangyongsheng.hearthstone.pojo.dto.ResultModel;
import com.huangyongsheng.hearthstone.pojo.dto.ResultStatus;
import com.huangyongsheng.hearthstone.pojo.dto.UserInfo;
import com.huangyongsheng.hearthstone.pojo.po.User;
import com.huangyongsheng.hearthstone.service.UserService;

import net.sf.json.JSONObject;

@RestController("UserController")
@RequestMapping(value = "/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	// 注册
	@PostMapping()
	public ResultModel addUser(@RequestParam String username, @RequestParam String password) {
		logger.info("user/addUser");
		User user = userService.getUserByUsername(username);
		if (user != null) {
			return ResultModel.error(ResultStatus.USERNAME_ALREADY_EXISTS);
		}
		Long userId = userService.addUser(username, password);
		JSONObject data = new JSONObject();
		data.put("userId", userId);
		return ResultModel.ok(ResultStatus.OK, data);
	}

	@DeleteMapping(value = "/{userId}")
	public Boolean deleteUser(@PathVariable Long userId) {
		logger.info("user/deleteUser");
		return userService.deleteUser(userId);
	}

	@PatchMapping(value = "{userId}")
	public Boolean updateUsername(@PathVariable Long userId, @RequestParam String username) {
		logger.info("updateUsername");
		return userService.updateUsername(userId, username);
	}

	@GetMapping(value = "{userId}")
	public User getUserById(@PathVariable Long userId) {
		logger.info("getUserById");
		return userService.getUserById(userId);
	}

	@GetMapping()
	public List<UserInfo> getUsers(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		logger.info("getUsers");
		return userService.getUsers(pageNumber, pageSize);
	}
}
