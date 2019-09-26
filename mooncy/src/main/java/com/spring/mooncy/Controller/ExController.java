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
public class ExController {
	@Autowired
	TestService testService;
	private static final Logger logger = LoggerFactory.getLogger(ExController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/exhome", method = RequestMethod.GET)
	public String exhome(Locale locale, Model model) {
		logger.info("!!");
		model.addAttribute("testList", testService.searchList());
		
		return "exhome";
	}
	
}
