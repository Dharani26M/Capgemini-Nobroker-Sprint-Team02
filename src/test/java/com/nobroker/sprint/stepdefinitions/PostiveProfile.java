package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import com.nobroker.sprint.utils.AllUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostiveProfile extends AllUtilities {
	
	private BaseClass base;

	public PostiveProfile(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}

	@Given("the user has successfully logged into the application")
	public void the_user_has_successfully_logged_into_the_application() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}

	@Given("the user navigates to the Profile page")
	public void the_user_navigates_to_the_profile_page() {
		Pages.dashpage.getProfileImg().click();
		Pages.dashpage.getProfileFeature().click();
	}

	@When("the user updates the profile name to {string}")
	public void the_user_updates_the_profile_name_to(String name) {
		Pages.profilepage.setupUserName(name);
	}

	@When("the user refreshes the current page")
	public void the_user_refreshes_the_current_page() {
		RefreshCurrentpage();
	}

	@Then("the profile name should be displayed as {string}")
	public void the_profile_name_should_be_displayed_as(String expectedname) {
		Assert.assertEquals(Pages.profilepage.getUserName().getAttribute("value"), expectedname, "profile mismatch");
	}
}