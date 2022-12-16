package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook book;
	private static Sheet sheet;

	// opens connection to the excel file
	private static void openExcel(String filePath) {

		try {
			FileInputStream fileIs = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// loads the worksheet
	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	// row count
	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	// col Count
	private static int colsCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();

	}

	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		int rows = rowCount();
		int cols = colsCount(0);

		Object[][] data = new Object[rows - 1][cols];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = cellData(i, j);

				System.out.println(cellData(i, j));

			}

		}

		return data;
	}
	
	
	
	
	
	
	
	
	
	
	

}
