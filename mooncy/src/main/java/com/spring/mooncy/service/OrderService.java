package com.spring.mooncy.service;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;

public interface  OrderService {


	public List<OrderDTO> selectOrder();
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO, String id);
	public List<Order_ManagementDTO> selectOrderResponseView(String id, OrderDTO orderDTO);

//	public int fileNameUpdate(int r_id, String fileName);
//
//
//
//	public int insertOrder(OrderDTO OrderDTO);
//
//
//
//	public int deleteOrder(OrderDTO OrderDTO);
//
//
//
//	public int updateOrder(OrderDTO OrderDTO);
//
//
//
//
//	public OrderDTO selectOrderOne(OrderDTO OrderDTO);
}
