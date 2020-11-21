package com.ibm.springboot.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 这是一个拦截器，做登录拦截的。

/*
 * 作者：赖炎林
 * 作用：登陆认证拦截器
 * */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
	// 目标方法执行之前，做一个预检查
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("进来了............................................................");

		Object user = request.getSession().getAttribute("user");

		if (user == null)// 未登录
		{
			// 带上提示的消息，返回登录的页面
			System.out.println("您尚未登录，请先登录");

			request.setAttribute("msg", "您尚未登录，请先登录");

			return false;

		} else// 已经登录
		{
			return true;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
