package com.spring.mooncy.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mooncy.common.CommonUtil;
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
	

	@RequestMapping(value = "/order/responseDate",  method = RequestMethod.GET, produces = "application/json;")
	@ResponseBody
	public String ResponseDate(Model model,ResponseDTO responseDTO, HttpSession session) throws Exception {

		logger.info("/order/responseDate");
		HashMap<String, Object> result = new HashMap<String, Object>();
		CommonUtil commonUtil = new CommonUtil();
 		
 		String id = (String)session.getAttribute("m_id");
		int count = OrderService.selectOrder_Date_Count(id, responseDTO);
		result.put("count", (count <= 10) ? "Y" : "N");
		System.out.println("count"+count);
		if(count <= 10) {
			result.put("ResponseDate_User", OrderService.ResponseDate_User(id, responseDTO));
			System.out.println("-");
		}
		else {
			System.out.println("Å©´Ù");
		}
	      String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
	      
	      System.out.println("callbackMsg::"+callbackMsg);
	      
	      return callbackMsg;

	}
}
