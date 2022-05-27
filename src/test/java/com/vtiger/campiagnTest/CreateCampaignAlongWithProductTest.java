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
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateCampaignAlongWithProductTest extends MainBaseClassUtilities
{
	ProductPage newProductCreate;
	CreateProductPage productDetails;
	
	
	
//	@Test(groups="Sanity",description="testing:-CreateCampaignAlongWithProductTest")
//	@Description("descriptions:-CreateCampaignAlongWithProductTest")
//	@Epic("epic:-CreateCampaignAlongWithProductTest")
//	@Story("strory:-CreateCampaignAlongWithProductTest")
//	@Step("step:-CreateCampaignAlogWithProductTest")
	public void createProductByCampiagn() throws IOException
	{
		String productname = MainExcelUtility.getDataFromExcel("Product Name", 0, 0);

		newProductCreate=new ProductPage(driver);
		productDetails=new CreateProductPage(driver);

		homePageActions.productsClick();
		newProductCreate.createNewProducts();

		productDetails.productDetails(productname);

		MainWebDriverUtility.mouseHoverOnTheElement(productDetails.campiagnMouseHover(), driver);
	}
}
