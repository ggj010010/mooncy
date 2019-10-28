package com.spring.mooncy.service;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.CustomerDTO;

public interface LoginService {
	
	public int insertCustomer(CustomerDTO customerDTO);
	public int Id_Check(CustomerDTO customerDTO);
	public int Login(CustomerDTO customerDTO, HttpSession Hsession);
}