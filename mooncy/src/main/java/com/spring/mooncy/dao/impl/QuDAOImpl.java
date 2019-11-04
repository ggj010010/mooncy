package com.spring.mooncy.dao.impl;

import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.QuDAO;
import com.spring.mooncy.dto.QuVO;
 
@Repository    // ���� Ŭ������ dao bean���� ���
public class QuDAOImpl implements QuDAO {
    @Inject
    SqlSession SqlSession;
    // 01. �Խñ� �ۼ�
    @Override
    public void create(QuVO vo) throws Exception {
        SqlSession.insert("main.insert", vo);
    }
    // 02. �Խñ� �󼼺���
    @Override
    public QuVO read(int q_no) throws Exception {
        return SqlSession.selectOne("main.view", q_no);
    }
    // 03. �Խñ� ����
    @Override
    public void update(QuVO vo) throws Exception {
        SqlSession.update("main.updateArticle", vo);
 
    }
    // 04. �Խñ� ����
    @Override
    public void delete(int q_no) throws Exception {
        SqlSession.delete("main.deleteArticle",q_no);
 
    }
    // 05. �Խñ� ��ü ���
    @Override
    public List<QuVO> listAll() throws Exception {
        return SqlSession.selectList("main.listAll");
    }
    // �Խñ� ��ȸ�� ����
    @Override
    public void increaseViewcnt(int q_no) throws Exception {
        SqlSession.update("main.increaseViewcnt", q_no);
    }
 
}
