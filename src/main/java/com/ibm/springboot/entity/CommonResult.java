package com.ibm.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

	public CommonResult(int status2, String msg2, Object object) {
		// TODO Auto-generated constructor stub
	}

	// 状态码，200：响应成功，404：资源找不到
	private Integer status;

	// 消息：如："修改成功"
	private String msg;

	// 携带数据
	private T data;

}
