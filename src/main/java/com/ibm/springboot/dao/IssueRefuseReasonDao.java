package com.ibm.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.springboot.entity.IssueRefuseReason;

@Mapper
public interface IssueRefuseReasonDao {

	public int insert(IssueRefuseReason issueRefuseReason);
	
	public int update(IssueRefuseReason issueRefuseReason);
	
	public IssueRefuseReason getIssueRefuseReason(String issueNo);
	
}
