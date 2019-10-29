package com.spring.mooncy.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mooncy.service.OrderService;

@Controller
public class ManagerController {
//	@Autowired
//
//	LoginService loginService;

	@Autowired
	OrderService orderService;

	

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

	

	@RequestMapping(value = "/Manager/ManagerMain")
	public String Manager(Model model) throws Exception {

		return "/Manager/ManagerMain";

	}
	
	@RequestMapping(value = "/Manager/manager_order")
	public String manager_order(Model model) throws Exception {
		
		model.addAttribute("orderList", orderService.selectOrder());

		return "/Manager/manager_order";

	}
}
