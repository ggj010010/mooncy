package com.spring.mooncy.Controller;

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

	public String selectOrder(Model model,PagingDTO pagingDTO) throws Exception {

		logger.info("order :: page :: " + pagingDTO.getPageNo());

 		int pageNo = 1;

		

 		if(pagingDTO.getPageNo() <= 0 ) {

 			pagingDTO.setPageNo(pageNo);

 		}

		

		model.addAttribute("orderList", OrderService.selectOrderView(pagingDTO));

		model.addAttribute("totalCnt", OrderService.selectOrderView(pagingDTO).get(0).getPagingDTO().getTotalCnt());

		model.addAttribute("pageNo", pagingDTO.getPageNo());

		

		return "order/orderview";

	}
}
