package com.spring.mooncy.dao.impl;

import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.QuDAO;
import com.spring.mooncy.dto.QuVO;
 
@Repository    // 현재 클래스를 dao bean으로 등록
public class QuDAOImpl implements QuDAO {
    @Inject
    SqlSession SqlSession;
    // 01. 게시글 작성
    @Override
    public void create(QuVO vo) throws Exception {
        SqlSession.insert("main.insert", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public QuVO read(int q_no) throws Exception {
        return SqlSession.selectOne("main.view", q_no);
    }
    // 03. 게시글 수정
    @Override
    public void update(QuVO vo) throws Exception {
        SqlSession.update("main.updateArticle", vo);
 
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int q_no) throws Exception {
        SqlSession.delete("main.deleteArticle",q_no);
 
    }
    // 05. 게시글 전체 목록
    @Override
    public List<QuVO> listAll() throws Exception {
        return SqlSession.selectList("main.listAll");
    }
    // 게시글 조회수 증가
    @Override
    public void increaseViewcnt(int q_no) throws Exception {
        SqlSession.update("main.increaseViewcnt", q_no);
    }
 
}
