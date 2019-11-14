package com.spring.mooncy.dao;

import java.util.List;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.ResponseDTO;

public interface  OrderDAO {
	public List<OrderDTO> selectOrder();
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO);
	public List<Order_ManagementDTO> selectOrderResponseView(OrderDTO orderDTO);
	public int selectOrder_User_Count(OrderDTO orderDTO);
	public List<ResponseDTO> selectOrder_Group(OrderDTO orderDTO);
	public List<ResponseDTO> selectOrder_User_Group(OrderDTO orderDTO);
	public List<ResponseDTO> ResponseDate(OrderDTO orderDTO);
	public int selectOrder_Date_Count(ResponseDTO responseDTO);
	public List<ResponseDTO> ResponseDate_User(ResponseDTO responseDTO);
	public List<ResponseDTO> ResponseDate_Group(ResponseDTO responseDTO);
	public List<ResponseDTO> ResponseDate_User_Group(ResponseDTO responseDTO);
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
