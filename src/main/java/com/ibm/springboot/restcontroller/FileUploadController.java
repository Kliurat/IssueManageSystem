package com.ibm.springboot.restcontroller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.springboot.entity.IssuePicture;
import com.ibm.springboot.service.IssuePictureService;
import com.ibm.springboot.utils.FileDownLoad;

@RestController
public class FileUploadController {
	
	@Autowired
	private IssuePictureService issuePictureService;
	
	@Value("${handsomeboy.file.root.path}")  //不能放在方法中
	private String fileRootPath;
	
	/**
	 * 
	 * @param files   前端上传过来的图片集合
	 * @param issueNo 用户创建的 issue 的 issueNo
	 */
	@PostMapping("/file/upload")
    public void fileUpload(@RequestParam("files") MultipartFile[] files,@RequestParam("issueNo") String issueNo)
	{
		
		for (MultipartFile multipartFile : files) 
		{
			String filePath = FileDownLoad.fileUpload(multipartFile,fileRootPath);  // 文件保存在本地后返回的保存路径
			issuePictureService.insert(new IssuePicture(issueNo,filePath)); // 将 issueNo 以及 filePath 插入到数据库中
		}
		
    }
	
	// 从本地读取文件并进行回显
	@GetMapping("/file/download")
	public void fileDown(HttpServletResponse response,@RequestParam(value = "url") String url)
	{
		System.out.println("获取到的url为：" + url);
		FileDownLoad.fileDown(response,url);
	}

}
