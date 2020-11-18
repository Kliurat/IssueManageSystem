package com.ibm.springboot.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.UserDao;
import com.ibm.springboot.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public int insert(User user) {
		
		int insert = userDao.insert(user);
		
		return insert;
		
	}
	
	//查询所有的用户
	public List<User> selectAll(){
		
		List<User> list = userDao.selectAll();
		
		return list;
	}
	
	//修改个人信息
	public int update(User user)
	{
		int update = userDao.update(user);
		return update;
	}
	
	//根据用户姓名查询用户
	public List<User> selectByName(String name)
	{
		List<User> list = userDao.selectByName(name);
		for (User user : list) {
			System.out.println(user);
		}
		return list;
	}
	
	//根据用户ID或者用户姓名查询用户信息
	public List<User> selectUser(User user)
	{
		List<User> list = userDao.selectUser(user);
		return list;
	}

}
