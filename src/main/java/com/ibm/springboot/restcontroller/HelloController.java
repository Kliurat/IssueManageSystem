package com.ibm.springboot.restcontroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.dao.StudentDao;

/*
 * PS：@RestController既可返回数据，也可返回页面
 * 		@Controller只可返回页面
 * 
 * */

@RestController
public class HelloController {

	@Resource
	StudentDao studentDao;

	@GetMapping("/hello")
	public String test() {
		System.out.println("hello world ，This is Issue Management System!");

		return "hello world ，This is Issue Management System!";
	}

}
