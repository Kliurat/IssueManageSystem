package com.ibm.springboot.dao;

import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * 对Isseu操作的Dao接口
 */
@Mapper
public interface IssueDao {
	
	//创建一个新的Issue
	//0：创建失败；1：创建成功
	public int insertIssue(@Param("issue") Issue issue);
	
	//查询与登陆用户有关的Issue
	public List<Issue> getIssuesByUser(User user);
	
	
	
	
	//经理的
	public List<Issue> findAll();


}
