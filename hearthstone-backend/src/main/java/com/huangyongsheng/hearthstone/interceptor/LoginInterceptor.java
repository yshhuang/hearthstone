package com.huangyongsheng.hearthstone.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.huangyongsheng.hearthstone.annotation.Login;
import com.huangyongsheng.hearthstone.global.Constant.User;
import com.huangyongsheng.hearthstone.pojo.dto.ResultModel;
import com.huangyongsheng.hearthstone.pojo.dto.ResultStatus;
import com.huangyongsheng.hearthstone.service.TokenService;

import net.sf.json.JSONObject;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

		// 没有@Login注解,即不需要登录,通过
		if (method.getAnnotation(Login.class) == null) {
			return true;
		}

		String token = request.getHeader(User.TOKEN);
		boolean isPass = tokenService.checkToken(token);
		if (isPass) {
			return true;
		} else {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSONObject.fromObject(ResultModel.error(ResultStatus.NOT_LOGIN)).toString());
			return false;
		}

	}
}
