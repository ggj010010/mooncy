package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.QuRepVO;

 
public interface QuRepDAO {
	// 1. ��� �Է�
	public void create(QuRepVO vo);
	// 2. ��� ���
	public List<QuRepVO> list(Integer bno, int start, int end);

	// 4. ��ۼ���
	public void update(QuRepVO vo);

	public void delete(Integer rno);
	// 5. ��ۻ���	
	public int reply_delete(QuRepVO vo);

	public int count(Integer bno);
}
 

