package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class ReferAndEarnPage {
	public WebDriver driver;
	public AllUtilities utility;

	public ReferAndEarnPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	}

	@FindBy(xpath = "//button[@type='button' and contains(.,'Enter Owner Details')]")
	private WebElement OwnerDetails;
	
	@FindBy(xpath = "//div[text()='Refer & Earn']")
	private WebElement ReferAndEarnWindow;
	
	@FindBy(css = ".nb-select__placeholder")
	private WebElement cityDropdownContainer;
	
	@FindBy(id = "formValidationOwnerPhone")
	private WebElement PhoneNo;
	
	@FindBy(id = "formValidationName")
	private WebElement OwnerName;
	
	@FindBy(xpath = "//div[text()='Select Property Type']")
	private WebElement PropertyDropdown;
	
	@FindBy(id = "formUserText")
	private WebElement TellUsField;
	
	@FindBy(xpath = "//button[text()='Send Details']")
	private WebElement SendBtn;
	
	
	public WebElement getOwnerDetails() {
		return OwnerDetails;
	}


	public WebElement getReferAndEarnWindow() {
		return ReferAndEarnWindow;
	}


	public WebElement getCityDropdownContainer() {
		return cityDropdownContainer;
	}


	public WebElement getPhoneNo() {
		return PhoneNo;
	}


	public WebElement getOwnerName() {
		return OwnerName;
	}


	public WebElement getPropertyDropdown() {
		return PropertyDropdown;
	}


	public WebElement getTellUsField() {
		return TellUsField;
	}

	public void ClickEnterOwnerDetails() {
		getOwnerDetails().click();
	}
	
	public WebElement getSendBtn() {
		return SendBtn;
	}

	public void EnterDetails(WebDriver driver,String cityName, String phoneno,String name,String typename,String description) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getReferAndEarnWindow()));
	    getCityDropdownContainer().click();	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'nb-select__option') and text()='" + cityName + "']"))).click();
	    getPhoneNo().sendKeys(phoneno);
	    getOwnerName().sendKeys(name);
	    getPropertyDropdown().click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'nb-select__option') and text()='" + typename + "']"))).click();
	    getTellUsField().sendKeys(description);
	    getSendBtn().click();
	}
}
