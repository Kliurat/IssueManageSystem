package com.ibm.springboot.entity.VO;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IssueDetail implements Serializable {
	
	// 数据库中的id
		private Integer id;

		// IssueNo
		private String issueNo;

		// Issue类型
		private String issueType;	

		/*
		 * @DateTimeFormat(pattern = "yyyy/MM/dd") 作用是指定前端向后端传时间参数应用什么格式
		 * 
		 * @JsonFormat(pattern = "yyyy/MM-dd") 指定后端向前端传递的格式
		 */

		// 创建时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy/MM/dd")
		private Date createDate;

		// 计划修改时间
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy/MM/dd")
		private Date planModifyTime;

		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy/MM/dd")
		private Date actualComplteTime;

		// Issue等级
		// 1：最高；2：较高；3：一般；4：低
		private Integer priority;

		// 影响版本
		private String influentVersion;

		// 重现步骤
		private String reStep;

		// Issue创建人
		private String createPersonID;

		// Issue指定修改人
		private String modifyPersonID;

		// Issue标题
		private String title;

		// Issue状态
		// -1：已关闭；0：待解决；1：待验证
		private Integer status;

		//解决方案
		private String solution;

		//创建人姓名
		private String createPersonName;
		
		//修改人姓名
		private String modifyPersonName;
	

}
