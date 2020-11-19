package com.ibm.springboot.restcontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
		
		//需要获取当前日期为用户的注册时间
		// 当 serverTimezone=UTC 时插入的时间不正确，需要改成 serverTimezone=Asia/Shanghai
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
		System.out.println("当前日期："+df.format(new Date()));// new Date()为获取当前系统时间
		
		try {
			user.setRegisteDate(df.parse(df.format(new Date())));;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int insert = userService.insert(user);
		System.out.println("用户成功注册");
		return insert;
		
	}
	
	//查询所有的用户
	@GetMapping("/selectAll/user")
	public List<User> selectAll(HttpServletResponse response){
//		response.setHeader("Access-Control-Allow-Origin", "*");
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
	@RequestMapping("/selectUser")
	List<User> selectUser(@RequestParam(value = "loginID",required = false) String loginID,@RequestParam(value = "username",required = false) String username)
	{
		
		System.out.println("login的值为：" + loginID);
		System.out.println("username的值为：" + username);
		
		User user = new User(loginID,username);
		
		List<User> list = userService.selectUser(user);

		for (User user2 : list) {
			System.out.println(user2);
		}
		
		return list;
	}
	
	//Admin对用户的注销 --- 实际上是修改数据库，将 user 表的用户状态修改为0
	@RequestMapping("/update/statusAndrole")
	public List<User> updateStatusAndRole(@RequestParam(value = "loginID",required = false) String loginID,@RequestParam(value = "role",required = false) Integer role,@RequestParam(value = "status",required = false) Integer status)
	{
		User user = new User(loginID,role,status);
		System.out.println("loginID：" + loginID);
		System.out.println("role：" + role);
		System.out.println("status：" + status);
		
		System.out.println("====================");
		System.out.println("user为：" + user);
		
		if(role == null && status != null) {
			userService.updateStatus(user);
		}else if (role != null && status == null) {
			userService.updateRole(user);
		}
		
		
//		int updateResult = userService.updateStatusAndRole(user);
		//返回全用户列表给前端
		return userService.selectAll();
//		return updateResult;
	}
	
}
