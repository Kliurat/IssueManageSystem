package com.ibm.springboot.restcontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.service.UserService;

@RestController
public class LoginController {

	@Resource
	UserService userService;

	@PostMapping("/login")
	public CommonResult login(@RequestParam("loginId") Integer loginId, @RequestParam("password") String password,
			HttpSession session) {

//		session.setAttribute("loginUser", username);  放到login方法里去存user对象了

		return userService.login(loginId, password, session);

	}
}
