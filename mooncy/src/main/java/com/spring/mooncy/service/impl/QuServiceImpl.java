package com.spring.mooncy.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Service;
 
import com.spring.mooncy.dao.QuDAO;
import com.spring.mooncy.dto.QuVO;
import com.spring.mooncy.dto.QuVO;
import com.spring.mooncy.dto.QuVO;
import com.spring.mooncy.dto.StoreDTO;
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
    public List<QuVO> listAllView(QuVO quVO, String id) throws Exception {
		quVO.setM_id(id);
        return quDao.listAll(quVO);
    }
	public List<QuVO> listAll() {

		// TODO Auto-generated method stub

		return QuVO.listAll();

	}



    // 06. 게시글 조회수 증가
    /*
    @Override
    public void increaseViewcnt(int q_no, HttpSession session) throws Exception {
        long update_time = 0;
        // 세션에 저장된 조회시간 검색
        // 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행X
        if(session.getAttribute("update_time_"+q_no) != null){
                                // 세션에서 읽어오기
            update_time = (long)session.getAttribute("update_time_"+q_no);
        }
        // 시스템의 현재시간을 current_time에 저장
        long current_time = System.currentTimeMillis();
        // 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
        // 시스템현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
        if(current_time - update_time > 5*1000){
            quDao.increaseViewcnt(q_no);
            // 세션에 시간을 저장 : "update_time_"+q_no는 다른변수와 중복되지 않게 명명한 것
            session.setAttribute("update_time_"+q_no, current_time);
            
        }
    }*/
 
}