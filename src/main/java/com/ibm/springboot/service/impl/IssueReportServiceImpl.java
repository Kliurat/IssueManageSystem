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
	public List<IssueReport> findAll(String loginId, String username) {

		return issueReportDao.findAll(loginId, username);

	}

	/**
	 * 当用户创建一个Issue的时候，需要获取 create_count 并将其值加一
	 */
	@Override
	public IssueReport getReportByLoginID(String loginID) {
		return issueReportDao.selectByLoginId(loginID);
	}

	@Override
	public int insertReport(IssueReport report) {

		float finishedPer = report.getFinishedPer();
		int temp = (int) (finishedPer * 1000);
		int k = temp % 10; // 取出第三位
		if (k >= 5) {

			int t = (int) (finishedPer * 100) + 1;
			report.setFinishedPer(t);
		} else {

			int t = (int) (finishedPer * 100);
			report.setFinishedPer(t);
		}
		int result = issueReportDao.insert(report);

		System.out.println("用户报表插入结果：" + result);

		return result;
	}

	@Override
	public int updateReport(IssueReport report) {
		float finishedPer = report.getFinishedPer();
		int temp = (int) (finishedPer * 1000);
		int k = temp % 10; // 取出第三位
		if (k >= 5) {

			int t = (int) (finishedPer * 100) + 1;
			report.setFinishedPer(t);
		} else {

			int t = (int) (finishedPer * 100);
			report.setFinishedPer(t);
		}

		int result = issueReportDao.update(report);
		return result;
	}

}
