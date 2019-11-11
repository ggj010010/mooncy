package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.PagingDTO;

public interface  OrderDAO {
	public List<OrderDTO> selectOrder();
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO);
	public List<OrderDTO> selectOrderResponseView(PagingDTO pagingDTO);
//	
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
