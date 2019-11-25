package com.spring.mooncy.dao.impl;

import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.QuDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.QuVO;
 
@Repository    // ���� Ŭ������ dao bean���� ���
public class QuDAOImpl implements QuDAO {
    @Inject
	private SqlSession sqlSession;
    // 01. �Խñ� �ۼ�
    @Override
    public void create(QuVO vo) throws Exception {
    	sqlSession.insert("main.insert", vo);
    }
    // 02. �Խñ� �󼼺���
    @Override
    public QuVO read(int q_no) throws Exception {
        return sqlSession.selectOne("main.view", q_no);
    }
    // 03. �Խñ� ����
    @Override
    public void update(QuVO vo) throws Exception {
    	sqlSession.update("main.updateArticle", vo);
 
    }
    // 04. �Խñ� ����
    @Override
    public void delete(int q_no) throws Exception {
    	sqlSession.delete("main.deleteArticle",q_no);
 
    }
    // 05. �Խñ� ��ü ���
//    @Override
//    public List<QuVO> listAll(QuVO quVO) throws Exception {
//        return sqlSession.selectList("main.listAll");
//    }


	@Override
	public List<QuVO> listAll() {

		// TODO Auto-generated method stub

		return sqlSession.selectList("main.listAll");

	}

	@Override

	public List<QuVO> listAllView(PagingDTO pagingDTO) throws Exception{

		// TODO Auto-generated method stub

		return sqlSession.selectList("main.listAll",pagingDTO);

	}



}
