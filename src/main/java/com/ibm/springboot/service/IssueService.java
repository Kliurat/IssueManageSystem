package com.ibm.springboot.service;

import java.util.List;
import java.util.Map;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.VO.IssueVo;

public interface IssueService {

	List<Issue> findAll();

	int deleteById(Integer id) throws Exception;

	CommonResult insertIssue(Issue issue);

	List<Issue> queryByCondition(IssueVo issue);
	
	List<Issue> queryByID(IssueVo issue);

	int updateIssue(Issue issue);

	int getRowByIssueNo(String issueNo);
	
	Issue getIssueByIssueNo(String issueNo);
	
	// 导出
	List<Map<String, Object>> queryUserInfoResultListMap();
}
