/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bean.InputFormBean;
import com.example.bean.InventoryLeftInWarehouses;
import com.example.bean.InventoryStorageDaysForMonth;
import com.example.bean.SumInventoryLoadingChargesForMonth;
import com.example.bean.SumInventoryStorageAndLoadingChargesForMonth;
import com.example.bean.SumInventoryStorageChargesForMonth;
import com.example.model.InputTxn;
import com.example.model.OrderRequest;
import com.example.repository.IInputTxnRepository;

/**
 * @author Anurag
 * @description
 */
@Service("inputTxnService")
public class InputTxnServiceImpl implements IInputTxnService
{

	@Autowired
	private IInputTxnRepository inputTxnRepository;

	@Autowired
    private IOrderRequestService orderRequestService;

	@Override
	public Boolean saveInputTxn(InputTxn inputTxn)
	{
		try
		{
			inputTxnRepository.save(inputTxn);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public InputTxn saveAndGetInputTxn(InputTxn inputTxn)
	{
		return inputTxnRepository.save(inputTxn);
	}

	@Override
	public Boolean saveInputTxns(List<InputTxn> inputTxns)
	{
		try
		{
			inputTxnRepository.save(inputTxns);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<InputTxn> saveAndGetInputTxns(List<InputTxn> inputTxns)
	{
		return inputTxnRepository.save(inputTxns);
	}

	@Override
	public int markInputTxnsAsOut(List<Integer> inputTxnIds)
	{
	  return inputTxnRepository.updateSoftDeleteAndOutOrderIDAndDate(inputTxnIds, true, "1", new Date());
	  //TODO  comment above & uncomment below
		//return inputTxnRepository.updateSoftDelete(inputTxnIds, true);
	  
	}

	  @Override
	  public int markInputTxnsAsOutAndUpdateOutOrderID(List<Integer> inputTxnIds, String outOrderID) {
	    
	    return inputTxnRepository.updateSoftDeleteAndOutOrderID(inputTxnIds, true, outOrderID);
	  }
	  
	  @Override
	  public int markInputTxnsAsOutAndUpdateOutOrderIDAndDate(List<Integer> inputTxnIds,
	      String outOrderID, Date outDate) {
	    
	    return inputTxnRepository.updateSoftDeleteAndOutOrderIDAndDate(inputTxnIds, true, outOrderID, new Date());
	  }
	  
	@Override
	public InputTxn findByCustomerID(String customerID)
	{
		// return inputTxnRepository.findByCustomerID(customerID);
		return inputTxnRepository.findByCustomerIDAndSoftDelete(customerID, false);
	}

	@Override
	public InputTxn findByWarehouseID(String warehouseID)
	{
		// return inputTxnRepository.findByWarehouseID(warehouseID);
		return inputTxnRepository.findByWarehouseIDAndSoftDelete(warehouseID, false);
	}

	@Override
	public InputTxn findByOrderID(String orderID)
	{
		// return inputTxnRepository.findByOrderID(orderID);
		return inputTxnRepository.findByOrderIDAndSoftDelete(orderID, false);
	}
	
	@Override
	public Page<InputTxn> getAllWithPagination(Pageable pageable)
	{
		Page<InputTxn> blogList = inputTxnRepository.findAll(pageable);
		return blogList;
	}
	

	@Override
	public InputTxn parseRowToModel(InputFormBean inputFormBean, Row row)
	{

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
			inputTxn = new InputTxn(inputFormBean.getCustomerID(), inputFormBean.getWarehouseID(),
					inputFormBean.getOrderID(), inputFormBean.getInvoiceNo(), inputFormBean.getInvoiceDate(),
					inputFormBean.getlCNo(), inputFormBean.getDateOfIssue(), inputFormBean.getCustomer(),
					inputFormBean.getDeliveryTerms(), inputFormBean.getPortOfImport(), inputFormBean.getbLNo(),
					inputFormBean.getbLDate(), inputFormBean.getpONo(), inputFormBean.getComments(), category,
					subCategory, product, principalCompany, model, identifierID, uom, quantity, attribute1Name,
					attribute1Value, attribute2Name, attribute2Value, attribute3Name, attribute3Value, attribute4Name,
					attribute4Value, attribute5Name, attribute5Value, description);
			System.out.println("Extra Columns are there ");
			break;
		}
		return inputTxn;
	}

	@Override
	public List<InputTxn> parseWorkbook(InputFormBean inputFormBean, Workbook workbook)
	{

		// Assuming this is the "FIRST" Sheet in the excel File
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return inputTxns;
	}

	@Override
	public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath)
	{

		try
		{
			Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
			List<InputTxn> inputTxns = parseWorkbook(inputFormBean, workbook);
			System.out.println(inputTxns.size());
			if (inputTxns.size() >= 1)
				System.out.println(inputTxns.get(0));
			inputTxnRepository.save(inputTxns);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.service.IInputTxnService#readFromExcelAndReturnAfterSaveToDb(
	 * com.example.bean.InputFormBean, java.lang.String)
	 */
	@Override
	public List<InputTxn> readFromExcelAndReturnAfterSaveToDb(InputFormBean inputFormBean, String excelFilePath)
	{

		List<InputTxn> savedInputTxns = null;
		try
		{
			Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
			List<InputTxn> inputTxns = parseWorkbook(inputFormBean, workbook);
			System.out.println(inputTxns.size());
			if (inputTxns.size() >= 1)
				System.out.println(inputTxns.get(0));
			savedInputTxns = inputTxnRepository.save(inputTxns);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return savedInputTxns;
	}

	@Override
	public List<InputTxn> findInputTransactions()
	{
		return inputTxnRepository.findAll();
	}

  @Override
  public List<InventoryLeftInWarehouses> findInventoryLeftInWarehousesByCustomerID(
      String customerID) {
    
    return inputTxnRepository.findInventoryLeftInWarehousesByCustomerID(customerID);
  }


  @Override
  public List<InventoryStorageDaysForMonth> findInventoryStorageDaysForMonthByCustomerID(
      String customerID, Date monthStartDateTime, Date monthEndDateTime) {
    
    return inputTxnRepository.findInventoryStorageDaysForMonthByCustomerID(customerID, monthStartDateTime, monthEndDateTime);
  }

  @Override
  public List<InventoryStorageDaysForMonth> findInventoryStorageDaysForMonthByCustomerID(
      String customerID, Date someDateOfAMonth) {
    // TODO Auto-generated method stub
    DateTime monthStartDateTime = new DateTime(someDateOfAMonth).dayOfMonth().withMinimumValue();
    DateTime monthEndDateTime = new DateTime(someDateOfAMonth).dayOfMonth().withMaximumValue();
    //TODO 
    return inputTxnRepository.findInventoryStorageDaysForMonthByCustomerID2(customerID, monthStartDateTime.toDate(), monthEndDateTime.toDate());
  }
  
  /******************** Utility ***************************/
  public DateTime getMonthStartDate(Date date){
    
    DateTime monthStartDateTime = new DateTime(date).dayOfMonth().withMinimumValue();
    System.out.println("Given date "+ date + " monthStartDateTime "+ monthStartDateTime);
    
    return monthStartDateTime;
  }

  public DateTime getMonthEndDate(Date date){
    
    DateTime monthEndDateTime = new DateTime(date).dayOfMonth().withMaximumValue();
    System.out.println("Given date "+ date + " monthEndDateTime "+ monthEndDateTime);
    
    return monthEndDateTime;
  }

  /* (non-Javadoc)
   * @see com.example.service.IInputTxnService#findInventoryStorageChargesForMonthByCustomerID(java.lang.String, java.util.Date)
   */
  @Override
  public List<InventoryStorageDaysForMonth> findInventoryStorageChargesForMonthByCustomerID(
      String customerID, Date someDateOfAMonth) {
    
    List<InventoryStorageDaysForMonth> listOfInventoryStorageDaysForMonth = findInventoryStorageDaysForMonthByCustomerID(customerID, new Date());
    
    System.out.println("listOfInventoryStorageDaysForMonth \n"+listOfInventoryStorageDaysForMonth);
    List<Integer> orderIds = new ArrayList<>();
    for (InventoryStorageDaysForMonth inventoryStorageDaysForMonth : listOfInventoryStorageDaysForMonth){
      if(inventoryStorageDaysForMonth != null 
          && inventoryStorageDaysForMonth.getOrderID() != null){
        orderIds.add(Integer.parseInt(inventoryStorageDaysForMonth.getOrderID()));
      }
    }
    
    List<OrderRequest> orderRequests = orderRequestService.findByOrderIDIn(orderIds);
    System.out.println("orderRequests \n"+ orderRequests);
    Map<Integer, OrderRequest> orderRequestsMap = new HashMap<>();
    for(OrderRequest orderRequest : orderRequests){
      orderRequestsMap.put(orderRequest.getOrderID(), orderRequest);
    }
    
    for (InventoryStorageDaysForMonth inventoryStorageDaysForMonth : listOfInventoryStorageDaysForMonth){
      if(inventoryStorageDaysForMonth != null 
          && inventoryStorageDaysForMonth.getOrderID() != null){
        
        Integer orderID = Integer.parseInt(inventoryStorageDaysForMonth.getOrderID());
        OrderRequest orderRequest = orderRequestsMap.get(orderID);
        Double ratePerUnitPerDay = Double.parseDouble(orderRequest.getRatePerUnitPerDay());
        Double storageCharge =  ratePerUnitPerDay * inventoryStorageDaysForMonth.getDaysPresent();
        
        inventoryStorageDaysForMonth.setRatePerUnitPerDay(ratePerUnitPerDay);
        inventoryStorageDaysForMonth.setStorageCharges(storageCharge);
      }
    }
    
    return listOfInventoryStorageDaysForMonth;
  }

  @Override
  public SumInventoryStorageChargesForMonth findSumInventoryStorageChargesForMonthByCustomerID(
      String customerID, Date someDateOfAMonth) {

    List<InventoryStorageDaysForMonth> listInventoryStorageDaysForMonth = findInventoryStorageChargesForMonthByCustomerID(customerID, someDateOfAMonth);
    Double storageCharges = 0.0;
    
    for(InventoryStorageDaysForMonth inventoryStorageDaysForMonth : listInventoryStorageDaysForMonth){
      storageCharges += inventoryStorageDaysForMonth.getStorageCharges();
    }
    
    SumInventoryStorageChargesForMonth  sumInventoryStorageChargesForMonth = new SumInventoryStorageChargesForMonth();
    sumInventoryStorageChargesForMonth.setCustomerID(customerID);
    sumInventoryStorageChargesForMonth.setStorageCharges(storageCharges);
    
    return sumInventoryStorageChargesForMonth;
  }

  @Override
  public SumInventoryStorageAndLoadingChargesForMonth findSumInventoryStorageAndLoadingChargesForMonthByCustomerID(
      String customerID, Date someDateOfAMonth) {

    SumInventoryStorageChargesForMonth sumInventoryStorageChargesForMonth = findSumInventoryStorageChargesForMonthByCustomerID(customerID, someDateOfAMonth);
    
    SumInventoryLoadingChargesForMonth sumInventoryLoadingChargesForMonth = orderRequestService.findSumInventoryLoadingChargesMonthByCustomerID(customerID, someDateOfAMonth);
    
    SumInventoryStorageAndLoadingChargesForMonth sumInventoryStorageAndLoadingChargesForMonth= new SumInventoryStorageAndLoadingChargesForMonth();
    
    sumInventoryStorageAndLoadingChargesForMonth.setCustomerID(customerID);
    sumInventoryStorageAndLoadingChargesForMonth.setLoadingCharge(sumInventoryLoadingChargesForMonth.getLoadingCharge());
    sumInventoryStorageAndLoadingChargesForMonth.setOtherCharge(sumInventoryLoadingChargesForMonth.getOtherCharge());
    sumInventoryStorageAndLoadingChargesForMonth.setStorageCharges(sumInventoryStorageChargesForMonth.getStorageCharges());
    sumInventoryStorageAndLoadingChargesForMonth.setUnloadingCharge(sumInventoryLoadingChargesForMonth.getUnloadingCharge());
    
    return sumInventoryStorageAndLoadingChargesForMonth;
  }

}
