package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1.genericUtility.MainDataBaseUtility;
import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInDatabaseWrtToGUI {

	public static void main(String[] args) throws SQLException, IOException {
		
		MainFileUtility.openPropertyfile(MainIconstantPath.RMG_YANTRA_PROPERTY_FILE);
		MainJavaUtility Jutil = new MainJavaUtility();
		int RandomInt = Jutil.getRandomNumber(1000);
		
		String DBUrl = MainFileUtility.fetchdataFromPropertyFile("DBUrl");
		String DBUserName = MainFileUtility.fetchdataFromPropertyFile("DBUserName");
		String DBPassword = MainFileUtility.fetchdataFromPropertyFile("DBPassword");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		MainWebDriverUtility.waitTillPageGetLoad(10, driver);
		
		MainWebDriverUtility.navigateApp("http://localhost:8084", driver);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String projectName="Ep-Tracking";
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName+RandomInt);
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementsByName('teamSize').Value='10'");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak sir");
		WebElement ProjectDropdownStatus = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		
		
		
		MainWebDriverUtility.selectDropDown(ProjectDropdownStatus,1);
		
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement ListToProject = driver.findElement(By.xpath("//table//tbody/tr/td[2]"));
		//JDBC
		
	
		MainDataBaseUtility.openDBConnection(DBUrl, DBUserName, DBPassword);
		
		MainDataBaseUtility.getDataFromDB("select* from project;", "2");
		MainDataBaseUtility.validateDataInDB(DBUserName, DBPassword, projectName);
        MainJavaUtility.printTheStatement("tc pass");
        MainDataBaseUtility.closeConnection();


}}
