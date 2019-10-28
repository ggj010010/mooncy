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
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.service.LoginService;





@Controller

public class LoginController {

	@Autowired

	LoginService loginService;

	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	

	@RequestMapping(value = "/")

	public String login(Model model) throws Exception {



		return "login/login";

	}

	@RequestMapping(value = "/login/signup")

	public String signupForm(Model model) throws Exception {

		model.addAttribute("CustomerDTO", new CustomerDTO());

		return "login/signup";

	}

	@ResponseBody

	@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)

	public int insertCustomer(Locale locale, CustomerDTO customerDTO) throws Exception {

		logger.info("a"+customerDTO.toString());



		return loginService.insertCustomer(customerDTO);

	}

	

	@ResponseBody

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public int login(CustomerDTO customerDTO, HttpSession session) {
		String id = (String)session.getAttribute("m_id");
		
		return loginService.Login(customerDTO, session); 
	
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)

    //메소드 이름은 LOGOUT 매게 변수는 SESSION

    public String logout(HttpSession session) {

        //m으로 선언된 세션을 삭제시킨다.
		
        session.removeAttribute("m");

        // /페이지로 리다이렉트 시킨다.

        return "redirect:/";

    }





}
