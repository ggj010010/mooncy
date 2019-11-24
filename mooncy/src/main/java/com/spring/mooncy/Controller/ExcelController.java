package com.spring.mooncy.Controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mooncy.service.OrderService;

@Controller
public class ExcelController {

	@Autowired
	OrderService OrderService;


	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @RequestMapping(value = "/excelUploadAjax", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView excelUploadAjax(MultipartHttpServletRequest request)  throws Exception{
        MultipartFile excelFile =request.getFile("excelFile");
        System.out.println("엑셀 파일 업로드 컨트롤러");
        if(excelFile==null || excelFile.isEmpty()){
            throw new RuntimeException("엑셀파일을 선택 해 주세요.");
        }
        
        File destFile = new File("D:\\"+excelFile.getOriginalFilename());
        try{
            excelFile.transferTo(destFile);
        }catch(IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }
        
        //userService.excelUpload(destFile);
        
        //FileUtils.delete(destFile.getAbsolutePath());
        //destFile.delete();
        ModelAndView view = new ModelAndView();
        view.setViewName("");
        return view;
    }


}
