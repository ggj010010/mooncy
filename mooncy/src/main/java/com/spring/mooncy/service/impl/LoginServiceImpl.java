package com.spring.mooncy.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mooncy.dao.LoginDAO;
import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.service.LoginService;




@Service
public class LoginServiceImpl implements LoginService{

	

	@Autowired

	LoginDAO LoginDAO;

	

	@Override

	public int insertCustomer(CustomerDTO customerDTO){

		return LoginDAO.insertCustomer(customerDTO);

	}

	@Override

	public int Id_Check(CustomerDTO customerDTO){

		return LoginDAO.Id_Check(customerDTO);

	}

	@Override

	public int Login(CustomerDTO customerDTO, HttpSession Hsession){

		return LoginDAO.Login(customerDTO, Hsession);

	}
	

//	@Override

//	public List<CustomerDTO> Login(CustomerDTO customerDTO, HttpSession Hsession) {

//		// TODO Auto-generated method stub

//		return LoginDAO.Login(customerDTO, Hsession);

//	}

}
