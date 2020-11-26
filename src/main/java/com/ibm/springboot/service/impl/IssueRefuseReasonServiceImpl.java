package com.ibm.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.IssueRefuseReasonDao;
import com.ibm.springboot.entity.IssueRefuseReason;
import com.ibm.springboot.service.IssueRefuseReasonService;

@Service
public class IssueRefuseReasonServiceImpl implements IssueRefuseReasonService {

	@Autowired
	private IssueRefuseReasonDao issueRefuseReasonDao;
	
	@Override
	public int insert(IssueRefuseReason issueRefuseReason) {
		// TODO Auto-generated method stub
		return issueRefuseReasonDao.insert(issueRefuseReason);
	}

	@Override
	public int update(IssueRefuseReason issueRefuseReason) {
		// TODO Auto-generated method stub
		return issueRefuseReasonDao.update(issueRefuseReason);
	}

	@Override
	public IssueRefuseReason getIssueRefuseReason(String issueNo) {
		// TODO Auto-generated method stub
		return issueRefuseReasonDao.getIssueRefuseReason(issueNo);
	}

}
