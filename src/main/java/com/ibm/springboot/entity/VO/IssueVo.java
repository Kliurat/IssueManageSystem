package com.ibm.springboot.entity.VO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IssueVo {

	// IssueNo
	private String issueNo;

	// -1：已关闭；0：待解决；1：待验证
	private int status;

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
	private int createPersonID;

	// Issue指定修改人ID
	private int modifyPersonID;

	// 修改日期
	// 起始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifyStartDate;

	// 结束日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifyEndDate;

	public IssueVo() {
		super();
	}

	public IssueVo(String issueNo, int status, Date createStartDate, Date createEndDate, int createPersonID,
			int modifyPersonID, Date modifyStartDate, Date modifyEndDate) {
		super();
		this.issueNo = issueNo;
		this.status = status;
		this.createStartDate = createStartDate;
		this.createEndDate = createEndDate;
		this.createPersonID = createPersonID;
		this.modifyPersonID = modifyPersonID;
		this.modifyStartDate = modifyStartDate;
		this.modifyEndDate = modifyEndDate;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
				+ ", createEndDate=" + createEndDate + ", createPersonID=" + createPersonID + ", modifyPersonID="
				+ modifyPersonID + ", modifyStartDate=" + modifyStartDate + ", modifyEndDate=" + modifyEndDate + "]";
	}

}
