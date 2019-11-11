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
    
    // 01. 게시글쓰기
    @Override
    public void create(QuVO vo) throws Exception {
        String q_title = vo.getQ_title();
        String q_desc = vo.getQ_desc();
        String m_id = vo.getM_id();
        // *태그문자 처리 (< ==> &lt; > ==> &gt;)
        // replace(A, B) A를 B로 변경
        q_title = q_title.replace("<", "&lt;");
        q_title = q_title.replace("<", "&gt;");
        m_id = m_id.replace("<", "&lt;");
        m_id = m_id.replace("<", "&gt;");
        // *공백문자 처리
        q_title = q_title.replace("  ",    "&nbsp;&nbsp;");
        m_id = m_id.replace("  ",    "&nbsp;&nbsp;");
        // *줄바꿈 문자처리
        q_desc = q_desc.replace("\n", "<br>");
        vo.setQ_title(q_title);
        vo.setQ_desc(q_desc);
        vo.setM_id(m_id);
        quDao.create(vo);


    }
    // 02. 게시글 상세보기
    @Override
    public QuVO read(int q_no) throws Exception {
        return quDao.read(q_no);
    }
    // 03. 게시글 수정
    @Override
    public void update(QuVO vo) throws Exception {
        quDao.update(vo);
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int q_no) throws Exception {
        quDao.delete(q_no);
    }
    // 05. 게시글 전체 목록
    @Override
    public List<QuVO> listAll() throws Exception {
        return quDao.listAll();
    }
    

}