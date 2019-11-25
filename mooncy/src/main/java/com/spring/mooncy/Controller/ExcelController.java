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

	    System.out.println("업로드 진행");

	    MultipartFile excelFile = request.getFile("excelFile");

	    if(excelFile==null || excelFile.isEmpty()){

	        throw new RuntimeException("엑셀파일을 선택 해 주세요.");
	    }

	    File destFile = new File("C:\\"+excelFile.getOriginalFilename());

	    try{
	      //내가 설정한 위치에 내가 올린 파일을 만들고
	        excelFile.transferTo(destFile);

	    }catch(Exception e){
	        throw new RuntimeException(e.getMessage(),e);
	    }

	    //업로드를 진행하고 다시 지우기
	    excelService.excelUpload(destFile);

	    destFile.delete();
	  //		FileUtils.delete(destFile.getAbsolutePath());

	    ModelAndView view = new ModelAndView();

	    view.setViewName("main/main.tiles");

	      return view;
	  }
	 
}
