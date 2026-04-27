package com.nobroker.sprint.pages;

import java.time.Duration;
import java.util.List;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class AddInventoryPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public AllUtilities Utilities;

	public AddInventoryPage(WebDriver driver) {

		Utilities = new AllUtilities();
		this.driver = driver;
		this.Utilities.initializeDriver(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	}

	@FindBy(css = "[placeholder='Search for any item']")
	private WebElement SearchItem;

// Locating Bedroom

	@FindBy(css = "[href='#67d84a4ae50df484e137daea']")
	private WebElement Bedrooms;

//Locating Bed
	@FindBy(xpath = "//div[text()='Bed']")
	private WebElement Bed;

//Locating Mattress

	@FindBy(xpath = "//div[text()='Mattress']")
	private WebElement Mattress;

//Locating Table

	@FindBy(xpath = "//div[text()='Table']")
	private WebElement Table;

//Locating Chair

	@FindBy(xpath = "//div[text()='Chair']")
	private WebElement Chair;

//Locating Television

	@FindBy(xpath = "//div[text()='Television']")
	private WebElement Television;

//Locating AirConditioner

	@FindBy(xpath = "//div[text()='Air Conditioner']")
	private WebElement AirConditioner;

// Locating AlmirahWardrobe

	@FindBy(xpath = "//div[text()='Almirah/Wardrobe']")
	private WebElement AlmirahWardrobe;

//Locating Cabinet And Storage
	@FindBy(xpath = "//div[text()='Cabinet & Storage']")
	private WebElement CabinetAndStorage;

//Locating Appliances

	@FindBy(xpath = "//div[text()='Appliances']")
	private WebElement Appliances;

// LivingRooms

	@FindBy(css = "[href='#67d84a4ae50df484e137daeb']")
	private WebElement LivingRooms;

	@FindBy(xpath = "//div[text()='Sofa']")
	private WebElement Sofa;

	@FindBy(xpath = "//div[text()='Dining']")
	private WebElement Dining;

// kitchen

	@FindBy(css = "[href='#67d84a4ae50df484e137daec']")
	private WebElement Kitchen;

// Refrigerator

	@FindBy(xpath = "//div[text()='Refrigerator']")
	private WebElement Refigerator;

//Kitchen Items

	@FindBy(xpath = "//div[text()='Kitchen Items']")
	private WebElement KitchenItems;

// Miscellaneous

	@FindBy(css = "[href='#5f052c026c7da2160fc07c06']")
	private WebElement Miscellaneous;

// Washing machine 

	@FindBy(xpath = "//div[text()='Washing Machine']")
	private WebElement WashingMachine;

//Kitchen Items

	@FindBy(xpath = "//div[text()='Gym Equipments']")
	private WebElement GymEquipments;

	@FindBy(css = "[href='#67d84a4ae50df484e137daed']")
	private WebElement Cartons;

//Add Item
	@FindBy(xpath = "//div[text()='Baby Wooden Bed']/..//following-sibling::div")
	private WebElement AddIcon;

// AddedItemCount
	@FindBy(css = "[style='display: inline-block; transition: transform 0.4s cubic-bezier(0.4, 0, 0.2, 1), color 0.4s; transform: translateY(0px); will-change: transform, color;']")
	private WebElement AddedItemCount;

//Locating WebElement To continue;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement Continue;

//Locating WebElement ToEdit Location

	@FindBy(xpath = "//div[.='Edit']")

	private WebElement Edit;

//Clearing the From Relocation

	@FindBy(xpath = "//div[@controlid='pnmLandingPageFromRelocationFormLocalitySearch']//span[@class='right-input-icon ']")
	private WebElement ClearFromRelocation;

//Clearing the To Relocation

	@FindBy(xpath = "//div[@controlid=\"pnmLandingPageToRelocationLocalitySearch\"]//span[@class='right-input-icon ']")
	private WebElement ClearToRelocation;

//Locate Webelement Relocate From Location

	@FindBy(id = "pnmLandingPageFromRelocationFormLocalitySearch")
	private WebElement RelocateFromLocation;

//Locate Webelement Relocate To Location

	@FindBy(id = "pnmLandingPageToRelocationLocalitySearch")
	private WebElement RelocateToLocation;

//
	@FindBy(id = "pnmGetRealPriceButtonDesktop")
	private WebElement UpdateLocation;

// Locate WebElement To close relocation
	@FindBy(css = "[src='https://assets.nobroker.in/hs-new/public/Home-Services/closeIcon.svg']")
	private WebElement CloseRelocation;

// getPageTitle
	@FindBy(xpath = "//header//div[@class=\"font-bold text-22 undefined\"]")
	private WebElement PageTitle;

	@FindBy(id = "alertMessageBox")
	private WebElement Alert;

	@FindBy(xpath = "//div[text()='Confirm']/../..")
	private WebElement Confirm;

	@FindBy(css = "[class='font-bold text-14 text-pnm-lightest-grey  leading-none']")
	private WebElement Addeditem;

	@FindBy(xpath = "//button[.='Close']")
	private WebElement close;

	@FindBy(xpath = "//div[@class='p-0 overflow-auto h-80']//div[@id='decreament']")
	private WebElement decreamentadditems;

	@FindBy(id = "scroll-container")
	private WebElement scrollcontainer;

	
	@FindBy(xpath="//div[text()='Confirm your shifting Date & Slot']")
	private WebElement ConfirmShiftingDateTitle;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations')]")
	private WebElement Confirmation;
	
	@FindBy(xpath="//div[text()='Close']")
	private WebElement CloseBtn;
	
	public WebElement getScrollcontainer() {
		return scrollcontainer;
	}
	public WebElement getDecreamentadditems() {
		return decreamentadditems;
	}
	public WebElement getClose() {
		return close;
	}

	public WebElement getAddeditems() {
		return Addeditem;
	}
	
	
	

	

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCloseBtn() {
		return CloseBtn;
	}

	public WebElement getConfirm() {
		return Confirm;
	}

	public WebElement getAlert() {
		return Alert;
	}

	public WebElement getEdit() {
		return Edit;
	}

	public WebElement getPageTitle() {
		return PageTitle;
	}

// Increment The added item

	public WebElement getSearchItem() {
		return SearchItem;
	}

	public WebElement getBedrooms() {
		return Bedrooms;
	}

	public WebElement getBed() {
		return Bed;
	}

	public WebElement getMattress() {
		return Mattress;
	}

	public WebElement getTable() {
		return Table;
	}

	public WebElement getChair() {
		return Chair;
	}

	public WebElement getTelevision() {
		return Television;
	}

	public WebElement getAirConditioner() {
		return AirConditioner;
	}

	public WebElement getAlmirahWardrobe() {
		return AlmirahWardrobe;
	}

	public WebElement getCabinetAndStorage() {
		return CabinetAndStorage;
	}

	public WebElement getAppliances() {
		return Appliances;
	}

	public WebElement getLivingRooms() {
		return LivingRooms;
	}

	public WebElement getSofa() {
		return Sofa;
	}

	public WebElement getDining() {
		return Dining;
	}

	public WebElement getKitchen() {
		return Kitchen;
	}

	public WebElement getRefigerator() {
		return Refigerator;
	}

	public WebElement getKitchenItems() {
		return KitchenItems;
	}

	public WebElement getMiscellaneous() {
		return Miscellaneous;
	}

	public WebElement getWashingMachine() {
		return WashingMachine;
	}

	public WebElement getGymEquipments() {
		return GymEquipments;
	}

	public WebElement getCartons() {
		return Cartons;
	}

	public WebElement getAddIcon() {
		return AddIcon;
	}

	public WebElement getAddedItemCount() {
		return AddedItemCount;
	}

	public WebElement getContinue() {
		return Continue;
	}

	public WebElement getEditLocation() {
		return Edit;
	}

	public WebElement getClearFromRelocation() {
		return ClearFromRelocation;
	}

	public WebElement getClearToRelocation() {
		return ClearToRelocation;
	}

	public WebElement getRelocateFromLocation() {
		return RelocateFromLocation;
	}

	public WebElement getRelocateToLocation() {
		return RelocateToLocation;
	}

	public WebElement getUpdateLocation() {
		return UpdateLocation;
	}

	public WebElement getCloseRelocation() {
		return CloseRelocation;
	}
	
	public WebElement getConfirmation() {
		return Confirmation;
	}
	
	

	public WebElement getIncrementButton(String itemName) {
		return driver.findElement(By.xpath(
				"//div[normalize-space()='" + itemName + "']/..//following-sibling::div//div[@id='increament']"));
	}

	public WebElement AddIcon(String itemName) {
		return driver.findElement(By.xpath("//div[text()='" + itemName + "']/..//following-sibling::div[@style='justify-content: center;']"));
	}

//Decrement The Added item Count
	public WebElement getDecrementButton(String itemName, WebDriver driver) {
		return driver.findElement(By.xpath(
				"//div[normalize-space()='" + itemName + "']/..//following-sibling::div//div[@id='decreament']"));
	}
	
	

	public void ConfirmDate(String date) {
		
		// Then find and click the date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(normalize-space(),'Pickup Date')]"
				+ "/..//div[normalize-space()='" + date + "'" + " and not(contains(@class,'disabled'))]"))).click();


	}

	public void ConfirmTimeAndDate(String date, String periods, String TimeSlot, WebDriver driver) {
		driver.findElement(By.xpath("//div[contains(normalize-space(),'Pickup Date')]/..//div[normalize-space()='"
				+ date + "' and not(contains(@class,'disabled'))]")).click();
		if (!periods.equals("Morning")) {
			driver.findElement(By.xpath("//div[text()='Select Pickup Slot']/..//div[text()='" + periods + "']"))
					.click();
			driver.findElement(By.xpath("//div[@class=\"font-normal text-14\" and text()='" + TimeSlot + "']")).click();
			driver.findElement(By.xpath("//div[text()='Confirm']")).click();
		}
	}

	public void RelocateFromAndToLocation(String fromlocation, String Tolocation) {
		getEditLocation().click();
		getClearFromRelocation().click();
		getRelocateFromLocation().sendKeys(fromlocation, Keys.ARROW_DOWN.ENTER);
		getClearToRelocation().click();
		getRelocateToLocation().sendKeys(Tolocation, Keys.ARROW_DOWN.ENTER);
	}

	public void openIfClosed(String category,String subcategory) {

		List<WebElement> elements = driver.findElements(
				By.xpath("//div[@id='scroll-container']//div[text()='"+category+"']/../../../..//div[text()='"+subcategory+"']/../..//img[contains(@src,'open-accordian')]"));
		if (!elements.isEmpty()) {
			WebElement element = elements.get(0);
			if (element.isDisplayed()) {
				Utilities.scrollToElement(element);
				element.click();
			}
		}
	}
	
	public void selectcategory(String name) {
		driver.findElement(By.xpath("//div[@class='flex items-end justify-between w-full']//a[text()='"+name+"']")).click();
	}

	public void removeitems() {
		String countText = getAddeditems().getText().trim();
		int count = Integer.parseInt(countText);
		if (count > 0) {
			getAddeditems().click();
			Utilities.scrollToElement(driver.findElement(By.id("decreament")));
			Utilities.WaitForToBeClickableOfElement(7, driver.findElement(By.id("decreament")));

			while (count > 0) {
				driver.findElement(By.id("decreament")).click();
				count--;
			}
			getClose().click();

		}

	}
	


}
