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
import com.ibm.springboot.util.ConstantUtil;

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
	// timeStr 前端传过来的计划修改时间
	@PostMapping("")
	public CommonResult insertIssue(Issue issue, HttpSession session,String timeStr) 
	{
		
		//timeStr: 2020-11-29T17:34
		//timePlanString: 2020-11-29 17:34:00
		// 为了将前端传过来的 timeStr 
		//日期格式 转化为 timePlanString 的日期格式
		// 以便插入数据库
		String timeStr1 = timeStr;
		String timeStr2 = timeStr;
		
		int index = timeStr.indexOf("T");
		
		String left = timeStr.substring(0,index);
		System.out.println("left:" + left);
		
		String right = timeStr1.substring(index+1,timeStr2.length());	
		System.out.println("right:" + right);
		
		String timePlanString = left + " " + right + ":00";
		
		System.out.println("timeStr: "+timeStr);
		System.out.println("timePlanString: "+timePlanString);
		
		timeStr = timePlanString;
		
		////////////////////////////////////////////////////////////////////////////////////

		User user = new User();
		
		String createPersonID = issue.getCreatePersonID();
		
		System.out.println("createPersonID :"+createPersonID);
		
		User usersByLoginID = userDao.getUsersByLoginID(createPersonID);	
		
		System.out.println("createPerson :"+usersByLoginID);

		// 经理没有创建 Issue 的权利
		if (usersByLoginID.getRole() != ConstantUtil.ROLE_ORDINARY_USER)
		{
			return new CommonResult<String>(403, ConstantUtil.NO_PRIVILEGE, null);
		}

		// 设置创建时间
		SimpleDateFormat df = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_TWO_STRING);
		Date createDate = null;
		
		try 
		{
			// 设置创建时间
			createDate = df.parse(df.format(new Date()));
			issue.setCreateDate(createDate);
			
			// 设置计划修改时间
			Date parse = df.parse(timeStr);
			issue.setPlanModifyTime(parse);
			
		}
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}

		// 给每一个Issue创建一个唯一的uuid
		String uuid = null;
		
		int row = 0;
		
		do 
		{
			uuid = UUID.randomUUID().toString().replaceAll("-", "");
			uuid = uuid.substring(0, 6);
			
			// 判断数据库中是否存在 uuid == issue_no
			// 如果存在则 row > 0 , 则继续循环
			row = issueService.getRowByIssueNo(uuid);
			
			System.out.println("insertIssue==>生成issueNo冲突，查询row:" + row);

		}while (row != 0);
		issue.setIssueNo(uuid);
		
		issue.setStatus(0); // 状态为 0 代表待解决

		System.out.println("insertIssue==>待插入" + issue.toString());
		
		///////////////////////////////////////////////////////////////////////////////////////

		/*-----------------------------------------------------------------------------------------
		 * 开始
		 * 报表数据更新处理
		 * 
		 */

		// 创建人的Issue创建数加1

		// 1.查看是否有自己的报表行记录
		IssueReport report = null;
		
		report = iRepService.getReportByLoginID(usersByLoginID.getLoginID());

		System.out.println("insertIssue==>loginID:" + usersByLoginID.getLoginID() + ", 报表行：" + report);
		if (report == null) 
		{
			// 2.若无，则插入一条，创建数为1
			iRepService.insertReport(new IssueReport(usersByLoginID.getLoginID(), usersByLoginID.getUsername(), 1, 0, 0, 0));
		}
		else 
		{
			report.setCreateCount(report.getCreateCount() + 1);
			iRepService.updateReport(report);
		}

		/*-----------------------------------------------------------------------------------------
		 * 结束
		 * 报表数据更新处理
		 * 
		 */

		// 根据登陆的user，取出loginID
