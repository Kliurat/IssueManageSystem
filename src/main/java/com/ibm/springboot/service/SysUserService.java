package com.ibm.springboot.service;

import com.ibm.springboot.entity.CommonResult;

public interface SysUserService {

	CommonResult login(String username, String password);
}
