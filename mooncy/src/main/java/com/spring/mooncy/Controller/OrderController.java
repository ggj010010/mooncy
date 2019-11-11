package com.spring.mooncy.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.service.OrderService;

@Controller
public class OrderController {
	

	@Autowired

	OrderService OrderService;


	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


	
	@RequestMapping(value = "/order/orderview")

	public String selectOrder(Model model,PagingDTO pagingDTO, HttpSession session) throws Exception {

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
		
		/*
		 * model.addAttribute("orderResponseList",
		 * OrderService.selectOrderResponseView(pagingDTO, id));
		 * if(OrderService.selectOrderResponseView(pagingDTO, id).size() != 0) {
		 * model.addAttribute("totalCnt2",
		 * OrderService.selectOrderResponseView(pagingDTO,
		 * id).get(0).getPagingDTO().getTotalCnt()); } model.addAttribute("pageNo2",
		 * pagingDTO.getPageNo());
		 */
		

		return "order/orderview";

	}
}
