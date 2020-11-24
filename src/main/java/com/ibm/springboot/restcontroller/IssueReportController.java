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

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.IssueReport;
import com.ibm.springboot.service.IssueReportService;

@RestController
@RequestMapping("/issue/report")
@CrossOrigin
public class IssueReportController {

	@Resource
	IssueReportService iService;

	/**
	 * 
	 * @author :chf
	 * @date :2020-11-20 16:28:05
	 * @description : 面向角色：经理（代码：1） 1.不带参数时，默认返回所有Issue报表记录；2.带参数时，执行模糊查询
	 * @param loginId
	 * @param username
	 * @return
	 */

	// Issue报表-------统计报表
	@RequestMapping("")
	public CommonResult getAll(@RequestParam(value = "loginID", required = false) String loginId,
			@RequestParam(value = "username", required = false) String username, HttpSession session) {

//		User user = (User) session.getAttribute("user");

//		System.out.println(user);

//		User user = new User(in)
//
//		if (user.getRole() != 1) {
//
//			return new CommonResult<String>(403, ConstantUtil.NO_PRIVILEGE, null);
//
//		}

		System.out.println("loginId:" + loginId);
		System.out.println("username:" + username);

		int status = 200;
		String msg = "查询成功";

		if (username == "") {
			username = null;
		}
		if (loginId == "") {
			loginId = null;
		}

		List<IssueReport> list = iService.findAll(loginId, username);

		if (list == null) {
			list = new ArrayList<IssueReport>();
			System.out.println("list为null");
		}

		for (IssueReport issueReport : list) {
			System.out.println(issueReport);
		}

		return new CommonResult<List<IssueReport>>(status, msg, list);
	}

	@GetMapping("formatter")
	public String Formatter() {

		return "数据校验成功";
	}

}
