package com.spring.mooncy.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.mooncy.excel.ExcelRead;
import com.spring.mooncy.excel.ExcelReadOption;
import com.spring.mooncy.service.ExcelService;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

  @Resource(name = "excelMapper")
  private ExcelMapper excelMapper;
  
  @Override
  public List<Map> selectRow() throws Exception {

    return excelMapper.selectRow();
  }

  @Override
  public void excelUpload(File destFile) {

    ExcelReadOption excelReadOption = new ExcelReadOption();

//		파일경로 추가
        excelReadOption.setFilePath(destFile.getAbsolutePath());
//      추출할 컬럼 명 추가
        excelReadOption.setOutputColumns("A","B","C","D");
        // 시작 행
        excelReadOption.setStartRow(2);

        List<Map<String, String>>excelContent = ExcelRead.read(excelReadOption);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("excelContent", excelContent);

        try {
      excelMapper.insertExcel(paramMap);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
