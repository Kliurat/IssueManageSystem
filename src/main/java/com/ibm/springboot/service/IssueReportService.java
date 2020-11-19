package com.ibm.springboot.service;

import java.util.List;

import com.ibm.springboot.entity.IssueReport;

public interface IssueReportService {

	List<IssueReport> findAll(Integer loginId, String username);

	IssueReport getReportByLoginID(Integer loginID);

	int insertReport(IssueReport report);

	int updateReport(IssueReport report);

}
