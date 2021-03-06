package com.ibm.springboot.service;

import java.util.List;

import com.ibm.springboot.entity.IssueReport;

public interface IssueReportService {

	List<IssueReport> findAll(String loginId, String username);

	IssueReport getReportByLoginID(String loginID);

	int insertReport(IssueReport report);

	int updateReport(IssueReport report);

//	// 24号报表增加-cai
//	int createNumAddOne(String loginId);
//
//	int receiveNumAddOne(String loginId);

}
