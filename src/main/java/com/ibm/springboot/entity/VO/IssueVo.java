package com.ibm.springboot.entity.VO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IssueVo {

	// IssueNo
	private String issueNo;

	// -1：已关闭；0：待解决；1：待验证
	private Integer status;

	// 创建日期
	// 起始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createStartDate;

	// 结束日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createEndDate;

	// Issue创建人ID
	private String createPersonName;

	// Issue指定修改人ID
	private String modifyPersonName;

	// 修改日期
	// 起始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifyStartDate;

	// 结束日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifyEndDate;
	
	//创建人的ID
	private String createPersonID;
	
	//修改人的ID
	private String modifyPersonID;

	public IssueVo() {
		super();
	}
	
	public IssueVo(String issueNo, Integer status, Date createStartDate, Date createEndDate, String createPersonName,
			String modifyPersonName, Date modifyStartDate, Date modifyEndDate) {
		super();
		this.issueNo = issueNo;
		this.status = status;
		this.createStartDate = createStartDate;
		this.createEndDate = createEndDate;
		this.createPersonName = createPersonName;
		this.modifyPersonName = modifyPersonName;
		this.modifyStartDate = modifyStartDate;
		this.modifyEndDate = modifyEndDate;
	}
	
	
	
	public IssueVo(String issueNo, Integer status, Date createStartDate, Date createEndDate, String createPersonName,
			String modifyPersonName, Date modifyStartDate, Date modifyEndDate, String createPersonID,
			String modifyPersonID) {
		super();
		this.issueNo = issueNo;
		this.status = status;
		this.createStartDate = createStartDate;
		this.createEndDate = createEndDate;
		this.createPersonName = createPersonName;
		this.modifyPersonName = modifyPersonName;
		this.modifyStartDate = modifyStartDate;
		this.modifyEndDate = modifyEndDate;
		this.createPersonID = createPersonID;
		this.modifyPersonID = modifyPersonID;
	}

	public String getCreatePersonID() {
		return createPersonID;
	}

	public void setCreatePersonID(String createPersonID) {
		this.createPersonID = createPersonID;
	}

	public String getModifyPersonID() {
		return modifyPersonID;
	}

	public void setModifyPersonID(String modifyPersonID) {
		this.modifyPersonID = modifyPersonID;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateStartDate() {
		return createStartDate;
	}

	public void setCreateStartDate(Date createStartDate) {
		this.createStartDate = createStartDate;
	}

	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public Date getModifyStartDate() {
		return modifyStartDate;
	}

	public void setModifyStartDate(Date modifyStartDate) {
		this.modifyStartDate = modifyStartDate;
	}

	public Date getModifyEndDate() {
		return modifyEndDate;
	}

	public void setModifyEndDate(Date modifyEndDate) {
		this.modifyEndDate = modifyEndDate;
	}

	@Override
	public String toString() {
		return "IssueVo [issueNo=" + issueNo + ", status=" + status + ", createStartDate=" + createStartDate
				+ ", createEndDate=" + createEndDate + ", createPersonName=" + createPersonName + ", modifyPersonName="
				+ modifyPersonName + ", modifyStartDate=" + modifyStartDate + ", modifyEndDate=" + modifyEndDate
				+ ", createPersonID=" + createPersonID + ", modifyPersonID=" + modifyPersonID + "]";
	}

	

	

}
