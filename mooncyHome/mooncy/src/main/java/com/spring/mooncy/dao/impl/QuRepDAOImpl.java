package com.spring.mooncy.dao.impl;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.QuRepDAO;
import com.spring.mooncy.dto.QuRepVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class QuRepDAOImpl implements QuRepDAO {
	@Inject
	SqlSession sqlSession;
	
	// 1. ?κΈ? ?? ₯
		@Override
		public void create(QuRepVO vo) {
			sqlSession.insert("reply.insertReply", vo);
		}
	// 2. ?κΈ? λͺ©λ‘
	@Override
	public List<QuRepVO> list(Integer bno,  int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("reply.listReply", map);
	}
	// 4. ?κΈ? ?? 
	@Override
	public void update(QuRepVO vo) {
		sqlSession.update("reply.updateReply", vo);
	}
	// 5. ?κΈ? ?­? 
	@Override
	public void delete(Integer rno) {
		sqlSession.delete("reply.deleteReply", rno);
	}
	@Override
	public int reply_delete(QuRepVO vo) {
		return sqlSession.delete("reply.reply_deleteReply", vo);
	}
	// 6. ?κΈ? κ°??
	@Override
	public int count(Integer bno) {
		return sqlSession.selectOne("reply.countReply", bno);
	}

}
