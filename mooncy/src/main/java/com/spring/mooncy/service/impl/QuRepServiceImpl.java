package com.spring.mooncy.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


import com.spring.mooncy.dao.QuRepDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.dto.QuVO;
import com.spring.mooncy.service.QuRepService;

@Service
public class QuRepServiceImpl implements QuRepService {
   
   @Inject
   QuRepDAO qurepDAO;

   // 1. ?���? ?��?��
   @Override
   public void create(QuRepVO vo) {
      qurepDAO.create(vo);
   }
   // 2. ?���? 목록
   @Override
   public List<QuRepVO> list(Integer q_no, int start, int end, HttpSession session) {
      List<QuRepVO> items = qurepDAO.list(q_no, start, end);
      // ?��?��?��?�� ?��?�� ?��?��?�� id�? ???��
      String userId = (String) session.getAttribute("userId");
      for(QuRepVO vo : items){
         // ?���? 목록중에 중에 비�? ?���??�� ?��?�� 경우
            if(userId== null){ // 비로그인 ?��?���? 비�? ?���?�? 처리
               vo.setQ_r_desc("a");
            } else { // 로그?�� ?��?��?�� 경우
               String writer = vo.getR_id(); // 게시�? ?��?��?�� ???��
               // 로그?��?�� ?��?��?���? 게시물의 ?��?��?��X ?���? ?��?��?��?�� X 비�??���?�? 처리

            }
      }
      return items; 
   }
   // 4. ?���? ?��?��

   // 5. ?���? ?��?��
//   @Override
//   public void delete(Integer q_r_no) {
//      qurepDAO.delete(q_r_no);
//   }
//   // 6. ?���? �??��
   @Override
   public int count(Integer q_no) {
      return qurepDAO.count(q_no);
   }
   @Override
   public int reply_delete(QuRepVO vo) {
      // TODO Auto-generated method stub
      return qurepDAO.reply_delete(vo);
   }
   public int insert_reply(QuRepVO vo) {
		// TODO Auto-generated method stub
		
		return qurepDAO.insert_reply(vo);

	}
@Override
public void update(QuRepVO vo) {
	// TODO Auto-generated method stub
	
}
@Override
public List<QuRepVO> readRep(int q_no) throws Exception {
        return qurepDAO.readRep(q_no);
    }
}
 