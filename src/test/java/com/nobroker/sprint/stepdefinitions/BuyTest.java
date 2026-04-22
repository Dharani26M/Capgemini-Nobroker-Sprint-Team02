package com.nobroker.sprint.stepDefinition;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyTest extends AllUtilities{
	private BaseClass base;

	public BuyTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
	
	//buy
	@Given("the user is not logged in")
	public void the_user_is_not_logged_in() {
	    Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"));
	}
	@When("user clicks on buy button")
	public void user_clicks_on_buy_button() {
	    Pages.get().dashPage.clickBuyModule();
	    AllUtilities.info("user clicks on buy button");
	}
	@When("user selects the city {string}")
	public void user_selects_the_city(String city) {
	    Pages.get().dashPage.selectCityWithDropdown(city, driver);
	    AllUtilities.info("User selects city: " + city);
	}
	@When("user enters the locality {string}")
	public void user_enters_the_locality(String loc) throws InterruptedException {
	    Pages.get().dashPage.writeLocality(loc, driver);
	    AllUtilities.info("User enters locality: " + loc);
	}
	@When("user clicks on search")
	public void user_clicks_on_search() {
	    Pages.get().dashPage.clickSearch();
	    AllUtilities.info("User clicks on Search button");
	}
	@When("user skips the popup")
	public void user_skips_the_popup() {
	    Pages.get().buy.clickSkip(driver);
	    AllUtilities.info("User skips the popup");
	}
	@When("user applies filter")
	public void user_applies_filter() {
	    Pages.get().buy.clickFiter();
	    AllUtilities.info("User applies property filter");
	}
	@When("user clicks on View All projects")
	public void user_clicks_on_view_all_projects() {
	    Pages.get().buy.clickViewAll(driver);
	    AllUtilities.info("User clicks on View All Projects");
	}
	@When("user selects the property from list")
	public void user_selects_the_property_from_list() {
	    Pages.get().buy.setProperty(driver);
	    AllUtilities.info("User selects a property from the list");
	}
	@Then("user clicks on contact builder")
	public void user_clicks_on_contact_builder() {
	    Pages.get().buy.clickContact(driver);
	    AllUtilities.info("User clicks on Contact Builder");
	}
	

}
