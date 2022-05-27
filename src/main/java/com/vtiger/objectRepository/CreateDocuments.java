package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocuments {
	@FindBy(xpath = "(//input[@class='detailedViewTextBox'])[1]")
	private WebElement enterTitleTxt;
	
	@FindBy(xpath = "//html[@dir='ltr']")
	private WebElement desciptionTxtArea;
	
	@FindBy(xpath = "//a[@id='cke_5']")
	private WebElement BoldIcn;
	
	@FindBy(xpath = "//a[@id='cke_6']")
	private WebElement ItalicIcn;
	
	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement FileUploadBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveDocsBtn;
	
	public CreateDocuments(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterTilte(String Docs)
	{
		enterTitleTxt.sendKeys(Docs);
	}
	
	public void enterDescription(String Quotes )
	{
		desciptionTxtArea.sendKeys(Quotes);
	}
	
	public void bold()
	{
		BoldIcn.click();
	}
	
	public void italic()
	{
		ItalicIcn.click();
	}
	
	public void uploadDocs(String path)
	{
		FileUploadBtn.sendKeys(path);	
	}
	
	public void saveDocs()
	{
		SaveDocsBtn.click();	
	}
	
			

}
