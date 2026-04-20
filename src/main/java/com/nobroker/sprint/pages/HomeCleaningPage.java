package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.utils.AllUtilities;

public class HomeCleaningPage {

	public WebDriver driver;
	public AllUtilities utility;

	public HomeCleaningPage(WebDriver driver) {
		this.driver = driver;
		utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	} 

	@FindBy(xpath = "//div[@id='main-menu']")
	private WebElement Menu;

	@FindBy(xpath = "//a[contains(text(),'Painting & Cleaning')]")
	private WebElement PaintandClean;

	@FindBy(xpath = "//div[contains(text(),'Home Cleaning')]")
	private WebElement homeCleaningOption;
	
	@FindBy(xpath = "//div[contains(text(),'Chennai')]")
	private WebElement Location;

	@FindBy(xpath = "//div[.='Weekly Cleaning']")
	private WebElement weeklyCleaning;

	@FindBy(xpath = "//button[.='4']")
	private WebElement NoOfBathrooms;

	@FindBy(xpath = "//button[.='Once in 2 weeks']")
	private WebElement onceInTwoWeeks;

	@FindBy(xpath = "//div[.='Order Summary']/..//button[.='Proceed']")
	private WebElement proceedButton;

	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHomeCleaningOption() {
		return homeCleaningOption;
	}
	public WebElement getLocation() {
		return Location;
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

	public WebElement getPaintandClean() {
		return PaintandClean;
	}

	public WebElement getMenu() {
		return Menu;
	}
	

}
