package com.vtiger.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.CreateOrganization;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationByGivingIndustryTypeTest extends MainBaseClassUtilities{

	@Test

	public void createOrganizationByGivingIndustryType () throws IOException{

		String organization = MainExcelUtility.getDataFromExcel("Organization", 1, 1);


		OrganizationPage OrgAction = new OrganizationPage(driver);

		CreateOrganization createOrgAction = new CreateOrganization(driver);

		homePageActions.organizationClick();
		
		OrgAction.createOrganization();

		createOrgAction.enterOrganizationNameOnly(organization+RandomInt);
		
		MainWebDriverUtility.selectDropDown("Education", createOrgAction.industryDropDown());
		
		MainWebDriverUtility.selectDropDown("Press", createOrgAction.pressDropDown());
		
		createOrgAction.saveOrganization(driver);
		//homePageActions.signOutclick(driver);
	}
}
