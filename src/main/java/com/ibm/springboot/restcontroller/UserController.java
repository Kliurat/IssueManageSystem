package com.ibm.springboot.restcontroller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.User;
import com.ibm.springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//注册新用户，向数据库中添加记录
	@PostMapping("/register/user")
	public int insertUser(@RequestBody User user) {
		
		//注册前要先判断用户是否存在，查询出所有的用户ID
		List<User> list = userService.selectAll();
		for (User user2 : list)
		{
			if(user2.getLoginID() == user.getLoginID())
			{
				// 该用户ID已经被使用过了
				System.out.println("注册失败，用户ID已经被使用过了");
				return -1;
			}
		}
		
		int insert = userService.insert(user);
		System.out.println("用户成功注册");
		return insert;
		
	}
	
	//查询所有的用户
	@GetMapping("/selectAll/user")
	public List<User> selectAll(){
		
		List<User> list = userService.selectAll();
		return list;
	}
	
	//修改个人信息
	@PutMapping("/update/user")
	public int update(@RequestBody User user)
	{
		int update = userService.update(user);
		return update;
	}
	
	//根据用户姓名查询用户
	@GetMapping("/selectByName/{name}")
	List<User> selectByName(@PathVariable("name") String name)
	{
		List<User> list = userService.selectByName(name);
		return list;
	}
	
	//根据用户ID或者用户姓名查询用户信息
	@GetMapping("/selectUser")
	List<User> selectUser(User user)
	{
		//把传入的参数封装为一个map	
		List<User> list = userService.selectUser(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
		
		return list;
	}
	
	//Admin对用户的注销 --- 实际上是修改数据库，将 user 表的用户状态修改为0
	@PutMapping("/update/statusAndrole")
	public int updateStatusAndRole(User user)
	{
		int updateStatus = userService.updateStatusAndRole(user);
		return updateStatus;
	}
	
}
