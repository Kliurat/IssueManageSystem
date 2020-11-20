package com.ibm.springboot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.springboot.entity.User;
import com.ibm.springboot.service.UserService;

@SpringBootTest
class IssueManagementSystemApplicationTests {
	
	@Autowired
	private UserService userService;
	
	// 测试插入方法
	@Test
	public void testInsert() {
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String substring = uuid.substring(0, 5);
		
		System.out.println(substring+" 111");
		
	}

	@Test
	void contextLoads() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println("date:" + format.format(date));
	}
	
	
	

}
