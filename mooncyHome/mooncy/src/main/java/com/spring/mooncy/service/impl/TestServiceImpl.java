package com.spring.mooncy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mooncy.dao.TestDAO;
import com.spring.mooncy.dto.TestDTO;
import com.spring.mooncy.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	

	@Autowired

	TestDAO testDAO;

	

	@Override

	public List<TestDTO> searchList() {

		// TODO Auto-generated method stub

		return testDAO.searchList();

	}
}
