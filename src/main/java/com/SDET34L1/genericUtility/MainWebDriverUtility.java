package com.SDET34L1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class is used to maintain all the WebDriver common actions
 * @author USER1
 *
 */

public class MainWebDriverUtility {
	private static final TakesScreenshot driver = null;
	static WebDriverWait wait;
	static Select select;
	static Actions action;

	/**
	 * This method is used to the application
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url, WebDriver driver)
	{

		driver.get(url);
	}

	/**
	 *  This method is used to the browser setting with implicitly wait 
	 * @param longTimeUnit
	 * @param driver
	 */

	public static void browserSetting(long longTimeOut,WebDriver driver)
	{

		maximizeBrowser(driver);
		waitTillPageGetLoad(longTimeOut, driver);

	}

	/**
	 *  This method is used to the maximize the browser
	 * @param driver
	 */

	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 *  This method is used to the giving implicitly wait
	 * @param longTimeOut
	 * @param driver
	 */

	public static void waitTillPageGetLoad(long longTimeOut,WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}

	/**
	 *  This method is used to the Mousehover actions
	 * @param element
	 * @param driver
	 */

	public static void mouseHoverOnTheElement(WebElement element, WebDriver driver)
	{
		action=new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 *  This method is used to the quit the browser
	 * @param driver
	 */

	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();	
	}

	/**
	 * This method is used to wait the control till the particularelement is clickable.
	 * @param element
	 */

	public static void waitUntillElementToBeClickable(WebDriver driver,WebElement element,long longTimeOut)
	{
		wait=new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	public static void waitUntillElementVisible(WebDriver driver,WebElement element,long longTimeOut)
	{
		wait=new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait the control till particular element is visible.
	 * @param driver
	 * @param timeOut
	 */

	public static void explicitlyWait(WebDriver driver, long timeOut)
	{
		wait = new WebDriverWait(driver, timeOut);
	}


	/**
	 * This method is used to switch to window based on title
	 * @param driver
	 * @param partialText
	 */

	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText));
			{
				break;
			}
		}
	}

	/**
	 * This method is used to handle the dropdown by  value
	 * 
	 * 
	 */
	public static void selectDropDown(WebElement Element, String value)
	{
		select = new Select(Element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle the dropdown by index
	 * @param VisibleText
	 * @param Element
	 */

	public static void selectDropDown( WebElement Element,int index)
	{
		select = new Select(Element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle the dropdown by visible text.
	 * @param VisibleText
	 * @param Element
	 */

	public static void selectDropDown( String VisibleText,WebElement Element)
	{
		select = new Select(Element);
		select.selectByVisibleText(VisibleText);
	}


	/**
	 * This method is used to switch the frame by using index number
	 * @param driver
	 * @param index
	 */

	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);	
	}

	/**
	 * This method is used to switch the frame 
	 * @param driver
	 * @param nameOrId
	 */
	public static void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);	
	}

	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public static void switchbackToHomeFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * This Method is used to double click action
	 */

	public void doubleClick(WebElement element) 
	{
		action.moveToElement(element).click().perform();
	}




	/**
	 * This method is used for handle the alert popup.
	 * @param driver
	 */

	public static void alertPopUp(WebDriver driver) {
		Alert alertPopUp = driver.switchTo().alert();
		alertPopUp.accept();
	}

	/**
	 * this method is used to scroll action the web element.
	 * @param driver
	 * @param element
	 */

	public void scrollToWebElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}


	/**
	 * this method is used to initialization the action class
	 */

	public static void initializationAction(WebDriver driver)
	{
		action=new Actions(driver);

	}

	/**
	 * this method is used to take screen shot
	 * @param driver
	 * @return
	 */

	public static File takeScreenShot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		return src;     
	}

	/**
	 * this method is used copy the screenshot in specific file
	 * @param filePath
	 * @param filename
	 * @param DateTime
	 * @param src
	 * @throws IOException
	 */

	public static void copyFromSourseToDestination(String filePath,String filename,String DateTime,File src) throws IOException
	{
		File dest=new File(""+filePath+filename+DateTime+".PNG");
		FileUtils.copyFile(src, dest);
	}



}



