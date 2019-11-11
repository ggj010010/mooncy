package com.spring.mooncy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mooncy.dao.OrderDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.PagingDTO;

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
	public List<OrderDTO> selectOrderResponseView(PagingDTO pagingDTO) {

		// TODO Auto-generated method stub

		return sqlSession.selectList("order.selectOrder_User",pagingDTO);

	}
//	@Override
//
//	public int insertRoom(OrderDTO OrderDTO) {
//
//		// TODO Auto-generated method stub
//
//		return sqlSession.insert("room.insertRoom", OrderDTO);
//
//	}
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
