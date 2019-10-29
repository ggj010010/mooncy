package com.spring.mooncy.dao;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.CustomerDTO;

	public interface LoginDAO {

		public int Id_Check(CustomerDTO customerDTO);
		public int insertCustomer(CustomerDTO customerDTO);
		public int Login(CustomerDTO customerDTO, HttpSession Hsession);

	}

