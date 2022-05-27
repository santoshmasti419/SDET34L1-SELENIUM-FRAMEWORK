package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.MainWebDriverUtility;

public class CreateOrganization {

	@FindBy(xpath = "//input[@class='detailedViewTextBox']")
	private WebElement EnterOrganizationName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement PressDropDown;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrganizationValidation;

	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void enterOrganizationName(String OrganizationName,WebDriver driver)
	{
		EnterOrganizationName.sendKeys(OrganizationName);
		SaveBtn.click();
		MainWebDriverUtility.waitUntillElementVisible(driver, OrganizationValidation, 30);
	}

	public WebElement industryDropDown()
	{
		return IndustryDropDown;
	}
	
	public WebElement pressDropDown()
	{
		return PressDropDown;	
	}

	public void saveOrganization(WebDriver driver) {
		
		SaveBtn.click();
		MainWebDriverUtility.waitUntillElementVisible(driver, OrganizationValidation, 30);

	}
	
	public void enterOrganizationNameOnly(String OrganizationName)
	{
		EnterOrganizationName.sendKeys(OrganizationName);
	}
}
