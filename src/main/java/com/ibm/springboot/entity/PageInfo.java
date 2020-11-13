package com.ibm.springboot.entity;

import java.util.List;

public class PageInfo<T> {
	private Integer pageIndex; // 起始页

	private Integer pageNum; // 每页容量

	private Integer currentPage; // 当前页

	private Integer endPage; // 尾页

	private Integer total; // 数据总行数

	private List<T> data;

	public PageInfo() {

	}

	public PageInfo(Integer currentPage, Integer total) {
		pageNum = 10;
		this.currentPage = currentPage;
		this.total = total;

		// 计算尾页
		endPage = total / pageNum;
		if (total % pageNum != 0) {
			endPage += 1;
		}

		// 如果已经是首页，那么让跳转页依旧为首页
		if (currentPage == 0) {
			currentPage = 1;
		}

		// 如果已经是尾页，那么让跳转页依旧为尾页
		if (currentPage > endPage) {
			currentPage = endPage;
		}

		// 计算pageIndex
		pageIndex = (currentPage - 1) * pageNum;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
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
		return "PageInfo [pageIndex=" + pageIndex + ", pageNum=" + pageNum + ", currentPage=" + currentPage
				+ ", endPage=" + endPage + ", total=" + total + ", data=" + data + "]";
	}

}
