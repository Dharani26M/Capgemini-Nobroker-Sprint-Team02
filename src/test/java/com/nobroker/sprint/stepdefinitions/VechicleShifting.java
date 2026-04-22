package com.nobroker.sprint.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VechicleShifting extends AllUtilities {
	
	public VechicleShifting(BaseClass base) {
		
		this.initializeDriver(base.driver);
	}
	
	
	@When("User clicks on Packers and Mover")
	public void user_clicks_on_packers_and_mover() {
		Pages.get().dashpage.clickPackersAndMovers();

        info("User clicked on Packers and Movers");
	}
	@When("User selects Vehicle Shifting")
	public void user_selects_vehicle_shifting() {
		
		SwitchWindowUsingUrl("packers");
		waitForElementOrTimeout(Pages.get().moverspage.getCompletebooking(), 40);
		Pages.get().moverspage.getVechicleShifting().click();
		info("User selected Vehicle Shifting option");
	}
	@When("User enters source city  as {string}")
	public void user_enters_source_city_as(String FromCity) {
	 
		Pages.get().moverspage.SelectBetweenFromcity(FromCity);
		 info("User entered source city: " + FromCity);
	}
	@When("User enters destination city  as {string}")
	public void user_enters_destination_city_as(String ToCity) {
		Pages.get().moverspage.SelectBetweenTocity(ToCity);
		info("User entered destination city: " + ToCity);
	}
	
	@When("User selects shifting date {string}")
	public void user_selects_shifting_date(String Date) {
		Pages.get().moverspage.SelectDate(Date);
		 info("User selected shifting date: " + Date);
	}
	@When("User clicks on Checks Price")
	public void user_clicks_on_checks_price() {
		Pages.get().moverspage.getCheckPrices().click();
		info("User clicked on Check Price");
	}
	@Then("User should be navigated to Vechicle Inventorys page")
	public void user_should_be_navigated_to_vechicle_inventorys_page() {
		SwitchWindowUsingUrl("vehicle-shifting");
		Assert.assertTrue(Pages.get().vechicleinventory.getTitle().getText().contains("Inventory"));
		 info("User navigated to Vehicle Inventory page");
	}
	@When("User selects vehicle types:")
	public void user_selects_vehicle_types(DataTable dataTable) {
	    
	    List<Map<String, String>> vehicles = dataTable.asMaps(String.class, String.class);

	    for (Map<String, String> row : vehicles) {

	        String vehicleType = row.get("VehicleType");
	        int count = Integer.parseInt(row.get("Count"));
	        for (int i = 0; i < count; i++) {
	            Pages.get().vechicleinventory.addVehicle(vehicleType);
	        }
	    }
	    info("User attempted to select vehicle type using DataTable");
	}
	
	@When("User edits location {string} And {string}")
	public void user_edits_location_and_continue(String fromcity, String tocity) {
	    Pages.get().vechicleinventory.editlocation(fromcity, tocity);
	    info("User edited location From: " + fromcity + " To: " + tocity);
	    
	}

	@Then("User should either see confirmation popup or navigate to summary page")
	public void user_should_handle_both_outcomes() {

	    try {
	         
	    	WaitForVisibiltyOfElement(15, Pages.get().vechicleinventory.getConfirmation());
	    	

	        if (Pages.get().vechicleinventory.getConfirmation().isDisplayed()) {
	        	 Assert.assertTrue(Pages.get().vechicleinventory.getConfirmation().isDisplayed());
	              Pages.get().vechicleinventory.getCloseBtn().click();
	              info("Confirmation popup displayed and handled");
	            return; 
	        }

	    } catch (Exception e) {
	        System.out.println("⚡ Popup not displayed, proceeding to summary page");
	    }

	    SwitchWindowUsingUrl("summary");
	    Assert.assertTrue(Pages.get().summary.getConfirmBooking().isDisplayed());
	    info("User navigated to summary page successfully");
	}
	
	
}
