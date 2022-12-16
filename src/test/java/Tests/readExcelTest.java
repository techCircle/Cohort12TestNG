package Tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.Constants;

public class readExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream input = new FileInputStream(Constants.excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

//		Row row = sheet.getRow(2);
//		Cell cell = row.getCell(0);
//		//System.out.println(cell);
//		Row row2 = sheet.getRow(4);
//		Cell cell2 = row2.getCell(0);
//		System.out.println(cell + " vs. "+ cell2);

		for (Row row : sheet) {

			for (Cell cell : row) {

				switch (cell.getCellType()) {

				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case FORMULA:
					System.out.println(cell.getNumericCellValue());
					break;
				}

				System.out.println(" ");

			}

			workbook.close();

		}

	}

}
