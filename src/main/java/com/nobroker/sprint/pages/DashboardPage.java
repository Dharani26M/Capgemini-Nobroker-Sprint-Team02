package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class DashboardPage {
	public WebDriver driver;
	public AllUtilities utility;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	}

	// Locating the City Drop down
	@FindBy(xpath = "//div[contains(@class,'nb-select__control')]")
	private WebElement cityDropdown;

	// Locating the Search btn
	@FindBy(xpath = "//button[contains(@class, 'prop-search-button')]")
	private WebElement SearchBtn;

	// Locating of Login WebElement
	@FindBy(xpath = "//div[contains(text(),'Log in')]")
	private WebElement Login;

	// Locating the Mobile Number Field
	@FindBy(css = "[type='tel']")
	private WebElement MobileNumber;

	// Locating Continue Btn
	@FindBy(id = "signUpSubmit")
	private WebElement continueButton;

	// Locating N Icon
	@FindBy(xpath = "//p[text()='New']")
	private WebElement NewIcon;

	// locating ProfileImg
	@FindBy(xpath = "//div[@id='profile-icon']//img")
	private WebElement ProfileImg;

	// Locating Profile feature
	@FindBy(xpath = "//div[@id='profile-menu-dropdown']//a[contains(.,'Profile')]")
	private WebElement ProfileFeature;

	// locating menu
	@FindBy(xpath = "//div[.='Menu']")
	private WebElement MenuField;

	// locating post your property
	@FindBy(xpath = "//div[@id='main-menu']//a[.='Post Your Property']")
	private WebElement PostProperty;

	// locating rent receipts
	@FindBy(xpath = "//div[@id='main-menu']//a[.='Rent Receipts']")
	private WebElement RentReceipts;

	// locating refer and earn field
	@FindBy(xpath = "//div[@id='main-menu']//a[.='Refer & Earn']")
	private WebElement ReferEarn;

	// locating paintings and cleaning
	@FindBy(xpath = "//div[@id='main-menu']//a[.='Painting & Cleaning']")
	private WebElement PaintingsCleaning;

	// Locating Packers And Movers Banner
	@FindBy(xpath = "//span[text()='Packers And Movers']")
	private WebElement PackersAndMovers;

	public WebElement getPackersAndMovers() {
		return PackersAndMovers;
	}

	// getters For WebElements
	public WebElement getCityDropdown() {
		return cityDropdown;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getMenuField() {
		return MenuField;
	}

	public WebElement getPostProperty() {
		return PostProperty;
	}

	public WebElement getRentReceipts() {
		return RentReceipts;
	}

	public WebElement getReferEarn() {
		return ReferEarn;
	}

	public WebElement getPaintingsCleaning() {
		return PaintingsCleaning;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getNewIcon() {
		return NewIcon;
	}

	public WebElement getProfileImg() {
		return ProfileImg;
	}

	public WebElement getProfileFeature() {
		return ProfileFeature;
	}

	// after OTP, click continue
	public void clickContinueAfterOTP(WebDriver driver) {
		// using an Explicit Wait to ensure the button is clickable
		utility.WaitForToBeClickableOfElement(60, continueButton);
	}

	public void selectCityWithDropdown(String cityName, WebDriver driver) {
		// Click the dropdown to get list of city
		cityDropdown.click();
		// dynamic XPath using the city name
		String cityXpath = "//div[contains(@class, 'nb-select__menu')]//div[text()='" + cityName + "']";
		// click that specific city
		driver.findElement(By.xpath(cityXpath)).click();
	}

	// Login Into Application
	public void LoginIn(WebDriver driver, String MobileNo) {
		getLogin().click();
		getMobileNumber().sendKeys(MobileNo);
		clickContinueAfterOTP(driver);
	}

	public void clickNewIcon(WebDriver driver) {
		// using an Explicit Wait to click new icon because webpage needs to refresh the
		// page
		utility.WaitForToBeClickableOfElement(30, getNewIcon());
	}

	public void GotoProfile(WebDriver driver) {
		// using explicit wait because profile clicking is hovering part
		utility.WaitForToBeClickableOfElement(20, getProfileImg());
		utility.WaitForToBeClickableOfElement(20, getProfileFeature());
	}

	public void ClickPostYourProperty() {
		getMenuField().click();
		getPostProperty().click();
	}

	public void ClickRentReceipts() {
		utility.WaitForInvisibilityOfElement(6, By.className("login-signup__backdrop"));
	    utility.WaitForToBeClickableOfElement(20, getMenuField());
	    getMenuField().click();
	    utility.WaitForToBeClickableOfElement(20, getRentReceipts());
	    getRentReceipts().click();
	}

	public void ClickReferAndEarn() {
		getMenuField().click();
		getReferEarn().click();
	}

	public void ClickPaintingsAndCleaning() {
		getMenuField().click();
		getPaintingsCleaning().click();
	}

	// Click The PackersAndMovers to Navigate to the Section

	public void clickPackersAndMovers() {
		getPackersAndMovers().click();
	}

	// locating buy module
	@FindBy(xpath = "//div[text()='Buy']")
	private WebElement buy;

	// entering locality
	@FindBy(id = "listPageSearchLocality")
	private WebElement locality;

	public void clickBuyModule() {
		getBuyHouse().click();
	}

	// entering the locality
	public void writeLocality(String loc, WebDriver driver) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		getLocality().click();
		getLocality().clear();
		getLocality().sendKeys(loc);

		// wait
		Thread.sleep(2000);

		// select 1st sugg
		Actions act = new Actions(driver);
		getLocality().sendKeys(Keys.DOWN);
		getLocality().sendKeys(Keys.ENTER);
	}

	// search button
	public void clickSearch() {
		getSearchBtn().click();
	}

	public WebElement getBuyHouse() {
		return buy;
	}

	public WebElement getLocality() {
		return locality;
	}

}
