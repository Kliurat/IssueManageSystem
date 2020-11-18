package com.ibm.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.UserDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public int insert(User user) {

		int insert = userDao.insert(user);

		return insert;

	}

	// 查询所有的用户
	public List<User> selectAll() {

		List<User> list = userDao.selectAll();

		return list;
	}

	// 修改个人信息
	public int update(User user) {
		int update = userDao.update(user);
		return update;
	}

	// 根据用户姓名查询用户
	public List<User> selectByName(String name) {
		List<User> list = userDao.selectByName(name);
		for (User user : list) {
			System.out.println(user);
		}
		return list;
	}

	// 根据用户ID或者用户姓名查询用户信息
	public List<User> selectUser(User user) {
		List<User> list = userDao.selectUser(user);
		return list;
	}
	
	//Admin对用户的注销 --- 实际上是修改数据库，将 user 表的用户状态修改为0
	public int updateStatusAndRole(User user)
	{
		int updateStatus = userDao.updateStatusAndRole(user);
		return updateStatus;
	}

	public CommonResult login(String username, String password) {

		int status = 200;
		String msg;

		// 用户名、密码不为空
		if (username != null && password != null && !"".equals(username.trim()) && !"".equals(password.trim())) {

			User user = userDao.findByUserName(username);
			if (user != null) {

				if (password.equals(user.getPassword())) {
					status = 200;
					msg = "登陆成功";
				} else {
					status = 201;
					msg = "用户名或密码错误";
				}

			} else {
				// 根据用户名找不到用户
				status = 201;
				msg = "用户名或密码错误";
			}

		} else {
			// 用户名或密码为空
			status = 201;
			msg = "用户名或密码不能为空";
		}

		return new CommonResult<String>(status, msg, null);
	}

}
