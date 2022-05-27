package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author USER1
 *
 */
public class LeadValidationPage {
	@FindBy(xpath = "//input[@style='width:120px']")
	private WebElement SearchForTxt;

	@FindBy(xpath = "(//select[@id='bas_searchfield'])[1]")
	private WebElement SearchInDropDownWebsite;


	@FindBy(xpath ="//input[@name='submit']" )
	private WebElement SearchBtn;

	@FindBy(xpath = "//input[@style='width:120px']")
	private WebElement EmailIdDropDown;


	@FindBy(xpath ="//a[.='Santosh']" )
	private WebElement ValidateNameLnk; 


	@FindBy(xpath = "(//input[@class='crmbutton small edit'])[2]")
	private WebElement MassEditBtn;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchForNumTxt;

	@FindBy(xpath = "(//select[@id='bas_searchfield'])[1]")
	private WebElement searchInDropDownNum;

	@FindBy(xpath ="//a[.='Masti']" )
	private WebElement ValidateMastiNameLnk;

	@FindBy(xpath = "//select[@id='bas_searchfield'])[1]")
	private WebElement AssignedTo;

	@FindBy(xpath = "(//select[@id='bas_searchfield'])[1]")
	private WebElement DropDownBtn;


	public LeadValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement searchInDropDown(WebDriver driver)
	{
		return DropDownBtn;

	}

	public WebElement searchInDropDownNum(WebDriver driver)
	{
		return searchInDropDownNum;
	}

	public WebElement SearchInDropDownWebsite(WebDriver driver)
	{
		return SearchInDropDownWebsite;
	}

	public WebElement validName()
	{
		return ValidateNameLnk;
	}

	public void leadValidationThroughWebsite(String Website )
	{
		SearchForTxt.sendKeys(Website);
		SearchBtn.click();
	}

	public void leadValidationThroughNum(String phoneNumber)
	{
		searchForNumTxt.sendKeys(phoneNumber);
	}

	public String ValidateMastiName()
	{
		return ValidateMastiNameLnk.getText();
	}

	public void assignedTo(String assignedTo)
	{
		AssignedTo.sendKeys(assignedTo);
		SearchBtn.click();
	}

	public void search()
	{
		SearchBtn.click();
	}
	
	public void emailId(String EmailId)
	{
		EmailIdDropDown.sendKeys(EmailId);
	}

}
