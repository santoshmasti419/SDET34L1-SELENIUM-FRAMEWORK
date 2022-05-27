package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fileMulti = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fileMulti);
		Sheet sh = wb.getSheet("MultipleData");
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			for(int j=0;i<sh.getRow(0).getLastCellNum();j++)
			{
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			}
		}

	}

}
