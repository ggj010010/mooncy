package com.spring.mooncy.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;

import com.spring.mooncy.dao.ManagerDAO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.StoreDTO;
import com.spring.mooncy.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired

	ManagerDAO ManagerDAO;

	@Override

	public List<OrderDTO> selectOrder() {

		// TODO Auto-generated method stub

		return ManagerDAO.selectOrder();

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
	public void ktoe(OrderDTO orderDTO) {
		if(orderDTO.getP_name().equals("µþ±â")) {
			orderDTO.setP_name("ddalgi");
		}
		else if(orderDTO.getP_name().equals("¿À·»Áö")) {
			orderDTO.setP_name("orange");
		}
		else if(orderDTO.getP_name().equals("¹Ù³ª³ª")) {
			orderDTO.setP_name("banana");
		}
		else if(orderDTO.getP_name().equals("Å°À§")) {
			orderDTO.setP_name("kiwi");
		}
		else if(orderDTO.getP_name().equals("ÆÄÀÎ¾ÖÇÃ")) {
			orderDTO.setP_name("pine");
		}
		else if(orderDTO.getP_name().equals("ÇÑ¶óºÀ")) {
			orderDTO.setP_name("hanla");
		}
		else if(orderDTO.getP_name().equals("¼ö¹Ú")) {
			orderDTO.setP_name("suback");
		}
		else if(orderDTO.getP_name().equals("Åä¸¶Åä")) {
			orderDTO.setP_name("tomato");
		}
		else if(orderDTO.getP_name().equals("»ç°ú")) {
			orderDTO.setP_name("apple");
		}
		else if(orderDTO.getP_name().equals("¸Á°í")) {
			orderDTO.setP_name("mango");
		}
		else if(orderDTO.getP_name().equals("»¡´ë")) {
			orderDTO.setP_name("bbalde");
		}
		else if(orderDTO.getP_name().equals("¶Ñ²±")) {
			orderDTO.setP_name("dduggung");
		}
		else if(orderDTO.getP_name().equals("ÄÅ")) {
			orderDTO.setP_name("cup");
		}
	}
}
