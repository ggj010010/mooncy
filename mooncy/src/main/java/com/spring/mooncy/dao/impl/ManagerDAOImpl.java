package com.spring.mooncy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.ManagerDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.StoreDTO;
@Repository
public class ManagerDAOImpl implements ManagerDAO{
	
	@Autowired

	private SqlSession sqlSession;

	@Override

	public List<OrderDTO> selectOrder() {

		// TODO Auto-generated method stub

		return sqlSession.selectList("manager.selectOrder");

	}

	@Override

	public List<StoreDTO> order_request(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.selectList("manager.requestOrder", orderDTO);

	}
	@Override

	public List<Order_ManagementDTO> selectOrder_Management() {

		// TODO Auto-generated method stub

		return sqlSession.selectList("manager.selectOrder_Management");

	}
	@Override

	public int order_Update(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.update("manager.order_Update", orderDTO);

	}
	@Override

	public int request_Update(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.update("manager.request_Update", orderDTO);

	}
	@Override

	public int check_Update(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.update("manager.check_Update", orderDTO);

	}
	public int order_Manager(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.insert("manager.order_Manager", orderDTO);

	}
	
}
