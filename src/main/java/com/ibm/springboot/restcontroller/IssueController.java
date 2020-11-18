package com.ibm.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.VO.IssueVo;
import com.ibm.springboot.service.IssueService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Resource
	IssueService issueService;

	// 创建Issue
	@PostMapping("")
	public CommonResult insertIssue(Issue issue) {
		System.out.println("待插入Issue:" + issue.toString());
		CommonResult result = issueService.insertIssue(issue);

		return result;

	}

	// 查询全部Issue
	@GetMapping("/all")
	public CommonResult<List<Issue>> getAllIssues() {

		List<Issue> list = issueService.findAll();
		return new CommonResult<List<Issue>>(200, "全部数据查询成功", list);
	}

	@PostMapping("/query")
	public CommonResult query(IssueVo issue) {
		System.out.println("待查询条件：" + issue);
		int status = 200;
		String msg = "查询成功";
		List<Issue> list = issueService.queryByCondition(issue);
		if (list == null) {
			list = new ArrayList<Issue>();
		}
		return new CommonResult<List<Issue>>(status, msg, list);
	}

}
