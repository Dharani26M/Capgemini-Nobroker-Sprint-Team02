package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.utils.AllUtilities;

public class RentalPage {

    public WebDriver driver;
    public AllUtilities utility;

    public RentalPage(WebDriver driver) {
        this.driver = driver;
        this.utility = new AllUtilities();
        this.utility.initializeDriver(driver);
    }

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

    @FindBy(xpath = "//input[@placeholder='Type city name']")
    private WebElement cityPopupInput;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement chennaiOption;

    // ================= GETTERS =================

    public WebElement getRentalAgreementIcon() {
        return rentalAgreementIcon;
    }

    public WebElement getProceed() {
        return proceed;
    }

    public WebElement getUploadDraft() {
        return uploadDraft;
    }

    public WebElement getUploadFile() {
        return uploadFile;
    }

    public WebElement getCityDropdown() {
        return cityDropdown;
    }

    public WebElement getCitySearch() {
        return citySearch;
    }

    public WebElement getRefundableAmount() {
        return refundableAmount;
    }

    public WebElement getStampPaperAmt() {
        return stampPaperAmt;
    }

    public WebElement getRadioBtnYes() {
        return radioBtnYes;
    }

    public WebElement getOwner() {
        return owner;
    }

    public WebElement getLandlordName() {
        return landlordName;
    }

    public WebElement getLandlordEmail() {
        return landlordEmail;
    }

    public WebElement getLandlordPhone() {
        return landlordPhone;
    }

    public WebElement getTenantName() {
        return tenantName;
    }

    public WebElement getTenantEmail() {
        return tenantEmail;
    }

    public WebElement getTenantPhone() {
        return tenantPhone;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getCityPopupInput() {
        return cityPopupInput;
    }

    public WebElement getChennaiOption() {
        return chennaiOption;
    }
}