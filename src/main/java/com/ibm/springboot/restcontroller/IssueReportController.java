package com.ibm.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.dao.IssueReportDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.IssueReport;
import com.ibm.springboot.service.IssueReportService;

@RestController
@RequestMapping("/issue/report")
@CrossOrigin
public class IssueReportController {

	@Resource
	IssueReportService iService;

	@Resource
	IssueReportDao iRepDao;

	// Issue报表-------统计报表
	@RequestMapping("")
	public CommonResult getAll(@RequestParam(value = "loginID", required = false) String loginId,
							   @RequestParam(value = "username", required = false) String username,
							   HttpSession session) {

		System.out.println("loginId:" + loginId);
		System.out.println("username:" + username);

		int status = 200;
		String msg = "查询成功";

		if (username == "") 
		{
			username = null;
		}
		if (loginId == "")
		{
			loginId = null;
		}

		List<IssueReport> list = iService.findAll(loginId, username);

		if (list == null)
		{
			list = new ArrayList<IssueReport>();
			System.out.println("list为null");
		}

		for (IssueReport issueReport : list)
		{
			System.out.println(issueReport);
		}

		return new CommonResult<List<IssueReport>>(status, msg, list);
	}

	@GetMapping("formatter")
	public String Formatter()
	{
		iRepDao.deleteAll();
		iRepDao.staticsFromIssueTable();
		return "数据统计成功";
	}

}
