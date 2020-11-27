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

/*
 * 前端显示图片时，把图片传给前端
 */
@RequestMapping("/picture")
@RestController
public class IssuePictureController {
	
	@Autowired
	private IssuePictureService issuePictureService;
	
	// 根据 issueNo 获取对应的记录数
	@GetMapping("/getCount")
	public int getPictureCountByIssueNo(String issueNo)
	{
		return issuePictureService.getCountByIssueNO(issueNo);
	}
	
	// 根据 issueNo 获取对应的集合，用于获取 url 
	@PostMapping("/getList")
	public List<IssuePicture> getPictureListByIssueNo(@RequestParam(value = "issueNo") String issueNo){
		
		System.out.println("picture中的issueNo为：" + issueNo);
		
		return issuePictureService.getIssuePicturesByIssueNo(issueNo);
	}

}
