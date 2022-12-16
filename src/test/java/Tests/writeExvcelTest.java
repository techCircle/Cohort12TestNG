package Tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.Constants;

public class writeExvcelTest {
	
	public static void main(String[] args) throws IOException {
		
	//opens connection to the file
	FileInputStream input = new FileInputStream(Constants.excelFilePath);
	
	
	//get workbook
	XSSFWorkbook wb = new XSSFWorkbook(input);
	
	//get sheet index of
	Sheet sheet = wb.getSheetAt(0);
	
	
	int lastRow = sheet.getLastRowNum();
	System.out.println(lastRow);
	
	
	for(int i = 1; i<=lastRow; i++) {
		
		Row row = sheet.getRow(i);
		
		
		Cell cell = row.createCell(8);
		Cell cell2 = row.createCell(9);
		
		
		cell.setCellValue("Cohort 12");
		cell2.setCellValue("TechCircle Team");
		
	}
	

	FileOutputStream fos = new FileOutputStream(Constants.excelFilePath);
	wb.write(fos);
	fos.close();

	}
}
