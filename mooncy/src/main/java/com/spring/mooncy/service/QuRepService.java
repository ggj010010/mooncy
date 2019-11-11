package com.spring.mooncy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.QuRepVO;

public interface QuRepService {
	// 1. ?Œ“ê¸? ?…? ¥
	public void create(QuRepVO vo);
	// 2. ?Œ“ê¸? ëª©ë¡
	public List<QuRepVO> list(Integer bno, int start, int end, HttpSession session);
	// 4. ?Œ“ê¸? ?ˆ˜? •
	public void update(QuRepVO vo);
	// 5. ?Œ“ê¸? ?‚­? œ
	public void delete(Integer rno);
	
	public int reply_delete(QuRepVO vo);
	// 6. ?Œ“ê¸? ê°??ˆ˜
	public int count(Integer bno);
}
