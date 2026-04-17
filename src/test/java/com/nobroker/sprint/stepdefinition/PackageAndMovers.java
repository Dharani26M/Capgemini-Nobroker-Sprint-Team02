package com.nobroker.sprint.stepdefinition;

import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PackageAndMovers {

	
	@When("User clicks on Packers and Movers")
	public void user_clicks_on_packers_and_movers() {
	  Pages.dashpage.clickPackersAndMovers();
	}
	@Then("User should be navigated to Packers and Movers page")
	public void user_should_be_navigated_to_packers_and_movers_page() {
	    String pagetitle = Pages.inventorypage.getPageTitle().getText();
	   
	}
	@When("User selects {string} option")
	public void user_selects_option(String string) {
	    
	}
	@When("User enters {string} as {string}")
	public void user_enters_as(String string, String string2) {
	   
	}
	@When("User enters {string} location as {string}")
	public void user_enters_location_as(String string, String string2) {
	    
	}
	@Then("User should be navigated to Inventory page")
	public void user_should_be_navigated_to_inventory_page() {
	    
	}
	@When("User adds bedroom items")
	public void user_adds_bedroom_items() {
	   
	}
	@When("User adds kitchen items")
	public void user_adds_kitchen_items() {
	    
	}
	@When("User adds living room items")
	public void user_adds_living_room_items() {
	    
	}
	@When("User selects shifting date")
	public void user_selects_shifting_date() {
	    
	}
	@Then("Confirm Booking button should be enabled")
	public void confirm_booking_button_should_be_enabled() {
	    
	}

		
}
