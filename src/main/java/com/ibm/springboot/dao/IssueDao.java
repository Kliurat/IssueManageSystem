package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.Issue;

@Mapper
public interface IssueDao {

	List<Issue> findAll();

	void insertIssue(@Param("issue") Issue issue);

}
