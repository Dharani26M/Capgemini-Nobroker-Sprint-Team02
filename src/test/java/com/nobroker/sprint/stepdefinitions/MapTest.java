package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MapTest extends AllUtilities{
	private BaseClass base;

	public MapTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
	
	@Given("the user is not log in")
	public void the_user_is_not_log_in() {
	    Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"));
	}
	@When("user clicks on the buy button")
	public void user_clicks_on_the_buy_button() {
	    Pages.dashPage.clickBuyModule();
	}
	@When("user selects a city {string}")
	public void user_selects_a_city(String city) {
	    Pages.dashPage.selectCityWithDropdown(city, driver);
	}
	@When("user enter the locality {string}")
	public void user_enter_the_locality(String loc) throws InterruptedException {
	    Pages.dashPage.writeLocality(loc, driver);
	}
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	    Pages.dashPage.clickSearch();
	}
	@When("user skips the popups")
	public void user_skips_the_popups() {
	    Pages.buy.clickSkip(driver);
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
