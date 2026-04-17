package com.nobroker.sprint.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewIconPage {
	
	// locating Buy Button
	@FindBy(xpath = "//button[@type='button' and text()='BUY']")
	private WebElement buyBtn;

	// getters of WebElement 
	public WebElement getbuybtn() {
		return buyBtn;
	}
	
	public void clickBuyBtn() {
		getbuybtn().click();
	}
}
