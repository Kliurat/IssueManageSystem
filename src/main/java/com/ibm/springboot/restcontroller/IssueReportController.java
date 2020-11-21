package com.ibm.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.IssueReport;
import com.ibm.springboot.service.IssueReportService;

@RestController
@RequestMapping("/issue/report")
public class IssueReportController {

	@Resource
	IssueReportService iService;

	//Issue报表-------统计报表
	@RequestMapping("")
	public CommonResult getAll(
			@RequestParam(value = "loginID", required = false) String userId,
			@RequestParam(value = "username", required = false) String username)
	{
	
		System.out.println("userId:" + userId);
		System.out.println("username:" + username);

		int status = 200;
		String msg = "查询成功";
		
		if(username == "") {
			username = null;
		}
		if (userId == "") {
			userId = null;
		}

		List<IssueReport> list = iService.findAll(userId, username);

		if (list == null) {
			list = new ArrayList<IssueReport>();
			System.out.println("list为null");
		}

	
		for (IssueReport issueReport : list) {
			System.out.println(issueReport);
		}

		return new CommonResult<List<IssueReport>>(status, msg, list);
	}

}
