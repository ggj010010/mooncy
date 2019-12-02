package com.spring.mooncy.service.impl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;

import com.spring.mooncy.dao.ManagerDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.StoreDTO;
import com.spring.mooncy.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired

	ManagerDAO ManagerDAO;

	@Override

	public List<OrderDTO> selectOrder(PagingDTO pagingDTO) {
		System.out.println("sm 1 "+pagingDTO.getPageNo());
		// TODO Auto-generated method stub

		return ManagerDAO.selectOrder(pagingDTO);

	}

	@Override

	public List<StoreDTO> requestOrderList(OrderDTO orderDTO, HttpSession Hsession) {
		//Hsession.invalidate();
		Hsession.setAttribute("request_id", orderDTO.getM_id());
		System.out.println("c"+orderDTO.getP_count());
		System.out.println("n"+orderDTO.getO_no());
		Hsession.setAttribute("request_count", orderDTO.getP_count());
		Hsession.setAttribute("o_no", orderDTO.getO_no());
		ktoe(orderDTO);
		return ManagerDAO.order_request(orderDTO);

	}
	@Override

	public List<Order_ManagementDTO> selectOrder_Management(PagingDTO pagingDTO) {
		//System.out.println("2"+pagingDTO.getPageNo2());
		return ManagerDAO.selectOrder_Management(pagingDTO);

	}
	@Override

	public int order_Update(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
		ktoe(orderDTO);
		return ManagerDAO.order_Update(orderDTO);

	}
	@Override

	public int request_Update(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
		ktoe(orderDTO);
		return ManagerDAO.request_Update(orderDTO);

	}
	@Override

	public int check_Update(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
		ktoe(orderDTO);
		return ManagerDAO.check_Update(orderDTO);

	}
	@Override

	public int order_Manager(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
		return ManagerDAO.order_Manager(orderDTO);

	}
	public void ktoe(OrderDTO orderDTO) {
		if(orderDTO.getP_name().equals("����")) {
			orderDTO.setP_name("ddalgi");
		}
		else if(orderDTO.getP_name().equals("������")) {
			orderDTO.setP_name("orange");
		}
		else if(orderDTO.getP_name().equals("�ٳ���")) {
			orderDTO.setP_name("banana");
		}
		else if(orderDTO.getP_name().equals("Ű��")) {
			orderDTO.setP_name("kiwi");
		}
		else if(orderDTO.getP_name().equals("���ξ���")) {
			orderDTO.setP_name("pine");
		}
		else if(orderDTO.getP_name().equals("�Ѷ��")) {
			orderDTO.setP_name("hanla");
		}
		else if(orderDTO.getP_name().equals("����")) {
			orderDTO.setP_name("suback");
		}
		else if(orderDTO.getP_name().equals("�丶��")) {
			orderDTO.setP_name("tomato");
		}
		else if(orderDTO.getP_name().equals("���")) {
			orderDTO.setP_name("apple");
		}
		else if(orderDTO.getP_name().equals("����")) {
			orderDTO.setP_name("mango");
		}
		else if(orderDTO.getP_name().equals("����")) {
			orderDTO.setP_name("bbalde");
		}
		else if(orderDTO.getP_name().equals("�Ѳ�")) {
			orderDTO.setP_name("dduggung");
		}
		else if(orderDTO.getP_name().equals("��")) {
			orderDTO.setP_name("cup");
		}
	}

	@Override
	public List<Order_ManagementDTO> selectManagerPop(Order_ManagementDTO order_managementDTO)  {
		// TODO Auto-generated method stub
		return ManagerDAO.selectManagerPop(order_managementDTO);
	}

}
