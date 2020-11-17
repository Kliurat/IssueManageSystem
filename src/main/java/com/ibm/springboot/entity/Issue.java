package com.ibm.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	public Issue() {
		super();
	}

	public Issue(int id, String issueNo, String issueType, Date createDate, Date planModifyTime,
			String actualComplteTime, int priority, String influentVersion, String reStep, int createPersonID,
			int modifyPersonID, String title, int status) {
		super();
		this.id = id;
		this.issueNo = issueNo;
		this.issueType = issueType;
		this.createDate = createDate;
		this.planModifyTime = planModifyTime;
		this.actualComplteTime = actualComplteTime;
		this.priority = priority;
		this.influentVersion = influentVersion;
		this.reStep = reStep;
		this.createPersonID = createPersonID;
		this.modifyPersonID = modifyPersonID;
		this.title = title;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPlanModifyTime() {
		return planModifyTime;
	}

	public void setPlanModifyTime(Date planModifyTime) {
		this.planModifyTime = planModifyTime;
	}

	public String getActualComplteTime() {
		return actualComplteTime;
	}

	public void setActualComplteTime(String actualComplteTime) {
		this.actualComplteTime = actualComplteTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getInfluentVersion() {
		return influentVersion;
	}

	public void setInfluentVersion(String influentVersion) {
		this.influentVersion = influentVersion;
	}

	public String getReStep() {
		return reStep;
	}

	public void setReStep(String reStep) {
		this.reStep = reStep;
	}

	public int getCreatePersonID() {
		return createPersonID;
	}

	public void setCreatePersonID(int createPersonID) {
		this.createPersonID = createPersonID;
	}

	public int getModifyPersonID() {
		return modifyPersonID;
	}

	public void setModifyPersonID(int modifyPersonID) {
		this.modifyPersonID = modifyPersonID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
