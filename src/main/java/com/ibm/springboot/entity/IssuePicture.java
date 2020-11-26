package com.ibm.springboot.entity;

import java.io.Serializable;

public class IssuePicture implements Serializable {
	
	private Integer id;
	
	private String issueNo;
	
	private byte[] pictureByte;
	
	private String imgUrl;
	
	

	public IssuePicture(String issueNo, String imgUrl) {
		super();
		this.issueNo = issueNo;
		this.imgUrl = imgUrl;
	}

	public IssuePicture(Integer id, String issueNo, byte[] pictureByte, String imgUrl) {
		super();
		this.id = id;
		this.issueNo = issueNo;
		this.pictureByte = pictureByte;
		this.imgUrl = imgUrl;
	}

	public IssuePicture() {
		super();
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

	public byte[] getPictureByte() {
		return pictureByte;
	}

	public void setPictureByte(byte[] pictureByte) {
		this.pictureByte = pictureByte;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
	
}
