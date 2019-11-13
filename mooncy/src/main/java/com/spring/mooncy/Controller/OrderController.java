package com.spring.mooncy.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.ResponseDTO;
import com.spring.mooncy.service.OrderService;

@Controller
public class OrderController {
	

	@Autowired

	OrderService OrderService;


	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


	
	@RequestMapping(value = "/order/orderview")

	public String selectOrder(Model model,PagingDTO pagingDTO, OrderDTO orderDTO, HttpSession session) throws Exception {

		logger.info("order :: page :: " + pagingDTO.getPageNo());

 		int pageNo = 1;

		

 		if(pagingDTO.getPageNo() <= 0 ) {

 			pagingDTO.setPageNo(pageNo);

 		}
 		
 		String id = (String)session.getAttribute("m_id");
		

		model.addAttribute("orderList", OrderService.selectOrderView(pagingDTO, id));
		if(OrderService.selectOrderView(pagingDTO, id).size() != 0) {
			model.addAttribute("totalCnt", OrderService.selectOrderView(pagingDTO, id).get(0).getPagingDTO().getTotalCnt());
		}
		model.addAttribute("pageNo", pagingDTO.getPageNo());
		
		int count = OrderService.selectOrder_User_Count(id, orderDTO);
		System.out.println("count"+count);
		model.addAttribute("count", count);
		if(count <= 10) {
			model.addAttribute("orderResponseList", OrderService.selectOrderResponseView(id, orderDTO));
		}
		else {
			model.addAttribute("user", OrderService.selectOrder_User_Group(id, orderDTO));
			model.addAttribute("orderResponseGroupList", OrderService.selectOrder_Group(id, orderDTO));
		}
		

		return "order/orderview";

	}
	

	@RequestMapping(value = "/order/responseDate")
	public Map<String,Object> ResponseDate(Model model,ResponseDTO responseDTO, HttpSession session) throws Exception {

		logger.info("/order/responseDate");
		Map<String, Object> map = new HashMap<String, Object>();


 		
 		String id = (String)session.getAttribute("m_id");
		int count = OrderService.selectOrder_Date_Count(id, responseDTO);
		System.out.println(count);
		if(count <= 10) {
			map.put("ResponseDate_User", OrderService.ResponseDate_User(id, responseDTO));
			//model.addAttribute("ResponseDate_User", OrderService.ResponseDate_User(id, responseDTO));
			System.out.println("-");
		}
		else {
			System.out.println("Å©´Ù");
		}
		//model.addAttribute("orderList", OrderService.selectOrderView(responseDTO, id));
		
		return map;

	}
}
