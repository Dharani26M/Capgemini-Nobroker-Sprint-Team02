package com.nobroker.sprint.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.Pages;

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
	
	

	
	@FindBy(id="pnmLandingPageFromRelocationFormLocalitySearch")
	private WebElement RelocateFromLocation;

	//Locate Webelement Relocate To Location
	@FindBy(id="pnmLandingPageToRelocationLocalitySearch")
	private WebElement RelocateToLocation;
	
	
	@FindBy(xpath="(//div[@id='autocomplete-dropdown-container']//div)[1]")
	private WebElement ShiftingDropDowm;
	
	@FindBy(id="pnmGetRealPriceButtonDesktop")
	private WebElement UpdateLocation;

	
	
	@FindBy(xpath="//p[contains(text(),'Congratulations')]")
	private WebElement Confirmation;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement CloseBtn;
	
	
	public WebElement getCloseBtn() {
		return CloseBtn;
	}

	public WebElement getEdit() {
		return Edit;
	}
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

	    if (driver.findElements(addLocator).size() > 0) {

	        WebElement addBtn = driver.findElement(addLocator);

	        if (addBtn.isDisplayed()) {
	            Utilities.scrollToElement(addBtn);
	            addBtn.click();
	            return;
	        }
	    }

	    if (driver.findElements(incLocator).size() > 0) {

	        WebElement incBtn = driver.findElement(incLocator);

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

	    } else {
	        Reporter.log("Item not added yet, cannot decrement: " + carType);
	    }
	}
	
	public void RelocateFromCity(String City) {
		getRelocateFromLocation().sendKeys(City);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		waitForStableDropdownAndClick();
		
	}
	
	public void RelocateToCity(String City) {
		getRelocateToLocation().sendKeys(City);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		waitForStableDropdownAndClick();
	}
	private By getDropDown() {
	    return By.xpath("(//div[@id='autocomplete-dropdown-container']//div)[1]");
	}
	
	   public  void waitForStableDropdownAndClick() {
	        
	        String previousText = "";
	        int stableCount = 0;

	        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(20))        // max wait time
	                .pollingEvery(Duration.ofMillis(300))        // check every 300ms
	                .ignoring(StaleElementReferenceException.class)  // ignore stale during poll
	                .ignoring(NoSuchElementException.class);         // ignore if not found yet

	        for (int i = 0; i < 20; i++) {

	            try {
	            	List<WebElement> items = fluentWait.until(
	            	    driver -> {
	            	    	 List<WebElement> elements = driver.findElements(getDropDown());

	            	    	    if (!elements.isEmpty()) {
	            	    	    }

	            	    	 return elements.isEmpty() ? null : elements; 
	            	    	 
	            	    }
	            	);

	                if (items.isEmpty()) {
	                    stableCount = 0;
	                    continue;
	                }

	                String currentText = items.get(0).getText();

	                if (currentText.equals(previousText)) {
	                    stableCount++;
	                } else {
	                    stableCount = 0;
	                    previousText = currentText;
	                }

	                if (stableCount >= 3) {
	                    items.get(0).click();
	                    System.out.println("✅ Clicked: " + currentText);
	                    return;
	                }

	            } catch (StaleElementReferenceException e) {
	                stableCount = 0;
	            }
	        }
	        throw new RuntimeException("❌ Dropdown never stabilized!");
	    }
	   
	   public void editlocation(String fromcity , String tocity ) {
		   Pages.get().vechicleinventory.getEdit().click();
		    Pages.get().vechicleinventory.RelocateFromCity(fromcity);
		    Pages.get().vechicleinventory.RelocateToCity(tocity);
		    Pages.get().vechicleinventory.getUpdateLocation().click();
			Pages.get().vechicleinventory.getContinue().click();
	   }
}


