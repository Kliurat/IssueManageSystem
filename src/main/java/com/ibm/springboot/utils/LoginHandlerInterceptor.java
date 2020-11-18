package com.ibm.springboot.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 这是一个拦截器，做登录拦截的。

public class LoginHandlerInterceptor implements HandlerInterceptor
{
	 // 目标方法执行之前，做一个预检查
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
    	
    	System.out.println("进来了............................................................");
    	
        Object user = request.getSession ( ).getAttribute ("loginUser");
        
        if (user == null)// 未登录
        {
            // 带上提示的消息，返回登录的页面
            request.setAttribute ("msg","您尚未登录，请先登录");
            
            request.getRequestDispatcher ("/login.html").forward (request,response);

            return false;
        }
        else// 已经登录
        {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    
}
