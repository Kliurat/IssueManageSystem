package com.ibm.springboot.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	
	private int loginID;
	
	private String username;
	
	private String email;
	
	private String password;
	
	

}
