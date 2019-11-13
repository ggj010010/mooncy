package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.QuRepVO;

 
public interface QuRepDAO {
	// 1. ´ñ±Û ÀÔ·Â
	public void create(QuRepVO vo);
	// 2. ´ñ±Û ¸ñ·Ï
	public List<QuRepVO> list(Integer q_no, int start, int end);

	// 4. ´ñ±Û¼öÁ¤
	public void update(QuRepVO vo);

	public void delete(Integer q_r_no);
	// 5. ´ñ±Û»èÁ¦	
	public int reply_delete(QuRepVO vo);

	public int count(Integer q_no);
}
 

