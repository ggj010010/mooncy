package com.spring.mooncy.dto;

import java.util.Date;

public class QuRepVO {

    private Integer q_r_no;        // ´ñ±Û ¹øÈ£
    private Integer q_no;        // °Ô½Ã±Û ¹øÈ£
    private String q_r_desc;    // ´ñ±Û ³»¿ë
    private String r_id;        // ´ñ±Û ÀÛ¼ºÀÚ
    private Date q_r_date;        // ´ñ±Û ÀÛ¼ºÀÏÀÚ
   
    // Getter/Setter
    public Integer getQ_r_no() {
        return q_r_no;
    }
    public void setQ_r_no(Integer q_r_no) {
        this.q_r_no = q_r_no;
    }
    public Integer getQ_no() {
        return q_no;
    }
    public void setQ_no(Integer q_no) {
        this.q_no = q_no;
    }
    public String getQ_r_desc() {
        return q_r_desc;
    }
    public void setQ_r_desc(String q_r_desc) {
        this.q_r_desc = q_r_desc;
    }
    public String getR_id() {
        return r_id;
    }
    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public Date getQ_r_date() {
        return q_r_date;
    }
    public void setQ_r_date(Date q_r_date) {
        this.q_r_date = q_r_date;
    }

    
    // toString()
    @Override
    public String toString() {
        return "QuRepVO [q_r_no=" + q_r_no + ", q_no=" + q_no + ", q_r_desc=" + q_r_desc + ", r_id=" + r_id
                + ", q_r_date=" + q_r_date + "]";
    }
    
    
}