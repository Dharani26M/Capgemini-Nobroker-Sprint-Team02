package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShortListTest extends AllUtilities{
	@Given("user logged in for shortlisting")
	public void user_opens_the_browser() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
	@When("user clicks MyDashBoard")
	public void user_clicks_my_dash_board() {
	    
	}
	@When("clicks shortlist")
	public void clicks_shortlist() {
	    
	}
	@When("your shortlistand clicks sales")
	public void your_shortlistand_clicks_sales() {
	    
	}
	@Then("verify property available")
	public void verify_property_available() {
	    
	}

}
