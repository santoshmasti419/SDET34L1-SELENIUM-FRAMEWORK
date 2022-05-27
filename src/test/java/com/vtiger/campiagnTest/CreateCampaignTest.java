package com.vtiger.campiagnTest;

import java.io.IOException;

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
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.MorePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends MainBaseClassUtilities {
	MorePage moreActions;
	CampaignPage campiagnClick;
	CreateCampaignPage createCamp;

	@Test
	public void createCampiagnTest() throws IOException, InterruptedException {
		String games = MainExcelUtility.getDataFromExcel("Campaign", 1, 1);

		moreActions = new MorePage(driver);
		campiagnClick = new CampaignPage(driver);
		createCamp = new CreateCampaignPage(driver);
		homePageActions.moreClick();
		moreActions.clickCampaign(moreActions.campaign(), driver);
		moreActions.campaignName();
		createCamp.createCampaign();
		createCamp.enterCampaignName(games);
	}
}
