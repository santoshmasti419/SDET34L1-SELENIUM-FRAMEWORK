package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelTest {

	public static void main(String[] args) throws IOException {
		/*FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("organization");
		Row row=sh.getRow(3);
		Cell cell = row.getCell(1);
		//Random ran=new Random();
		//int RandomNo = ran.nextInt(1000);
		String data=cell.getStringCellValue();
		System.out.println(data);
		wb.close();*/
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(5);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue();
		System.out.println(data);
		wb.close();
		
		
		

	}

}
