package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.springboot.entity.IssueReport;

@Mapper
public interface IssueReportDao {

	// 根据输入字段模糊查询
	List<IssueReport> findAll(String userId, String username);

	// 根据 userId 查询
	IssueReport selectByUserId(String userId);

	// 插入记录
	int insert(IssueReport report);

	// 修改记录
	int update(IssueReport report);

}
