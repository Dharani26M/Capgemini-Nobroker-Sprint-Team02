package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReferAndEarnPage {

	private WebDriver driver;
	private WebDriverWait wait; // 30s - page level
	private WebDriverWait shortWait; // 5s - dropdown close

	public ReferAndEarnPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@FindBy(xpath = "//button[contains(.,'Enter Owner Details')]")
	private WebElement ownerDetailsBtn;

	@FindBy(xpath = "//button[text()='Send Details']")
	private WebElement sendBtn;

	// --- Locators scoped to modal to avoid cross-thread interference ---
	private final By profileIcon = By.xpath("//div[@id='profile-icon']//img");
	private final By modalTitle = By.xpath("//div[contains(text(),'Refer')]");
	private final By phoneField = By.id("formValidationOwnerPhone");
	private final By nameField = By.id("formValidationName");
	private final By descField = By.id("formUserText");

	// City dropdown scoped inside citySelectContainer
	private final By cityDropdown = By
			.xpath("//div[@id='citySelectContainer']//div[contains(@class,'nb-select__control')]");

	// Property dropdown scoped inside the modal form - avoids matching city
	// dropdown
	private final By propDropdown = By
			.xpath("//div[@id='propertyTypeSelectContainer']//div[contains(@class,'nb-select__control')]");

	// --- Helpers ---

	private void jsClick(WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	}

	private void selectFromDropdown(By dropdownLocator, String optionText) {
		// Re-fetch dropdown fresh every time - never use a cached WebElement
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

		try {
			dropdown.click();
		} catch (Exception e) {
			jsClick(dropdown);
		}

		// Scope option lookup to the open menu - not the whole page
		By option = By.xpath("//div[contains(@class,'nb-select__menu')]"
				+ "//div[contains(@class,'nb-select__option') and contains(text(),'" + optionText + "')]");

		jsClick(wait.until(ExpectedConditions.elementToBeClickable(option)));

		// Wait for menu to close using short wait
		By menu = By.xpath("//div[contains(@class,'nb-select__menu')]");
		try {
			shortWait.until(ExpectedConditions.invisibilityOfElementLocated(menu));
		} catch (Exception e) {
			// already closed, continue
		}
	}

	// --- Page Actions ---

	public void ClickOwnerDetails() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));
		jsClick(wait.until(ExpectedConditions.elementToBeClickable(ownerDetailsBtn)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
	}

	public void EnterDetails(WebDriver driver, String cityName, String phoneno, String name, String typename,
			String description) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));

		// City dropdown
		selectFromDropdown(cityDropdown, cityName);

		// Phone & Name - fresh lookup after city re-render
		wait.until(ExpectedConditions.elementToBeClickable(phoneField)).sendKeys(phoneno);
		driver.findElement(nameField).sendKeys(name);

		// Property type dropdown
		try {
			// Try scoped container first
			selectFromDropdown(propDropdown, typename);
		} catch (Exception e) {
			// Fallback: pick second nb-select__control in the modal
			By fallback = By.xpath("(//div[contains(@class,'nb-select__control')])[2]");
			selectFromDropdown(fallback, typename);
		}

		// Description & Submit - fresh lookup after property re-render
		wait.until(ExpectedConditions.elementToBeClickable(descField)).sendKeys(description);
		jsClick(wait.until(ExpectedConditions.elementToBeClickable(sendBtn)));
	}
}