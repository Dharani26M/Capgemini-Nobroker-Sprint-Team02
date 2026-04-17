package com.nobroker.sprint.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostYourPropertyPage {
	
	//Locating Toggle btn
	@FindBy(css = ".nb-switch-toggle")
	private WebElement ToggleBtn;
	
	//locating Properties field
	@FindBy(xpath = "//div[@value='ALL']/../following-sibling::div")
	private WebElement PropertiesField;
	
	@FindBy(xpath = "//div[text()='No ']")
	private WebElement NoPropertyContentField;
	
	//getter for Toggle btn
	public WebElement getToggle() {
		return ToggleBtn;
	}
	
	public WebElement getNoPropertyContentField() {
		return NoPropertyContentField;
	}
	
	public WebElement getPropertyField() {
		return PropertiesField;
	}
	
	public void ClickOnToggle() {
		getToggle().click();
	}

	
}
