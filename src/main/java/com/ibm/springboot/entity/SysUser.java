package com.ibm.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SysUser {

	private Integer userId;

	private String username;

	private String password;

	private String name;

	private Integer age;

<<<<<<< HEAD
=======
	public SysUser() {
		super();
	}

	public SysUser(Integer userId, String username, String password, String name, Integer age) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
	}

>>>>>>> 55ce1b775d7eae7d2a696c92dcaea24c24be5636
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
<<<<<<< HEAD
=======
	
	
>>>>>>> 55ce1b775d7eae7d2a696c92dcaea24c24be5636

}
