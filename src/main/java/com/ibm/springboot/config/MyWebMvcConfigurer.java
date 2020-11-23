package com.ibm.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ibm.springboot.utils.LoginHandlerInterceptor;


@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	
//	@Autowired
//	private MyHandlerInterceptor myHandlerInterceptor;

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
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
//				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/",
//						"/login.html", "/user/login", "/login", "/asserts/**");
//				registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/**");
			}

		};

		return configurer;
	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		// TODO Auto-generated method stub
//		System.out.println("这是个CorsMapping");
//		registry.addMapping("/**")
//		        //设置允许跨域请求的域名
//		        .allowedOrigins("*")
//		        //是否允许证书 不再默认开启
//		        .allowCredentials(true)
//		        //设置允许的方法
//		        .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
//		        //跨域允许时间
//		        .maxAge(3600);
//
//	}
	
	

}
