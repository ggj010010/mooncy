package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.QuVO;
 
public interface QuDAO {
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
    public List<QuVO> listAllView(PagingDTO pagingDTO) throws Exception;
    // 06. �Խñ� üũ����
    public void updatecheck(QuVO vo) throws Exception;
    


}
