package com.ibm.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.dao.IssueDao;
import com.ibm.springboot.dao.IssuePictureDao;
import com.ibm.springboot.entity.Issue;
import com.ibm.springboot.entity.IssuePicture;
import com.ibm.springboot.service.IssuePictureService;

@Service
public class IssuePictureServiceImpl implements IssuePictureService{

	@Autowired
	private IssuePictureDao issuePictureDao;
	
	@Override
	public List<IssuePicture> getIssuePicturesByIssueNo(String issueNo) {
		// TODO Auto-generated method stub
		List<IssuePicture> issuePictures = null;
		try {
			issuePictures = issuePictureDao.getIssuePicturesByIssueNo(issueNo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return issuePictures;
	}

	@Override
	public int insert(IssuePicture issuePicture) {
		// TODO Auto-generated method stub
		int result = -1;
		try {
			String imgUrl1 = issuePicture.getImgUrl();
			
			String replaceAll = imgUrl1.replaceAll("\\\\", "/");
			issuePicture.setImgUrl(replaceAll);
			result = issuePictureDao.insert(issuePicture);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int getCountByIssueNO(String issueNo) {
		// TODO Auto-generated method stub
		return issuePictureDao.getCountByIssueNO(issueNo);
	}

}
