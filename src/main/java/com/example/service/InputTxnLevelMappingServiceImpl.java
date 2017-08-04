/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bean.InputFormBean;
import com.example.bean.InputTxnLevelMappingBean;
import com.example.model.InputTxn;
import com.example.model.InputTxnLevelMapping;
import com.example.model.OrderRequest;
import com.example.repository.IInputTxnLevelMappingRepository;

/**
 * @author Anurag
 * @description
 */
@Service("inputTxnLevelMappingService")
public class InputTxnLevelMappingServiceImpl implements IInputTxnLevelMappingService
{

	@Autowired
	private IInputTxnLevelMappingRepository inputTxnLevelMappingRepository;

	@Autowired
	private IInputTxnService inputTxnService;

	@Override
	public Boolean saveInputTxnLevelMapping(InputTxnLevelMapping inputTxnLevelMapping)
	{

		try
		{
			inputTxnLevelMappingRepository.save(inputTxnLevelMapping);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public InputTxnLevelMapping saveAndGetInputTxnLevelMapping(InputTxnLevelMapping inputTxnLevelMapping)
	{

		return inputTxnLevelMappingRepository.save(inputTxnLevelMapping);
	}

	@Override
	public Boolean saveInputTxnLevelMappings(List<InputTxnLevelMapping> inputTxnLevelMappings)
	{

		try
		{
			inputTxnLevelMappingRepository.save(inputTxnLevelMappings);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<InputTxnLevelMapping> saveAndGetInputTxnLevelMappings(List<InputTxnLevelMapping> inputTxnLevelMappings)
	{

		return inputTxnLevelMappingRepository.save(inputTxnLevelMappings);
	}

	@Override
	public int markCorrespondingInputTxnsAsOut(List<InputTxnLevelMapping> inputTxnLevelMappings)
	{

		List<Integer> inputTxnIds = new ArrayList<>();
		for (InputTxnLevelMapping inputTxnLevelMapping : inputTxnLevelMappings)
		{
			inputTxnIds.add(inputTxnLevelMapping.getInputTxn().getId());
		}

		return inputTxnService.markInputTxnsAsOut(inputTxnIds);
	}
	@Override
    public int markCorrespondingInputTxnLevelMappingsAsOut(List<InputTxnLevelMapping> inputTxnLevelMappings)
    {

        List<Integer> inputTxnLevelMappingIds = new ArrayList<>();
        for (InputTxnLevelMapping inputTxnLevelMapping : inputTxnLevelMappings)
        {
            inputTxnLevelMappingIds.add(inputTxnLevelMapping.getInputTxn().getId());
        }

        return inputTxnLevelMappingRepository.updateSoftDelete(inputTxnLevelMappingIds, true);
    }

	  @Override
	  public int markCorrespondingInputTxnsAsOutFromIds(List<Integer> inputTxnIds) {

	    return inputTxnService.markInputTxnsAsOut(inputTxnIds);
	  }

	  @Override
	  public int markCorrespondingInputTxnLevelMappingsAsOutFromIds(
	      List<Integer> inputTxnLevelMappingIds) {
	    
	    return inputTxnLevelMappingRepository.updateSoftDelete(inputTxnLevelMappingIds, true);
	  }
	  
	  @Override
	  public int markCorrespondingBothInputTxnAndLevelMappingsAsOut(List<InputTxnLevelMappingBean> inputTxnLevelMappingBeans){
	    
        List<Integer> inputTxnIds = new ArrayList<>();
        List<Integer> inputTxnLevelMappingIds = new ArrayList<>();

	    for(InputTxnLevelMappingBean inputTxnLevelMappingBean : inputTxnLevelMappingBeans){
	      if (inputTxnLevelMappingBean != null){
	        
    	      inputTxnIds.add(inputTxnLevelMappingBean.getInputTxnId());
    	      inputTxnLevelMappingIds.add(inputTxnLevelMappingBean.getId());
	      }   
	    }
	    
        markCorrespondingInputTxnLevelMappingsAsOutFromIds(inputTxnLevelMappingIds);
        markCorrespondingInputTxnsAsOutFromIds(inputTxnIds);	    
	    
	    return 1;
	  }
	  
	@Override
	public Page<InputTxnLevelMapping> getAllWithPagination(Pageable pageable)
	{
		Page<InputTxnLevelMapping> blogList = inputTxnLevelMappingRepository.findAll(pageable);
		return blogList;
	}

	@Override
	public List<InputTxnLevelMapping> findByCustomerID(String customerID)
	{

		return inputTxnLevelMappingRepository.findByCustomerID(customerID);
	}

	@Override
	public List<InputTxnLevelMapping> findByWarehouseID(String warehouseID)
	{

		return inputTxnLevelMappingRepository.findByWarehouseID(warehouseID);
	}

	@Override
	public List<InputTxnLevelMapping> findByOrderID(String orderID)
	{

		return inputTxnLevelMappingRepository.findByOrderID(orderID);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevel1Value(String level1Value)
	{

		return inputTxnLevelMappingRepository.findByLevel1Value(level1Value);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevel2Value(String level2Value)
	{

		return inputTxnLevelMappingRepository.findByLevel2Value(level2Value);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevel3Value(String level3Value)
	{

		return inputTxnLevelMappingRepository.findByLevel3Value(level3Value);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevel1NameAndLevel1Value(String level1Name, String level1Value)
	{

		return inputTxnLevelMappingRepository.findByLevel1NameAndLevel1ValueAndSoftDelete(level1Name, level1Value, false);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevel2NameAndLevel2Value(String level2Name, String level2Value)
	{

		return inputTxnLevelMappingRepository.findByLevel2NameAndLevel2ValueAndSoftDelete(level2Name, level2Value, false);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevel3NameAndLevel3Value(String level3Name, String level3Value)
	{

		return inputTxnLevelMappingRepository.findByLevel3NameAndLevel3ValueAndSoftDelete(level3Name, level3Value, false);
	}

	@Override
	public Page<InputTxnLevelMapping> findByLevel1NameAndLevel1Value(String level1Name, String level1Value,
			Pageable pageable)
	{

		return inputTxnLevelMappingRepository.findByLevel1NameAndLevel1Value(level1Name, level1Value, pageable);
	}

	@Override
	public Page<InputTxnLevelMapping> findByLevel2NameAndLevel2Value(String level2Name, String level2Value,
			Pageable pageable)
	{

		return inputTxnLevelMappingRepository.findByLevel2NameAndLevel2Value(level2Name, level2Value, pageable);
	}

	@Override
	public Page<InputTxnLevelMapping> findByLevel3NameAndLevel3Value(String level3Name, String level3Value,
			Pageable pageable)
	{

		return inputTxnLevelMappingRepository.findByLevel3NameAndLevel3Value(level3Name, level3Value, pageable);
	}

	@Override
	public List<InputTxnLevelMapping> findByLevelNameAndLevelValue(Integer levelNo, String levelName, String levelValue)
	{

		List<InputTxnLevelMapping> inputTxnLevelMappings = new ArrayList<>();
		if (levelNo == 1)
		{
			inputTxnLevelMappings = findByLevel1NameAndLevel1Value(levelName, levelValue);
		}
		else if (levelNo == 2)
		{
			inputTxnLevelMappings = findByLevel2NameAndLevel2Value(levelName, levelValue);
		}
		else if (levelNo == 3)
		{
			inputTxnLevelMappings = findByLevel3NameAndLevel3Value(levelName, levelValue);
		}
		return inputTxnLevelMappings;
	}
	
	@Override
	public List<InputTxnLevelMappingBean> findByLevelNameAndLevelValueAndGetBean(Integer levelNo, String levelName, String levelValue){
	  
	  List<InputTxnLevelMappingBean> inputTxnLevelMappingBeans = new ArrayList<>();
	  List<InputTxnLevelMapping> inputTxnLevelMappings = findByLevelNameAndLevelValue(levelNo, levelName, levelValue);
	  for (InputTxnLevelMapping inputTxnLevelMapping : inputTxnLevelMappings){
	   
	    InputTxnLevelMappingBean inputTxnLevelMappingBean = 
	        new InputTxnLevelMappingBean(inputTxnLevelMapping.getId(),inputTxnLevelMapping.isSoftDelete(),inputTxnLevelMapping.getCustomerID(),inputTxnLevelMapping.getWarehouseID(),inputTxnLevelMapping.getOrderID(),inputTxnLevelMapping.getLevel1Name(),inputTxnLevelMapping.getLevel1Value(),inputTxnLevelMapping.getLevel2Name(),inputTxnLevelMapping.getLevel2Value(),inputTxnLevelMapping.getLevel3Name(),inputTxnLevelMapping.getLevel3Value(),inputTxnLevelMapping.getInputTxn().getId());
	    inputTxnLevelMappingBeans.add(inputTxnLevelMappingBean);	    	    
	  }
	  
	  
	  return inputTxnLevelMappingBeans;
	}
	
	@Override
	public Page<InputTxnLevelMapping> findByLevelNameAndLevelValue(Integer levelNo, String levelName, String levelValue,
			Pageable pageable)
	{

		Page<InputTxnLevelMapping> inputTxnLevelMappings = null;
		if (levelNo == 1)
		{
			inputTxnLevelMappings = findByLevel1NameAndLevel1Value(levelName, levelValue, pageable);
		}
		else if (levelNo == 2)
		{
			inputTxnLevelMappings = findByLevel2NameAndLevel2Value(levelName, levelValue, pageable);
		}
		else if (levelNo == 3)
		{
			inputTxnLevelMappings = findByLevel3NameAndLevel3Value(levelName, levelValue, pageable);
		}
		return inputTxnLevelMappings;
	}

	@Override
	public InputTxnLevelMapping parseRowToModel(InputFormBean inputFormBean, Row row)
	{
		InputTxnLevelMapping inputTxnLevelMapping = null;
		// For each row, iterate through each columns
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext())
		{

			// Cell cell = cellIterator.next();
			// String level1Name =
			// ExcelService.parseCellValueToString(cellIterator.next());
			// String level1Value =
			// ExcelService.parseCellValueToString(cellIterator.next());
			// String level2Name =
			// ExcelService.parseCellValueToString(cellIterator.next());
			// String level2Value =
			// ExcelService.parseCellValueToString(cellIterator.next());
			// String level3Name =
			// ExcelService.parseCellValueToString(cellIterator.next());
			// String level3Value =
			// ExcelService.parseCellValueToString(cellIterator.next());

			String level1Name = null;
			if (cellIterator.hasNext())
			{
				level1Name = ExcelService.parseCellValueToString(cellIterator.next());
			}
			String level1Value = null;
			if (cellIterator.hasNext())
			{
				level1Value = ExcelService.parseCellValueToString(cellIterator.next());
			}
			String level2Name = null;
			if (cellIterator.hasNext())
			{
				level2Name = ExcelService.parseCellValueToString(cellIterator.next());
			}
			String level2Value = null;
			if (cellIterator.hasNext())
			{
				level2Value = ExcelService.parseCellValueToString(cellIterator.next());
			}
			String level3Name = null;
			if (cellIterator.hasNext())
			{
				level3Name = ExcelService.parseCellValueToString(cellIterator.next());
			}
			String level3Value = null;
			if (cellIterator.hasNext())
			{
				level3Value = ExcelService.parseCellValueToString(cellIterator.next());
			}

			inputTxnLevelMapping = new InputTxnLevelMapping(inputFormBean.getCustomerID(),
					inputFormBean.getWarehouseID(), inputFormBean.getOrderID(), level1Name, level1Value, level2Name,
					level2Value, level3Name, level3Value);
			System.out.println("Extra Columns are there ");
			break;
		}
		return inputTxnLevelMapping;
	}

	@Override
	public List<InputTxnLevelMapping> parseWorkbook(InputFormBean inputFormBean, Workbook workbook)
	{

		// Assuming this is the "SECOND" Sheet in the excel File

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
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return inputTxnLevelMappings;
	}

	@Override
	public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath)
	{

		try
		{
			Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
			List<InputTxnLevelMapping> inputTxnLevelMappings = parseWorkbook(inputFormBean, workbook);
			System.out.println(inputTxnLevelMappings.size());
			if (inputTxnLevelMappings.size() >= 1)
				System.out.println(inputTxnLevelMappings.get(1));
			inputTxnLevelMappingRepository.save(inputTxnLevelMappings);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath, List<InputTxn> inputTxns)
	{

		try
		{
			Workbook workbook = ExcelService.convertFileToWorkbook(excelFilePath);
			List<InputTxnLevelMapping> inputTxnLevelMappings = parseWorkbook(inputFormBean, workbook);
			System.out.println(inputTxnLevelMappings.size());

			Map<String, InputTxn> hashMapOfPKAndInputTxns = _getHashMapOfPKAndInputTxns(inputTxns);
			List<InputTxnLevelMapping> inputTxnLevelMappingsWithInputTxns = _getInputTxnLevelMappingsWithInputTxns(
					inputTxnLevelMappings, hashMapOfPKAndInputTxns);

			if (inputTxnLevelMappings.size() >= 1)
				System.out.println(inputTxnLevelMappings.get(1));
			inputTxnLevelMappingRepository.save(inputTxnLevelMappingsWithInputTxns);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private Map<String, InputTxn> _getHashMapOfPKAndInputTxns(List<InputTxn> inputTxns)
	{

		Map<String, InputTxn> hashMapOfPKAndInputTxns = new HashMap<>();
		for (InputTxn inputTxn : inputTxns)
		{
			String primaryKey = inputTxn.getUom() + "~" + inputTxn.getIdentifierID();
			String levelValue = inputTxn.getIdentifierID();
			if (!(levelValue == null || levelValue.isEmpty()))
			{
				hashMapOfPKAndInputTxns.put(primaryKey, inputTxn);
			}else {
			  System.out.println("Some Level 1 Values are emply or Null in Input Txns");
			}
		}
		return hashMapOfPKAndInputTxns;
	}

	@SuppressWarnings("unused")
	private List<InputTxnLevelMapping> _getInputTxnLevelMappingsWithInputTxns(
			List<InputTxnLevelMapping> inputTxnLevelMappings, Map<String, InputTxn> hashMapOfPKAndInputTxns)
	{

		List<InputTxnLevelMapping> inputTxnLevelMappingsWithInputTxns = new ArrayList<>();

		for (InputTxnLevelMapping inputTxnLevelMapping : inputTxnLevelMappings)
		{
			String primaryKey = inputTxnLevelMapping.getLevel1Name() + "~" + inputTxnLevelMapping.getLevel1Value();
			String levelValue = inputTxnLevelMapping.getLevel1Value();
			if (!(levelValue == null || levelValue.isEmpty()))
			{
				InputTxn inputTxn = hashMapOfPKAndInputTxns.get(primaryKey);
				if(inputTxn != null){
	                inputTxnLevelMapping.setInputTxn(inputTxn);
	                inputTxnLevelMappingsWithInputTxns.add(inputTxnLevelMapping);				  
				}else {
				  System.out.println("No Corresponding pair found in Input Txns");
				}
			}else {
			  System.out.println("Some Level 1 Values are emply or Null in Input Txns Level Mapping");
			}

		}
		return inputTxnLevelMappingsWithInputTxns;
	}



}
