package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;
import org.testng.Reporter;

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
	    Pages.get().renovationPage.clickClean();
	    AllUtilities.info("User clicks on Painting and Cleaning service");
	}
	@When("user clicks on city")
	public void user_clicks_on_city() {
	    Pages.get().renovationPage.setCity();
	    AllUtilities.info("User selects the city for renovation service");
	}
	@When("user naviagtes and clicks on home rennovation icon")
	public void user_naviagtes_and_clicks_on_home_rennovation_icon() {
	    Pages.get().renovationPage.setRenovation();
	    AllUtilities.info("User navigates and clicks on Home Renovation option");
	}
	@When("user check on wall panel")
	public void user_check_on_wall_panel() {
	    Pages.get().renovationPage.setWall();
	    AllUtilities.info("User selects Wall Panel option");
	}
	@When("user chooses the charcoal pannel and clicks it")
	public void user_chooses_the_charcoal_pannel_and_clicks_it() {
	    Pages.get().renovationPage.setCharcoal();
	    AllUtilities.info("User selects Charcoal Panel");
	}
	@Then("user can view the price")
	public void user_can_view_the_price() {
		Assert.assertTrue(Pages.get().renovationPage.checkPrice());
		AllUtilities.info("User is able to view the price details");
		Reporter.log("Assertion from renovation is passed");
	}

}
