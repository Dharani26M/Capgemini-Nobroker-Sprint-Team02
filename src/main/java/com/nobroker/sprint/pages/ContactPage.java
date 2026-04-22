package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;


public class ContactPage {
WebDriver driver;
	
	public AllUtilities utilities; 
	public ContactPage(WebDriver driver) {
		utilities =new AllUtilities();
		this.driver = driver;
		this.utilities.initializeDriver(driver);
	}
	
	//menu
	@FindBy(xpath = "//div[.='Menu']")
	private WebElement MenuField;
	
	@FindBy(xpath = "//a[contains(@href,'facebook')]//*[name()='svg']")
	private WebElement logo;
	
	public WebElement getMenuField() {
		return MenuField;
	}
	
	public WebElement getLogo() {
		return logo;
	}
	
	public void clickMenu() {
		utilities.WaitForToBeClickableOfElement(10, getMenuField());
		getMenuField().click();
	}
	
	public void clickLogo() {
		utilities.WaitForToBeClickableOfElement(10, getLogo());
		getLogo().click();
	}

}
