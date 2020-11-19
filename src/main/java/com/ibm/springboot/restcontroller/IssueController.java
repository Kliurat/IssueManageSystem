package com.ibm.springboot.restcontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.dao.UserDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.IssueReport;
import com.ibm.springboot.entity.User;
import com.ibm.springboot.entity.VO.IssueVo;
import com.ibm.springboot.service.IssueReportService;
import com.ibm.springboot.service.IssueService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Resource
	IssueService issueService;

	@Resource
	IssueReportService iRepService;

	@Resource
	UserDao userDao;

	// 创建Issue
	@PostMapping("")
	public CommonResult insertIssue(Issue issue, HttpSession session) {

		System.out.println("进入.......................................................");

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");// 设置日期格式
		System.out.println("当前日期：" + df.format(new Date()));// new Date()为获取当前系统时间

		// 给每一个Issue创建一个唯一的uuid
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		issue.setIssueNo(uuid);
		issue.setStatus(0);

		try {
			issue.setCreateDate(df.parse(df.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("待插入Issue:" + issue.toString());

		User user = (User) session.getAttribute("user");
		System.out.println("查看session存储的user:" + user);

		// 1.查看是否有自己的报表行记录

		IssueReport report = null;
		try {
			report = iRepService.getReportByLoginID(user.getLoginID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e instanceof NullPointerException) {
				return new CommonResult<String>(201, "您尚未登陆，请先登陆", null);
			}
		}
		if (report == null) {
			// 2.若无，则插入一条，创建数为1
			iRepService.insertReport(new IssueReport(user.getLoginID(), user.getUsername(), 1, 0, 0, 0, 0));
		} else {
			report.setCreateCount(report.getCreateCount() + 1);
			iRepService.updateReport(report);
		}

		// 3.插入issue
		CommonResult result = issueService.insertIssue(issue);
		if (result.getStatus() == 200) {
			// issue创建成功，更新issue发派目标用户的issue报表

			// 4.查看目标用户是否有报表行记录
			report = iRepService.getReportByLoginID(issue.getModifyPersonID());
			if (report == null) {
				// 5.若无，先查询目标用户的信息
				User targetUser = userDao.findByLoginId(issue.getModifyPersonID());

				// 再插入一条issue报表行，收到数为1
				iRepService.insertReport(
						new IssueReport(targetUser.getLoginID(), targetUser.getUsername(), 0, 1, 0, 0, 0));
			} else {
				// 7.计算完成率
				int finished = report.getFinishCount();
				report.setReceiveCount(report.getReceiveCount() + 1);
				int receive = report.getReceiveCount();
				float finishedPer = finished * 1.0f / receive;
				report.setFinishedPer(finishedPer);
				iRepService.updateReport(report);
			}
		}
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

	// 条件查询
	// 注释部分为分页查询代码，如需要，关闭全部注释即可
	@PostMapping("/query")
	public CommonResult query(IssueVo issue
//			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
	) {

		System.out.println("待查询条件：" + issue);

		int status = 200;
		String msg = "查询成功";

//		PageHelper.startPage(pageNum, ConstantUtil.PAGE_SIZE_5);

		List<Issue> list = issueService.queryByCondition(issue);
		if (list == null) {
			list = new ArrayList<Issue>();
		}
//		PageInfo<Issue> page = new PageInfo<Issue>(list);
//		MyPageInfo<Issue> dataPage = new MyPageInfo<Issue>(page.getNavigateFirstPage(), page.getPageNum(),
//				page.getNavigateLastPage(), page.getPageSize(), page.getTotal(), list);

//		return new CommonResult<MyPageInfo<Issue>>(status, msg, dataPage);

		return new CommonResult<List<Issue>>(status, msg, list);
	}

	// 修改解决方案&状态
	@PutMapping
	public CommonResult modify(Issue issue) {
		System.out.println("修改后的Issue：" + issue.toString());
		int status = 200;
		String msg = "提交成功";
		issue.setStatus(1); // 状态置为待验证
		int result = issueService.updateIssue(issue);
		if (result != 1) {
			status = 500;
			msg = "提交失败";
		}

		return new CommonResult<String>(status, msg, null);
	}

}
