package com.ibm.springboot.service;

import java.util.List;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.VO.IssueVo;

public interface IssueService {

	List<Issue> findAll();

	int deleteById(Integer id) throws Exception;

	CommonResult insertIssue(Issue issue);

	List<Issue> queryByCondition(IssueVo issue);

	int updateIssue(Issue issue);

	int getRowByIssueNo(String issueNo);
}
