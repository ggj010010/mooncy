package com.spring.mooncy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.QuRepVO;

public interface QuRepService {
   // 1. ?κΈ? ?? ₯
   public void create(QuRepVO vo);
   // 2. ?κΈ? λͺ©λ‘
   public List<QuRepVO> list(Integer q_no, int start, int end, HttpSession session);
   // 4. ?κΈ? ?? 
   public void update(QuRepVO vo);
   // 5. ?κΈ? ?­? 
   //public void delete(Integer q_r_no);
   
   public int reply_delete(QuRepVO vo);
   
   public int count(Integer q_no);
   
	public int insert_reply(QuRepVO vo);
//  public void increaseViewcnt(int q_no, HttpSession session) throws Exception;
  public List<QuRepVO> readRep(int q_no) throws Exception;
}