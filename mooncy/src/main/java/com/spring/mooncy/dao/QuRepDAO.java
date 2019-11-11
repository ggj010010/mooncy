package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.dto.StoreDTO;

 
public interface QuRepDAO {
   // 1. ��� �Է�
   public void create(QuRepVO vo);
   // 2. ��� ���
   public List<QuRepVO> list(Integer q_no, int start, int end);

   //public List<StoreDTO> order_request(OrderDTO orderDTO);
	public int insert_reply(QuRepVO vo);
   // 4. ��ۼ���
   public void update(QuRepVO vo);

  // public void delete(QuRepVO vo);
   // 5. ��ۻ���   
   public int reply_delete(QuRepVO vo);

   public int count(Integer q_no);
   
   public List<QuRepVO> readRep(int q_no) throws Exception;
}