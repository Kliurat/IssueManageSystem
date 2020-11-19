package com.ibm.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.IssueReportDao;
import com.ibm.springboot.entity.IssueReport;
import com.ibm.springboot.service.IssueReportService;

@Service
public class IssueReportServiceImpl implements IssueReportService {

	@Resource
	IssueReportDao issueReportDao;

	@Override
	public List<IssueReport> findAll(Integer loginId, String username) {

		return issueReportDao.findAll(loginId, username);
	}

	@Override
	public IssueReport getReportByLoginID(Integer loginID) {
		return issueReportDao.selectByUserId(loginID);
	}

	@Override
	public int insertReport(IssueReport report) {
		// TODO Auto-generated method stub
		int result = issueReportDao.insert(report);
		System.out.println("用户报表插入结果：" + result);
		return result;
	}

	@Override
	public int updateReport(IssueReport report) {
		int result = issueReportDao.update(report);
		return result;
	}

}
