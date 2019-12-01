package com.spring.mooncy.excel;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.mooncy.dto.CustomerDTO;

public interface ExcelService {
	public List<CustomerDTO> xlsExcelReader(MultipartHttpServletRequest req);
	
	public List<CustomerDTO> xlsxExcelReader(MultipartHttpServletRequest req);
}
