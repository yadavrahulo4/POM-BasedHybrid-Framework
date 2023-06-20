import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI {
	public static void main(String[] args) throws IOException {
		write("\\TestData\\employee.xlsx");
//		read("\\TestData\\employee.xlsx");
	}

	public static void fetch(String value, String from, String where) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(System.getProperty("user.dir") + "\\TestData\\\\employee.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.getSheetAt(0);

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			Row row=sheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equals("samar Yadav")) {
			for (int j = 0; j < sheet.getRow(1).getLastCellNum(); j++) {
				Cell cell= row.getCell(j);
			CellType cellType=	cell.getCellType();
				

			}
			}
			else 
				continue;

		}

	}

	public static void read(String path) {
		File file1 = new File(System.getProperty("user.dir") + path);
		FileInputStream file = null;
		try {
			file = new FileInputStream(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Sheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int column = sheet.getRow(1).getLastCellNum();

		for (int r = 0; r < rows; r++) {
			Row row = sheet.getRow(r);
			for (int c = 0; c < column; c++) {
			    Cell cell = row.getCell(c);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;

				default:
					System.out.println("**");
					break;
				}
			}
		}
	}

	public static void write(String path) throws IOException {

		XSSFWorkbook workbook1 = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook1.createSheet("employeesDetails");
		Object[][] data = { 
				{ "EmployeeName", "EmployeeAddress", "EmployeeID" },
				{ "Rahul Yadav", "bhadohi", 0023 },
				{ "Vishal Yadav", "bhadohi", 0024 }, 
				{ "vinit Yadav", "bhadohi", 0025 },
				{ "samar Yadav", "bhadohi", 0026 }, 
				};
		int rows1 = data.length;
		int column1 = data[0].length;
		for (int r = 0; r < rows1; r++) {
			XSSFRow row = sheet1.createRow(r);
			for (int c = 0; c < column1; c++) {
				XSSFCell cell = row.createCell(c);
				Object cellvalue = data[r][c];
				if (cellvalue instanceof String) {
					cell.setCellValue((String) cellvalue);
				} else if (cellvalue instanceof Integer) {
					cell.setCellValue((Integer) cellvalue);
				}

			}
		}
		File file2 = new File(path);
		FileOutputStream fileOutputStream = new FileOutputStream(file2);
		workbook1.write(fileOutputStream);
		workbook1.close();
	}
}
