package com.ibm.springboot.service.impl;

import javax.annotation.Resource;

import com.ibm.springboot.dao.IssueDao;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.service.IssueService;

public class IssueServiceImpl implements IssueService {

	@Resource
	IssueDao issueDao;

	@Override
	public void insertIssue(Issue issue) {
		// TODO Auto-generated method stub
		issueDao.insertIssue(issue);
	}

}
