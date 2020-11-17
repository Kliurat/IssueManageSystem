package com.ibm.springboot.entity;

import java.io.Serializable;

import javax.print.attribute.standard.MediaSize.Other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	public User() {
		super();
	}

	public User(int loginID, String username, String email, String password, int status, int role) {
		super();
		this.loginID = loginID;
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	

}
