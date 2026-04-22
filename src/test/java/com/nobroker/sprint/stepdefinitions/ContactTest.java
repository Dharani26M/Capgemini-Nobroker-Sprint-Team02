package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;
import org.testng.Reporter;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactTest extends AllUtilities {
	private BaseClass base;

	public ContactTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
	
	@Given("the user does log in the application")
	public void the_user_does_log_in_the_application() {
		Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"));
	}
	@When("the user clicks on menu")
	public void the_user_clicks_on_menu() {
	    Pages.get().contactPage.clickMenu();
	    AllUtilities.info("User clicks on menu option");
	}
	@When("the user connects on facebook")
	public void the_user_connects_on_facebook() {
	    Pages.get().contactPage.clickLogo();
	    AllUtilities.info("User clicks on Facebook logo");
	}
	@Then("the user has to navigate")
	public void the_user_has_to_navigate() {
		Assert.assertTrue(FetchApplicationTitle().contains("Facebook.in"));
		AllUtilities.info("User clicks on Facebook logo but no redirection happens (defect scenario)");
		Reporter.log("Assertion from contact is passed");
	}

}
