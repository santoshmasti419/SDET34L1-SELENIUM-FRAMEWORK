package com.vtiger.organizationTest;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.vtiger.objectRepository.CreateOrganization;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationTest extends MainBaseClassUtilities {

	@Test
	public void createOrganization(){
		String organizationName = MainExcelUtility.getDataFromExcel("Organization", 1, 1);
		OrganizationPage OrgAction = new OrganizationPage(driver);
		LoginPage loginAction = new LoginPage(driver);
		CreateOrganization createOrgAction = new CreateOrganization(driver);
		HomePage homePageAction = new HomePage(driver);
		homePageAction.organizationClick();
		OrgAction.createOrganization();
		createOrgAction.enterOrganizationName(organizationName+RandomInt, driver);	
	}
}
