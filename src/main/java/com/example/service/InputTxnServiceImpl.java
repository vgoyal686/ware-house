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
import org.springframework.stereotype.Service;

import com.example.bean.InputFormBean;
import com.example.model.InputTxn;
import com.example.model.TestReport;
import com.example.repository.IInputTxnRepository;

/**
 * @author Anurag
 * @description 
 */
@Service("inputTxnService")
public class InputTxnServiceImpl implements IInputTxnService{

  @Autowired
  private IInputTxnRepository inputTxnRepository;
  
  @Override
  public Boolean saveInputTxn(InputTxn inputTxn) {
    try{
      inputTxnRepository.save(inputTxn);
    } catch(Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public InputTxn saveAndGetInputTxn(InputTxn inputTxn) {
    return inputTxnRepository.save(inputTxn);
  }

  @Override
  public Boolean saveInputTxns(List<InputTxn> inputTxns) {
    try{
      inputTxnRepository.save(inputTxns);
    } catch(Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public List<InputTxn> saveAndGetInputTxns(List<InputTxn> inputTxns) {
    return inputTxnRepository.save(inputTxns);
  }

  @Override
  public int markInputTxnsAsOut(List<Integer> inputTxnIds) {

    return inputTxnRepository.updateSoftDelete(inputTxnIds, true);
  }
  
  @Override
  public InputTxn findByCustomerID(String customerID) {
    //return inputTxnRepository.findByCustomerID(customerID);
    return inputTxnRepository.findByCustomerIDAndSoftDelete(customerID, false);
  }

  @Override
  public InputTxn findByWarehouseID(String warehouseID) {
    //return inputTxnRepository.findByWarehouseID(warehouseID);
    return inputTxnRepository.findByWarehouseIDAndSoftDelete(warehouseID, false);
  }

  @Override
  public InputTxn findByOrderID(String orderID) {
    //return inputTxnRepository.findByOrderID(orderID);
    return inputTxnRepository.findByOrderIDAndSoftDelete(orderID, false);
  }

  @Override
  public InputTxn parseRowToModel(InputFormBean inputFormBean,Row row) {

    InputTxn inputTxn = null;
      // For each row, iterate through each columns
      Iterator<Cell> cellIterator = row.cellIterator();
      while (cellIterator.hasNext())
      {
        
          // Cell cell = cellIterator.next();
        String category = ExcelService.parseCellValueToString(cellIterator.next());
        String subCategory = ExcelService.parseCellValueToString(cellIterator.next());
        String product = ExcelService.parseCellValueToString(cellIterator.next());
        String principalCompany = ExcelService.parseCellValueToString(cellIterator.next());
        String model = ExcelService.parseCellValueToString(cellIterator.next());
        String identifierID = ExcelService.parseCellValueToString(cellIterator.next());
        String uom = ExcelService.parseCellValueToString(cellIterator.next());
        String quantity = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute1Name = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute1Value = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute2Name = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute2Value = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute3Name = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute3Value = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute4Name = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute4Value = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute5Name = ExcelService.parseCellValueToString(cellIterator.next());
        String attribute5Value = ExcelService.parseCellValueToString(cellIterator.next());
        String description = ExcelService.parseCellValueToString(cellIterator.next());
        inputTxn = new InputTxn(inputFormBean.getCustomerID(),inputFormBean.getWarehouseID(), inputFormBean.getOrderID(), inputFormBean.getInvoiceNo(),inputFormBean.getInvoiceDate(),inputFormBean.getlCNo(),inputFormBean.getDateOfIssue(),inputFormBean.getCustomer(),inputFormBean.getDeliveryTerms(),inputFormBean.getPortOfImport(),inputFormBean.getbLNo(),inputFormBean.getbLDate(),inputFormBean.getpONo(),inputFormBean.getComments(),
          category, subCategory, product, principalCompany, model, identifierID, uom, quantity, attribute1Name, attribute1Value, attribute2Name, attribute2Value, attribute3Name, attribute3Value, attribute4Name, attribute4Value, attribute5Name, attribute5Value, description);
        System.out.println("Extra Columns are there ");
        break;
      }
      return inputTxn;
  }
  @Override
  public List<InputTxn> parseWorkbook(InputFormBean inputFormBean, Workbook workbook) {

    //Assuming this is the "FIRST" Sheet in the excel File
    List<InputTxn> inputTxns = new ArrayList<InputTxn>();
    try
    {
        if (workbook != null)
        {
            // Get "first" sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // TODO FIX LATER. Skipping top 2 rows intentionally
            rowIterator.next();
            rowIterator.next();

            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                InputTxn inputTxn = parseRowToModel(inputFormBean, row);
                inputTxns.add(inputTxn);
                System.out.println("");
            }

        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return inputTxns;  
  }

  @Override
  public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath) {
   
    try
    {
        Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
        List<InputTxn> inputTxns = parseWorkbook(inputFormBean, workbook);
        System.out.println(inputTxns.size());
        if (inputTxns.size() >= 1) System.out.println(inputTxns.get(0));
        inputTxnRepository.save(inputTxns);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
  }

  /* (non-Javadoc)
   * @see com.example.service.IInputTxnService#readFromExcelAndReturnAfterSaveToDb(com.example.bean.InputFormBean, java.lang.String)
   */
  @Override
  public List<InputTxn> readFromExcelAndReturnAfterSaveToDb(InputFormBean inputFormBean,
      String excelFilePath) {
    
    List<InputTxn> savedInputTxns = null;
    try
    {
        Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
        List<InputTxn> inputTxns = parseWorkbook(inputFormBean, workbook);
        System.out.println(inputTxns.size());
        if (inputTxns.size() >= 1) System.out.println(inputTxns.get(0));
        savedInputTxns = inputTxnRepository.save(inputTxns);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }  
    return savedInputTxns;
  }

}
