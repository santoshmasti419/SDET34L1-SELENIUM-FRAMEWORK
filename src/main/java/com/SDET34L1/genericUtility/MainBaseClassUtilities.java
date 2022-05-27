package com.SDET34L1.genericUtility;

import java.io.IOException;
/**
 * this class contains all base class utilities.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainBaseClassUtilities {
	public String url;
	public String username;
	public String password;
	public String timeout;
	public	MainJavaUtility jUtil;
	public int RandomInt;
	public long LongTimeOut;
	public String browser;
	public LoginPage loginAction;
	public HomePage homePageActions;
	public WebDriver driver;

	/**
	 * This method is used to open the excel and property files path
	 * @throws IOException
	 */
	@BeforeSuite(groups="BaseClass")
	public void beforeSuiteTest() throws IOException {
		MainFileUtility.openPropertyfile(MainIconstantPath.PROPERTY_FILE_PATH);
		MainExcelUtility.openExcel(MainIconstantPath.EXCEL_FILE_PATH);
	}

	/**
	 * This method is used to get the all the data from excel property file and normal execution configuration
	 * 
	 */
//	@Parameters("browser")
	@BeforeClass(groups="BaseClass")
	public void beforeClass1Test() {
		MainJavaUtility jUtil=new MainJavaUtility();
		url =MainFileUtility.fetchdataFromPropertyFile("url");
		username = MainFileUtility.fetchdataFromPropertyFile("username");
		password = MainFileUtility.fetchdataFromPropertyFile("password");
		timeout = MainFileUtility.fetchdataFromPropertyFile("timeout");
		browser = MainFileUtility.fetchdataFromPropertyFile("browser");
		LongTimeOut = jUtil.stringToLong(timeout);
		RandomInt = jUtil.getRandomNumber(10000);

		switch (browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println("specify browser key");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
			break;
		}
		
		MainWebDriverUtility.navigateApp(url, driver);
		MainWebDriverUtility.browserSetting(LongTimeOut, driver);
		MainWebDriverUtility.initializationAction(driver);
		MainWebDriverUtility.explicitlyWait(driver, LongTimeOut);
		loginAction = new LoginPage(driver);
		homePageActions=new HomePage(driver);


	}
	/**
	 * this method is used to login to application
	 */

	@BeforeMethod(groups="BaseClass")
	public void beforeMethod1Test()
	{
		loginAction.loginToApp(username, password);
	}

	/**
	 * this methos is used to logout the application
	 */

	@AfterMethod(groups="BaseClass")
	public void afterMethodTest()
	{
		MainWebDriverUtility.waitTillPageGetLoad(LongTimeOut, driver);
		homePageActions.signOutclick(driver);
	}

	/**
	 * this methos is used to close the browser
	 * @throws IOException
	 */
	@AfterClass(groups="BaseClass")
	public void aftreClass1Test() throws IOException
	{
		MainWebDriverUtility.explicitlyWait(driver, LongTimeOut);
		MainWebDriverUtility.quitBrowser(driver);
	}
	/**
	 * this method is used to close the excel
	 * @throws IOException
	 * 
	 */

	@AfterSuite(groups="BaseClass")
	public void afterSuite1Test() throws IOException {
		MainExcelUtility.closeExcel();
	}


}
