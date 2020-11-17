package com.ibm.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {

	private Integer userId;

	private String username;

	private String password;

	private String name;

	private Integer age;

}
