package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		@FindBy(xpath = "//input[@type='text']")
		private WebElement userNameTxt;
		
		@FindBy(xpath = "//input[@type='password']")
		private WebElement passwordTxt;
		
		@FindBy(xpath = "//input[@type='submit']")
		private WebElement submitBTN;
		
		
       public LoginPage(WebDriver driver) {
    	   PageFactory.initElements(driver, this);   
       }
       
       //business libraries
       
       public void loginToApp(String username, String password) {
    	   userNameTxt.sendKeys(username); 
    	   passwordTxt.sendKeys(password);
    	   submitBTN.click();
       }
	}


