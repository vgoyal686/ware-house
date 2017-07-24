package com.example.service;


import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.example.bean.InputFormBean;
import com.example.model.InputTxn;
import com.example.model.InputTxnLevelMapping;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Anurag
 * @description 
 */
public interface IInputTxnLevelMappingService {

  /******************** Save Api *****************************/
  public Boolean saveInputTxnLevelMapping(InputTxnLevelMapping inputTxnLevelMapping);
  public InputTxnLevelMapping saveAndGetInputTxnLevelMapping(InputTxnLevelMapping inputTxnLevelMapping);
  
  public Boolean saveInputTxnLevelMappings(List<InputTxnLevelMapping> inputTxnLevelMappings);
  public List<InputTxnLevelMapping> saveAndGetInputTxnLevelMappings(List<InputTxnLevelMapping> inputTxnLevelMappings);

  public int markCorrespondingInputTxnsAsOut(List<InputTxnLevelMapping> inputTxnLevelMappings);
  
  /******************** Find/Search Api *****************************/
//  public InputTxnLevelMapping findByCustomerID(String customerID);  
//  public InputTxnLevelMapping findByWarehouseID(String warehouseID);
//  public InputTxnLevelMapping findByOrderID(String orderID);
  public List<InputTxnLevelMapping> findByCustomerID(String customerID);  
  public List<InputTxnLevelMapping> findByWarehouseID(String warehouseID);
  public List<InputTxnLevelMapping> findByOrderID(String orderID);
  
  public List<InputTxnLevelMapping> findByLevel1Value(String level1Value);
  public List<InputTxnLevelMapping> findByLevel2Value(String level2Value); 
  public List<InputTxnLevelMapping> findByLevel3Value(String level3Value); 
 

  public List<InputTxnLevelMapping> findByLevel1NameAndLevel1Value(String level1Name, String level1Value);
  public List<InputTxnLevelMapping> findByLevel2NameAndLevel2Value(String level2Name, String level2Value);
  public List<InputTxnLevelMapping> findByLevel3NameAndLevel3Value(String level3Name, String level3Value);

  
  /******************** Excel Workbook parsing utility *****************/
  public InputTxnLevelMapping parseRowToModel(InputFormBean inputFormBean, Row row);
  public List<InputTxnLevelMapping> parseWorkbook(InputFormBean inputFormBean, Workbook workbook);
  public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath);
  public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath, List<InputTxn> inputTxns);
  
}
