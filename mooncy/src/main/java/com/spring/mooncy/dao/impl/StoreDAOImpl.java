package com.spring.mooncy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.StoreDAO;
import com.spring.mooncy.dto.StoreDTO;

@Repository
public class StoreDAOImpl implements StoreDAO{



	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<StoreDTO> searchList() {

		// TODO Auto-generated method stub

		return sqlSession.selectList("store.selectList");

	}
}
