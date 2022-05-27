package com.vtiger.contactTest;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateContactWithOrganizationTest extends MainBaseClassUtilities {

	ContactPage contactsName;
	CreateContactPage enterContactDetails;

	MainJavaUtility jUtil;
	String contactName;
	@Test
	public void createContact(){

		contactsName=new ContactPage(driver);
		enterContactDetails=new CreateContactPage(driver);
		contactName = MainExcelUtility.getDataFromExcel("Contact Name", 0, 1);

		homePageActions.contactsClick();

		contactsName.addCreateContact();


		enterContactDetails.enterContacts(contactName);
		if(enterContactDetails.ContactValid().getText().contains(contactName))
		{
			jUtil.printTheStatement("Tc Pass");
			
		}
		else
			MainWebDriverUtility.waitTillPageGetLoad(LongTimeOut, driver);
		{
			jUtil.printTheStatement("Tc Fail");
		}
	
	}
}
