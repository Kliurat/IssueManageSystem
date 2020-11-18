package com.ibm.springboot.restcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.service.IssueService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Resource
	IssueService issueService;

	// 创建Issue
	@PostMapping("")
	public CommonResult insertIssue(Issue issue) {
		CommonResult resutl = issueService.insertIssue(issue);
		return resutl;
	}

	@GetMapping("/all")
	public CommonResult<List<Issue>> getAllIssues() {
		List<Issue> list = issueService.findAll();
		return new CommonResult<List<Issue>>(200, "全部数据查询成功", list);
	}

}
