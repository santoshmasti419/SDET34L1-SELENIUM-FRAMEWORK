package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainWebDriverUtility;

public class TestNgPracticeTest1 
{
	@Test(dataProvider = "loginData")
	public void TestNgPracticeTest1(String username,String password)
	{
		Reporter.log(username+" ====>  "+password,true);
	}
	@DataProvider
	public Object[][] loginData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = new Object[4][2];
		data[0][0]="ramesh";
		data[0][1]="123";

		data[1][0]="ramesh";
		data[1][1]="123";
		
		data[2][0]="ramesh";
		data[2][1]="123";
		
		data[3][0]="ramesh";
		data[3][1]="123";
		return data;

		//	MainExcelUtility.openExcel(MainIconstantPath.EXCEL_FILE_PATH);
		//	return MainExcelUtility.getMultipleDataFromExcel("loginData");

	}

}
