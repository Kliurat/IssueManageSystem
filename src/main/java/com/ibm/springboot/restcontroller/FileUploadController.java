package com.ibm.springboot.restcontroller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ibm.springboot.utils.FileDownLoad;

@RestController
public class FileUploadController {
	
	@PostMapping("/file/upload")
    public String fileUpload(@RequestParam("files") MultipartFile[] files)
	{
        String filePath = FileDownLoad.fileUpload(files);
        return filePath;
    }
	
	// 从本地读取文件并进行回显
	@GetMapping("/file/download")
	public void fileDown(HttpServletResponse response)
	{
		FileDownLoad.fileDown(response);
	}

}
