package com.ibm.springboot.entity;

public class Student {
	private Integer id;

	private String name;

	private String stuNo;

	private String classNo;

	private String major;

	private String image;

	public Student() {
		super();
	}

	public Student(Integer id, String name, String stuNo, String classNo, String major, String image) {
		super();
		this.id = id;
		this.name = name;
		this.stuNo = stuNo;
		this.classNo = classNo;
		this.major = major;
		this.image = image;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", stuNo=" + stuNo + ", classNo=" + classNo + ", major=" + major
				+ ", image=" + image + "]";
	}

}
