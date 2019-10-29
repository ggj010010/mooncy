package com.spring.mooncy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.TestDAO;
import com.spring.mooncy.dto.TestDTO;

@Repository
public class TsetDAOImpl implements TestDAO{



	@Autowired

	private SqlSession sqlSession;

	

	@Override

	public List<TestDTO> searchList() {

		// TODO Auto-generated method stub

		return sqlSession.selectList("mooncy.selectList");

	}
}
