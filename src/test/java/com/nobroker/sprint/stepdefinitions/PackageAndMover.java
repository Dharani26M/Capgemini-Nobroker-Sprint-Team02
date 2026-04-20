package com.nobroker.sprint.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	

	public PackageAndMover(BaseClass base) {
	
		this.initializeDriver(base.driver);
	}
	
	@When("User clicks on Packers and Movers")
	public void user_clicks_on_packers_and_movers() {
		
		Pages.dashpage.clickPackersAndMovers();
	}
	@Then("User should be navigated to Packers and Movers page")
	public void user_should_be_navigated_to_packers_and_movers_page() {
	
		SwitchWindowUsingUrl("packers");
	    waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
	}
	@When("User selects WithinCity option")
	public void user_selects_within_city_option() {
		  Pages.moverspage.getWithinCity().click();
		  System.out.println("Executing");
	}
	@When("User enters Cityname as {string}")
	public void user_enters_cityname_as(String cityname) {
		WaitForToBeClickableOfElement(40, Pages.moverspage.getSelectCity());
		Pages.moverspage.SelectCity(cityname);	
	}
	@When("User enters ShiftingFrom location as {string}")
	public void user_enters_shifting_from_location_as(String FromLocation) {
		
		WaitForToBeClickableOfElement(40, Pages.moverspage.getShiftingFrom());
		
		Pages.moverspage.getShiftingFrom().sendKeys(FromLocation);
		
		waitForRefreshedVisibility(Pages.moverspage.getShiftingFrom(), 40);
		
		Pages.moverspage.getShiftingDropDowm().click();
		
	}
	@When("User enters ShiftingTo location as {string}")
	public void user_enters_shifting_to_location_as(String ToLocation) {

		Pages.moverspage.getShiftingTo().sendKeys(ToLocation);
		waitForRefreshedVisibility(Pages.moverspage.getShiftingTo(), 40);
		WaitForToBeClickableOfElement(40, Pages.moverspage.getShiftingTo());
		pauseOnAction(20);
		Pages.moverspage.getShiftingDropDowm().click();
	}
	@When("User clicks on checkprice")
	public void user_clicks_on_checkprice() {
		WaitForToBeClickableOfElement(40, Pages.moverspage.getCheckPrices());

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
	@When("User selects shifting date as {string}")
	public void User_selects_shifting_date_as(String date) {

	    Pages.inventorypage.ConfirmDate(date);
	}
	@Then("User click Confirm Booking")
	public void User_click_confirm_booking() {
		
		SwitchWindowUsingUrl("summary");
		Pages.summary.getConfirmBooking().click();
		SwitchWindowUsingUrl("checkout");
		Assert.assertTrue(Pages.payment.getTitle().getText().contains("Payments"));
		
	}
}
