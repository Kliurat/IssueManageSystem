package com.ibm.springboot.entity;

public class CommonResult<T> {

	// 状态码，200：响应成功，201:登陆失败，404：资源找不到

	private Integer status;

	// 消息：如："修改成功"
	private String msg;

	// Response数据
	private T data;

	public CommonResult() {
		super();
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
=======
>>>>>>> 55ce1b775d7eae7d2a696c92dcaea24c24be5636
	}

	public CommonResult(Integer status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
<<<<<<< HEAD
	
	
=======

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
>>>>>>> 55ce1b775d7eae7d2a696c92dcaea24c24be5636

}
