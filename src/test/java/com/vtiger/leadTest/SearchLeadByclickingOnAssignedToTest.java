package com.vtiger.leadTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class SearchLeadByclickingOnAssignedToTest extends MainBaseClassUtilities{
	@Test(groups="Sanity")

	public void SearchLeadByclickingOnAssignedTo() {
		
		String assignedTo = MainExcelUtility.getDataFromExcel("Lead_Module", 3, 1);

		LoginPage loginAction=new LoginPage(driver);
		HomePage homePageActions=new HomePage(driver);
		LeadValidationPage leadValid=new LeadValidationPage(driver);

		leadValid.assignedTo(assignedTo);

		MainWebDriverUtility.selectDropDown(leadValid.searchInDropDown(driver), 7);

		leadValid.search();

		if(leadValid.ValidateMastiName().contains("Masti"))
		{
			MainJavaUtility.printTheStatement("lead module details displayes by using Assigned to");
			MainJavaUtility.printTheStatement("Tc Pass");
		}
		else
		{
			MainJavaUtility.printTheStatement("Tc Fail");
		}
		
	}

}



