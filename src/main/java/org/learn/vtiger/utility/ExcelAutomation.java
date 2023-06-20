package org.learn.vtiger.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAutomation {
	public static  List<Map<String, String>> AllData;
	
//	String pathOfFile;
//	public ExcelAutomation(String pathOfFile) {
//		// TODO Auto-generated constructor stub
//		this.pathOfFile = pathOfFile;
//	}

	public static Workbook createWorkbookObj() {
		Workbook workbook = null;
		try {
			InputStream objFileInputStream = new FileInputStream("src\\main\\resources\\TestData\\TestData.xlsx");
			workbook = new XSSFWorkbook(objFileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public static String getCellData(Row rowObj, int cellnum) {
		// TODO Auto-generated method stub
		Cell cellObj = rowObj.getCell(cellnum, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		CellType cellTypeObj = cellObj.getCellType();
		String cellData;
		if (cellTypeObj == CellType.NUMERIC) {
			Double data = cellObj.getNumericCellValue();
			Integer intdata = data.intValue();
			cellData = intdata.toString();
		} else {
			cellData = cellObj.getStringCellValue();
		}
		return cellData;
	}

	public static List<Map<String, String>> readAllData(String sheetName) {
		// TODO Auto-generated method stub
		Workbook objWorkbook = createWorkbookObj();
		Sheet obj = objWorkbook.getSheet(sheetName);
		AllData = new ArrayList<Map<String, String>>();
		int row = obj.getLastRowNum();
		for (int i = 0; i <= row; i++) {
			Row objrow = obj.getRow(i);
			Row objrowHeadder = obj.getRow(0);
			int cellcount = objrow.getLastCellNum();
			Map<String, String> mapData = new HashMap<String, String>();
			for (int j = 0; j < cellcount; j++) {
				String cellDataKey = getCellData(objrowHeadder, j);
				String cellDataValue = getCellData(objrow, j);
				mapData.put(cellDataKey, cellDataValue);
			}
			AllData.add(mapData);
		}
		return AllData;
	}

	public List<String> getColumnData(String sheetName,String columnName) {
		// TODO Auto-generated method stub
		List<Map<String, String>> data = readAllData(sheetName);
		List<String> columnData = new ArrayList<String>();
		for (Map<String, String> map : data) {
			columnData.add(map.get(columnName));
		}
		return columnData;
	}

	public Map<String, String> readRowData( int sheetName,int row_No) {
		// TODO Auto-generated method stub
		Workbook objWorkbook = createWorkbookObj();
		Sheet obj = objWorkbook.getSheetAt(sheetName);
		Row objrow = obj.getRow(row_No);
		Row objrowHeadder = obj.getRow(0);
		int cellcount = objrow.getLastCellNum();
		Map<String, String> mapData = new HashMap<String, String>();
		for (int j = 1; j < cellcount; j++) {
			String cellDataKey = getCellData(objrowHeadder, j);
			String cellDataValue = getCellData(objrow, j);
			mapData.put(cellDataKey, cellDataValue);
		}
		return mapData;
	}
}
