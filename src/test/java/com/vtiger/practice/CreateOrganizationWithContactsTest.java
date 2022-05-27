package com.vtiger.practice;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.CreateOrganization;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithContactsTest {
	@Test
	
	
	public  void createOrganizationWithContactsTest() throws IOException, InterruptedException {

		MainJavaUtility jutil = new MainJavaUtility();

		int RandomInt = jutil.getRandomNumber(1000);

		MainFileUtility.openPropertyfile(MainIconstantPath.PROPERTY_FILE_PATH);

		String url = MainFileUtility.fetchdataFromPropertyFile("url");
		String username =  MainFileUtility.fetchdataFromPropertyFile("username");
		String password = MainFileUtility.fetchdataFromPropertyFile("password");
		String timeout =  MainFileUtility.fetchdataFromPropertyFile("timeout");
		String browser = MainFileUtility.fetchdataFromPropertyFile("browser");
		String OrgName = MainFileUtility.fetchdataFromPropertyFile("OrgName");

		long LongTimeOut = jutil.stringToLong(timeout);

		WebDriver driver=null;
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
			break;

		default:
			System.out.println("specify browser key");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
			break;
		}
		LoginPage loginAction = new LoginPage(driver);
		HomePage homePageActions=new HomePage(driver);
		
		CreateOrganization orgCreate=new CreateOrganization(driver);

		MainWebDriverUtility.waitTillPageGetLoad(LongTimeOut, driver);


		MainWebDriverUtility.navigateApp(url, driver);


		MainWebDriverUtility.maximizeBrowser(driver);


		loginAction.loginToApp(username, password);

		//driver.findElement(By.xpath("//a[.='Organizations']")).click();
		homePageActions.organizationClick();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		orgCreate.enterOrganizationName(OrgName, driver);


		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("SDET000"+RandomInt);
		//driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		orgCreate.saveOrganization(driver);
		
	    homePageActions.contactsClick();



		WebElement dr = driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']"));



		MainWebDriverUtility.mouseHoverOnTheElement(dr, driver);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//img[@alt='Select']")).click(); 
		Thread.sleep(2000);



		String parent_browser = driver.getWindowHandle();
		System.out.println(parent_browser);

		Set<String> child_and_parent = driver.getWindowHandles();
		System.out.println(child_and_parent);
		child_and_parent.remove(parent_browser);
		for(String only_child:child_and_parent)
		{
			driver.switchTo().window(only_child);
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("TYSS935");
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.id("1")).click();
		}
		driver.switchTo().window(parent_browser);

		driver.findElement(By.xpath("//input[@accesskey='S']")).click();

		homePageActions.signOutclick(driver);

	}

}
