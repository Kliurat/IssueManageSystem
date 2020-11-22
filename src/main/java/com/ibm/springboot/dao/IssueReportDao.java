package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.IssueReport;

@Mapper
public interface IssueReportDao {

	// 根据输入字段模糊查询
	List<IssueReport> findAll(@Param("loginId") String loginId, @Param("username") String username);

	// 根据 userId 查询
	IssueReport selectByLoginId(String loginId);

	// 插入记录
	int insert(IssueReport report);

	// 修改记录
	int update(IssueReport report);

}
