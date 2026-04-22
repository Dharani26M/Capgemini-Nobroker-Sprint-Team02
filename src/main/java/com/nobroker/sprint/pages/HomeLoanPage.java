package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.utils.AllUtilities;

public class HomeLoanPage {
	public WebDriver driver;
	public AllUtilities utility;

	public HomeLoanPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.='Loan Amount']/..//input[@placeholder='1000000']")
	public WebElement loanAmount;

	@FindBy(xpath = "//span[.='Monthly Income']/..//input[@placeholder='25000']")
	public WebElement monthlyIncome;

	@FindBy(xpath = "//span[.='Other EMI']/..//input[@placeholder='0']")
	public WebElement EMI;

	@FindBy(xpath = "//span[.='Rate of Interest (P.A)']/..//input[@placeholder='6.7']")
	public WebElement RateofInterest;

	@FindBy(xpath = "//div[.='Check Eligibility']")
	private WebElement check;

	@FindBy(css = "[for='switcher-1']")
	private WebElement Eligibility;

	@FindBy(xpath = "//span[text()='Estimated EMI']/..")
	private WebElement Verify;

	public WebElement getVerify() {
		return Verify;
	}

	public WebElement getEligibility() {
		return Eligibility;
	}

	public WebElement getLoanAmount() {
		return loanAmount;
	}

	public WebElement getMonthlyIncome() {
		return monthlyIncome;
	}

	public WebElement getEMI() {
		return EMI;
	}

	public WebElement getRateofInterest() {
		return RateofInterest;
	}

	public WebElement getCheck() {
		// TODO Auto-generated method stub
		return check;
	}

}
