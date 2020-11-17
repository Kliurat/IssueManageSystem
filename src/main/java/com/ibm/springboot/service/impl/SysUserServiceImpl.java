package com.ibm.springboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.SysUserDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.SysUser;
import com.ibm.springboot.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	SysUserDao sysUserDao;

	@Override
	public CommonResult login(String username, String password) {

		int status = 200;
		String msg;

		// 用户名、密码不为空
		if (username != null && password != null && !"".equals(username.trim()) && !"".equals(password.trim())) {

			SysUser sysUser = sysUserDao.findByUserName(username);
			if (sysUser != null) {

				if (password.equals(sysUser.getPassword())) {
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
