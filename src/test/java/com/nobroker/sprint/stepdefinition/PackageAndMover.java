package com.nobroker.sprint.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.nobroker.sprint.pages.AddInventoryPage;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PackageAndMover extends AllUtilities {

	private BaseClass base;

	public PackageAndMover(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
	
	@When("User clicks on Packers and Movers")
	public void user_clicks_on_packers_and_movers() {
		Pages.dashpage.clickPackersAndMovers();
	}
	@Then("User should be navigated to Packers and Movers page")
	public void user_should_be_navigated_to_packers_and_movers_page() {
//	
		SwitchWindowUsingUrl("packers");
		Assert.assertTrue(Pages.moverspage.getPageTitle().getText().contains("Packers and Movers"));
	}
	@When("User selects WithinCity option")
	public void user_selects_within_city_option() {
		  Pages.moverspage.getWithinCity().click();
	}
	@When("User enters Cityname as {string}")
	public void user_enters_cityname_as(String cityname) {
		Pages.moverspage.SelectCity(cityname);	
	}
	@When("User enters ShiftingFrom location as {string}")
	public void user_enters_shifting_from_location_as(String FromLocation) {
		Pages.moverspage.getShiftingFrom().sendKeys(FromLocation);
		WaitForToBeClickableOfElement(40, Pages.moverspage.getShiftingDropDowm());
		Pages.moverspage.getShiftingDropDowm().click();
	}
	@When("User enters ShiftingTo location as {string}")
	public void user_enters_shifting_to_location_as(String ToLocation) {

		Pages.moverspage.getShiftingTo().sendKeys(ToLocation);
		WaitForToBeClickableOfElement(40, Pages.moverspage.getShiftingDropDowm());
		Pages.moverspage.getShiftingDropDowm().click();
	}
	@When("User clicks on checkprice")
	public void user_clicks_on_checkprice() {
		 Pages.moverspage.getCheckPrices().click();
	}
	@Then("User should be navigated to Inventory page")
	public void user_should_be_navigated_to_inventory_page() {
	   SwitchWindowUsingUrl("inventory");
	}
	
	@When("User adds inventory items:")
	public void user_adds_inventory_items(DataTable dataTable) {
		
		  List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

		   

		    for (Map<String, String> row : items) {

		        String category = row.get("Category");
		        String subCategory = row.get("SubCategory");
		        String itemName = row.get("Item Name");

		        // Click Category
		        
		        Pages.inventorypage.openIfClosed(category);
		        

		        // Click SubCategory
		      Pages.inventorypage.openIfClosed(subCategory);

		        // Click Add Button (dynamic)
		      
		        try {
		            Pages.inventorypage.AddIcon(itemName).click();   // first time
		        } catch (Exception e) {
		            Pages.inventorypage.getIncrementButton(itemName).click(); // already added
		        }
		    }
		
		
	}
	
	@When("User clicks on Continue")
	public void user_clicks_on_continue() {
	   Pages.inventorypage.getContinue().click();
	}
	@When("User selects shifting date as {string} period as {string} slot as {string}")
	public void user_selects_shifting_date(String date, String period, String timeSlot) {

	    Pages.inventorypage.ConfirmTimeAndDate(date, period, timeSlot, driver);
	}
	@Then("Confirm Booking button should be enabled")
	public void confirm_booking_button_should_be_enabled() {
		
		
		SwitchWindowUsingUrl("summary");
		Assert.assertTrue(Pages.summary.getConfirmBooking().isEnabled());
		
	}
}
