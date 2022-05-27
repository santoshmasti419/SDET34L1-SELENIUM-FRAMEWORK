package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainJavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactByOrganizationAndWriteInExcelTest {

@Test



	public void createContactByOrganizationAndWriteInExcelTest() throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(file);
		
		
		
		MainJavaUtility Rand = new MainJavaUtility();
		int R = Rand.getRandomNumber(1000);
		
		MainJavaUtility TimeOut = new MainJavaUtility();
		long t = TimeOut.stringToLong("timeout");


		String url =MainFileUtility.fetchdataFromPropertyFile("url");
		String usernamr = MainFileUtility.fetchdataFromPropertyFile("username");
		String password = MainFileUtility.fetchdataFromPropertyFile("password");
		String timeout = MainFileUtility.fetchdataFromPropertyFile("timeout");
		
		//long LongTimeOut = Long.parseLong(timeout);

		FileInputStream file1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		Random rand=new Random();
		int RandomNo = rand.nextInt(1000);
		Sheet sh=wb.getSheet("contacts");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(1);
		String FirstName = cell.getStringCellValue();
		Row row1 = sh.getRow(1);
		Cell cell1 = row1.getCell(1);
		String lastName = cell1.getStringCellValue();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);

		//login to app
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(usernamr);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		if(driver.getTitle().contains("Home"))
		{
			wb.getSheet("contacts").getRow(7).createCell(5).setCellValue("Home Page is Displayed");
			wb.getSheet("contacts").getRow(7).createCell(6).setCellValue("tc pass");

		}
		//click on contact
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		String title = driver.getTitle();
		{
			System.out.println(title);
		}

		if(driver.getTitle().contains("Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM"))
		{
			wb.getSheet("contacts").getRow(8).createCell(5).setCellValue("contact Page is Displayed");
			wb.getSheet("contacts").getRow(8).createCell(6).setCellValue("tc pass");
		}

		//enter First Name, last name and save
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		/*String t = driver.getTitle();
		{
			System.out.println(t);
		}
		if(driver.getTitle().contains("EditView&return_action"))
		{
			wb.getSheet("contacts").getRow(9).createCell(5).setCellValue("contact is displayed");
			wb.getSheet("contacts").getRow(9).createCell(6).setCellValue("tc pass");
		}*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		String save_contact = driver.getTitle();
		{
			System.out.println(save_contact);
		}
		if(driver.getTitle().contains("Administrator - Contacts - vtiger CRM 5"))
		{
			wb.getSheet("contacts").getRow(9).createCell(5).setCellValue("Save pupup is displayed");
			wb.getSheet("contacts").getRow(9).createCell(6).setCellValue("tc pass");
		}




		FileOutputStream file2 = new FileOutputStream("./src/test/resources/Worksheet.xlsx");
		wb.write(file2);
		wb.close();
		driver.quit();







	}

}
