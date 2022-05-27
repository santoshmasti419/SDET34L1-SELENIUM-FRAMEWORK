package com.vtiger.productTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends MainBaseClassUtilities {
@Test
	public void createProductName() throws IOException {

		String product = MainExcelUtility.getDataFromExcel("Product Name", 0, 0);
		

		ProductPage productName=new ProductPage(driver);
		CreateProductPage addProduct=new CreateProductPage(driver);
		homePageActions.productsClick();
		productName.createNewProducts();

		addProduct.productDetails(product+RandomInt);
	}
}
