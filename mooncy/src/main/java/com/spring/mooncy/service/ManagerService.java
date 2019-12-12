package com.spring.mooncy.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.SaleDTO;
import com.spring.mooncy.dto.StoreDTO;

public interface ManagerService {

	public List<OrderDTO> selectOrder(PagingDTO pagingDTO);
	public List<StoreDTO> requestOrderList(OrderDTO orderDTO, HttpSession Hsession);
	public List<Order_ManagementDTO> selectOrder_Management(PagingDTO pagingDTO);
	public int order_Update(OrderDTO orderDTO);
	public int check_Update(OrderDTO orderDTO);
	public int request_Update(OrderDTO orderDTO);
	public int order_Manager(OrderDTO orderDTO);
	public List<Order_ManagementDTO> selectManagerPop(Order_ManagementDTO order_managementDTO);
	public List<CustomerDTO> selectCustomer();
	public List<Order_ManagementDTO> selectManagerName(Order_ManagementDTO order_managementDTO);
	List<OrderDTO> select_User_Order();
	public int UesrCheck(CustomerDTO customerDTO);
	public int UesrInsert(CustomerDTO customerDTO);
	public int User_ProductInsert(CustomerDTO customerDTO);
	public List<SaleDTO> selectSale(SaleDTO saleDTO);
}
