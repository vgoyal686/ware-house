/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.bean.InputFormBean;
import com.example.model.InputTxn;
import com.example.model.InputTxnLevelMapping;
import com.example.repository.IInputTxnLevelMappingRepository;

/**
 * @author Anurag
 * @description 
 */
public class InputTxnLevelMappingServiceImpl implements IInputTxnLevelMappingService{

  @Autowired
  private IInputTxnLevelMappingRepository inputTxnLevelMappingRepository;

  @Override
  public Boolean saveInputTxnLevelMapping(InputTxnLevelMapping inputTxnLevelMapping) {
    // TODO Auto-generated method stub
    return null;
  }

  
  @Override
  public InputTxnLevelMapping saveAndGetInputTxnLevelMapping(
      InputTxnLevelMapping inputTxnLevelMapping) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.save(inputTxnLevelMapping);
  }

  @Override
  public Boolean saveInputTxnLevelMappings(List<InputTxnLevelMapping> inputTxnLevelMappings) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<InputTxnLevelMapping> saveAndGetInputTxnLevelMappings(
      List<InputTxnLevelMapping> inputTxnLevelMappings) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.save(inputTxnLevelMappings);
  }

  @Override
  public List<InputTxnLevelMapping> findByCustomerID(String customerID) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByCustomerID(customerID);
  }

  @Override
  public List<InputTxnLevelMapping> findByWarehouseID(String warehouseID) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByWarehouseID(warehouseID);
  }

  @Override
  public List<InputTxnLevelMapping> findByOrderID(String orderID) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByOrderID(orderID);
  }

  @Override
  public List<InputTxnLevelMapping> findByLevel1Value(String level1Value) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByLevel1Value(level1Value);
  }

  @Override
  public List<InputTxnLevelMapping> findByLevel2Value(String level2Value) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByLevel2Value(level2Value);
  }

  @Override
  public List<InputTxnLevelMapping> findByLevel3Value(String level3Value) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByLevel3Value(level3Value);
  }

  @Override
  public List<InputTxnLevelMapping> findByLevel1NameAndLevel1Value(String level1Name,
      String level1Value) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByLevel1NameAndLevel1Value(level1Name, level1Value);
  }

  @Override
  public List<InputTxnLevelMapping> findByLevel2NameAndLevel2Value(String level2Name,
      String level2Value) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByLevel2NameAndLevel2Value(level2Name, level2Value);
  }

  @Override
  public List<InputTxnLevelMapping> findByLevel3NameAndLevel3Value(String level3Name,
      String level3Value) {
    // TODO Auto-generated method stub
    return inputTxnLevelMappingRepository.findByLevel3NameAndLevel3Value(level3Name, level3Value);
  }

  @Override
  public InputTxnLevelMapping parseRowToModel(InputFormBean inputFormBean, Row row) {
    InputTxnLevelMapping inputTxnLevelMapping = null;
    // For each row, iterate through each columns
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext())
    {
      
        // Cell cell = cellIterator.next();
      String level1Name = ExcelService.parseCellValueToString(cellIterator.next());
      String level1Value = ExcelService.parseCellValueToString(cellIterator.next());
      String level2Name = ExcelService.parseCellValueToString(cellIterator.next());
      String level2Value = ExcelService.parseCellValueToString(cellIterator.next());
      String level3Name = ExcelService.parseCellValueToString(cellIterator.next());
      String level3Value = ExcelService.parseCellValueToString(cellIterator.next());
      
      inputTxnLevelMapping = new InputTxnLevelMapping(inputFormBean.getCustomerID(),inputFormBean.getWarehouseID(), inputFormBean.getOrderID()
        ,level1Name,level1Value,level2Name,level2Value,level3Name,level3Value);
      System.out.println("Extra Columns are there ");
      break;
    }
    return inputTxnLevelMapping;
  }

  @Override
  public List<InputTxnLevelMapping> parseWorkbook(InputFormBean inputFormBean, Workbook workbook) {
    
    //Assuming this is the "SECOND" Sheet in the excel File
    
    List<InputTxnLevelMapping> inputTxnLevelMappings = new ArrayList<InputTxnLevelMapping>();
    try
    {
        if (workbook != null && workbook.getNumberOfSheets() >= 2)
        {
            // Get "second" sheet from the workbook
            Sheet sheet = workbook.getSheetAt(1);

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // TODO FIX LATER. Skipping top 2 rows intentionally
            rowIterator.next();
            rowIterator.next();

            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                InputTxnLevelMapping inputTxnLevelMapping = parseRowToModel(inputFormBean, row);
                inputTxnLevelMappings.add(inputTxnLevelMapping);
                System.out.println("");
            }

        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return inputTxnLevelMappings;  
  }

  @Override
  public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath) {
   
    try
    {
        Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
        List<InputTxnLevelMapping> inputTxnLevelMappings = parseWorkbook(inputFormBean, workbook);
        System.out.println(inputTxnLevelMappings.size());
        if (inputTxnLevelMappings.size() >= 1) System.out.println(inputTxnLevelMappings.get(1));
        inputTxnLevelMappingRepository.save(inputTxnLevelMappings);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    
  }

}
