package com.nobroker.sprint.stepDefinition;

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
	    Pages.get().dashPage.clickBuyModule();
	    AllUtilities.info("User clicks on Buy module");
	}
	@When("user selects a city {string}")
	public void user_selects_a_city(String city) {
	    Pages.get().dashPage.selectCityWithDropdown(city, driver);
	    AllUtilities.info("User selects city: " + city);
	}
	@When("user enter the locality {string}")
	public void user_enter_the_locality(String loc) throws InterruptedException {
	    Pages.get().dashPage.writeLocality(loc, driver);
	    AllUtilities.info("User enters locality: " + loc);
	}
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	    Pages.get().dashPage.clickSearch();
	    AllUtilities.info("User clicks on Search button");
	}
	@When("user skips the popups")
	public void user_skips_the_popups() {
	    Pages.get().buy.clickSkip(driver);
	    AllUtilities.info("User skips popup");
	}
	
	//map page
	@When("user clicks on map")
	public void user_clicks_on_map() {
	    Pages.get().mapPage.clickMap();
	    AllUtilities.info("User clicks on Map view");
	}
	@When("user clicks on metro")
	public void user_clicks_on_metro() {
	    Pages.get().mapPage.clickMetro();
	    AllUtilities.info("User enables Metro layer on map");
	}
	@Then("user should see the lines")
	public void user_should_see_the_lines() {
		Assert.assertTrue(Pages.get().mapPage.isLinesDisplayed());
		AllUtilities.info("Metro lines are displayed on the map");
		System.out.println("Assertion is passed");
	}

}
