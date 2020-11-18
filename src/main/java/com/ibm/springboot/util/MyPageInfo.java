package com.ibm.springboot.util;

import java.util.List;

public class MyPageInfo<T> {

	private Integer startPage; // 起始页

	private Integer currentPage; // 当前页

	private Integer endPage; // 尾页

	private Integer pageSize; // 每页容量

	private Long total; // 数据总行数

	private List<T> data;

	public MyPageInfo() {

	}

	public MyPageInfo(Integer startPage, Integer currentPage, Integer endPage, Integer pageSize, Long total,
			List<T> data) {
		super();
		this.startPage = startPage;
		this.currentPage = currentPage;
		this.endPage = endPage;
		this.pageSize = pageSize;
		this.total = total;
		this.data = data;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageNum(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PageInfo [startPage=" + startPage + ", currentPage=" + currentPage + ", endPage=" + endPage
				+ ", pageSize=" + pageSize + ", total=" + total + ", data=" + data + "]";
	}

}
