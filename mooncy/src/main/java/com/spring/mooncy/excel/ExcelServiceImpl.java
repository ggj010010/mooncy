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

import com.spring.mooncy.dao.ManagerDAO;
import com.spring.mooncy.dto.ExcelDTO;
@Service
public class ExcelServiceImpl implements ExcelService{
	@Autowired
	ExcelDAO excelDAO;
	
	
	public List<ExcelDTO> xlsExcelReader(MultipartHttpServletRequest req) {
		// ��ȯ�� ��ü�� ����
		List<ExcelDTO> list = new ArrayList<>();

		MultipartFile file = req.getFile("excel");
		HSSFWorkbook workbook = null;

		try {
			// HSSFWorkbook�� �������� ��ü ������ ��� �ִ� ��ü
			workbook = new HSSFWorkbook(file.getInputStream());

			// Ž���� ����� Sheet, Row, Cell ��ü
			HSSFSheet curSheet;
			HSSFRow curRow;
			HSSFCell curCell;
			ExcelDTO excelDTO;

			// Sheet Ž�� for��
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// ���� sheet ��ȯ
				curSheet = workbook.getSheetAt(sheetIndex);
				// row Ž�� for��
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0�� ��������̱� ������ ����
					if (rowIndex != 0) {
						curRow = curSheet.getRow(rowIndex);
						excelDTO = new ExcelDTO();
						String value;

						// row�� ù��° cell���� ������� �ʴ� ��츸 cellŽ��
						if (curRow.getCell(0) != null) {
							if (!"".equals(curRow.getCell(0).getStringCellValue())) {
								// cell Ž�� for��
								for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
									curCell = curRow.getCell(cellIndex);

									if (true) {
										value = "";
										// cell ��Ÿ���� �ٸ����� String���� ��ȯ ����
										switch (curCell.getCellType()) {
										case HSSFCell.CELL_TYPE_FORMULA:
											value = curCell.getCellFormula();
											break;
										case HSSFCell.CELL_TYPE_NUMERIC:
											value = curCell.getNumericCellValue() + "";
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

										// ���� colum index�� ���� excelDTO�Է�
										switch (cellIndex) {
										case 0: // ���̵�
											excelDTO.setCustId(value);
											break;
										case 1: // �̸�
											excelDTO.setCustName(value);
											break;
										case 2: // ����
											excelDTO.setCustAge(value);
											break;
										case 3: // �̸���
											excelDTO.setCustEmail(value);
											break;
										default:
											break;
										}
									} // end if
								} // end for
								// cell Ž�� ���� excelDTO �߰�
								list.add(excelDTO);
							} // end
						} // end if
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ��� insert
		excelDAO.insertExcelTest(list);
		return list;
	}

	public List<ExcelDTO> xlsxExcelReader(MultipartHttpServletRequest req) {
		// ��ȯ�� ��ü�� ����
		List<ExcelDTO> list = new ArrayList<>();

		MultipartFile file = req.getFile("excel");
		XSSFWorkbook workbook = null;

		try {
			// HSSFWorkbook�� �������� ��ü ������ ��� �ִ� ��ü
			workbook = new XSSFWorkbook(file.getInputStream());

			// Ž���� ����� Sheet, Row, Cell ��ü
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			ExcelDTO excelDTO;

			// Sheet Ž�� for��
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// ���� sheet ��ȯ
				curSheet = workbook.getSheetAt(sheetIndex);
				// row Ž�� for��
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0�� ��������̱� ������ ����
					if (rowIndex != 0) {
						curRow = curSheet.getRow(rowIndex);
						excelDTO = new ExcelDTO();
						String value;

						// row�� ù��° cell���� ������� �ʴ� ��츸 cellŽ��
						if (curRow.getCell(0) != null) {
							if (!"".equals(curRow.getCell(0).getStringCellValue())) {
								// cell Ž�� for��
								for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
									curCell = curRow.getCell(cellIndex);

									if (true) {
										value = "";
										// cell ��Ÿ���� �ٸ����� String���� ��ȯ ����
										switch (curCell.getCellType()) {
										case HSSFCell.CELL_TYPE_FORMULA:
											value = curCell.getCellFormula();
											break;
										case HSSFCell.CELL_TYPE_NUMERIC:
											value = curCell.getNumericCellValue() + "";
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

										// ���� colum index�� ���� excelDTO�Է�
										switch (cellIndex) {
										case 0: // ���̵�
											excelDTO.setCustId(value);
											break;
										case 1: // �̸�
											excelDTO.setCustName(value);
											break;
										case 2: // ����
											excelDTO.setCustAge(value);
											break;
										case 3: // �̸���
											excelDTO.setCustEmail(value);
											break;
										default:
											break;
										}
									} // end if
								} // end for
								// cell Ž�� ���� excelDTO �߰�
								list.add(excelDTO);
							} // end
						} // end if
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		excelDAO.insertExcelTest(list);
		return list;
	}
}
