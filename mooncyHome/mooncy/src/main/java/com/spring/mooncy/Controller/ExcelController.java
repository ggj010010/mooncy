package com.spring.mooncy.Controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mooncy.excel.ExcelRead;
import com.spring.mooncy.excel.ExcelReadOption;



@Controller
public class ExcelController{
	 @ResponseBody
	  @RequestMapping(value = "menu/excelUploadAjax.do", method = RequestMethod.POST)
	  public ModelAndView excelUploadAjax(MultipartFile testFile, MultipartHttpServletRequest request)  throws Exception{

	    System.out.println("���ε� ����");

	    MultipartFile excelFile = request.getFile("excelFile");

	    if(excelFile==null || excelFile.isEmpty()){

	        throw new RuntimeException("���������� ���� �� �ּ���.");
	    }

	    File destFile = new File("C:\\"+excelFile.getOriginalFilename());

	    try{
	      //���� ������ ��ġ�� ���� �ø� ������ �����
	        excelFile.transferTo(destFile);

	    }catch(Exception e){
	        throw new RuntimeException(e.getMessage(),e);
	    }

	    //���ε带 �����ϰ� �ٽ� �����
	    excelService.excelUpload(destFile);

	    destFile.delete();
	  //		FileUtils.delete(destFile.getAbsolutePath());

	    ModelAndView view = new ModelAndView();

	    view.setViewName("main/main.tiles");

	      return view;
	  }
	 
}
