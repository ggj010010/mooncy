package com.spring.mooncy.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.excel.ExcelService;

@Controller
public class ExcelController {

	@Autowired
	ExcelService excelService;

	

	private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);
	
	
	@RequestMapping(value = "/excel/excelhome", method = {RequestMethod.GET,RequestMethod.POST})
	public String serviceMngForm(Model model,Principal principal) {
		return "/excel/excelhome";
	}
	
	@ResponseBody
	@RequestMapping(value = "/excel/ExcelUpload",  method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView excelUpload(MultipartHttpServletRequest req){
		ModelAndView mav = new ModelAndView("/excel/excelhome");
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		String excelType = req.getParameter("excelType");
		if(excelType.equals("xlsx")){
			list = excelService.xlsxExcelReader(req);
		}else if(excelType.equals("xls")){
			list = excelService.xlsExcelReader(req);
		}
		mav.addObject("list", list);
		return mav;
	}

}
