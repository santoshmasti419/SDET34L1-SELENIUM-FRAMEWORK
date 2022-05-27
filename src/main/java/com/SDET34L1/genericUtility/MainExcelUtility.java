package com.SDET34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

/**
 * This Class is used to fetch data from excel sheet
 * @author USER1
 *
 */


public class MainExcelUtility {
	static Workbook wb;

	/**
	 * This method is used to open excel 
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream FileExel = new FileInputStream(filePath);
		wb=WorkbookFactory.create(FileExel);
	}

	/**
	 * This method is used to fetch the data from excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */

	public static String getDataFromExcel(String sheetName,int rowNumber,int cellNumber)
	{
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}

	/**
	 * This method is used for write the data inside the excel sheet
	 * @param sheet
	 * @param rowNumber
	 * @param cellNumber
	 * @param massage
	 */

	public static void createDataInExcel(String sheet,int rowNumber, int cellNumber, String massage) 
	{
		wb.getSheet(sheet).getRow(rowNumber).createCell(cellNumber).setCellValue("message");	
	}

	/**
	 * This method is used for write data inside the excel file.
	 * @param filePath
	 * @throws FileNotFoundException
	 */

	public static void writeFileOutPutStream(String filePath) throws FileNotFoundException
	{
		FileOutputStream Fos = new FileOutputStream(filePath);
	}

	public static void closeExcel() throws IOException
	{
		wb.close();
	}

	/**
	 * this method is used to fetch the data from the excel
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getMultipleDataFromExcel(String sheetName)
	{
		Sheet sh = wb.getSheet(sheetName);
		Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				arr[i][j]=sh.getRow(j).getCell(j).getStringCellValue();

			}
		}
		return arr;



	}

}
