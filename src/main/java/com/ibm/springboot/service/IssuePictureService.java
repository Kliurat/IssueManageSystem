package com.ibm.springboot.service;

import java.util.List;

import com.ibm.springboot.entity.IssuePicture;

public interface IssuePictureService {
	
	List<IssuePicture> getIssuePicturesByIssueNo(String issueNo);

	
	int insert(IssuePicture issuePicture);
	
	int getCountByIssueNO(String issueNo);
}
