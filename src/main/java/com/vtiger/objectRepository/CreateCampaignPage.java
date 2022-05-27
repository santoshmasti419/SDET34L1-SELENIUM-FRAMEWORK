package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement CampaignNameTxt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveCampaignBtn;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaignBtn;
	
	
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createCampaign()
	{
		createCampaignBtn.click();
	}
	
	public void enterCampaignName(String CampaignName)
	{
		CampaignNameTxt.sendKeys(CampaignName);
		SaveCampaignBtn.click();
	}
	
	public void saveCampaign()
	{
		SaveCampaignBtn.click();
	} 
	
	
}
