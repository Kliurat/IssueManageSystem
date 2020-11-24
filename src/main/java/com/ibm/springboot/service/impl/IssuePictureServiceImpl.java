package com.ibm.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.IssueDao;
import com.ibm.springboot.entity.IssuePicture;
import com.ibm.springboot.service.IssuePictureService;

@Service
public class IssuePictureServiceImpl implements IssuePictureService{

	@Autowired
	private IssueDao issueDao;
	
	@Override
	public List<IssuePicture> getIssuePicturesByIssueNo(String issueNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
