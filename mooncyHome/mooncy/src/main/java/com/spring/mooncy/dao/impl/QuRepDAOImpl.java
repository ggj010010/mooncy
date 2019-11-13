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
	
	// 1. ?Œ“ê¸? ?…? ¥
		@Override
		public void create(QuRepVO vo) {
			sqlSession.insert("reply.insertReply", vo);
		}
	// 2. ?Œ“ê¸? ëª©ë¡
	@Override
	public List<QuRepVO> list(Integer q_no,  int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("q_no", q_no);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("reply.listReply", map);
	}
	// 4. ?Œ“ê¸? ?ˆ˜? •
	@Override
	public void update(QuRepVO vo) {
		sqlSession.update("reply.updateReply", vo);
	}
	// 5. ?Œ“ê¸? ?‚­? œ
	@Override
	public void delete(Integer q_r_no) {
		sqlSession.delete("reply.deleteReply", q_r_no);
	}
	@Override
	public int reply_delete(QuRepVO vo) {
		return sqlSession.delete("reply.reply_deleteReply", vo);
	}
	// 6. ?Œ“ê¸? ê°??ˆ˜
	@Override
	public int count(Integer q_no) {
		return sqlSession.selectOne("reply.countReply", q_no);
	}

}
