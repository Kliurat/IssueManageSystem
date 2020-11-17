package com.ibm.springboot.service;

import java.util.List;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.Issue;

public interface IssueService {

	List<Issue> findAll();

	CommonResult insertIssue(Issue issue);

}
