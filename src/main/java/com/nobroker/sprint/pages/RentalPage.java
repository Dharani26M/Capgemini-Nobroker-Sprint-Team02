package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class RentalPage {

    WebDriver driver;
    WebDriverWait wait;

    public RentalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // 🔹 Elements
    @FindBy(xpath = "//span[contains(text(),'Rental Agreement')]")
    private WebElement rentalAgreementIcon;

    @FindBy(xpath = "//button[.='Proceed']")
    private WebElement proceed;

    @FindBy(xpath = "//div[contains(text(),'Upload your Draft')]")
    private WebElement uploadDraft;

    @FindBy(id = "uploadAgreement")
    private WebElement uploadFile;

    @FindBy(id = "leadCity")
    private WebElement cityDropdown;

    @FindBy(css = "[name='city-search']")
    private WebElement citySearch;

    @FindBy(id = "deposit")
    private WebElement refundableAmount;

    @FindBy(xpath = "//div[contains(text(),'Stamp')]")
    private WebElement stampPaperAmt;

    @FindBy(id = "rentwithMaintenance_yes")
    private WebElement radioBtnYes;

    @FindBy(xpath = "//div[.='Owner']")
    private WebElement owner;

    @FindBy(id = "landlords.0.fullName")
    private WebElement landlordName;

    @FindBy(id = "landlords.0.email")
    private WebElement landlordEmail;

    @FindBy(id = "landlords.0.phone")
    private WebElement landlordPhone;

    @FindBy(id = "tenants.0.fullName")
    private WebElement tenantName;

    @FindBy(id = "tenants.0.email")
    private WebElement tenantEmail;

    @FindBy(id = "tenants.0.phone")
    private WebElement tenantPhone;

    @FindBy(xpath = "//button[.='Save and Continue']")
    private WebElement continueButton;

    // 🔥 CITY POPUP ELEMENT
    @FindBy(xpath = "//input[@placeholder='Type city name']")
    private WebElement cityPopupInput;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement chennaiOption;

    // 🔹 Utility
    private void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private void type(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    // 🔹 Actions

    public void clickRentalAgreementIcon() {
        click(rentalAgreementIcon);
    }

    // 🔥 HANDLE CITY POPUP (IMPORTANT)
    public void selectCityFromPopup(String city) {

        wait.until(ExpectedConditions.visibilityOf(cityPopupInput));
        cityPopupInput.sendKeys(city);

        cityPopupInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.invisibilityOf(cityPopupInput));
    }

    public void selectChennaiDirect() {
    	  WebElement chennai = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//img[@alt='Chennai']/parent::div")
    		    ));

    		    chennai.click();
    }

    public void clickProceed() {
        click(proceed);
    }

    public void clickUploadDraft() {
        click(uploadDraft);
    }

    public void uploadFile(String path) {
        uploadFile.sendKeys(path);
    }

    public void selectCity(String city) {
        click(cityDropdown);
        type(citySearch, city);
        citySearch.sendKeys(Keys.ARROW_DOWN);
        citySearch.sendKeys(Keys.ENTER);
    }

    public void enterRefund(String amount) {
        type(refundableAmount, amount);
    }

    public void selectStamp() {
        click(stampPaperAmt);
    }

    public void selectMaintenanceYes() {
        click(radioBtnYes);
    }

    public void selectOwner() {
        click(owner);
    }

    public void enterLandlordDetails(String name, String email, String phone) {
        type(landlordName, name);
        type(landlordEmail, email);
        type(landlordPhone, phone);
    }

    public void enterTenantDetails(String name, String email, String phone) {
        type(tenantName, name);
        type(tenantEmail, email);
        type(tenantPhone, phone);
    }

    public void clickContinue() {
        click(continueButton);
    }
}