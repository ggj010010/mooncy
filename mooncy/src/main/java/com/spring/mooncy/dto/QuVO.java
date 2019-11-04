package com.spring.mooncy.dto;

import java.util.Date;
 
public class QuVO {
    private int q_no;            // �Խñ� ��ȣ
    private String q_title;       // �Խñ� ����
    private String q_desc;     // �Խñ� ����
    private String m_id;      // �Խñ� �ۼ���
    private Date q_date;       // �Խñ� �ۼ����� util.Date
    private int q_check;        // �Խñ� ��ȸ��
	PagingDTO pagingDTO;
    
    // Getter/Setter
    public int getQ_no() {
        return q_no;
    }
    public void setQ_no(int q_no) {
        this.q_no = q_no;
    }
    public String getQ_title() {
        return q_title;
    }
    public void setQ_title(String q_title) {
        this.q_title = q_title;
    }
    public String getQ_desc() {
        return q_desc;
    }
    public void setQ_desc(String q_desc) {
        this.q_desc = q_desc;
    }
    public String getM_id() {
        return m_id;
    }
    public void setM_id(String m_id) {
        this.m_id = m_id;
    }
    public Date getQ_date() {
        return q_date;
    }
    public void setQ_date(Date q_date) {
        this.q_date = q_date;
    }
    public int getQ_check() {
        return q_check;
    }
    public void setQ_check(int q_check) {
        this.q_check = q_check;
    }
	public PagingDTO getPagingDTO() {

		return pagingDTO;

	}

	public void setPagingDTO(PagingDTO pagingDTO) {

		this.pagingDTO = pagingDTO;

	}
    // toString()
    @Override
    public String toString() {
        return "QuVO [q_no=" + q_no + ", q_title=" + q_title + ", q_desc=" + q_desc + ", m_id=" + m_id + ", q_date="
                + q_date + ", q_check=" + q_check + "]";
    }
    
}