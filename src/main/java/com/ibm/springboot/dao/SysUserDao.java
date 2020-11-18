package com.ibm.springboot.dao;

import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.SysUser;

public interface SysUserDao {

	SysUser findByUserName(@Param("username") String username);

}
