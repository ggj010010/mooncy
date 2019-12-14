package com.spring.mooncy.excel;

import java.util.List;

import com.spring.mooncy.dto.CustomerDTO;

public interface ExcelDAO {
	int insertExcel(List<CustomerDTO> list);
	int insertProduct(List<CustomerDTO> List);
}
