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
		System.out.println("待插入Issue:" + issue.toString());
		CommonResult resutl = issueService.insertIssue(issue);

		return resutl;

	}

	// 查询全部Issue
	@GetMapping("/all")
	public CommonResult<List<Issue>> getAllIssues() {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		List<Issue> list = issueService.findAll();
//		for (Issue issue : list) {
//			System.out.println("时间：" + df.format(issue.getCreateDate()));
//		}
		return new CommonResult<List<Issue>>(200, "全部数据查询成功", list);
	}

}
