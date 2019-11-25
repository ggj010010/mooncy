package com.spring.mooncy.excel;

import java.util.List;

import com.spring.mooncy.dto.ExcelDTO;

public interface ExcelDAO {
	int insertExcelTest(List<ExcelDTO> list);
}
