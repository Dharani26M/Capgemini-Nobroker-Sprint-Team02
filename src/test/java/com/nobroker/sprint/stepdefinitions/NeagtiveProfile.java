package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import com.nobroker.sprint.utils.AllUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NeagtiveProfile extends AllUtilities {
    private BaseClass base;

    public NeagtiveProfile(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }
    @Given("the user has logged into the application")
	public void the_user_has_logged_into_the_application() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}

	@Given("the user navigates has the Profile page")
	public void the_user_navigates_has_the_profile_page() {
		Pages.dashpage.getProfileImg().click();
		Pages.dashpage.getProfileFeature().click();
	}

	@When("the user updates profile name to {string}")
	public void the_user_updates_profile_name_to(String name) {
		Pages.profilepage.setupUserName(name);
	}

    @Then("an error message should be displayed indicating an invalid name format")
    public void an_error_message_should_be_displayed_indicating_an_invalid_name_format() {
        WaitForVisibiltyOfElement(20, Pages.profilepage.getErrorMsg());
        Assert.assertTrue(Pages.profilepage.getErrorMsg().isDisplayed(), "Invalid message is not showing");
    }

    @Then("the profile changes should not be saved {string}")
    public void the_profile_changes_should_not_be_saved(String passingname) {
        driver.navigate().refresh();
        Pages.dashpage.getProfileImg().click();
        Pages.dashpage.getProfileFeature().click();
        String actualName = Pages.profilepage.getUserName().getAttribute("value");
        Assert.assertNotEquals(actualName, passingname, "BUG: The application saved an invalid name format");
    }
}