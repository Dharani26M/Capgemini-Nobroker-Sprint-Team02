package com.nobroker.sprint.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nobroker.sprint.utils.AllUtilities;

public class ReferAndEarnPage {

	public WebDriver driver;
	public AllUtilities utility;
	WebDriverWait wait;

	public ReferAndEarnPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(xpath = "//button[contains(.,'Enter Owner Details')]")
	private WebElement OwnerDetails;

	@FindBy(xpath = "//div[text()='Refer & Earn']")
	private WebElement ReferAndEarnWindow;

	@FindBy(xpath = "//div[@id='citySelectContainer']//div[contains(@class,'nb-select__control')]")
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

	public WebElement getSendBtn() {
		return SendBtn;
	}

	private void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	private void selectOption(String optionText) {
		By locator = By.xpath("//div[contains(@class,'nb-select__option') and text()='" + optionText + "']");
		jsClick(wait.until(ExpectedConditions.elementToBeClickable(locator)));
	}

	public void ClickOwnerDetails() {
		jsClick(wait.until(ExpectedConditions.elementToBeClickable(getOwnerDetails())));
	}

	public void EnterDetails(WebDriver driver, String cityName, String phoneno, String name, String typename,
			String description) {
		wait.until(ExpectedConditions.visibilityOf(getReferAndEarnWindow()));

		getCityDropdownContainer().click();
		selectOption(cityName);

		getPhoneNo().sendKeys(phoneno);
		getOwnerName().sendKeys(name);

		getPropertyDropdown().click();
		selectOption(typename);

		getTellUsField().sendKeys(description);
		getSendBtn().click();
	}
}