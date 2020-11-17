package com.ibm.springboot.entity;

import java.io.Serializable;

import javax.print.attribute.standard.MediaSize.Other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	
	//用户登陆ID
	private int loginID;
	
	//用户姓名
	private String username;
	
	//用户邮箱
	private String email;
	
	//用户登陆密码
	private String password;
	
	//用户状态
	//1：激活；-1：注销
	private int status;
	
	//用户角色
	//0：普通用户；1：经理
	private int role;
	
	

}
