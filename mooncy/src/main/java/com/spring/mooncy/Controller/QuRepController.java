package com.spring.mooncy.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.dto.QuRepPager;
import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.dto.StoreDTO;
import com.spring.mooncy.service.QuRepService;
import com.spring.mooncy.service.StoreService;


// REST : Representational State Transfer
// ?ïò?Çò?ùò URIÍ∞? ?ïò?Çò?ùò Í≥†Ïú†?ïú Î¶¨ÏÜå?ä§Î•? ???ëú?ïò?èÑÎ°? ?Ñ§Í≥ÑÎêú Í∞úÎÖê

// http://localhost/spring02/list?q_no=1 ==> url+?åå?ùºÎØ∏ÌÑ∞
// http://localhost/spring02/list/1 ==> url
// RestController?? ?ä§?îÑÎß? 4.0Î∂??Ñ∞ Ïß??õê
// @Controller, @RestController Ï∞®Ïù¥?†ê?? Î©îÏÑú?ìúÍ∞? Ï¢ÖÎ£å?êòÎ©? ?ôîÎ©¥Ï†Ñ?ôò?ùò ?ú†Î¨?

@Controller

@RequestMapping("/reply/*")
public class QuRepController {
	@Autowired
	QuRepService qurepservice;

   
   private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
   
   

	
	@RequestMapping(value = "/insert", method = {RequestMethod.POST,RequestMethod.GET})
	
	@ResponseBody
	public int order_response(Model model,QuRepVO QuRepVO) throws Exception {
		logger.info("order_responses");
		int check = 0;
		int order_manager = qurepservice.insert_reply(QuRepVO);
		 
		 return check;
		
	}
	
@RequestMapping(value = "/delete", method = {RequestMethod.POST,RequestMethod.GET})
	
	@ResponseBody
    public int delete(Model model,QuRepVO QuRepVO) throws Exception{
		int result = qurepservice.reply_delete(QuRepVO);
        return result;
    }
/*
	 @RequestMapping("/menu/delete.do")
	    public String delete(@RequestParam int q_no) throws Exception{
	        quService.delete(q_no);
	        return "redirect:/menu/quview";
	    }
   */
}