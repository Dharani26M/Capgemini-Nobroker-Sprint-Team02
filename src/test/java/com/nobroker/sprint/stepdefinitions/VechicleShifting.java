package com.nobroker.sprint.stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VechicleShifting extends AllUtilities {
	
	public VechicleShifting(BaseClass base) {
		
		this.initializeDriver(base.driver);
	}
	
	
	@When("User clicks on Packers and Mover")
	public void user_clicks_on_packers_and_mover() {
		Pages.dashpage.clickPackersAndMovers();
	}
	@When("User selects Vehicle Shifting")
	public void user_selects_vehicle_shifting() {
		
		SwitchWindowUsingUrl("packers");
		waitForElementOrTimeout(Pages.moverspage.getCompletebooking(), 40);
		Pages.moverspage.getVechicleShifting().click();
	}
	@When("User enters source city  as {string}")
	public void user_enters_source_city_as(String FromCity) {
	 
		Pages.moverspage.SelectBetweenFromcity(FromCity);
	}
	@When("User enters destination city  as {string}")
	public void user_enters_destination_city_as(String ToCity) {
		Pages.moverspage.SelectBetweenTocity(ToCity);
	}
	
	@When("User selects shifting date {string}")
	public void user_selects_shifting_date(String Date) {
		Pages.moverspage.SelectDate(Date);
	}
	@When("User clicks on Checks Price")
	public void user_clicks_on_checks_price() {
		Pages.moverspage.getCheckPrices().click();
	}
	@Then("User should be navigated to Vechicle Inventorys page")
	public void user_should_be_navigated_to_vechicle_inventorys_page() {
		SwitchWindowUsingUrl("vehicle-shifting");
		Assert.assertTrue(Pages.vechicleinventory.getTitle().getText().contains("Inventory"));
	}
	@When("User selects vehicle type  as {string}")
	public void user_selects_vehicle_type_as(String cartype) {
	    
		Pages.vechicleinventory.addVehicle(cartype);
		Pages.vechicleinventory.addVehicle(cartype);
	}
	@When("User edits location {string} And {string}")
	public void user_edits_location_and_continue(String fromcity, String tocity) {
	    Pages.vechicleinventory.getEdit().click();
	    Pages.vechicleinventory.RelocateFromCity(fromcity);
	    Pages.vechicleinventory.RelocateToCity(tocity);
	    waitForInvisibilityOfElement(Pages.vechicleinventory.getShiftingDropDowm(), 6);
	    WaitForToBeClickableOfElement(5,Pages.vechicleinventory.getUpdateLocation());
	    Pages.vechicleinventory.getUpdateLocation().click();
	    WaitForToBeClickableOfElement(5,Pages.vechicleinventory.getContinue());
		Pages.vechicleinventory.getContinue().click();
	    
	}

	@Then("User should navigate to summarypage")
	public void user_should_navigate_to_summarypage() {
		SwitchWindowUsingUrl("summary");
		Assert.assertTrue(Pages.summary.getConfirmBooking().isDisplayed());
	}
	
}
