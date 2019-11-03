package com.spring.mooncy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.StoreDTO;

public interface ManagerService {

	public List<OrderDTO> selectOrder();
	public List<StoreDTO> requestOrderList(OrderDTO orderDTO, HttpSession Hsession);
	public int order_Update(OrderDTO orderDTO);
	public int check_Update(OrderDTO orderDTO);
	public int request_Update(OrderDTO orderDTO);
}
