package com.ibm.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.entity.IssuePicture;
import com.ibm.springboot.service.IssuePictureService;

@RequestMapping("/picture")
@RestController
public class IssuePictureController {
	
	@Autowired
	private IssuePictureService issuePictureService;
	
	@GetMapping("/getCount")
	public int getPictureCountByIssueNo(String issueNo) {
		return issuePictureService.getCountByIssueNO(issueNo);
	}
	
	@PostMapping("/getList")
	public List<IssuePicture> getPictureListByIssueNo(@RequestParam(value = "issueNo")String issueNo){
		
		System.out.println("picture中的issueNo为：" + issueNo);
		
		return issuePictureService.getIssuePicturesByIssueNo(issueNo);
	}

}
