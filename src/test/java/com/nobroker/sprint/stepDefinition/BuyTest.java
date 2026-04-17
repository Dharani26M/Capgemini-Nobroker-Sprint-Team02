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
	    Pages.dashPage.clickBuyModule();
	}
	@When("user selects the city {string}")
	public void user_selects_the_city(String city) {
	    Pages.dashPage.selectCityWithDropdown(city, driver);
	}
	@When("user enters the locality {string}")
	public void user_enters_the_locality(String loc) throws InterruptedException {
	    Pages.dashPage.writeLocality(loc, driver);
	}
	@When("user clicks on search")
	public void user_clicks_on_search() {
	    Pages.dashPage.clickSearch();
	}
	@When("user skips the popup")
	public void user_skips_the_popup() {
	    Pages.buy.clickSkip(driver);
	}
	@When("user applies filter")
	public void user_applies_filter() {
	    Pages.buy.clickFiter();
	}
	@When("user clicks on View All projects")
	public void user_clicks_on_view_all_projects() {
	    Pages.buy.clickViewAll(driver);
	}
	@When("user selects the property from list")
	public void user_selects_the_property_from_list() {
	    Pages.buy.setProperty(driver);
	}
	@Then("user clicks on contact builder")
	public void user_clicks_on_contact_builder() {
	    Pages.buy.clickContact(driver);
	}
	
	//map page
	@When("user clicks on map")
	public void user_clicks_on_map() {
	    Pages.mapPage.clickMap();
	}
	@When("user clicks on metro")
	public void user_clicks_on_metro() {
	    Pages.mapPage.clickMetro();
	}
	@Then("user should see the lines")
	public void user_should_see_the_lines() {
	    Pages.mapPage.checkLines();
	}

}
