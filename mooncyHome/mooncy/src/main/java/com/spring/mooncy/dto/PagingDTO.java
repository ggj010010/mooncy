package com.spring.mooncy.dto;

public class PagingDTO {

	

	int totalCnt;
	String m_id;
	int pageNo;

	

	public int getTotalCnt() {

		return totalCnt;

	}

	public void setTotalCnt(int totalCnt) {

		this.totalCnt = totalCnt;

	}

	public int getPageNo() {

		return pageNo;

	}

	public void setPageNo(int pageNo) {

		this.pageNo = pageNo;

	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	

}