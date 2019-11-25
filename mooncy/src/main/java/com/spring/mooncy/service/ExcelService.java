package com.spring.mooncy.service;

import java.io.File;
import java.util.List;
import java.util.Map;



public interface  ExcelService {


	public List<Map> selectRow() throws Exception ;
	public void excelUpload(File destFile);
}
