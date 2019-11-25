package com.spring.mooncy.service;

import java.util.List;
 
import javax.servlet.http.HttpSession;
 
import com.spring.mooncy.dao.QuDAO;
import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.dto.QuVO;
 
public interface QuService {
    // 01. �Խñ� �ۼ�
    public void create(QuVO vo) throws Exception;
    // 02. �Խñ� �󼼺���
    public QuVO read(int q_no) throws Exception;
    // 03. �Խñ� ����
    public void update(QuVO vo) throws Exception;
    // 04. �Խñ� ����
    public void delete(int q_no) throws Exception;
    // 05. �Խñ� ��ü ���
    public List<QuVO> listAll() throws Exception;
//    // 06. �Խñ� ��ȸ
    public void updatecheck(QuVO vo) throws Exception;
}
 
