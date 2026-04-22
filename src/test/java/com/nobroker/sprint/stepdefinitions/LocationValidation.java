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
		Pages.dashpage.clickPackersAndMovers();
		SwitchWindowUsingUrl("packers");
	    waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
	}
	@When("User enters ShiftingFrom as {string}")
	public void user_enters_shifting_from_as(String from) {
		Pages.moverspage.getClearShiftingFrom().click();

	    if (!from.isEmpty()) {
	        Pages.moverspage.getShiftingFrom().sendKeys(from);
	        pauseOnAction(20);
			Pages.moverspage.getShiftingDropDowm().click();
	    }
	}
	@When("User enters ShiftingTo as {string}")
	public void user_enters_shifting_to_as(String to) {
		Pages.moverspage.getClearShiftingTo().click();

	    if (!to.isEmpty()) {
	        Pages.moverspage.getShiftingTo().sendKeys(to);
	        pauseOnAction(20);
			Pages.moverspage.getShiftingDropDowm().click();
	}
	}
	@When("User clicks on Check Prices")
	public void user_clicks_on_check_prices() {
		WaitForToBeClickableOfElement(40, Pages.moverspage.getCheckPrices());
		 Pages.moverspage.getCheckPrices().click();
	}

	
	
	@Then("{string} pickup error should be displayed")
	public void pickup_error_should_be_displayed(String expected) {
		   boolean isDisplayed;

		    try {
		        WebElement pickupError = waitForRefreshedVisibility(
		                By.xpath("//*[contains(text(),'pickup locality')]"), 5);
		        isDisplayed = pickupError.isDisplayed();
		    } catch (Exception e) {
		        isDisplayed = false;
		    }

		    Assert.assertEquals(isDisplayed, Boolean.parseBoolean(expected),
		            "Pickup error validation failed");
	}
	@Then("{string} destination error should be displayed")
	public void destination_error_should_be_displayed(String expected) {
		 boolean isDisplayed;

		    try {
		        WebElement destinationError = waitForRefreshedVisibility(
		                By.xpath("//*[contains(text(),'destination locality')]"), 5);
		        isDisplayed = destinationError.isDisplayed();
		    } catch (Exception e) {
		        isDisplayed = false;
		    }

		    Assert.assertEquals(isDisplayed, Boolean.parseBoolean(expected),
		            "Destination error validation failed");
	}


 
	}

