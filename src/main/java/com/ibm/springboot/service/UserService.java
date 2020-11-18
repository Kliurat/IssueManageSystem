package com.ibm.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.UserDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.User;

public interface UserService {
	
	public int insert(User user);
	
	//查询所有的用户
	public List<User> selectAll();
	
	//修改个人信息
	public int update(User user);
	
	//根据用户姓名查询用户
	public List<User> selectByName(String name);
		
	//根据用户ID或者用户姓名查询用户信息
	public List<User> selectUser(User user);

	public int updateStatusAndRole(User user);
	
	//在指派修改人的时候，传入loginID的前缀，
	public List<User> getUsersByPreLoginID(int loginID);

	//用户登录
	public CommonResult login(String username, String password);

}
