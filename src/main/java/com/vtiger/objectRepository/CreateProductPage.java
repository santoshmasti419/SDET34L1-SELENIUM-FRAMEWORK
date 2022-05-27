package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	@FindBy(xpath = "//input[@class='detailedViewTextBox']")
	private WebElement EnterProductsNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveProductsBtn;
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement campiagnMouseHoverBtn;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void productDetails(String redmi)
	{
		EnterProductsNameTxt.sendKeys(redmi);
		SaveProductsBtn.click();
	}
	
	public WebElement campiagnMouseHover()
	{
		return campiagnMouseHoverBtn;
	}
	
	

}
