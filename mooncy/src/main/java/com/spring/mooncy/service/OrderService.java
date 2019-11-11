package com.spring.mooncy.service;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.PagingDTO;

public interface  OrderService {


	public List<OrderDTO> selectOrder();
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO, String id);
	public List<OrderDTO> selectOrderResponseView(PagingDTO pagingDTO, String id);

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
