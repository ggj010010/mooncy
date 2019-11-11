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

	// 1. ?Œ“ê¸? ?…? ¥
	@Override
	public void create(QuRepVO vo) {
		replyDao.create(vo);
	}
	// 2. ?Œ“ê¸? ëª©ë¡
	@Override
	public List<QuRepVO> list(Integer bno, int start, int end, HttpSession session) {
		List<QuRepVO> items = replyDao.list(bno, start, end);
		// ?„¸?…˜?—?„œ ?˜„?¬ ?‚¬?š©? idê°? ???¥
		String userId = (String) session.getAttribute("userId");
		for(QuRepVO vo : items){
			// ?Œ“ê¸? ëª©ë¡ì¤‘ì— ì¤‘ì— ë¹„ë? ?Œ“ê¸??´ ?ˆ?„ ê²½ìš°
				if(userId== null){ // ë¹„ë¡œê·¸ì¸ ?ƒ?ƒœë©? ë¹„ë? ?Œ“ê¸?ë¡? ì²˜ë¦¬
					vo.setReplytext("ë¹„ë? ?Œ“ê¸??…?‹ˆ?‹¤.");
				} else { // ë¡œê·¸?¸ ?ƒ?ƒœ?¼ ê²½ìš°
					String writer = vo.getUserName(); // ê²Œì‹œë¬? ?‘?„±? ???¥
					// ë¡œê·¸?¸?•œ ?‚¬?š©?ê°? ê²Œì‹œë¬¼ì˜ ?‘?„±?X ?Œ“ê¸? ?‘?„±??„ X ë¹„ë??Œ“ê¸?ë¡? ì²˜ë¦¬

				}
		}
		return items; 
	}
	// 4. ?Œ“ê¸? ?ˆ˜? •
	@Override
	public void update(QuRepVO vo) {
		replyDao.update(vo);
	}
	// 5. ?Œ“ê¸? ?‚­? œ
	@Override
	public void delete(Integer rno) {
		replyDao.delete(rno);
	}
	// 6. ?Œ“ê¸? ê°??ˆ˜
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
 