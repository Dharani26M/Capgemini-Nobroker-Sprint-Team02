package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import com.nobroker.sprint.utils.AllUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaintingsAndCleanings extends AllUtilities {
    private BaseClass base;

    public PaintingsAndCleanings(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }
    
    @Given("the user has successfully logged into application")
	public void the_user_has_successfully_logged_into_application() {
		WaitForVisibiltyOfElement(80, Pages.get().dashpage.getProfileImg());
		Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
	}

    @When("the user navigates to the Painting and Cleaning section")
    public void the_user_navigates_to_the_painting_and_cleaning_section() {
        Pages.get().dashpage.ClickPaintingsAndCleaning();
    }

    @When("the user selects the city {string} for cleaning services")
    public void the_user_selects_the_city_for_cleaning_services(String city) {
        Pages.get().paintpage.SelectingCity(driver, city);
    }

    @When("the user selects Interior and Renovation")
    public void the_user_selects_interior_and_renovation() {
        Pages.get().paintpage.SelectingHomeServices(driver);
    }

    @When("the user schedules a visit for Home Interiors")
    public void the_user_schedules_a_visit_for_home_interiors() {
        SwitchWindowUsingUrl("interiors");
        Pages.get().homeinteriorpage.ClickOnScheduleVisit(base.driver);
    }

    @Then("the share button should be visible on the interiors page")
    public void the_share_button_should_be_visible_on_the_interiors_page() {
        WaitForVisibiltyOfElement(80, Pages.get().homeinteriorpage.getShareBtn());
        Assert.assertTrue(Pages.get().homeinteriorpage.getShareBtn().isDisplayed(), "Share button is not visible");
    }
}