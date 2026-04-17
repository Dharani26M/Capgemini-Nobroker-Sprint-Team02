package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeCleaningPage {

	WebDriver driver;

	public HomeCleaningPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='hsHomeTile']")
	private WebElement homeTile;

	@FindBy(xpath = "//div[.='Chennai']")
	private WebElement Location;

	@FindBy(xpath = "//div[contains(text(),'Home Cleaning')]")
	private WebElement homeCleaningOption;

	@FindBy(xpath = "//div[.='Weekly Cleaning']")
	private WebElement weeklyCleaning;

	@FindBy(xpath = "//button[.='4']")
	private WebElement NoOfBathrooms;

	@FindBy(xpath = "//button[.='Once in 2 weeks']")
	private WebElement onceInTwoWeeks;

	@FindBy(xpath = "//div[.='Order Summary']/..//button[.='Proceed']")
	private WebElement proceedButton;

	@FindBy(xpath = "//div[contains(text(),'Enter mobile number to continue')]")
	private WebElement mobilePopupTitle;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHomeTile() {
		return homeTile;
	}

	public WebElement getLocation() {
		return Location;
	}

	public WebElement getHomeCleaningOption() {
		return homeCleaningOption;
	}

	public WebElement getWeeklyCleaning() {
		return weeklyCleaning;
	}

	public WebElement getNoOfBathrooms() {
		return NoOfBathrooms;
	}

	public WebElement getOnceInTwoWeeks() {
		return onceInTwoWeeks;
	}

	public WebElement getProceedButton() {
		return proceedButton;
	}

	public WebElement getMobilePopupTitle() {
		return mobilePopupTitle;
	}

}
