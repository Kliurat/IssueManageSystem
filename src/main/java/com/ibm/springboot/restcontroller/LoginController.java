package com.ibm.springboot.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.ibm.springboot.entity.CommonResult;
=======
>>>>>>> 43a553f589c35a9f6f5f0256a6c0f29479de9901

@RestController

public class LoginController {

	@PostMapping("/login")
<<<<<<< HEAD
	public CommonResult<String> login(@RequestParam("username") String username,
=======
	public String login(@RequestParam("username") String username,
>>>>>>> 43a553f589c35a9f6f5f0256a6c0f29479de9901
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

<<<<<<< HEAD
		return new CommonResult<String>(status, msg, null);
=======
		return msg;
>>>>>>> 43a553f589c35a9f6f5f0256a6c0f29479de9901
	}
}
