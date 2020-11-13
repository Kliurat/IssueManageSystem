package com.ibm.springboot.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class LoginController {

	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		int status = 200;
		String msg = null;

		// 用户名密码判空验证在前端编写
//		if(username == null || password == null || 
//				"".equals(username.trim()) || 
//				"".equals(password.trim())) {
//			
//			if (username == null || "".equals(username.trim())) {
//				status = 201;
//				msg = "用户名不能为空";
//			}
//
//			if (password == null || "".equals(password.trim())) {
//				status = 201;
//				msg = "密码不能为空";
//			}
//		}else {
//			if (!) {
//				
//			}
//		}

		if (username.equals(password)) {
			status = 200;
			msg = "登陆成功";
		} else {
			status = 201;
			msg = "用户名或密码错误";
		}

//		return msg;

		return msg;
	}
}
