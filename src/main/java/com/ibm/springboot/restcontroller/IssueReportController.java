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

	/**
	 * 
	 * @author :chf
	 * @date :2020-11-20 16:28:05
	 * @description :1.不带参数时，默认返回所有Issue报表记录；2.带参数时，执行模糊查询
	 * @param loginId
	 * @param username
	 * @return
	 */
	@RequestMapping("")
	public CommonResult getAll(
			@RequestParam(value = "loginID", required = false) String userId,
			@RequestParam(value = "username", required = false) String username
//			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
		)
	{
	
//		System.out.println("IssueReportController=>getAll：PageNum=" + pageNum);
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

//		PageHelper.startPage(pageNum, ConstantUtil.PAGE_SIZE_5);

		List<IssueReport> list = iService.findAll(userId, username);

		if (list == null) {
			list = new ArrayList<IssueReport>();
			System.out.println("list为null");
		}

//		PageInfo<IssueReport> page = new PageInfo<IssueReport>(list);
//
//		MyPageInfo<IssueReport> dataPage = new MyPageInfo<IssueReport>(page.getNavigateFirstPage(), page.getPageNum(),
//				page.getNavigateLastPage(), page.getPageSize(), page.getTotal(), list);
//
//		return new CommonResult<MyPageInfo<IssueReport>>(200, msg, dataPage);
		
		for (IssueReport issueReport : list) {
			System.out.println(issueReport);
		}

		return new CommonResult<List<IssueReport>>(status, msg, list);
	}

	// 待删
//	@PostMapping("query")
//	public CommonResult<List<IssueReport>> queryByCondition(
//			@RequestParam(value = "loginID", required = false) String loginID,
//			@RequestParam(value = "username", required = false) String username) {
//
//		// 查询
//
//		return new CommonResult<List<IssueReport>>();
//	}

}
