package com.ibm.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = { "com.ibm.springboot.dao" })
public class IssueManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueManagementSystemApplication.class, args);
	}

}
