package com.example.service;

public interface IExcelService
{

	void readFromExcelAndSaveToDb();

  /**
   * @author Anurag
   * @Time -  Jul 7, 2017 - 7:01:34 PM
   * @param excelFilePath
   */
  void readFromExcelAndSaveToDb(String excelFilePath);

}
