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

	// 1. ?κΈ? ?? ₯
	@Override
	public void create(QuRepVO vo) {
		replyDao.create(vo);
	}
	// 2. ?κΈ? λͺ©λ‘
	@Override
	public List<QuRepVO> list(Integer bno, int start, int end, HttpSession session) {
		List<QuRepVO> items = replyDao.list(bno, start, end);
		// ?Έ??? ??¬ ?¬?©? idκ°? ???₯
		String userId = (String) session.getAttribute("userId");
		for(QuRepVO vo : items){
			// ?κΈ? λͺ©λ‘μ€μ μ€μ λΉλ? ?κΈ??΄ ?? κ²½μ°
				if(userId== null){ // λΉλ‘κ·ΈμΈ ??λ©? λΉλ? ?κΈ?λ‘? μ²λ¦¬
					vo.setReplytext("λΉλ? ?κΈ????€.");
				} else { // λ‘κ·Έ?Έ ???Ό κ²½μ°
					String writer = vo.getUserName(); // κ²μλ¬? ??±? ???₯
					// λ‘κ·Έ?Έ? ?¬?©?κ°? κ²μλ¬Όμ ??±?X ?κΈ? ??±?? X λΉλ??κΈ?λ‘? μ²λ¦¬

				}
		}
		return items; 
	}
	// 4. ?κΈ? ?? 
	@Override
	public void update(QuRepVO vo) {
		replyDao.update(vo);
	}
	// 5. ?κΈ? ?­? 
	@Override
	public void delete(Integer rno) {
		replyDao.delete(rno);
	}
	// 6. ?κΈ? κ°??
	@Override
	public int count(Integer bno) {
		return replyDao.count(bno);
	}
	@Override
	public int reply_delete(QuRepVO vo) {
		// TODO Auto-generated method stub
		return replyDao.reply_delete(vo);
	}
}
 