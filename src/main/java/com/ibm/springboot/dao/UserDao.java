package com.ibm.springboot.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.User;

@Mapper
public interface UserDao {
	
	//注册新用户，向数据库中添加记录
	int insert(User user);
	
	//查询所有的用户
	List<User> selectAll();
	
	//根据用户姓名查询用户
	List<User> selectByName(@Param("name") String name);
	
	//修改个人信息
	int update(User user);
	
	//根据用户ID或者用户姓名查询用户信息
	List<User> selectUser(User user);
	
}
