package com.spring.mooncy.excel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dto.ExcelDTO;

@Repository
public class ExcelDAOImpl implements ExcelDAO{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertExcelTest(List<ExcelDTO> list) {
		// TODO Auto-generated method stub
		return sqlSession.insert("excel.insertExcel", list);
	}
}
