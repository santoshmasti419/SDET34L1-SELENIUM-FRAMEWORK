package com.vtiger.leadTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
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

public class EditLeadByMassEditTest extends MainBaseClassUtilities {
	
	@Test(groups="Regression")

	public void editLeadByMassedit() throws IOException{
		
		String webSite = MainExcelUtility.getDataFromExcel("Lead_Module", 3, 1);
		homePageActions=new HomePage(driver);
		LeadValidationPage leadValid=new LeadValidationPage(driver);

		homePageActions.leadClick();

		leadValid.leadValidationThroughWebsite(webSite);

		MainWebDriverUtility.selectDropDown(leadValid.searchInDropDown(driver), 5);

		leadValid.search();

		if(leadValid.ValidateMastiName().contains("Masti"))
		{
			MainJavaUtility.printTheStatement("Edit lead module by mass edit successfully");
			MainJavaUtility.printTheStatement("Tc Pass");
		}
		else
		{
			MainJavaUtility.printTheStatement("Tc Fail");
		}
	}
}




