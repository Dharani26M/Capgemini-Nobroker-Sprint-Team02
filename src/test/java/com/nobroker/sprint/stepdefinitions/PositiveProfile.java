package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveProfile extends AllUtilities {

    private BaseClass base;

    public PositiveProfile(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @Given("the user has successfully logged into the application")
    public void the_user_has_successfully_logged_into_the_application() {
        WaitForVisibiltyOfElement(50, Pages.get().dashpage.getProfileImg());
        Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
        AllUtilities.info("User is logged in – profile image visible");
    }

    @Given("the user navigates to the Profile page")
    public void the_user_navigates_to_the_profile_page() {
        Pages.get().dashpage.getProfileImg().click();
        Pages.get().dashpage.getProfileFeature().click();
        AllUtilities.info("Navigated to Profile page");
    }

    @When("the user updates profile name to {string}")
    public void the_user_updates_profile_name_to(String name) {
        Pages.get().profilepage.setupUserName(name);
        AllUtilities.info("Profile name updated to: " + name);
    }

    @When("the user refreshes the current page")
    public void the_user_refreshes_the_current_page() {
        RefreshCurrentpage();
        AllUtilities.info("Page refreshed");
    }

    @Then("the profile name should be displayed as {string}")
    public void the_profile_name_should_be_displayed_as(String expectedname) {
        Assert.assertEquals(
            Pages.get().profilepage.getUserName().getAttribute("value"),
            expectedname, "profile mismatch"
        );
        AllUtilities.info("Profile name verified: " + expectedname);
    }
}
