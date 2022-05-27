package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(xpath ="//input[@name='lastname']" )
	private  WebElement LastNameTxt;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstNameTxt;

	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]" )
	private  WebElement SaveBtn;
	
	@FindBy(xpath ="//span[@class='dvHeaderText']" )
	private  WebElement ContactValidBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterContacts(String Lastname)
	{
		//FirstNameTxt.sendKeys(FirstName);
		LastNameTxt.sendKeys(Lastname);
		SaveBtn.click();
	}

	public void saveContact()
	{
		SaveBtn.click();
	}
	
	public WebElement ContactValid()
	{
		return ContactValidBtn;
	}

}
