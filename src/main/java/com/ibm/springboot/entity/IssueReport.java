package com.ibm.springboot.entity;

public class IssueReport {

	private Integer id; // 序号

	private String loginId; // 登陆ID

	private String username; // 用户姓名

	private int createCount; // 创建数

	private int receiveCount; // 接收数

	private int modifyCount; // 修改数

	private int finishCount; // 完成数

	private float finishedPer; // 完成率

	public IssueReport() {
		super();
	}

	public IssueReport(String loginId, String username, int createCount, int receiveCount, int modifyCount,
			int finishCount, float finishedPer) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.createCount = createCount;
		this.receiveCount = receiveCount;
		this.modifyCount = modifyCount;
		this.finishCount = finishCount;
		this.finishedPer = finishedPer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setUserId(String loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCreateCount() {
		return createCount;
	}

	public void setCreateCount(int createCount) {
		this.createCount = createCount;
	}

	public int getReceiveCount() {
		return receiveCount;
	}

	public void setReceiveCount(int receiveCount) {
		this.receiveCount = receiveCount;
	}

	public int getModifyCount() {
		return modifyCount;
	}

	public void setModifyCount(int modifyCount) {
		this.modifyCount = modifyCount;
	}

	public int getFinishCount() {
		return finishCount;
	}

	public void setFinishCount(int finishCount) {
		this.finishCount = finishCount;
	}

	public float getFinishedPer() {
		return finishedPer;
	}

	public void setFinishedPer(float finishedPer) {
		this.finishedPer = finishedPer;
	}

}
