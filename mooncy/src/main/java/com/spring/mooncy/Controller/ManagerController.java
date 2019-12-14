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
import org.springframework.web.servlet.ModelAndView;

import com.spring.mooncy.common.CommonUtil;
import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.dto.OrderDTO;
import com.spring.mooncy.dto.Order_ManagementDTO;
import com.spring.mooncy.dto.PagingDTO;
import com.spring.mooncy.dto.SaleDTO;
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
	   public String Manager(Model model,CustomerDTO customerDTO) throws Exception {
	      List<CustomerDTO> selectCustomer = managerService.selectCustomer();
	       model.addAttribute("selectCustomer", selectCustomer); // 데이터를 저장
	      return "/Manager/ManagerMain";

	   }

	   @ResponseBody
	   @RequestMapping(value = "/Manager/search", produces = "application/text; charset=utf8")
	   public String managerpop(SaleDTO saleDTO) throws Exception{
	      System.out.println("보낸이 : " +saleDTO.getM_id());
	      System.out.println("시작일 : " +saleDTO.getStart());
	      System.out.println("마무리일 : " +saleDTO.getEnd());
	      HashMap<String, Object> result = new HashMap<String, Object>();
	      CommonUtil commonUtil = new CommonUtil();
	      result.put("selectSale", managerService.selectSale(saleDTO)); 
	       String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
	       
	       System.out.println("callbackMsg::"+callbackMsg);
	       
	       return callbackMsg;
	   }
	@RequestMapping(value = "/Manager/UserInsert")
	public String UserInsert(Model model) throws Exception {

		return "/Manager/UserInsert";

	}
	@RequestMapping(value = "/Manager/manager_order")
	public String manager_order(Model model, PagingDTO pagingDTO) throws Exception {
		logger.info("Manager :: page :: " + pagingDTO.getPageNo());
		
		int pageNo = 1;
 		if(pagingDTO.getPageNo() <= 0 ) {

 			pagingDTO.setPageNo(pageNo);

 		}
 		int pageNo2 = 1;
 		if(pagingDTO.getPageNo2() <= 0 ) {

 			pagingDTO.setPageNo2(pageNo2);

 		}
 		model.addAttribute("select_User_Order", managerService.select_User_Order());
		model.addAttribute("orderList", managerService.selectOrder(pagingDTO));
		if(managerService.selectOrder(pagingDTO).size() != 0) {
			model.addAttribute("totalCnt", managerService.selectOrder(pagingDTO).get(0).getPagingDTO().getTotalCnt());
		}
		model.addAttribute("pageNo", pagingDTO.getPageNo());
		//
		model.addAttribute("order_managementList", managerService.selectOrder_Management(pagingDTO));
		if(managerService.selectOrder_Management(pagingDTO).size() != 0) {
			model.addAttribute("totalCnt2", managerService.selectOrder_Management(pagingDTO).get(0).getPagingDTO().getTotalCnt2());
		}
		model.addAttribute("pageNo2", pagingDTO.getPageNo2());
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
	
	@RequestMapping(value = "/UesrCheck", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public int UesrCheck(Model model,CustomerDTO customerDTO, HttpSession Hsession) throws Exception {
		logger.info("UesrCheck");
		
		 int check = managerService.UesrCheck(customerDTO);
		  return check;
		
	}
	@RequestMapping(value = "/UesrInsert", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public int UesrInsert(Model model,CustomerDTO customerDTO) throws Exception {
		logger.info("UesrInsert");

		 int insert_user = managerService.UesrInsert(customerDTO);
		 int insert_product = managerService.User_ProductInsert(customerDTO);
		  return insert_user+insert_product;
		
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


@ResponseBody
@RequestMapping(value = "/Manager/ManagerTest")
public String ManagerTest(Model model,Order_ManagementDTO order_managementDTO) throws Exception {
	
	List<Order_ManagementDTO> managerpop = managerService.selectManagerPop(order_managementDTO);

	return "/Manager/ManagerTest";

}


@RequestMapping(value = "/Manager/aaa")
public ModelAndView aaa(Order_ManagementDTO order_managementDTO) throws Exception{
	

    ModelAndView mav = new ModelAndView();
    mav.setViewName("Manager/aaa"); // 뷰를 custview.jsp로 설정

    return mav; // custview.jsp로 custview가 전달된다.
	}

@ResponseBody
@RequestMapping(value = "/Manager/managerpop2")
public ModelAndView managerpop2(Order_ManagementDTO order_managementDTO) throws Exception{
    List<CustomerDTO> selectCustomer = managerService.selectCustomer();
    ModelAndView mav = new ModelAndView();
    mav.setViewName("Manager/managerpop"); 
    mav.addObject("selectCustomer", selectCustomer); 
    return mav; 
	}

@ResponseBody
@RequestMapping(value = "/Manager/managerpop", produces = "application/text; charset=utf8")
public String managerpop(Order_ManagementDTO order_managementDTO) throws Exception{
	HashMap<String, Object> result = new HashMap<String, Object>();
	CommonUtil commonUtil = new CommonUtil();
	result.put("managerpop", managerService.selectManagerPop(order_managementDTO)); 
	result.put("managername", managerService.selectManagerName(order_managementDTO)); 

    
    String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
    
    System.out.println("callbackMsg::"+callbackMsg);
    
    return callbackMsg;
}

}
