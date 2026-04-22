package com.nobroker.sprint.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationValidation extends AllUtilities {

	public LocationValidation(BaseClass base) {
        this.initializeDriver(base.driver);
    }
	
	@Given("User is on Packers and Movers page")
	public void user_is_on_packers_and_movers_page() {
		Pages.get().dashpage.clickPackersAndMovers();
		SwitchWindowUsingUrl("packers");
	    waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
	    info("User is on Packers and Movers page");
	}
	@When("User enters ShiftingFrom as {string}")
	public void user_enters_shifting_from_as(String from) {
		Pages.get().moverspage.getClearShiftingFrom().click();
		

	    if (!from.isEmpty()) {
	        Pages.get().moverspage.getShiftingFrom().sendKeys(from);
	        
			Pages.get().moverspage.waitForStableDropdownAndClick();
	    }
	    info("User entered Shifting From location: " + from);
	}
	@When("User enters ShiftingTo as {string}")
	public void user_enters_shifting_to_as(String to) {
		Pages.get().moverspage.getClearShiftingTo().click();

	    if (!to.isEmpty()) {
	        Pages.get().moverspage.getShiftingTo().sendKeys(to);
	        
			Pages.get().moverspage.waitForStableDropdownAndClick();
	}
	    info("User entered Shifting To location: " + to);
	    
	}
	@When("User clicks on Check Prices")
	public void user_clicks_on_check_prices() {
		WaitForToBeClickableOfElement(40, Pages.get().moverspage.getCheckPrices());
		 Pages.get().moverspage.getCheckPrices().click();
		 info("User clicked on Check Prices");
		 
	}

	
	@Then("pickup error should be {string}")
	public void pickup_error_should_be(String expected) {

	    boolean isExpected = Boolean.parseBoolean(expected);

	    Assert.assertEquals(
	        isDisplayedSafe(Pages.get().moverspage.getPickupError()),
	        isExpected,
	        "Pickup error validation failed"
	    );
	    info("Pickup error validation completed. Expected: " + expected);
	    
	}

	@Then("destination error should be {string}")
	public void destination_error_should_be(String expected) {

	    boolean isExpected = Boolean.parseBoolean(expected);

	    Assert.assertEquals(
	        isDisplayedSafe(Pages.get().moverspage.getDestinationError()),
	        isExpected,
	        "Destination error validation failed"
	    );
	    info("Destination error validation completed. Expected: " + expected);
	}
	}


 
	

