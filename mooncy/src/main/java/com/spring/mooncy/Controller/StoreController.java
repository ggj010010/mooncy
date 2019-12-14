
package com.spring.mooncy.Controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mooncy.dto.StoreDTO;
import com.spring.mooncy.service.StoreService;

@Controller
public class StoreController {
	@Autowired
	StoreService storeService;
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@RequestMapping(value = "/store/store", method = RequestMethod.GET)
	public String exhome(Locale locale, Model model,StoreDTO storeDTO, HttpSession session) {
		logger.info("!!");
		String id = (String)session.getAttribute("m_id");
		
		model.addAttribute("storeList", storeService.searchList(storeDTO,id));
		
		return "store/store";
	}
}
