package com.huangyongsheng.hearthstone.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huangyongsheng.hearthstone.annotation.Login;
import com.huangyongsheng.hearthstone.pojo.dto.ResultModel;
import com.huangyongsheng.hearthstone.pojo.dto.ResultStatus;
import com.huangyongsheng.hearthstone.pojo.po.User;
import com.huangyongsheng.hearthstone.service.TokenService;
import com.huangyongsheng.hearthstone.service.UserService;

import lombok.extern.log4j.Log4j;
import net.sf.json.JSONObject;

@RestController("TokenController")
@RequestMapping(value = "/token")
public @Log4j class TokenController {
	@Autowired
	TokenService tokenService;
	@Autowired
	UserService userService;

	// 登录
	@PostMapping()
	public ResultModel login(@RequestParam String username, @RequestParam String password) {
		log.info("token/login");
		User user = userService.getUserByUsername(username);
		if (user == null || !DigestUtils.md5Hex(password).equals(user.getPassword())) {
			return ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR);
		}
		String token = tokenService.addToken(user.getUserId());
		JSONObject data = new JSONObject();
		data.put("userId", user.getUserId());
		data.put("token", token);
		return ResultModel.ok(ResultStatus.OK, data);
	}

	@Login
	@DeleteMapping("/{userId}")
	public ResultModel logout(@PathVariable Long userId) {
		log.info("token/get");
		Boolean ok = tokenService.logout(userId);
		if (ok) {
			return ResultModel.ok(ResultStatus.OK);
		} else {
			return ResultModel.error(null);// TODO 完善resultmodel.error,添加通用 error
		}

	}
}
