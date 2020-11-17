package com.ibm.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue implements Serializable {
	
	//数据库中的id
	private int id;
	
	//IssueNo
	private String issueNo;
	
	//Issue类型
	private String issueType;
	
	//创建时间
	private Date createDate;
	
	//计划修改时间
	private Date planModifyTime;
	
	//实际完成时间
	private String actualComplteTime;
	
	//Issue等级
	//1：最高；2：较高；3：一般；4：低
	private int priority;
	
	//影响版本
	private String influentVersion;
	
	//重现步骤
	private String reStep;
	
	//Issue创建人
	private int createPersonID;
	
	//Issue指定修改人
	private int modifyPersonID;
	
	//Issue标题
	private String title;
	
	//Issue状态
	//-1：已关闭；0：待解决；1：待验证
	private int status;
	
	
	
}
