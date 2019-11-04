package com.spring.mooncy.dao;

import java.util.List;
 
import com.spring.mooncy.dto.QuVO;
 
public interface QuDAO {
    // 01. 게시글 작성
    public void create(QuVO vo) throws Exception;
    // 02. 게시글 상세보기
    public QuVO read(int q_no) throws Exception;
    // 03. 게시글 수정
    public void update(QuVO vo) throws Exception;
    // 04. 게시글 삭제
    public void delete(int q_no) throws Exception;
    // 05. 게시글 전체 목록
    public List<QuVO> listAll() throws Exception;
    // 06. 게시글 조회 증가
    public void increaseViewcnt(int q_no) throws Exception;
}
