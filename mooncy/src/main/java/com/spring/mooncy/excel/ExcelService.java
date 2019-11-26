package com.spring.mooncy.excel;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.mooncy.dto.ExcelDTO;

public interface ExcelService {
	public List<ExcelDTO> xlsExcelReader(MultipartHttpServletRequest req);
	
	public List<ExcelDTO> xlsxExcelReader(MultipartHttpServletRequest req);
}
