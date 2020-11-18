package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.VO.IssueVo;

@Mapper
public interface IssueDao {

	List<Issue> findAll();

	int insertIssue(@Param("issue") Issue issue);

	List<Issue> queryByCondition(@Param("issue") IssueVo issue);

}
