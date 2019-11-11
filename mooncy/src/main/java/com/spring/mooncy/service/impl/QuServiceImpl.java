package com.spring.mooncy.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Service;
 
import com.spring.mooncy.dao.QuDAO;
import com.spring.mooncy.dto.QuVO;
import com.spring.mooncy.service.QuService;
 
@Service
public class QuServiceImpl implements QuService {
    
    @Inject
    QuDAO quDao;
    
    // 01. �Խñ۾���
    @Override
    public void create(QuVO vo) throws Exception {
        String q_title = vo.getQ_title();
        String q_desc = vo.getQ_desc();
        String m_id = vo.getM_id();
        // *�±׹��� ó�� (< ==> &lt; > ==> &gt;)
        // replace(A, B) A�� B�� ����
        q_title = q_title.replace("<", "&lt;");
        q_title = q_title.replace("<", "&gt;");
        m_id = m_id.replace("<", "&lt;");
        m_id = m_id.replace("<", "&gt;");
        // *���鹮�� ó��
        q_title = q_title.replace("  ",    "&nbsp;&nbsp;");
        m_id = m_id.replace("  ",    "&nbsp;&nbsp;");
        // *�ٹٲ� ����ó��
        q_desc = q_desc.replace("\n", "<br>");
        vo.setQ_title(q_title);
        vo.setQ_desc(q_desc);
        vo.setM_id(m_id);
        quDao.create(vo);


    }
    // 02. �Խñ� �󼼺���
    @Override
    public QuVO read(int q_no) throws Exception {
        return quDao.read(q_no);
    }
    // 03. �Խñ� ����
    @Override
    public void update(QuVO vo) throws Exception {
        quDao.update(vo);
    }
    // 04. �Խñ� ����
    @Override
    public void delete(int q_no) throws Exception {
        quDao.delete(q_no);
    }
    // 05. �Խñ� ��ü ���
    @Override
    public List<QuVO> listAll() throws Exception {
        return quDao.listAll();
    }
    

}