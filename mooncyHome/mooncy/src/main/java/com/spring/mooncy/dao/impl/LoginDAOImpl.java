package com.spring.mooncy.dao.impl;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.LoginDAO;
import com.spring.mooncy.dto.CustomerDTO;






@Repository

public class LoginDAOImpl implements LoginDAO{

	@Autowired

	private SqlSession sqlSession;

	public int Id_Check(CustomerDTO customerDTO) {

		try {

			return sqlSession.selectOne("login.Id_Check", customerDTO);

		}

		catch (Exception e) {

			e.printStackTrace();

			return -1;

		}

	}

	@Override

	public int insertCustomer(CustomerDTO customerDTO){

		System.out.println("insert");

		int Id_Check_Result = Id_Check(customerDTO);

		if(Id_Check_Result != 0) { 

			System.out.println("Re"+Id_Check_Result);

			return Id_Check_Result;}



		try {

			sqlSession.insert("login.insertCustomer", customerDTO);

			return 0;

		}

		catch (Exception e) {

			e.printStackTrace();

			return -2;

		}

	}

	public int Login(CustomerDTO customerDTO, HttpSession Hsession) {

		int Id_Search_Result = -1;

		try {

			Id_Search_Result = sqlSession.selectOne("login.Login", customerDTO);

		}

		catch (Exception e) {

			e.printStackTrace();

			return -1;

		}

		

		if(Id_Search_Result != 1) return Id_Search_Result;

		

		try {

			CustomerDTO c_info = sqlSession.selectOne("login.Login_Info", customerDTO);

			String customer_id = sqlSession.selectOne("CustomerID", customerDTO);

			Hsession.setAttribute("m_id", customer_id);

			Hsession.setAttribute("m", c_info);
			
			System.out.println(customer_id);

			if(customer_id.equals("0")) {
				return 2;
			}
			else{
				return 1;
			}
		}

		catch (Exception e) {

			e.printStackTrace();

			return -2;

		}

	}

}