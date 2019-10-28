package com.spring.mooncy.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mooncy.service.LoginService;

@Controller
public class ManagerController {
//	@Autowired
//
//	LoginService loginService;

	

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

	

	@RequestMapping(value = "/Manager/ManagerMain")

	public String Manager(Model model) throws Exception {



		return "/Manager/ManagerMain";

	}
}
