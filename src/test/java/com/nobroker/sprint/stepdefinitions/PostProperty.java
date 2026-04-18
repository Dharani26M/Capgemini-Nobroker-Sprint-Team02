package com.nobroker.sprint.stepdefinitions;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import com.nobroker.sprint.utils.AllUtilities;

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
		WaitForVisibiltyOfElement(70, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
    
    @When("the user clicks on Post Your Property from the menu")
    public void the_user_clicks_on_post_your_property_from_the_menu() {
        Pages.dashpage.ClickPostYourProperty();
    }

    @When("the user toggles the property status")
    public void the_user_toggles_the_property_status() {
    	try {
            WaitForVisibiltyOfElement(70, Pages.postpage.getToggle());
            Pages.postpage.ClickOnToggle();
        } catch (StaleElementReferenceException e) {
            // If it goes stale, try one more time - the second time it will be fresh
            WaitForVisibiltyOfElement(70, Pages.postpage.getToggle());
            Pages.postpage.ClickOnToggle();
        }
    }

    @Then("the user should see no property listing options")
    public void the_user_should_no_the_property_listing_options() {
        WaitForVisibiltyOfElement(70, Pages.postpage.getNoPropertyContentField());
        Assert.assertTrue(Pages.postpage.getNoPropertyContentField().isDisplayed(), "Active Property is Present");
    }
}