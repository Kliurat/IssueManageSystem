package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.springboot.entity.IssueReport;

@Mapper
public interface IssueReportDao {

	List<IssueReport> findAll(Integer userId, String username);

	IssueReport selectByUserId(Integer userId);

	int insert(IssueReport report);

	int update(IssueReport report);

}
