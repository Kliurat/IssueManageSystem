package com.ibm.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.IssueDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.VO.IssueVo;
import com.ibm.springboot.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueDao issueDao;

	@Override
	public List<Issue> findAll() {
		// TODO Auto-generated method stub
		return issueDao.findAll();
	}

	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return issueDao.delete(id);
	}

	@Override
	public CommonResult insertIssue(Issue issue) {

//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//
//		try {
//			issue.setCreateDate(df.parse(df.format(new Date())));
//			issue.setActualComplteTime(df.parse(df.format(new Date())));
//			issue.setPlanModifyTime(df.parse(df.format(new Date())));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		int i;
		try {
			i = issueDao.insert(issue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CommonResult<String>(201, "Issue编号已存在或插入数据异常", null);
		}
		if (i != 1) {
			return new CommonResult<String>(500, "Issue创建失败", null);
		}
		System.out.println("Issue插入结果：" + i);
		return new CommonResult<String>(200, "Issue创建成功", null);
	}

	@Override
	public List<Issue> queryByCondition(IssueVo issue) {

		return issueDao.queryByCondition(issue);

	}

	@Override
	public int updateIssue(Issue issue) {

		return issueDao.updateIssue(issue);

	}

	@Override
	public int getRowByIssueNo(String issueNo) {
		// TODO Auto-generated method stub
		return issueDao.getRowByIssueNo(issueNo);
	}

	@Override
	public Issue getIssueByIssueNo(String issueNo) {
		// TODO Auto-generated method stub
		return issueDao.getIssueByIssueNo(issueNo);
	}
	
	

}
