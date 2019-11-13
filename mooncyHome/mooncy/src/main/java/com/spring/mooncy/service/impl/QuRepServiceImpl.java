package com.spring.mooncy.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


import com.spring.mooncy.dao.QuRepDAO;
import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.service.QuRepService;

@Service
public class QuRepServiceImpl implements QuRepService {
	
	@Inject
	QuRepDAO replyDao;

	// 1. ?���? ?��?��
	@Override
	public void create(QuRepVO vo) {
		replyDao.create(vo);
	}
	// 2. ?���? 목록
	@Override
	public List<QuRepVO> list(Integer q_no, int start, int end, HttpSession session) {
		List<QuRepVO> items = replyDao.list(q_no, start, end);
		// ?��?��?��?�� ?��?�� ?��?��?�� id�? ???��
		String userId = (String) session.getAttribute("userId");
		for(QuRepVO vo : items){
			// ?���? 목록중에 중에 비�? ?���??�� ?��?�� 경우
				if(userId== null){ // 비로그인 ?��?���? 비�? ?���?�? 처리
					vo.setQ_r_desc("로그인을 안하셧습니다.");
				} else { // 로그?�� ?��?��?�� 경우
					String writer = vo.getR_id(); // 게시�? ?��?��?�� ???��
					// 로그?��?�� ?��?��?���? 게시물의 ?��?��?��X ?���? ?��?��?��?�� X 비�??���?�? 처리

				}
		}
		return items; 
	}
	// 4. ?���? ?��?��
	@Override
	public void update(QuRepVO vo) {
		replyDao.update(vo);
	}
	// 5. ?���? ?��?��
	@Override
	public void delete(Integer q_r_no) {
		replyDao.delete(q_r_no);
	}
	// 6. ?���? �??��
	@Override
	public int count(Integer q_no) {
		return replyDao.count(q_no);
	}
	@Override
	public int reply_delete(QuRepVO vo) {
		// TODO Auto-generated method stub
		return replyDao.reply_delete(vo);
	}
}
 