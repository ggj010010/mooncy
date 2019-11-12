package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;

public interface  OrderDAO {
	public List<OrderDTO> selectOrder();
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO);
	public List<Order_ManagementDTO> selectOrderResponseView(OrderDTO orderDTO);
//	  public int insertRoom(OrderDTO OrderDTO);
//	  
//	  
//	  
//	  public int fileNameUpdate(OrderDTO OrderDTO);
//	  
//	  
//	  
//	  public int deleteRoom(OrderDTO OrderDTO);
//	  
//	  
//	  
//	  public int updateRoom(OrderDTO OrderDTO);
//	 
//    public OrderDTO selectRoomOne(OrderDTO OrderDTO);


	

}
