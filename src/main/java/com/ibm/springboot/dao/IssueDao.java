package com.ibm.springboot.dao;

import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.Issue;

public interface IssueDao {

	void insertIssue(@Param("issue") Issue issue);

}
