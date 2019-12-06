package com.spring.mooncy.dto;

import java.sql.Date;

public class Order_ManagementDTO {
	int om_no;
	int o_no;
	String request_id;
	String response_id;
	String request_name;
	String response_name;
	String p_name;
	String p_count;
	String om_date;
	String m_name;
	String start;
	String end;
	
	PagingDTO pagingDTO;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	int om_count;
	public int getOm_no() {
		return om_no;
	}
	public void setOm_no(int om_no) {
		this.om_no = om_no;
	}
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getResponse_id() {
		return response_id;
	}
	public void setResponse_id(String response_id) {
		this.response_id = response_id;
	}
	public String getRequest_name() {
		return request_name;
	}
	public void setRequest_name(String request_name) {
		this.request_name = request_name;
	}
	public String getResponse_name() {
		return response_name;
	}
	public void setResponse_name(String response_name) {
		this.response_name = response_name;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_count() {
		return p_count;
	}
	public void setP_count(String p_count) {
		this.p_count = p_count;
	}
	public String getOm_date() {
		return om_date;
	}
	public void setOm_date(String om_date) {
		this.om_date = om_date;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getOm_count() {
		return om_count;
	}
	public void setOm_count(int om_count) {
		this.om_count = om_count;
	}
	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}
	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}
	
	
	
	
}
