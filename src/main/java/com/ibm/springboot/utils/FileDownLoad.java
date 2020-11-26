package com.ibm.springboot.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;


public class FileDownLoad
{
		// 前端传文件给后端
	    public static String fileUpload(MultipartFile file,String fileRootPath)
		{
			
	        String filePath = "";
	        
//	        System.out.println("收到的issueNo为" + issueNo);
	        
	        // 多文件上传
	        
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
	        
	        
	        System.out.println("filePath: "+filePath);
	        System.out.println("fileRootPath: "+fileRootPath);
	        
	        return filePath;
	    }
	 
		// 文件传给前端
		public static void fileDown(HttpServletResponse response,String url)
		{
			try 
			{
				
			    String path[] = {url};

			    OutputStream out = null;
			    BufferedInputStream fis = null;
			    byte[][] buffer = new byte[2][2];
			    
			    for (int i = 0; i < path.length; i++) 
			    {
			    	
			    	File file = new File(path[i]);
				    if(!file.exists()||file.isDirectory())
				    {
				    	throw new FileNotFoundException();
				    }
				    
				    InputStream inputStream = new FileInputStream(file);
				    
				    //输出文件
				    fis = new BufferedInputStream(inputStream);
				    buffer[i] = new byte[fis.available()];
				    fis.read(buffer[i]);
				    
				    //获取文件的名字再浏览器下载页面
				    String name = file.getName();
				    response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes(), "iso-8859-1"));
				    response.addHeader("Content-Length", "" + file.length());
				    out = new BufferedOutputStream(response.getOutputStream());
				    response.setContentType("application/octet-stream");
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
