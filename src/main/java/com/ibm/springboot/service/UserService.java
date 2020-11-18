package com.ibm.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.UserDao;
import com.ibm.springboot.entity.User;

@Service
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
	
	//Admin对用户的注销 --- 实际上是修改数据库，将 user 表的用户状态修改为0
	public int updateStatusAndRole(User user);
	
	//在指派修改人的时候，传入loginID的前缀，
	public List<User> getUsersByPreLoginID(int loginID);
	
	
}
