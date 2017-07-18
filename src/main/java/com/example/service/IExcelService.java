package com.example.service;

import com.example.bean.InputFormBean;

public interface IExcelService
{

	void readFromExcelAndSaveToDb();

  /**
   * @author Anurag
   * @Time -  Jul 7, 2017 - 7:01:34 PM
   * @param excelFilePath
   */
  void readFromExcelAndSaveToDb(String excelFilePath);
  
  void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath);
}
