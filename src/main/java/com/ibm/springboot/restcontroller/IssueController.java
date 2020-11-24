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
//@CrossOrigin(allowCredentials = "true")
public class IssueController {

	@Resource
	IssueService issueService;

	@Resource
	IssueReportService iRepService;

	@Resource
	UserDao userDao;

	// 创建Issue
	@PostMapping("")
	public CommonResult insertIssue(Issue issue, HttpSession session) 
	{
		
		////////////////////////////////////////////////////////////////////////////////////

		User user = new User();
		user.setLoginID(issue.getCreatePersonID());
//		if (user.getRole() != 0) {
//			return new CommonResult<String>(403, ConstantUtil.NO_PRIVILEGE, null);
//		}

		System.out.println("进入.......................................................");
		System.out.println(issue);

		System.out.println("待插入Issue:" + issue.toString());

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");// 设置日期格式
		System.out.println("当前日期：" + df.format(new Date()));// new Date()为获取当前系统时间

		// 给每一个Issue创建一个唯一的uuid
		String uuid = null;
		int row = 0;
		do {
			uuid = UUID.randomUUID().toString().replaceAll("-", "");
			uuid = uuid.substring(0, 6);
			// 判断数据库中是否存在该索引
			row = issueService.getRowByIssueNo(uuid);
			System.out.println("生成issueNo冲突，查询row:" + row);

		} while (row != 0);

		issue.setIssueNo(uuid);
		issue.setStatus(0);

		try {
			issue.setCreateDate(df.parse(df.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("待插入Issue:" + issue.toString());

//		System.out.println("查看session存储的user:" + user);

		// 1.查看是否有自己的报表行记录
		IssueReport report = null;
		report = iRepService.getReportByLoginID(user.getLoginID());
//		try {
//			
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			if (e instanceof NullPointerException) {
//				return new CommonResult<String>(201, "您尚未登陆，请先登陆", null);
//			}
//		}
		System.out.println("查看快快快：" + report);
		if (report == null) {
			// 2.若无，则插入一条，创建数为1
			System.out.println("插入开始");
			iRepService.insertReport(new IssueReport(user.getLoginID(), user.getUsername(), 1, 0, 0, 0, 0));
			System.out.println("插入结束");
		} else {
			report.setCreateCount(report.getCreateCount() + 1);
			iRepService.updateReport(report);
		}

		// 根据登陆的user，取出loginID
		issue.setCreatePersonID(user.getLoginID());

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

	@RequestMapping("/getIssueByIssueNo")
	public Issue getIssueByIssueNo(@RequestParam(value = "issueNo", required = false) String issueNo,
			@RequestParam(value = "status", required = false) String status) {

		System.out.println("获取到的issueNo为： " + issueNo);
		System.out.println("获取到的status为： " + status);
		Issue issue = issueService.getIssueByIssueNo(issueNo);
		
		issue.setUrl("F:\\JMPX\\16062045717911.jpg");
		
		return issue;
		
	}

	// 条件查询
	@PostMapping("/query")
	public CommonResult query(HttpSession session,IssueVo issue) {

		System.out.println("3333333333333333333333333333333333333");
		System.out.println("查询后的sessionID为：" + session.getId());
		
		System.out.println("待查询条件：" + issue);

		int status = 200;
		
		String msg = "查询成功";

		List<Issue> list = issueService.queryByCondition(issue);
		
		if (list == null) {
			list = new ArrayList<Issue>();
		}

		System.out.println("查询结果：");

		for (Issue issue2 : list) {
			System.out.println(issue2);
		}

		return new CommonResult<List<Issue>>(status, msg, list);
	}
	
		// 根据登陆id查询
		@PostMapping("/queryIssueByID")
		public CommonResult queryIssueByID(HttpSession session,IssueVo issue) {
			
			System.out.println("2222222222222222222222222222222222");
			System.out.println("查询后的sessionID为：" + session.getId());


			int status = 200;
			String msg = "查询成功";

			List<Issue> list = issueService.queryByID(issue);
			
			if (list == null) {
				list = new ArrayList<Issue>();
			}



			return new CommonResult<List<Issue>>(status, msg, list);
		}

	// 修改解决方案&状态
	@PutMapping("/update")
	public CommonResult modify(Issue issue) {
		System.out.println("修改后的Issue：" + issue.toString());
		int status = 200;
		String msg = "提交成功";
//
//		issue.setStatus(1); // 状态置为待验证
		
		if(issue.getStatus() == -1) {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");// 设置日期格式
				issue.setActualComplteTime(df.parse(df.format(new Date())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int result = issueService.updateIssue(issue);
		if (result != 1) {
			status = 500;
			msg = "提交失败";
		}

		return new CommonResult<String>(status, msg, null);
	}

}
