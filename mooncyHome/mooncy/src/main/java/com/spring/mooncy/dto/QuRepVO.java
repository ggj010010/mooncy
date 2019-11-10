package com.spring.mooncy.dto;

import java.util.Date;

public class QuRepVO {

    private Integer rno;        // ��� ��ȣ
    private Integer bno;        // �Խñ� ��ȣ
    private String replytext;    // ��� ����
    private String userName;        // ��� �ۼ���
    private Date updatedate;        // ��� �ۼ�����
    
    // Getter/Setter
    public Integer getRno() {
        return rno;
    }
    public void setRno(Integer rno) {
        this.rno = rno;
    }
    public Integer getBno() {
        return bno;
    }
    public void setBno(Integer bno) {
        this.bno = bno;
    }
    public String getReplytext() {
        return replytext;
    }
    public void setReplytext(String replytext) {
        this.replytext = replytext;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUpdatedate() {
        return updatedate;
    }
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    
    // toString()
    @Override
    public String toString() {
        return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", userName=" + userName
                + ", updatedate=" + updatedate + "]";
    }
    
    
}