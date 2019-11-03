package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.StoreDTO;

public  interface ManagerDAO {

	public List<OrderDTO> selectOrder();
	public List<StoreDTO> order_request(OrderDTO orderDTO);
	public int order_Update(OrderDTO orderDTO);
	public int request_Update(OrderDTO orderDTO);
	public int check_Update(OrderDTO orderDTO);
	//public int order_request(OrderDTO orderDTO);
}
