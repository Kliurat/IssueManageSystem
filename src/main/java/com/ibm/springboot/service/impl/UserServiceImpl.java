package com.ibm.springboot.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.springboot.dao.UserDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.User;
import com.ibm.springboot.entity.jwt.Audience;
import com.ibm.springboot.service.UserService;
import com.ibm.springboot.util.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Resource
	Audience audience;

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

	// Admin对用户的注销 --- 实际上是修改数据库，将 user 表的用户状态修改为0
	public int updateStatusAndRole(User user) {
		int updateStatus = userDao.updateStatusAndRole(user);
		return updateStatus;
	}

	// 在指派修改人的时候，传入loginID的前缀，判断该修改人是否存在
	public List<User> getUsersByPreLoginID(String loginID) {
		List<User> users = userDao.getUsersByPreLoginID(loginID);
		return users;
	}

	/**
	 * 登录的逻辑判断
	 */
	public CommonResult login(String loginId, String password, HttpSession session) {

		int status = 200;
		String msg;
		String token = null;
		Map<String, Object> map = null;

		// 用户名、密码不为空
		if (loginId != null && password != null && !"".equals(password.trim()))
		{
			
			if(loginId.equals("Admin")&&password.equals("Admin123"))
			{
				User adminUser = new User(loginId,Integer.getInteger("2"));
				status = 200;
				session.setAttribute("user", adminUser);
				msg = "Admin管理员登陆成功";
				token = JwtTokenUtil.createJWT(String.valueOf(adminUser.getLoginID()), String.valueOf(adminUser.getLoginID()),
						String.valueOf(adminUser.getRole()), audience);
				map = new HashedMap<String, Object>();
				map.put("loginID", adminUser.getLoginID());
				map.put("role", adminUser.getRole());
				map.put("token", token);
				session.setAttribute("token", token);
				System.out.println("#####  登陆成功 ##### ，生成token:" + token);
				
			}
			else
			{
				User user = userDao.findByLoginId(loginId.trim());
				if (user != null)
				{

					if (password.equals(user.getPassword())) {
						status = 200;

						session.setAttribute("user", user);

						msg = "登陆成功";

						// 调用封装好的方法，生成 token
						token = JwtTokenUtil.createJWT(String.valueOf(user.getSortID()), String.valueOf(user.getLoginID()),
								String.valueOf(user.getRole()), audience);

						map = new HashedMap<String, Object>();
						map.put("loginID", user.getLoginID());
						map.put("username", user.getUsername());
						map.put("email", user.getEmail());
						map.put("role", user.getRole());
						map.put("token", token);

						System.out.println("#####  登陆成功 ##### ，生成token:" + token);

						session.setAttribute("token", token);
					} else {
						status = 201;
						msg = "用户名或密码错误";
					}

				} else {
					// 根据用户名找不到用户
					status = 201;
					msg = "用户名或密码错误";
				}
			}
		}
		else
		{
			// 用户名或密码为空
			status = 201;
			msg = "用户名或密码不能为空";	
		}

//		System.out.println("session的值" + session.getAttribute("user") + "token: " + session.getAttribute("token"));
		
		System.out.println("UserImpl中---> session的id" + session.getId());
		
	return new CommonResult<Map<String, Object>>(status, msg, map);
			
			
			
	}

	/**
	 * 改变用户的状态：注销
	 */
	@Override
	public int updateStatus(User user) {

		return userDao.updateStatus(user);
	}

	// 改变用户的角色：普通用户，经理
	@Override
	public int updateRole(User user) {

		return userDao.updateRole(user);
	}

	@Override
	public List<User> getUsersByPreLoginID(int loginID) {
		// TODO Auto-generated method stub
		return null;
	}

}
