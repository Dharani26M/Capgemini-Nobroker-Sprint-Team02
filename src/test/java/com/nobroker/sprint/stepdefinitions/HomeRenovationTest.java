package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeRenovationTest extends AllUtilities{
	private BaseClass base;

	public HomeRenovationTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
	
	@Given("the user does not wants to log in")
	public void the_user_does_not_wants_to_log_in() {
		 Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"));
	}
	@When("user clicks on painting and cleaning")
	public void user_clicks_on_painting_and_cleaning() {
	    Pages.renovationPage.clickClean();
	}
	@When("user clicks on city")
	public void user_clicks_on_city() {
	    Pages.renovationPage.setCity();
	}
	@When("user naviagtes and clicks on home rennovation icon")
	public void user_naviagtes_and_clicks_on_home_rennovation_icon() {
	    Pages.renovationPage.setRenovation();
	}
	@When("user check on wall panel")
	public void user_check_on_wall_panel() {
	    Pages.renovationPage.setWall();
	}
	@When("user chooses the charcoal pannel and clicks it")
	public void user_chooses_the_charcoal_pannel_and_clicks_it() {
	    Pages.renovationPage.setCharcoal();
	}
	@Then("user can view the price")
	public void user_can_view_the_price() {
	   Pages.renovationPage.setPrice();
	}

}
