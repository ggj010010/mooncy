package com.spring.mooncy.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.mooncy.dto.CustomerDTO;

@Service
public class ExcelServiceImpl implements ExcelService{
	@Autowired
	ExcelDAO excelDAO;
	
	
	public List<CustomerDTO> xlsExcelReader(MultipartHttpServletRequest req) {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();

		MultipartFile file = req.getFile("excel");
		HSSFWorkbook workbook = null;

		try {
			workbook = new HSSFWorkbook(file.getInputStream());

			HSSFSheet curSheet;
			HSSFRow curRow;
			HSSFCell curCell;
			CustomerDTO CustomerDTO;

			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				curSheet = workbook.getSheetAt(sheetIndex);
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					if (rowIndex != 0) {
						curRow = curSheet.getRow(rowIndex);
						CustomerDTO = new CustomerDTO();
						String value;

						if (curRow.getCell(0) != null) {
							//if (!"".equals(curRow.getCell(0).getStringCellValue())) {
								for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
									curCell = curRow.getCell(cellIndex);

									if (true) {
										value = "";
										switch (curCell.getCellType()) {
										case HSSFCell.CELL_TYPE_FORMULA:
											value = curCell.getCellFormula();
											break;
										case HSSFCell.CELL_TYPE_NUMERIC:
											value = Integer.toString((int) curCell.getNumericCellValue()) + "";
											break;
										case HSSFCell.CELL_TYPE_STRING:
											value = curCell.getStringCellValue() + "";
											break;
										case HSSFCell.CELL_TYPE_BLANK:
											value = curCell.getBooleanCellValue() + "";
											break;
										case HSSFCell.CELL_TYPE_ERROR:
											value = curCell.getErrorCellValue() + "";
											break;
										default:
											value = new String();
											break;
										} // end switch

										
										switch (cellIndex) {
										case 0: 
											CustomerDTO.setM_id(value);
											break;
										case 1: 
											CustomerDTO.setM_pw(value);
											break;
										case 2: 
											CustomerDTO.setM_name(value);
											break;
										default:
											break;
										}
									} // end if
								} // end for
								list.add(CustomerDTO);
							} // end
						} // end if
					}

				//}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		excelDAO.insertExcel(list);
		excelDAO.insertProduct(list);
		return list;
	}

	public List<CustomerDTO> xlsxExcelReader(MultipartHttpServletRequest req) {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();

		MultipartFile file = req.getFile("excel");
		XSSFWorkbook workbook = null;

		try {
			workbook = new XSSFWorkbook(file.getInputStream());

			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			CustomerDTO CustomerDTO;

			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				curSheet = workbook.getSheetAt(sheetIndex);
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					if (rowIndex != 0) {
						curRow = curSheet.getRow(rowIndex);
						CustomerDTO = new CustomerDTO();
						String value;

						if (curRow.getCell(0) != null) {
							//if (!"".equals(curRow.getCell(0).getStringCellValue())) {
								for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
									curCell = curRow.getCell(cellIndex);
									
									 if (true) {
										 
										value = "";
										switch (curCell.getCellType()) {
										case HSSFCell.CELL_TYPE_FORMULA:
											value = curCell.getCellFormula();
											break;
										case HSSFCell.CELL_TYPE_NUMERIC:
											value = Integer.toString((int) curCell.getNumericCellValue()) + "";
											break;
										case HSSFCell.CELL_TYPE_STRING:
											value = curCell.getStringCellValue() + "";
											break;
										case HSSFCell.CELL_TYPE_BLANK:
											value = curCell.getBooleanCellValue() + "";
											break;
										case HSSFCell.CELL_TYPE_ERROR:
											value = curCell.getErrorCellValue() + "";
											break;
										default:
											value = new String();
											break;
										} // end switch
										
										switch (cellIndex) {
										case 0: 
											CustomerDTO.setM_id(value);
											break;
										case 1: 
											CustomerDTO.setM_pw(value);
											break;
										case 2: 
											CustomerDTO.setM_name(value);
											break;
										default:
											break;
										}
										
									} // end if
								} // end for
								list.add(CustomerDTO);
							} // end
						} // end if
					}

				//}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		excelDAO.insertExcel(list);
		excelDAO.insertProduct(list);
		return list;
	}
}
