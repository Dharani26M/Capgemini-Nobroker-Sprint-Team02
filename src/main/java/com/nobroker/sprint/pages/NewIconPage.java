package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class NewIconPage {
	public WebDriver driver;
	public AllUtilities utility;

	public NewIconPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	} 
	
	// locating Buy Button
	@FindBy(xpath = "//button[@type='button' and text()='BUY']")
	private WebElement buyBtn;
	
	@FindBy(xpath = "//span[.='Buy']")
	private WebElement VipBuybtn;
	
	@FindBy(xpath = "//div[@class='icon-back-white visible-desktop']")
	private WebElement Backbtn;
	
	@FindBy(xpath = "//button[.='View']")
	private WebElement ViewBtn;
	
	@FindBy(xpath = "//button[.='Yes']")
	private WebElement YesButton;
	
	@FindBy(xpath = "//div[@class='icon-back-arrow pointer qr-arrow']")
	private WebElement viewback;
	
	// getters of WebElement 
	public WebElement getVipBuybtn() {
		return VipBuybtn;
	}

	public WebElement getBackbtn() {
		return Backbtn;
	}

	public WebElement getYesButton() {
		return YesButton;
	}

	public WebElement getbuybtn() {
		return buyBtn;
	}
	
	public WebElement getviewBtn() {
		return ViewBtn;
	}
	
	public WebElement getviewbackBtn() {
		return viewback;
	}
	
	public void clickBuyBtn() {
		getbuybtn().click();
	}
	
	public void clickVipBuyButton(WebDriver driver) {
		utility.WaitForToBeClickableOfElement(30, getVipBuybtn());
		getVipBuybtn().click();

	}
	public void  clickBackButton(WebDriver driver) {
		utility.WaitForToBeClickableOfElement(30, getBackbtn());
		getBackbtn().click();
		utility.WaitForToBeClickableOfElement(30, getYesButton());
		getYesButton().click();
	}
}
