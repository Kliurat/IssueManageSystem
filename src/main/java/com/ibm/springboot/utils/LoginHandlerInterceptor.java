package com.ibm.springboot.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.User;
import com.ibm.springboot.entity.jwt.Audience;
import com.ibm.springboot.util.JwtTokenUtil;

// 这是一个拦截器，做登录拦截的。

/*
 * 作者：赖炎林
 * 作用：登陆认证拦截器
 * */
//@Component  
// 暂时弃用
public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Autowired
	Audience audience;

	// 目标方法执行之前，做一个预检查
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("Integerhandler中的 ---> session的id" + request.getSession().getId());
		
		int status = 200;

		String msg = null;

		User user = (User) request.getSession().getAttribute("user");

		String token = (String) request.getSession().getAttribute("token");

		System.out.println("token:" + token);

		if (user == null) { // 未登录

			status = 201;

			msg = "您尚未登录，请先登录";

			// 带上提示的消息，返回登录的页面

			System.out.println(msg);

			response.setContentType("application/json;charset=UTF-8");

			PrintWriter out = response.getWriter();

			CommonResult<String> result = new CommonResult<String>(201, msg, null);

			String jsonStr = JSONObject.toJSONString(result);

			JSONObject jsonObject = JSONObject.parseObject(jsonStr);

			out.append(jsonObject.toString());

			out.flush();

			out.close();

			return false;

		} else// 已经登录
		{

			boolean result = false;

			// 验证token是否过期

			if (audience == null) {
				BeanFactory factory = WebApplicationContextUtils
						.getRequiredWebApplicationContext(request.getServletContext());
				audience = (Audience) factory.getBean("audience");
			}

			result = JwtTokenUtil.parseJWT(token, audience.getBase64Secret()) != null;

			System.out.println("token校验结果：" + result);

			if (!result) {

				status = 201;

				msg = "登录已失效，请重新登录";

				response.setCharacterEncoding("UTF-8");

				response.setContentType("application/json;charset=UTF-8");

				CommonResult<String> res = new CommonResult<String>(status, msg, null);

				String jsonStr = JSONObject.toJSONString(res);

				JSONObject jsonObject = JSONObject.parseObject(jsonStr);

				PrintWriter out = response.getWriter();

				out.append(jsonObject.toString());

				out.flush();

				out.close();
			}

			return result;
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
