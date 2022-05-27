package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.SQLException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUIWrtDatabase {

	private static String projectid;
	private static String project;
	private static String projectname;

	public static void main(String[] args) throws SQLException, IOException {
		
		MainFileUtility.openPropertyfile(MainIconstantPath.RMG_YANTRA_PROPERTY_FILE);
		MainDataBaseUtility.openDBConnection(MainIconstantPath.DATABASEURL+"projects", MainFileUtility.fetchdataFromPropertyFile("DBUserName"), MainFileUtility.fetchdataFromPropertyFile("DBPassword"));
		
		MainJavaUtility Jutil = new MainJavaUtility();
		int RandomInt = Jutil.getRandomNumber(1000);
		
		String query=("insert into project(project_id,created_by,created_on,project_name,status,team_size)value('"+projectid+"','"+project+"','28/04/2022','"+projectname+"','on going','3');");
		
		MainDataBaseUtility.setDataInDataBase(query);
		MainDataBaseUtility.closeConnection();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8084");
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
        Select s=new Select(ProjectDropdownStatus);
        s.selectByVisibleText("On Goging");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        //jdbc
        
      
        
        
        

	}

}
