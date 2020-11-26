package com.ibm.springboot.service;

import org.springframework.stereotype.Service;

import com.ibm.springboot.entity.IssueRefuseReason;


public interface IssueRefuseReasonService {
	
	public int insert(IssueRefuseReason issueRefuseReason);
	
	public int update(IssueRefuseReason issueRefuseReason);
	
	public IssueRefuseReason getIssueRefuseReason(String issueNo);
}
