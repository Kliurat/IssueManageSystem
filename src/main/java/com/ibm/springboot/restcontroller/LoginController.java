package com.ibm.springboot.restcontroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.service.SysUserService;

@RestController
public class LoginController {

	@Resource
	SysUserService sysUserService;

	@PostMapping("/login")
	public CommonResult login(@RequestParam("username") String username,

			@RequestParam("password") String password) {

		return sysUserService.login(username, password);

	}
}
