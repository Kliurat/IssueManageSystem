package com.ibm.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ibm.springboot.utils.LoginHandlerInterceptor;

/*
 * 
 * 
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	// 配置视图映射
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		WebMvcConfigurer configurer = new WebMvcConfigurer() {

			// 配置，注册拦截器 ---> 实现对未登录的用户进行拦截
//			@Override
//			public void addInterceptors(InterceptorRegistry registry) {
//				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/",
//						"/login.html", "/user/login", "/login", "/asserts/**");
//			}

		};

		return configurer;
	}

}
