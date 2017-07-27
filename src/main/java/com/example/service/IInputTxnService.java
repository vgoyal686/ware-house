/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bean.InputFormBean;
import com.example.model.InputTxn;
import com.example.model.InputTxnLevelMapping;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Anurag
 * @description
 */
public interface IInputTxnService
{

	/******************** Save Api *****************************/
	public Boolean saveInputTxn(InputTxn inputTxn);

	public InputTxn saveAndGetInputTxn(InputTxn inputTxn);

	public Boolean saveInputTxns(List<InputTxn> inputTxns);

	public List<InputTxn> saveAndGetInputTxns(List<InputTxn> inputTxns);

	public int markInputTxnsAsOut(List<Integer> inputTxnIds);

	/******************** Find/Search Api *****************************/
	public InputTxn findByCustomerID(String customerID);

	public InputTxn findByWarehouseID(String warehouseID);

	public InputTxn findByOrderID(String orderID);

	/******************** Excel Workbook parsing utility *****************/
	public InputTxn parseRowToModel(InputFormBean inputFormBean, Row row);

	public List<InputTxn> parseWorkbook(InputFormBean inputFormBean, Workbook workbook);

	public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath);

	public List<InputTxn> readFromExcelAndReturnAfterSaveToDb(InputFormBean inputFormBean, String excelFilePath);

	List<InputTxn> findInputTransactions();

	Page<InputTxn> getAllWithPagination(Pageable pageable);
}
