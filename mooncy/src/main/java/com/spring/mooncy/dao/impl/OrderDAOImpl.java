package com.spring.mooncy.dao.impl;

import java.io.Console;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.OrderDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.ResponseDTO;

@Repository
public class OrderDAOImpl implements OrderDAO{
	@Autowired

	private SqlSession sqlSession;

	

	@Override

	public List<OrderDTO> selectOrder() {

		// TODO Auto-generated method stub

		return sqlSession.selectList("order.selectOrder");

	}

	@Override
	public List<OrderDTO> selectOrderView(PagingDTO pagingDTO) {

		// TODO Auto-generated method stub

		return sqlSession.selectList("order.selectOrderView",pagingDTO);

	}
	@Override
	public List<Order_ManagementDTO> selectOrderResponseView(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.selectList("order.selectOrder_User", orderDTO);

	}
	
	
	@Override

	public int selectOrder_User_Count(OrderDTO OrderDTO) {

		// TODO Auto-generated method stub
		int count = sqlSession.selectOne("order.selectOrder_User_Count", OrderDTO);
		return count;
	}
	@Override
	public List<ResponseDTO> selectOrder_Group(OrderDTO orderDTO) {

		// TODO Auto-generated method stub

		return sqlSession.selectList("order.selectOrder_Group", orderDTO);

	}
	@Override
	public List<ResponseDTO> selectOrder_User_Group(OrderDTO orderDTO) {

		// TODO Auto-generated method stub
		return sqlSession.selectList("order.selectOrder_User_Group", orderDTO);
	}
	@Override
	public List<ResponseDTO> ResponseDate(OrderDTO orderDTO) {

		// TODO Auto-generated method stub
		return sqlSession.selectList("order.ResponseDate", orderDTO);
	}
	@Override
	public int selectOrder_Date_Count(ResponseDTO responseDTO) {

		// TODO Auto-generated method stub
		int count = sqlSession.selectOne("order.selectOrder_Date_Count", responseDTO);
		return count;
	}
	@Override
	public List<ResponseDTO> ResponseDate_User(ResponseDTO responseDTO) {

		// TODO Auto-generated method stub
		return sqlSession.selectList("order.ResponseDate_User", responseDTO);
	}
	@Override
	public List<ResponseDTO> ResponseDate_Group(ResponseDTO responseDTO) {

		// TODO Auto-generated method stub
		return sqlSession.selectList("order.ResponseDate_Group", responseDTO);
	}
	@Override
	public List<ResponseDTO> ResponseDate_User_Group(ResponseDTO responseDTO) {

		// TODO Auto-generated method stub
		return sqlSession.selectList("order.ResponseDate_User_Group", responseDTO);
	}
	
//
//	
//
//	@Override
//
//	public int updateRoom(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return sqlSession.update("room.updateRoom", OrderDTO);
//
//	}
//
//	
//
//	@Override
//
//	public int deleteRoom(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return sqlSession.delete("room.deleteRoom", OrderDTO);
//
//	}
//
//	
//
//
//
//	
//
//	@Override
//
//	public OrderDTO selectRoomOne(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return sqlSession.selectOne("room.selectRoomOne",OrderDTO);
//
//	}
//
//	
//
//	@Override
//
//	public int fileNameUpdate(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return sqlSession.update("room.fileNameUpdate", OrderDTO);
//
//	}
}
