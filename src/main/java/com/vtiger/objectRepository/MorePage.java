package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class MorePage {
	@FindBy(xpath = "//a[@href='javascript:;']")
	private WebElement MoreBtn;

	@FindBy(xpath = "(//a[.='Campaigns'])[1]")
	private WebElement CampaignLnk;

	//	@FindBy(xpath = "//img[@title='Create Campaign...']")
	//	private WebElement CampaignLnk;

	public MorePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public void clickCampaign(WebElement element,WebDriver driver)
	{
		MainWebDriverUtility.mouseHoverOnTheElement(CampaignLnk, driver );
		//CampaignLnk.click();
	}

	public WebElement campaign()
	{
		return CampaignLnk;
	}

	public void campaignName()
	{
		CampaignLnk.click();

	}
}
