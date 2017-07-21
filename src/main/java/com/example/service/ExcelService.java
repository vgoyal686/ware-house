/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import com.example.bean.*;
import com.example.model.TestReport;
import com.example.repository.TestReportRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Anurag
 * @description
 */
@Component
public class ExcelService implements IExcelService
{
	@Autowired
	private TestReportRepository testReportRepository;

	private Workbook convertMultipartFileStreamToWorkbook(FileBean fileBean)
	{

		ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
		Workbook workbook;
		Sheet sheet;
		try
		{
			if (fileBean.getFileData().getOriginalFilename().endsWith("xls"))
			{
				workbook = new HSSFWorkbook(bis);
			}
			else if (fileBean.getFileData().getOriginalFilename().endsWith("xlsx"))
			{
				workbook = new XSSFWorkbook(bis);
			}
			else
			{
				throw new IllegalArgumentException("Received file does not have a standard excel extension.");
			}

			return workbook;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("resource")
	public static Workbook convertFileToWorkbook(String filepath) throws Exception
	{

		FileInputStream file;
		// ByteArrayInputStream bis = new
		// ByteArrayInputStream(file.getFileData().getBytes());
		Workbook workbook = null;
		Sheet sheet;
		try
		{
			file = new FileInputStream(new File(filepath));
			if (filepath.endsWith("xls"))
			{
				workbook = new HSSFWorkbook(file);
			}
			else if (filepath.endsWith("xlsx"))
			{
				workbook = new XSSFWorkbook(file);
			}
			else
			{
				throw new IllegalArgumentException("Received file does not have a standard excel extension.");
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new Exception("Corrupted file");
		}
		return workbook;
	}

	/**
	 * Types available
	 * 
	 * @see CellType#NUMERIC
	 * @see CellType#STRING
	 * @see CellType#FORMULA
	 * @see CellType#BLANK
	 * @see CellType#BOOLEAN
	 * @see CellType#ERROR
	 */

	private List<TestReport> parseWorkbook(Workbook workbook)
	{

		List<TestReport> testReports = new ArrayList<TestReport>();
		try
		{
			if (workbook != null)
			{
				// Get first sheet from the workbook
				Sheet sheet = workbook.getSheetAt(0);

				// Iterate through each rows from first sheet
				Iterator<Row> rowIterator = sheet.iterator();

				// TODO FIX LATER. Skipping top 2 rows intentionally
				rowIterator.next();
				rowIterator.next();

				while (rowIterator.hasNext())
				{
					Row row = rowIterator.next();
					TestReport testReport = parseRowToModel(row);
					testReports.add(testReport);
					System.out.println("");
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return testReports;
	}

	private TestReport parseRowToModel(Row row)
	{

		TestReport testReport = null;
		// For each row, iterate through each columns
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext())
		{

			// Cell cell = cellIterator.next();
			String barcode = parseCellValueToString(cellIterator.next());
			String isc = parseCellValueToString(cellIterator.next());
			String voc = parseCellValueToString(cellIterator.next());
			String imp = parseCellValueToString(cellIterator.next());
			String vmp = parseCellValueToString(cellIterator.next());
			String pmax = parseCellValueToString(cellIterator.next());
			String carton = parseCellValueToString(cellIterator.next());
			String pallet = parseCellValueToString(cellIterator.next());
			String cableLength = parseCellValueToString(cellIterator.next());
			String connector = parseCellValueToString(cellIterator.next());
			String countryOfOrigin = parseCellValueToString(cellIterator.next());
			String currentSorting = parseCellValueToString(cellIterator.next());
			testReport = new TestReport(barcode, isc, voc, imp, vmp, pmax, carton, pallet, cableLength, connector,
					countryOfOrigin, currentSorting);
		}
		return testReport;
	}

	public static String parseCellValueToString(Cell cell)
	{
		String value = null;
		switch (cell.getCellType())
		{
		case Cell.CELL_TYPE_BOOLEAN:
			System.out.print("BOOLEAN:" + cell.getBooleanCellValue() + "\t\t");
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			System.out.print("NUMERIC:" + cell.getNumericCellValue() + "\t\t");
			value = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING:
			System.out.print("STRING:" + cell.getStringCellValue() + "\t\t");
			value = String.valueOf(cell.getStringCellValue());
			break;
		}

		return value;
	}
    @Override
	public void readFromExcelAndSaveToDb()
	{

		String excelFilePath = "src/main/resources/CS6U_P_17020500059.xls";
		ExcelService excelService = new ExcelService();
		try
		{
			Workbook workbook = excelService.convertFileToWorkbook(excelFilePath);
			List<TestReport> testReports = excelService.parseWorkbook(workbook);
			testReportRepository.save(testReports);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
    @Override
    public void readFromExcelAndSaveToDb(String excelFilePath)
    {

        //ExcelService excelService = new ExcelService();
        try
        {
            Workbook workbook = convertFileToWorkbook(excelFilePath);
            List<TestReport> testReports = parseWorkbook(workbook);
            System.out.println(testReports.size());
            if (testReports.size() >= 1) System.out.println(testReports.get(0));
            testReportRepository.save(testReports);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void readFromExcelAndSaveToDb(InputFormBean inputFormBean, String excelFilePath) {
      // TODO Auto-generated method stub
      
    }    
}
