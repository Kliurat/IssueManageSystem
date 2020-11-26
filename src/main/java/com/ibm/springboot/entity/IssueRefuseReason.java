package com.ibm.springboot.entity;

import java.io.Serializable;

public class IssueRefuseReason implements Serializable {
	
	private String issueNo;
	
	private String reason;

	public IssueRefuseReason() {
		super();
	}

	public IssueRefuseReason(String issueNo, String reason) {
		super();
		this.issueNo = issueNo;
		this.reason = reason;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
