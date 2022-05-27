package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class HomePage {

	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement OrganizationLNK;

	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement ContactsLNK;

	@FindBy(xpath = "//a[.='Leads']")
	private WebElement LeadLNK;

	@FindBy(xpath = "//a[.='Products']")
	private WebElement ProductsLNK;

	@FindBy(xpath = "//a[.='Documents']")
	private WebElement DocumentsLNK;

	@FindBy(xpath = "//img[@style='padding-left:5px']")
	private WebElement MoreLNK;


	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorBTN;

	@FindBy(xpath ="//a[.='Sign Out']")
	private WebElement SignOutBTN;




	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//business libraries

	public  void organizationClick() {
		OrganizationLNK.click();
	}

	public void contactsClick()
	{
		ContactsLNK.click();
	}

	public void leadClick()
	{
		LeadLNK.click();
	}

	public void productsClick()
	{
		ProductsLNK.click();	
	}

	public void documentsClick()
	{
		DocumentsLNK.click();
	}

	public void moreClick()
	{	
		MoreLNK.click();
	}

	public void signOutclick(WebDriver driver)
	{
		MainWebDriverUtility.waitUntillElementToBeClickable(driver, AdministratorBTN, 30);
		MainWebDriverUtility.mouseHoverOnTheElement(AdministratorBTN, driver);
		SignOutBTN.click();
	}

	
	
}
