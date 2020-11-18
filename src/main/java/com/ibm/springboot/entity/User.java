package com.ibm.springboot.entity;

public class User{
	
	private int loginID;
	
	private String username;
	
	private String email;
	
	private String password;

	public User() {
		
	}

	public User(int loginID, String username, String email, String password, int status, int role) {
		super();
		this.loginID = loginID;
		this.username = username;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [loginID=" + loginID + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}
		
	//用户状态
	private int status;
	
	//用户角色
	//0：普通用户；1：经理
	private int role;

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
