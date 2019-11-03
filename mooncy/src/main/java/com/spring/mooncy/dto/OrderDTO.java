package com.spring.mooncy.dto;


public class OrderDTO {
	int o_no;
	String m_id;
	String m_name;
	int o_check;
	String p_name;
	String p_count;
	String p_date;
	String request_id;
	PagingDTO pagingDTO;
	

	

	

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public int getO_check() {
		return o_check;
	}

	public void setO_check(int o_check) {
		this.o_check = o_check;
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

	

	public String getp_date() {
		return p_date;
	}

	public void setp_date(String p_date) {
		this.p_date = p_date;
	}

	public PagingDTO getPagingDTO() {

		return pagingDTO;

	}

	public void setPagingDTO(PagingDTO pagingDTO) {

		this.pagingDTO = pagingDTO;

	}
	
	
	@Override

	public String toString() {

		return "o_no" + o_no + "m_id" + m_id +"o_check" + o_check + "p_name" + p_name + "p_count" + p_count;

	}
}
