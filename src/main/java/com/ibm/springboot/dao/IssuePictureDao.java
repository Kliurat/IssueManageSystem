package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.springboot.entity.IssuePicture;

@Mapper
public interface IssuePictureDao {
	
	public List<IssuePicture> getIssuePicturesByIssueNo(String issueNo);
	
	public int insert(IssuePicture issuePicture);
	
	public int getCountByIssueNO(String issueNo);
	
}
