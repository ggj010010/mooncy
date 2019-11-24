package com.spring.mooncy.Controller;

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

import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.StoreDTO;
import com.spring.mooncy.service.ManagerService;
import com.spring.mooncy.service.StoreService;

@Controller
public class ManagerController {
	//	@Autowired
	//
	//	LoginService loginService;


	@Autowired
	ManagerService managerService;
	@Autowired
	StoreService storeService;
	
	

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);



	@RequestMapping(value = "/Manager/ManagerMain")
	public String Manager(Model model) throws Exception {

		return "/Manager/ManagerMain";

	}

	@RequestMapping(value = "/Manager/manager_order")
	public String manager_order(Model model, PagingDTO pagingDTO) throws Exception {
		logger.info("Manager :: page :: " + pagingDTO.getPageNo());
		
		int pageNo = 1;
 		if(pagingDTO.getPageNo() <= 0 ) {

 			pagingDTO.setPageNo(pageNo);

 		}
// 		int pageNo2 = 1;
// 		if(pagingDTO.getPageNo2() <= 0 ) {
//
// 			pagingDTO.setPageNo2(pageNo2);
//
// 		}
		model.addAttribute("orderList", managerService.selectOrder(pagingDTO));
		System.out.println("ol"+managerService.selectOrder(pagingDTO).size());
		if(managerService.selectOrder(pagingDTO).size() != 0) {
			model.addAttribute("totalCnt", managerService.selectOrder(pagingDTO).get(0).getPagingDTO().getTotalCnt());
		}
		model.addAttribute("pageNo", pagingDTO.getPageNo());
		
		model.addAttribute("order_managementList", managerService.selectOrder_Management(pagingDTO));
		//System.out.println("oml"+managerService.selectOrder_Management(pagingDTO).size());
		//if(managerService.selectOrder_Management(pagingDTO).size() != 0) {
		//	model.addAttribute("totalCnt2", managerService.selectOrder_Management(pagingDTO).get(0).getPagingDTO().getTotalCnt2());
		//}
		//model.addAttribute("pageNo2", pagingDTO.getPageNo2());
		return "/Manager/manager_order";

	}
	@RequestMapping(value = "/Manager/manager_store")
	public String manager_store(Model model) throws Exception {
		

		model.addAttribute("storeList", storeService.manager_searchList());

		return "/Manager/manager_store";

	}
	@RequestMapping(value = "/manager/request", method = {RequestMethod.POST,RequestMethod.GET})
	
	@ResponseBody
	public List<StoreDTO> order_request(Model model,OrderDTO orderDTO, HttpSession Hsession) throws Exception {
		logger.info("order_request");

		 List<StoreDTO> StoreList = managerService.requestOrderList(orderDTO,Hsession);
		  return StoreList;
		
	}
	
	@RequestMapping(value = "/manager/response", method = {RequestMethod.POST,RequestMethod.GET})
	
	@ResponseBody
	public int order_response(Model model,OrderDTO orderDTO) throws Exception {
		logger.info("order_responses");
		int check = 0;
		int order_manager = managerService.order_Manager(orderDTO); //Insert
		int order_update = managerService.order_Update(orderDTO); //수량-
		int request_update = managerService.request_Update(orderDTO); //수량+
		int check_update = managerService.check_Update(orderDTO); //check 0 -> 1
		 
		 check=order_update+request_update+check_update+order_manager;
		 return check;
		
	}
@RequestMapping(value = "/manager/manager_response", method = {RequestMethod.POST,RequestMethod.GET})
	
	@ResponseBody
	public int order_manager_response(Model model,OrderDTO orderDTO) throws Exception {
		logger.info("order_responses");
		int check = 0;
		int order_manager = managerService.order_Manager(orderDTO);
		int request_update = managerService.request_Update(orderDTO);
		int check_update = managerService.check_Update(orderDTO);
		 
		 check=request_update+check_update+order_manager;
		 return check;
		
	}
}
