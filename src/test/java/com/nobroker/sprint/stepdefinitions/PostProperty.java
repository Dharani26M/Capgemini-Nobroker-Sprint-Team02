package com.nobroker.sprint.stepdefinitions;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostProperty extends AllUtilities {

    private BaseClass base;

    public PostProperty(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @Given("the user has successfull of logged into the application")
    public void the_user_has_successfull_of_logged_into_the_application() {
        WaitForVisibiltyOfElement(70, Pages.get().dashpage.getProfileImg());
        Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
        AllUtilities.info("User is logged in – profile image visible");
    }

    @When("the user clicks on Post Your Property from the menu")
    public void the_user_clicks_on_post_your_property_from_the_menu() {
        Pages.get().dashpage.ClickPostYourProperty();
        AllUtilities.info("Clicked on 'Post Your Property' from menu");
    }

    @When("the user toggles the property status")
    public void the_user_toggles_the_property_status() {
        try {
            WaitForVisibiltyOfElement(70, Pages.get().postpage.getToggle());
            Pages.get().postpage.ClickOnToggle();
        } catch (StaleElementReferenceException e) {
            WaitForVisibiltyOfElement(70, Pages.get().postpage.getToggle());
            Pages.get().postpage.ClickOnToggle();
        }
        AllUtilities.info("Toggled property status");
    }

    @Then("the user should see property listing options")
    public void the_user_should_see_the_property_listing_options() {
        WaitForVisibiltyOfElement(70, Pages.get().postpage.getNoPropertyContentField());
        Assert.assertTrue(Pages.get().postpage.getPremium().isDisplayed(),
                "Active Property is Present");
        AllUtilities.info("No property listing options are displayed as expected");
    }
}
