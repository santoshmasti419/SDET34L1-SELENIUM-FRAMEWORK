package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	
   public DocumentInformationPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);   
   }
   
   //business libraries
   
   public WebElement headerText() {
	return   headerText;
   }

}
