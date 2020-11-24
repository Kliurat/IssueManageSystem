package com.ibm.springboot.restcontroller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	
	@Value("${handsomeboy.file.root.path}")  //不能放在方法中
	private String fileRootPath;
	
//	// 将文件保存到本地
//	@PostMapping("/picture/import")
//	public HashMap<String, Object> importStudents(@RequestParam("file") MultipartFile file) throws IOException {
//		
//		System.out.println("进来了。。。。。。。。。。。。。。。。。");
//		
//	    System.out.println("file: "+file);
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		
//        String desFile = "F:/JMPX/picture.docx";
//		
//		// 文件输入输出流
//        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
////	FileInputStream fileInputStream = null;
//	    FileOutputStream fileOutputStream = null;
//
//        //使用管道的方式复制文件，比较高效
//        FileChannel in = null;
//        FileChannel out = null;
//        
//        try
//        {
//            
////            	fileInputStream = new FileInputStream(file[i]);
//                fileOutputStream = new FileOutputStream(desFile);
//                
//                in = fileInputStream.getChannel();
//                out = fileOutputStream.getChannel();
//                
//                in.transferTo(0,in.size(),out);
//				
//			
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                fileInputStream.close();
//                in.close();
//                fileOutputStream.close();
//                out.close();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//
//        }
//
//		return map;
//
//	}
	
	@PostMapping("/file/upload")
    public String fileUpload(@RequestParam("files") MultipartFile[] files)
	{
		
		System.out.println("进入12121212121212");
		System.out.println("files: "+files);
		
        String filePath = "";
        
        // 多文件上传
        for (MultipartFile file : files)
        {
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            
            // 存储路径
             filePath = new StringBuilder(fileRootPath)
                    .append(System.currentTimeMillis())
                    .append(originalFilename)
                    .toString();
            try 
            {
                // 保存文件
                file.transferTo(new File(filePath));
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("filePath: "+filePath);
        System.out.println("fileRootPath: "+fileRootPath);
        
        return filePath;
    }
	
	// 从本地读取文件并进行回显
	@GetMapping("/file/download")
	public void fileDown(HttpServletResponse response)
	{
		try 
		{
//		    ClassPathResource classPathResource = new ClassPathResource("sql/1606204571676error.jpg");
//		    File file = classPathResource.getFile();
//		    InputStream inputStream = (InputStream) classPathResource.getInputStream();
		    
		    String path[] = {"F:\\JMPX\\1606205851789Doge.jpg","F:\\JMPX\\1606209566548Doge.jpg"};
		    
		    OutputStream out = null;
		    BufferedInputStream fis = null;
		    byte[][] buffer = new byte[2][2];
		    
		    for (int i = 0; i < path.length; i++) 
		    {
		    	
		    	System.out.println("1111111111111111111111111111 :"+i);
		    	
		    	File file = new File(path[i]);
			    if(!file.exists()||file.isDirectory())
			    {
			    	throw new FileNotFoundException();
			    }
			    
			    System.out.println("22222222222222222222222");
			    
			    
			    InputStream inputStream = new FileInputStream(file);
			    
			    System.out.println("33333333333333333333333");
			    
			    
			    //输出文件
			    fis = new BufferedInputStream(inputStream);
			    buffer[i] = new byte[fis.available()];
			    fis.read(buffer[i]);
			    
			    System.out.println("4444444444444444444444444");

			    //获取文件的名字再浏览器下载页面
			    String name = file.getName();
			    response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes(), "iso-8859-1"));
			    response.addHeader("Content-Length", "" + file.length());
			    out = new BufferedOutputStream(response.getOutputStream());
			    response.setContentType("application/octet-stream");

			    System.out.println("5555555555555555555555555555555555");
			    
			    System.out.println("66666666666666666666666666666666666666");
			    
			}
		    
		    fis.close();
		    
		    response.reset();
		    
		    for (int i = 0; i < buffer.length; i++) {
		    	out.write(buffer[i]);
			}
		    
		    out.flush();
		    out.close();
		    
		} 
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		
	}

		
}
