package com.ibm.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.springboot.entity.jwt.Audience;
import com.ibm.springboot.util.JwtTokenUtil;

/*
 * 作者：蔡海锋
 * 作用：登陆认证拦截器
 * */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	Audience audience;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter("token");

//		Object user = request.getSession().getAttribute("user");
		System.out.println("LoginInterceptor：preHandle:token=>" + token);
		if (token == null) {
			// 未登录，返回登录页
			System.out.println("没有权限请先登录");
			request.setAttribute("msg", "没有权限请先登录");
//            request.getRequestDispatcher("/").forward(request,response);
//			response.sendRedirect("/login");
			return false;
		}

//        if (user == null){
//            response.sendRedirect("/");
//        }

		// 验证token是否有效
		if (audience == null) {
			BeanFactory factory = WebApplicationContextUtils
					.getRequiredWebApplicationContext(request.getServletContext());
			audience = (Audience) factory.getBean("audience");
		}
		System.out.println("audience:" + audience);
		// 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
		boolean result = JwtTokenUtil.parseJWT(token, audience.getBase64Secret()) != null;
		System.out.println("token校验结果：" + result);
		return result;
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
