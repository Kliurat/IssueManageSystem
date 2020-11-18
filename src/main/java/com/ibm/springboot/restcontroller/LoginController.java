package com.ibm.springboot.restcontroller;

import javax.annotation.Resource;

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
	public CommonResult login(@RequestParam("username") String username,

			@RequestParam("password") String password) {

		return userService.login(username, password);

	}
}
