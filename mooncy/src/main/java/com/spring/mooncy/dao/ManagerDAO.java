package com.spring.mooncy.dao;

import java.sql.Date;
import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.StoreDTO;

public  interface ManagerDAO {

	public List<OrderDTO> selectOrder(PagingDTO pagingDTO);
	public List<StoreDTO> order_request(OrderDTO orderDTO);
	public int order_Update(OrderDTO orderDTO);
	public int request_Update(OrderDTO orderDTO);
	public int check_Update(OrderDTO orderDTO);
	public int order_Manager(OrderDTO orderDTO);
	public List<Order_ManagementDTO> selectOrder_Management(PagingDTO pagingDTO);
	public List<Order_ManagementDTO> selectManagerPop(Order_ManagementDTO order_managementDTO);
	//public int order_request(OrderDTO orderDTO);
}
