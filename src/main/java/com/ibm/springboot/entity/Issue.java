package com.ibm.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibm.springboot.util.ConstantUtil;

public class Issue implements Serializable {

	// 数据库中的id
	private Integer id;

	// IssueNo
	private String issueNo;

	// Issue类型
	private String issueType;

	/*
	 * @DateTimeFormat(pattern = ConstantUtil.DATE_FORMAT_TWO_STRING)
	 * 作用是指定前端向后端传时间参数应用什么格式
	 * 
	 * @JsonFormat(pattern = "yyyy/MM-dd") 指定后端向前端传递的格式
	 */

	// 创建时间
	@DateTimeFormat(pattern = ConstantUtil.DATE_FORMAT_ONE_STRING)
	@JsonFormat(pattern = ConstantUtil.DATE_FORMAT_TWO_STRING)
	private Date createDate;

	// 计划修改时间
	@DateTimeFormat(pattern = ConstantUtil.DATE_FORMAT_ONE_STRING)
	@JsonFormat(pattern = ConstantUtil.DATE_FORMAT_TWO_STRING)
	private Date planModifyTime;

	// 实际完成时间
	@DateTimeFormat(pattern = ConstantUtil.DATE_FORMAT_ONE_STRING)
	@JsonFormat(pattern = ConstantUtil.DATE_FORMAT_TWO_STRING)
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

	private String createPersonName;

	// Issue指定修改人
	private String modifyPersonID;

	private String modifyPersonName;

	// Issue标题
	private String title;

	// Issue状态
	// -1：已关闭；0：待解决；1：待验证
	private Integer status;

	// 解决方案
	private String solution;
	
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Issue() {
		super();
	}

	public Issue(int id, String issueNo, String issueType, Date planModifyTime, Date actualComplteTime, int priority,
			String influentVersion, String reStep, String createPersonID, String modifyPersonID, String title,
			int status) {
		super();
		this.id = id;
		this.issueNo = issueNo;
		this.issueType = issueType;

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

	public Issue(Integer id, String issueNo, String issueType, Date createDate, Date planModifyTime,
			Date actualComplteTime, Integer priority, String influentVersion, String reStep, String createPersonID,
			String createPersonName, String modifyPersonID, String modifyPersonName, String title, Integer status,
			String solution) {
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
		this.createPersonName = createPersonName;
		this.modifyPersonID = modifyPersonID;
		this.modifyPersonName = modifyPersonName;
		this.title = title;
		this.status = status;
		this.solution = solution;
	}

	public Issue(String issueType, Date createDate, Date planModifyTime, Integer priority, String influentVersion,
			String reStep, String modifyPersonID, String title) {
		super();
		this.issueType = issueType;
		this.createDate = createDate;
		this.planModifyTime = planModifyTime;
		this.priority = priority;
		this.influentVersion = influentVersion;
		this.reStep = reStep;
		this.modifyPersonID = modifyPersonID;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getActualComplteTime() {
		return actualComplteTime;
	}

	public void setActualComplteTime(Date actualComplteTime) {
		this.actualComplteTime = actualComplteTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
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

	public String getCreatePersonID() {
		return createPersonID;
	}

	public void setCreatePersonID(String createPersonID) {
		this.createPersonID = createPersonID;
	}

	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public String getModifyPersonID() {
		return modifyPersonID;
	}

	public void setModifyPersonID(String modifyPersonID) {
		this.modifyPersonID = modifyPersonID;
	}

	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", issueNo=" + issueNo + ", issueType=" + issueType + ", createDate=" + createDate
				+ ", planModifyTime=" + planModifyTime + ", actualComplteTime=" + actualComplteTime + ", priority="
				+ priority + ", influentVersion=" + influentVersion + ", reStep=" + reStep + ", createPersonID="
				+ createPersonID + ", createPersonName=" + createPersonName + ", modifyPersonID=" + modifyPersonID
				+ ", modifyPersonName=" + modifyPersonName + ", title=" + title + ", status=" + status + ", solution="
				+ solution + "]";
	}

}
