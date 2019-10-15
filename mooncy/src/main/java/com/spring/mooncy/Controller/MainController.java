package com.spring.mooncy.Controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mooncy.service.TestService;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(ExController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/menu/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("main!");		
		return "menu/main";
	}
	@RequestMapping(value = "/menu/order", method = RequestMethod.GET)
	public String order(Locale locale, Model model) {
		logger.info("order!");		
		return "menu/order";
	}
	@RequestMapping(value = "/menu/sale", method = RequestMethod.GET)
	public String sale(Locale locale, Model model) {
		logger.info("sale!!");		
		return "menu/sale";
	}
	@RequestMapping(value = "/menu/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("write!!");		
		return "menu/write";
	}
	@RequestMapping(value = "/menu/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model) {
		logger.info("view!!");		
		return "menu/view";
	}
	
	
}
