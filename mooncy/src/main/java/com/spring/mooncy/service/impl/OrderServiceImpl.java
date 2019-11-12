package com.spring.mooncy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mooncy.dao.OrderDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{



	@Autowired

	OrderDAO OrderDAO;

	

	@Override

	public List<OrderDTO> selectOrder() {

		// TODO Auto-generated method stub

		return OrderDAO.selectOrder();

	}

	@Override

	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO, String id) {

		// TODO Auto-generated method stub
		pagingDTO.setM_id(id);
		return OrderDAO.selectOrderView(pagingDTO);
		
	}

	@Override

	public List<Order_ManagementDTO> selectOrderResponseView(String id, OrderDTO orderDTO) {

		// TODO Auto-generated method stub
		orderDTO.setM_id(id);
		return OrderDAO.selectOrderResponseView(orderDTO);
		
	}
//	@Override
//
//	public int insertOrder(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return OrderDAO.insertOrder(OrderDTO);
//
//	}
//
//	
//
//	@Override
//
//	public int updateOrder(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return OrderDAO.updateOrder(OrderDTO);
//
//	}
//
//	
//
//	@Override
//
//	public int deleteOrder(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		System.out.println(OrderDTO.toString());
//
//		return OrderDAO.deleteOrder(OrderDTO);
//
//	}
//
//	
//
//	@Override
//
//	public OrderDTO selectOrderOne(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return OrderDAO.selectOrderOne(OrderDTO);
//
//	}
//
//	
//
//	@Override
//
//	public int fileNameUpdate(int r_id, String fileName) {
//
//		// TODO Auto-generated method stub
//
//		OrderDTO OrderDTO = new OrderDTO();
//
//		OrderDTO.setR_id(r_id);
//
//		OrderDTO.setR_img(fileName);
//
//		
//
//		return OrderDAO.fileNameUpdate(OrderDTO);
//
//	}
}
