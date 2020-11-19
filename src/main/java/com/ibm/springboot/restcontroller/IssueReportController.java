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

	@GetMapping("")
	public CommonResult getAll(@RequestParam(value = "loginId", required = false) String loginId,
			@RequestParam(value = "username", required = false) String username
//			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
	) {

//		System.out.println("IssueReportController=>getAll：PageNum=" + pageNum);
		System.out.println("loginId:" + loginId);
		System.out.println("username:" + username);

		int status = 200;
		String msg = "查询成功";

//		PageHelper.startPage(pageNum, ConstantUtil.PAGE_SIZE_5);

		List<IssueReport> list = iService.findAll(loginId, username);

		if (list == null) {
			list = new ArrayList<IssueReport>();
		}

//		PageInfo<IssueReport> page = new PageInfo<IssueReport>(list);
//
//		MyPageInfo<IssueReport> dataPage = new MyPageInfo<IssueReport>(page.getNavigateFirstPage(), page.getPageNum(),
//				page.getNavigateLastPage(), page.getPageSize(), page.getTotal(), list);
//
//		return new CommonResult<MyPageInfo<IssueReport>>(200, msg, dataPage);

		return new CommonResult<List<IssueReport>>(status, msg, list);
	}

}
