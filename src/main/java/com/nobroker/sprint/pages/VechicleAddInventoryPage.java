package com.nobroker.sprint.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;

public class VechicleAddInventoryPage {
	
	public WebDriver driver;
	public AllUtilities Utilities;
	public VechicleAddInventoryPage(WebDriver driver) {
		Utilities = new AllUtilities();
		this.driver = driver;
		this.Utilities.initializeDriver(driver);
		
	}
	
	@FindBy(xpath = "//div[@class='font-bold text-22 undefined']")
	private WebElement title;


	@FindBy(xpath="//div[.='Edit']")
	private WebElement Edit;
	
	//Locating WebElement To continue;

	@FindBy(xpath="//div[text()='Continue']")
	private WebElement Continue;
	
	
	public WebElement getEdit() {
		return Edit;
	}
	
	@FindBy(id="pnmLandingPageFromRelocationFormLocalitySearch")
	private WebElement RelocateFromLocation;

	//Locate Webelement Relocate To Location
	@FindBy(id="pnmLandingPageToRelocationLocalitySearch")
	private WebElement RelocateToLocation;
	
	
	@FindBy(xpath="(//div[@id='autocomplete-dropdown-container']//div)[1]")
	private WebElement ShiftingDropDowm;
	
	@FindBy(id="pnmGetRealPriceButtonDesktop")
	private WebElement UpdateLocation;

	
	@FindBy(xpath="//img[@alt='Success']/..")
	private WebElement Confirmation;
	
	public WebElement getConfirmation() {
		return Confirmation;
	}

	public WebElement getContinue() {
		return Continue;
	}

	public WebElement getRelocateFromLocation() {
		return RelocateFromLocation;
	}

	public WebElement getRelocateToLocation() {
		return RelocateToLocation;
	}

	public WebElement getShiftingDropDowm() {
		return ShiftingDropDowm;
	}

	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getUpdateLocation() {
		return UpdateLocation;
	}

	
	public void addVehicle(String carType) {

	    By addLocator = By.xpath("//div[normalize-space()='" + carType + "']/ancestor::div[contains(@class,'item')]//div[text()='Add']");

	    By incLocator = By.xpath("//div[normalize-space()='" + carType + "']/ancestor::div[contains(@class,'item')]//button[@id='increament']" );

	    List<WebElement> addButtons = driver.findElements(addLocator);

	    if (!addButtons.isEmpty()) {
	   
	        WebElement addBtn = Utilities.WaitForToBeClickableOfElement(5, addLocator);

	        Utilities.scrollToElement(addBtn);

	        addBtn.click();

	    } else {

	        WebElement incBtn = Utilities.WaitForToBeClickableOfElement(5, incLocator);
	        Utilities.scrollToElement(incBtn);
	        incBtn.click();
	    }
	}
	
		
	public void decrementVehicle(String carType) {

	    By decLocator = By.xpath( "//div[normalize-space()='" + carType + "']/ancestor::div[contains(@class,'item')]//button[@id='decreament']");

	    if (!driver.findElements(decLocator).isEmpty()) {

	        WebElement decBtn = Utilities.WaitForToBeClickableOfElement(10, decLocator);

	        Utilities.scrollToElement(decBtn);

	        decBtn.click();

	    } 
	}
	
	public void RelocateFromCity(String City) {
		getRelocateFromLocation().sendKeys(City);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		getShiftingDropDowm().click();
	}
	
	public void RelocateToCity(String City) {
		getRelocateToLocation().sendKeys(City);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		getShiftingDropDowm().click();
	}
}


