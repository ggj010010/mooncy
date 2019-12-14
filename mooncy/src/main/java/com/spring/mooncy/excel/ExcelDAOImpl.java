package com.spring.mooncy.excel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dto.CustomerDTO;

@Repository
public class ExcelDAOImpl implements ExcelDAO{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertExcel(List<CustomerDTO> list) {
		// TODO Auto-generated method stub
		return sqlSession.insert("excel.insertExcel", list);
	}

	@Override
	public int insertProduct(List<CustomerDTO> list) {
		// TODO Auto-generated method stub
		return sqlSession.insert("excel.insertProduct", list);
	}
}