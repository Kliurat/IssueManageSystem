package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.User;
import com.ibm.springboot.entity.VO.IssueVo;

/*
 * 对Isseu操作的Dao接口
 */

@Mapper
public interface IssueDao {

	// 创建一个新的Issue
	// 0：创建失败；1：创建成功
	int insert(Issue issue);

	int delete(@Param("id") Integer id);

	// 查询与登陆用户有关的Issue
	public List<Issue> getIssuesByUser(User user);

	// 经理查询所有的Issue
	public List<Issue> findAll();

	//模糊查询Issue
	List<Issue> queryByCondition(IssueVo issue);
	
	Issue getIssueByIssueNo(String issueNo);

	//修改Issue
	int updateIssue(Issue issue);

	//查询 issueNo = issueNo  
	int getRowByIssueNo(@Param("issueNo") String issueNo);
	
	//查询出createPersonID 或 modifyPersonID 为登陆id的issue
	List<Issue> queryByID(IssueVo issue);


}
