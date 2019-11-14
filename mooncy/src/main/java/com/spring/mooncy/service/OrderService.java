package com.spring.mooncy.service;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.ResponseDTO;

public interface  OrderService {


	public List<OrderDTO> selectOrder();
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO, String id);
	public List<Order_ManagementDTO> selectOrderResponseView(String id, OrderDTO orderDTO);
	public int selectOrder_User_Count(String id, OrderDTO orderDTO);
	public List<ResponseDTO> selectOrder_Group(String id, OrderDTO orderDTO);
	public List<ResponseDTO> selectOrder_User_Group(String id, OrderDTO orderDTO);
	public List<ResponseDTO> ResponseDate(String id, OrderDTO orderDTO);
	public int selectOrder_Date_Count(String id, ResponseDTO responseDTO);
	public List<ResponseDTO> ResponseDate_User(String id, ResponseDTO responseDTO);
	public List<ResponseDTO> ResponseDate_Group(String id, ResponseDTO responseDTO);
	public List<ResponseDTO> ResponseDate_User_Group(String id, ResponseDTO responseDTO);
	

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
