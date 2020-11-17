package com.ibm.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.IssueDao;
import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

	@Resource
	IssueDao issueDao;

	@Override
	public List<Issue> findAll() {
		// TODO Auto-generated method stub
		return issueDao.findAll();
	}

	@Override
	public CommonResult insertIssue(Issue issue) {

		issueDao.insertIssue(issue);
		return new CommonResult<String>(200, "Issue创建成功", null);
	}

}
