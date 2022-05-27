package com.vtiger.leadTest;

import java.io.IOException;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LeadValidationPage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchLeadByClickingOnPhoneTest extends MainBaseClassUtilities {
	@Test(groups="Sanity")

	public void searchLeadByClickingOnPhone() {
		String phoneNumber = MainExcelUtility.getDataFromExcel("Lead_Module",0,1);
		LoginPage loginActions=new LoginPage(driver);
		HomePage homePageActions=new HomePage(driver);
		LeadValidationPage leadActions=new LeadValidationPage(driver);
		homePageActions.leadClick();
		leadActions.leadValidationThroughNum(phoneNumber);
		MainWebDriverUtility.selectDropDown(leadActions.searchInDropDownNum(driver), 4);
	
		if(leadActions.ValidateMastiName().contains("Masti"))
		{
			MainJavaUtility.printTheStatement("lead module details displayes by using Phone number");
			MainJavaUtility.printTheStatement("Tc Pass");
		}
		else
		{
			MainJavaUtility.printTheStatement("Tc Fail");
		}
	
	}

}
