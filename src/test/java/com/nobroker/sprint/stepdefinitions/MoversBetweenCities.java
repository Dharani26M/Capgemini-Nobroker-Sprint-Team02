package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoversBetweenCities extends AllUtilities{
	
	public MoversBetweenCities(BaseClass base) {
		
		this.initializeDriver(base.driver);
	}
	@When("User clicks on Packer and Mover")
	public void user_clicks_on_packer_and_mover() {
		
		Pages.dashpage.clickPackersAndMovers();
	}
	@When("User clicks on Between City")
	public void user_clicks_on_between_city() {
		
		SwitchWindowUsingUrl("packers");
		waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
		Pages.moverspage.getBetweenCity().click();
		
	    
	}
	@Then("Between City option should be selected")
	public void between_city_option_should_be_selected() {
		
		waitForRefreshedVisibility(By.xpath("//div[text()='Between Cities']"), 20);
	    
		Assert.assertTrue(Pages.moverspage.getBetweenCities().getAttribute("style").contains("background-color:"));
	}
	@When("User enters From City as {string}")
	public void user_enters_from_city_as(String FromCity) {
		
		Pages.moverspage.SelectBetweenFromcity(FromCity);
		
	}
	@When("User enters To City as {string}")
	public void user_enters_to_city_as(String ToCity) {
	    Pages.moverspage.SelectBetweenTocity(ToCity);
	    
	}
	@When("User select shifting date as {string}")
	public void user_select_shifting_date_as(String Date) {
		Pages.moverspage.SelectDate(Date);
	}
	@When("User clicks on Check Price")
	public void user_clicks_on_check_price()  {
	 Pages.moverspage.getCheckPrices().click();
	
	}

	@When("User enters modal ShiftingFrom as {string} ShiftingTo as {string} clicks on Update Location")
	public void user_enters_modal_shifting_from_as_shifting_to_as_clicks_on_update_location(String fromcity, String tocity) {
		
		Pages.moverspage.ShiftingCity(fromcity,tocity);

	}
	
	@When("User clicks on Continue without adding items")
	public void user_clicks_on_continue_without_adding_items() {
		SwitchWindowUsingUrl("inventory");
		
		Pages.inventorypage.removeitems();

		Pages.inventorypage.getContinue().click();
	}
	@Then("A popup message should be displayed")
	public void a_popup_message_should_be_displayed() {
	    
		String message  = Pages.inventorypage.getAlert().getText();
		Assert.assertTrue(message.contains("Please add items"));
		
	}
	


	
}
