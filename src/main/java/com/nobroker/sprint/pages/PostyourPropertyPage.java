package com.nobroker.sprint.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class PostyourPropertyPage {
	public WebDriver driver;
	public AllUtilities utility;

	public PostyourPropertyPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
		PageFactory.initElements(driver, this);
	}

	// --- Locators from Version 1 ---
	@FindBy(css = ".nb-switch-toggle")
	private WebElement ToggleBtn;

	@FindBy(xpath = "//div[@value='ALL']/../following-sibling::div")
	private WebElement PropertiesField;

	@FindBy(xpath = "//div[text()='No ']")
	private WebElement NoPropertyContentField;

	// --- Locators from Version 2 ---
	@FindBy(xpath = "//div[@id='main-menu']")
	private WebElement Menu;

	@FindBy(xpath = "//*[normalize-space()='Post Your Property']")
	private WebElement Propertylink;

	@FindBy(id = "postNow")
	private WebElement PostNowBtn;

	@FindBy(xpath = "//div[contains(text(),'Select City')]")
	private WebElement SelectCity;

	@FindBy(xpath = "//button[.='Start Posting Your Ad For FREE']")
	private WebElement Post;

	@FindBy(xpath = "//div[@class=\" modal-body \"]/..//button[.='Yes']")
	private WebElement Notification;

	@FindBy(id = "apartmentType")
	private WebElement ApartmentType;

	@FindBy(id = "bhkType")
	private WebElement BHK;

	@FindBy(id = "commercialFloorSearch")
	private WebElement Floor;

	@FindBy(id = "commercialTotalSearch")
	private WebElement TotalFloor;

	@FindBy(id = "propertyAge")
	private WebElement PropertyAge;

	@FindBy(id = "propertyFacing")
	private WebElement propertyFacing;

	@FindBy(id = "propertySize")
	private WebElement size;

	@FindBy(id = "saveAndContinue")
	private WebElement ContinueBtn;

	@FindBy(xpath = "//button[.='The data is correct']")
	private WebElement notification;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "propertyLocality")
	private WebElement Locality;

	@FindBy(id = "street")
	private WebElement street;

	@FindBy(xpath = "//button[.='Preview']")
	private WebElement preview;

	// --- Getters ---
	public WebElement getToggle() {
		return ToggleBtn;
	}

	public WebElement getNoPropertyContentField() {
		return NoPropertyContentField;
	}

	public WebElement getPropertyField() {
		return PropertiesField;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMenu() {
		return Menu;
	}

	public WebElement getPropertylink() {
		return Propertylink;
	}

	public WebElement getPostNowBtn() {
		return PostNowBtn;
	}

	public WebElement getSelectCity() {
		return SelectCity;
	}

	public WebElement getPost() {
		return Post;
	}

	public WebElement getNotification1() {
		return Notification;
	}

	public WebElement getApartmentType() {
		return ApartmentType;
	}

	public WebElement getBHK() {
		return BHK;
	}

	public WebElement getFloor() {
		return Floor;
	}

	public WebElement getTotalFloor() {
		return TotalFloor;
	}

	public WebElement getPropertyAge() {
		return PropertyAge;
	}

	public WebElement getPropertyFacing() {
		return propertyFacing;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getContinueBtn() {
		return ContinueBtn;
	}

	public WebElement getNotification() {
		return notification;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getLocality() {
		return Locality;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getPreview() {
		return preview;
	}

	// --- Action Methods ---
	public void ClickOnToggle() {
		getToggle().click();
	}

	public void accept(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.elementToBeClickable(getNotification())).click();
	}
}