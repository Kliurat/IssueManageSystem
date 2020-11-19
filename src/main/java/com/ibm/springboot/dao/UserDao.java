package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.User;

@Mapper
public interface UserDao {

	// 注册新用户，向数据库中添加记录
	int insert(User user);

	// 查询所有的用户
	List<User> selectAll();

	// 根据用户姓名查询用户
	List<User> selectByName(@Param("name") String name);

	// 修改个人信息
	int update(User user);

	// 根据用户ID或者用户姓名查询用户信息
	List<User> selectUser(User user);

	// 登陆：根据用户名查询用户
	User findByUserName(@Param("username") String username);

	// Admin对用户的注销 --- 实际上是修改数据库，将 user 表的用户状态修改为0
	// int updateStatus(@Param("loginID") int loginID);

	int updateStatusAndRole(User user);
	
	int updateStatus(User user);
	
	int updateRole(User user);
	
	//在指派修改人的时候，传入loginID的前缀，判断该修改人是否存在
	public List<User> getUsersByPreLoginID(int loginID);

}
