package com.ibm.springboot.restcontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.VO.IssueVo;
import com.ibm.springboot.service.IssueService;
import com.ibm.springboot.util.ConstantUtil;
import com.ibm.springboot.util.MyPageInfo;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Resource
	IssueService issueService;

	// 创建Issue
	@PostMapping("")
	public CommonResult insertIssue(Issue issue) {
		
		//给每一个Issue创建一个唯一的uuid
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		issue.setIssueNo(uuid);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("进入.......................................................");
		System.out.println(issue);
		
		try {
			issue.setCreateDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		issue.setStatus(0);
		
		
		System.out.println("待插入Issue:" + issue.toString());
		CommonResult result = issueService.insertIssue(issue);
		return result;
	}

	// 删除Issue
	@DeleteMapping("")
	public CommonResult delete(@RequestParam("id") Integer id) {
		System.out.println("待删除ID：" + id);

		int status = 200;
		String msg = "删除成功";

		int result;
		try {
			result = issueService.deleteById(id);
			if (result != 1) {
				status = 500;
				msg = "删除失败";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = 500;
			msg = "服务器异常，请稍后再试";
		}

		return new CommonResult<String>(status, msg, null);
	}

	// 查询全部Issue
	@GetMapping("/all")
	public CommonResult<List<Issue>> getAllIssues() {

		List<Issue> list = issueService.findAll();
		return new CommonResult<List<Issue>>(200, "全部数据查询成功", list);
	}

	@PostMapping("/query")
	public CommonResult query(IssueVo issue,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

		System.out.println("待查询条件：" + issue);

		int status = 200;
		String msg = "查询成功";

		PageHelper.startPage(pageNum, ConstantUtil.PAGE_SIZE_5);

		List<Issue> list = issueService.queryByCondition(issue);
		if (list == null) {
			list = new ArrayList<Issue>();
		}
		PageInfo<Issue> page = new PageInfo<Issue>(list);
		MyPageInfo<Issue> dataPage = new MyPageInfo<Issue>(page.getNavigateFirstPage(), page.getPageNum(),
				page.getNavigateLastPage(), page.getPageSize(), page.getTotal(), list);

		return new CommonResult<MyPageInfo<Issue>>(status, msg, dataPage);
	}

	@PutMapping
	public CommonResult modify(Issue issue) {
		System.out.println("修改后的Issue：" + issue.toString());
		int status = 200;
		String msg = "修改成功";
		int result = issueService.updateIssue(issue);
		if (result != 1) {
			status = 500;
			msg = "修改失败";
		}

		return new CommonResult<String>(status, msg, null);
	}

}
