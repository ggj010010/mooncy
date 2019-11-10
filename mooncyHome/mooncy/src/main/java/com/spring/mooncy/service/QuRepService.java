package com.spring.mooncy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.QuRepVO;

public interface QuRepService {
	// 1. ?���? ?��?��
	public void create(QuRepVO vo);
	// 2. ?���? 목록
	public List<QuRepVO> list(Integer bno, int start, int end, HttpSession session);
	// 4. ?���? ?��?��
	public void update(QuRepVO vo);
	// 5. ?���? ?��?��
	public void delete(Integer rno);
	
	public int reply_delete(QuRepVO vo);
	// 6. ?���? �??��
	public int count(Integer bno);
}