//		issue.setCreatePersonID(user.getLoginID());

		// 3.插入issue
		CommonResult result = issueService.insertIssue(issue);

		/*-----------------------------------------------------------------------------------------
		 * 开始
		 * 报表数据更新处理
		 * 
		 */
		if (result.getStatus() == 200) {
			// issue创建成功，更新issue发派目标用户的issue报表

			// 4.查看目标用户是否有报表行记录
			report = iRepService.getReportByLoginID(issue.getModifyPersonID());
			if (report == null) {
				// 5.若无，先查询目标用户的信息
				User targetUser = userDao.findByLoginId(issue.getModifyPersonID());

				// 再插入一条issue报表行，收到数为1
				iRepService
						.insertReport(new IssueReport(targetUser.getLoginID(), targetUser.getUsername(), 0, 1, 0, 0));
			} else {
				// 7.计算完成率
				int finished = report.getModifyCount();
				report.setReceiveCount(report.getReceiveCount() + 1);
				int receive = report.getReceiveCount();
				float finishedPer = finished * 1.0f / receive;
				report.setFinishedPer(finishedPer);
				System.out.println("接收人完成率计算结果：" + finishedPer);
				iRepService.updateReport(report);
			}

		}

		/*-----------------------------------------------------------------------------------------
		 * 结束
		 * 报表数据更新处理
		 * 
		 */

		return result;
	}

	// 删除Issue (暂时没有用到)
	@DeleteMapping("")
	public CommonResult delete(@RequestParam("id") Integer id) 
	{

		System.out.println("待删除ID：" + id);

		int status = 200;
		String msg = "删除成功";

		int result;
		try 
		{
			result = issueService.deleteById(id);
			
			if (result != 1)
			{
				status = 500;
				msg = "删除失败";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = 500;
			msg = "服务器异常，请稍后再试";
		}

		return new CommonResult<String>(status, msg, null);
	}

	// 查询全部Issue
	@GetMapping("/all")
	public CommonResult<List<Issue>> getAllIssues() 
	{
		List<Issue> list = issueService.findAll();
		return new CommonResult<List<Issue>>(200, "全部数据查询成功", list);
	}
	
	// 点击详情按钮使用到该函数
	@RequestMapping("/getIssueByIssueNo")
	public Issue getIssueByIssueNo(@RequestParam(value = "issueNo", required = false) String issueNo,
								   @RequestParam(value = "status", required = false) String status)
	{
		System.out.println("获取到的issueNo为： " + issueNo);
		System.out.println("获取到的status为： " + status);
		Issue issue = issueService.getIssueByIssueNo(issueNo);
		return issue;
	}


	// 普通用户的条件查询(六个字段的查询)
	@PostMapping("/query")
	public CommonResult query(HttpSession session, IssueVo issue) 
	{

		System.out.println("待查询条件：" + issue);

		int status = 200;
		String msg = "查询成功";

		List<Issue> list = issueService.queryByCondition(issue);

		if (list == null) 
		{
			list = new ArrayList<Issue>();
		}

		System.out.println("查询结果：");

		for (Issue issue2 : list) 
		{
			System.out.println(issue2);
		}

		return new CommonResult<List<Issue>>(status, msg, list);
	}

	// 根据登陆id查询
	// 普通用户登录系统后页面默认显示出修改人和创建人都是登录用户的 Issue信息
	@PostMapping("/queryIssueByID")
	public CommonResult queryIssueByID(HttpSession session, IssueVo issue)
	{
		int status = 200;
		String msg = "查询成功";

		List<Issue> list = issueService.queryByID(issue);

		if (list == null) 
		{
			list = new ArrayList<Issue>();
		}

		return new CommonResult<List<Issue>>(status, msg, list);
	}

	// 修改解决方案的状态
	@PutMapping("/update")
	public CommonResult modify(Issue issue) 
	{
		System.out.println("修改后的Issue：" + issue.toString());
		int status = 200;
		String msg = "提交成功";

		//表示已关闭
		//需要设置完成时间
		if (issue.getStatus() == ConstantUtil.ISSUE_CLOSED)  
		{
			try 
			{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date parse = df.parse(df.format(new Date()));
				issue.setActualComplteTime(parse);
				System.out.println("实际完成时间：" + parse.toString());
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}

			// 查看目标用户是否有报表行记录

			// 根据IssueNo查找到modifyPersonID
			Issue temp = issueService.getIssueByIssueNo(issue.getIssueNo());
			issue.setModifyPersonID(temp.getModifyPersonID());

			IssueReport report = iRepService.getReportByLoginID(issue.getModifyPersonID());
			if (report == null) 
			{
				// 若无，先查询目标用户的信息
				User targetUser = userDao.findByLoginId(issue.getModifyPersonID());

				// 再插入一条issue报表行，修改数为1
				report = new IssueReport(targetUser.getLoginID(), targetUser.getUsername(), 0, 1, 1, 1);
				iRepService.insertReport(report);

			} 
			else 
			{
				// 计算完成率

				report.setModifyCount(report.getModifyCount() + 1);
				int finished = report.getModifyCount(); // 修改数即为issue的已关闭数，即是完成数
				int receive = report.getReceiveCount();
				float finishedPer = finished * 1.0f / receive;
				System.out.println("完成：" + finished);
				System.out.println("接收：" + receive);
				System.out.println("插入后：完成率= " + finishedPer);
				report.setFinishedPer(finishedPer);
				iRepService.updateReport(report);

			}

		}

		int result = issueService.updateIssue(issue);
		
		if (result != 1)
		{
			status = 500;
			msg = "提交失败";
		}

		return new CommonResult<String>(status, msg, null);
	}

}
