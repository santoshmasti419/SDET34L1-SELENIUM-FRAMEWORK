package com.vtiger.documentsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.MainBaseClassUtilities;
import com.SDET34L1.genericUtility.MainExcelUtility;
import com.SDET34L1.genericUtility.MainFileUtility;
import com.SDET34L1.genericUtility.MainIconstantPath;
import com.SDET34L1.genericUtility.MainJavaUtility;
import com.SDET34L1.genericUtility.MainWebDriverUtility;
import com.vtiger.objectRepository.CreateDocuments;
import com.vtiger.objectRepository.DocumentInformationPage;
import com.vtiger.objectRepository.DocumentsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentsTest extends MainBaseClassUtilities{

	@Test

	public void createDocuments() throws InterruptedException{

		String docsTitle = MainExcelUtility.getDataFromExcel("Documents", 1, 0);
		String path = MainExcelUtility.getDataFromExcel("Documents", 1, 1);
		String descriptions = MainExcelUtility.getDataFromExcel("Documents", 1, 2);

		DocumentsPage docsPage = new DocumentsPage(driver);
		CreateDocuments creatDocs = new CreateDocuments(driver);
		DocumentInformationPage docInfoPage=new DocumentInformationPage(driver);
		homePageActions.documentsClick();
		docsPage.addDocuments();
		creatDocs.enterTilte(docsTitle+RandomInt);

		
		MainWebDriverUtility.switchToFrame(driver, 0);
		creatDocs.enterDescription(descriptions+Keys.CONTROL+"A");
		MainWebDriverUtility.switchbackToHomeFrame(driver);
		
		creatDocs.bold();
		creatDocs.italic();
		
		MainWebDriverUtility.explicitlyWait(driver, 30);
		
		creatDocs.uploadDocs(path);

		creatDocs.saveDocs();
	}
}

