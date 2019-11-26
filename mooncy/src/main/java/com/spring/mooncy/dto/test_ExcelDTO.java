package com.spring.mooncy.dto;

public class test_ExcelDTO {
	private String date;
	   private String value;
	   public String getDate() {
	      return date;
	   }
	   public void setDate(String date) {
	      this.date = date;
	   }
	   public String getValue() {
	      return value;
	   }
	   public void setValue(String value) {
	      this.value = value;
	   }
	   public test_ExcelDTO(String date, String value) {
	      super();
	      this.date = date;
	      this.value = value;
	   }
	   public test_ExcelDTO() {}

}
