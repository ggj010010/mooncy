package com.spring.mooncy.excel;

import java.util.List;

import com.spring.mooncy.dto.CustomerDTO;

public interface ExcelDAO {
	int insertExcelTest(List<CustomerDTO> list);
}
