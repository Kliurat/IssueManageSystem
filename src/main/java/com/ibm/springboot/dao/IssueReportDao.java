package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.IssueReport;

@Mapper
public interface IssueReportDao {

	List<IssueReport> findAll(@Param("loginId") String loginId, @Param("username") String username);

	IssueReport selectByUserId(String loginId);

	int insert(IssueReport report);

	int update(IssueReport report);

}
