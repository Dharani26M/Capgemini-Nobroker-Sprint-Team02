package com.nobroker.sprint.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nobroker.sprint.utils.AllUtilities;

public class DashboardPage {
	public WebDriver driver;
	public AllUtilities utility;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		utility = new AllUtilities();
		this.utility.initializeDriver(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'nb-select__control')]")
	private WebElement cityDropdown;

	@FindBy(xpath = "//button[contains(@class, 'prop-search-button')]")
	private WebElement SearchBtn;

	@FindBy(xpath = "//div[contains(text(),'Log in')]")
	private WebElement Login;

	@FindBy(css = "[type='tel']")
	private WebElement MobileNumber;

	@FindBy(id = "signUpSubmit")
	private WebElement continueButton;

	@FindBy(xpath = "//p[text()='New']")
	private WebElement NewIcon;

	@FindBy(xpath = "//div[@id='profile-icon']//img")
	private WebElement ProfileImg;

	@FindBy(xpath = "//div[@id='profile-menu-dropdown']//a[contains(.,'Profile')]")
	private WebElement ProfileFeature;

	@FindBy(xpath = "//div[.='Menu']")
	private WebElement MenuField;

	@FindBy(xpath = "//div[@id='main-menu']//a[.='Post Your Property']")
	private WebElement PostProperty;

	@FindBy(xpath = "//div[@id='main-menu']//a[.='Rent Receipts']")
	private WebElement RentReceipts;

	@FindBy(xpath = "//div[@id='main-menu']//a[.='Refer & Earn']")
	private WebElement ReferEarn;

	@FindBy(xpath = "//div[@id='main-menu']//a[.='Painting & Cleaning']")
	private WebElement PaintingsCleaning;

	@FindBy(xpath = "//span[text()='Packers And Movers']")
	private WebElement PackersAndMovers;

	// Getters
	public WebElement getPackersAndMovers() {
		return PackersAndMovers;
	}

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

	public WebElement getBuyHouse() {
		return buy;
	}

	public WebElement getLocality() {
		return locality;
	}

	// Actions
	public void clickContinueAfterOTP(WebDriver driver) {
		utility.WaitForToBeClickableOfElement(60, continueButton);
	}

	public void selectCityWithDropdown(String cityName, WebDriver driver) {
		cityDropdown.click();
		String cityXpath = "//div[contains(@class, 'nb-select__menu')]//div[text()='" + cityName + "']";
		driver.findElement(By.xpath(cityXpath)).click();
	}

	public void LoginIn(WebDriver driver, String MobileNo) {
		getLogin().click();
		getMobileNumber().sendKeys(MobileNo);
		clickContinueAfterOTP(driver);
	}

	public void GotoProfile(WebDriver driver) {
		utility.WaitForToBeClickableOfElement(20, getProfileImg());
		utility.WaitForToBeClickableOfElement(20, getProfileFeature());
	}

	public void ClickPostYourProperty() {
		getMenuField().click();
		getPostProperty().click();
	}

	public void ClickReferAndEarn() {
		getMenuField().click();
		getReferEarn().click();
	}

	public void ClickPaintingsAndCleaning() {
		getMenuField().click();
		getPaintingsCleaning().click();
	}

	public void clickPackersAndMovers() {
		getPackersAndMovers().click();
	}

	public void clickBuyModule() {
		getBuyHouse().click();
	}

	public void clickSearch() {
		getSearchBtn().click();
	}

	public void clickNewIcon(WebDriver driver) {
		// using an Explicit Wait to click new icon because webpage needs to refresh the
		// page
		utility.WaitForToBeClickableOfElement(30, getNewIcon());
		getNewIcon().click();
	}

	public void ClickRentReceipts() {
//		utility.WaitForInvisibilityOfElement(6, By.className("login-signup__backdrop"));
		utility.WaitForToBeClickableOfElement(20, getMenuField());
		getMenuField().click();
		utility.WaitForToBeClickableOfElement(20, getRentReceipts());
		getRentReceipts().click();
	}

	// locating buy module
	@FindBy(xpath = "//div[text()='Buy']")
	private WebElement buy;

	// entering locality
	@FindBy(id = "listPageSearchLocality")
	private WebElement locality;

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

	public boolean isUserLoggedIn() {
		try {
			// Use a 5-10 second wait instead of immediate check
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			return wait.until(ExpectedConditions.visibilityOf(getProfileImg())).isDisplayed();
		} catch (Exception e) {
			System.out.println("⚠️ Profile image not found - user not logged in.");
			return false;
		}
	}

}
