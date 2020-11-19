package com.ibm.springboot.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ibm.springboot.entity.jwt.Audience;
import com.ibm.springboot.util.JwtTokenUtil;

public class JwtInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private Audience audience;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Jwt拦截器");
		// 对于带JwtInore注解的请求，不予以token认证校验
//        if (handler instanceof HandlerMethod){
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
//            if (jwtIgnore != null){
//                return true;
//            }
//        }

		if (HttpMethod.OPTIONS.equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		}

		// 获取请求头信息authorization信息
		final String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
		System.out.println("## authHeader=" + authHeader);

		if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
			System.out.println("### 用户未登录，请先登录 ###");
			return false;
		}

		// 获取token
		final String token = authHeader.substring(7);

		if (audience == null) {
			BeanFactory factory = WebApplicationContextUtils
					.getRequiredWebApplicationContext(request.getServletContext());
			audience = (Audience) factory.getBean("audience");
		}

		// 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
		return JwtTokenUtil.parseJWT(token, audience.getBase64Secret()) != null;
	}
}
