package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//div[.='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='signUp-phoneNumber']")
	private WebElement phoneInput;
	
	@FindBy(id="signUpSubmit")
	private WebElement continueBtn;
	
	@FindBy(css="[type='tel']")
	private WebElement otp;
	

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn() {
		getLoginBtn().click();
	}

	public WebElement getPhoneInput() {
		return phoneInput;
	}

	public void enterPhoneNumber(String phoneInput) {
		getPhoneInput().sendKeys(phoneInput);
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void clickContinueBtn() {
		getContinueBtn().click();
	}

	public WebElement getOtp() {
		return otp;
	}

	public void setOtp() {
		getOtp().click();
	}
	
	
}
