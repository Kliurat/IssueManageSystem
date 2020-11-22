package com.ibm.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {

	// 序号
	private int sortID;

	// 用户登陆ID
	private String loginID;

	// 用户姓名
	private String username;

	// 用户邮箱
	private String email;

	// 用户登陆密码
	private String password;

	// 注册日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date registeDate;

	// 用户状态
	// 1：激活；0：注销
	private Integer status;

	// 用户角色
	// 0：普通用户；1：经理
	private Integer role;

	public User() {

	}
	
	public User(String loginID, String username) {
		super();
		this.loginID = loginID;
		this.username = username;
	}

	
	public User(String loginID, Integer status, Integer role) {
		super();
		this.loginID = loginID;
		this.status = status;
		this.role = role;
	}

	
	public User(String loginID, String username, String email, String password, Integer status, Integer role) {
		super();
		this.loginID = loginID;
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public User(String loginID, String username, String email, String password) {
		super();
		this.loginID = loginID;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(int sortID, String loginID, String username, String email, String password, Date registeDate, Integer status,
			Integer role) {
		super();
		this.sortID = sortID;
		this.loginID = loginID;
		this.username = username;
		this.email = email;
		this.password = password;
		this.registeDate = registeDate;
		this.status = status;
		this.role = role;
	}

	public int getSortID() {
		return sortID;
	}

	public void setSortID(int sortID) {
		this.sortID = sortID;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [sortID=" + sortID + ", loginID=" + loginID + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", registeDate=" + registeDate + ", status=" + status + ", role=" + role
				+ "]";
	}

	public Date getRegisteDate() {
		return registeDate;
	}

	public void setRegisteDate(Date registeDate) {
		this.registeDate = registeDate;
	}

}
