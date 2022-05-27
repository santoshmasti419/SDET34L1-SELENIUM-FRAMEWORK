package com.vtiger.contactTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends MainBaseClassUtilities{

	ContactPage contactsName;
	CreateContactPage createCont;
	@Test
	public  void createContact() throws IOException {

		String contacts= MainExcelUtility.getDataFromExcel("Contact Name", 0, 1);

		contactsName=new ContactPage(driver);
		createCont=new CreateContactPage(driver);

		homePageActions.contactsClick();

		contactsName.addCreateContact();

		createCont.enterContacts(contacts+RandomInt);

	}

}
