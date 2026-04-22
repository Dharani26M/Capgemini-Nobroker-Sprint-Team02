package com.nobroker.sprint.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReferAndEarn extends AllUtilities {

    private BaseClass base;

    public ReferAndEarn(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @Given("the user has successfully logged into the app")
    public void the_user_has_successfully_logged_into_the_app() {
        WaitForVisibiltyOfElement(90, Pages.get().dashpage.getProfileImg());
        Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
        AllUtilities.info("User is logged in – profile image is visible");
    }

    @When("the user navigates to the Refer and Earn section")
    public void the_user_navigates_to_the_refer_and_earn_section() {
        Pages.get().dashpage.ClickReferAndEarn();
        AllUtilities.info("Navigated to Refer and Earn section");
    }

    @When("the user enters owner details for referral:")
    public void the_user_enters_owner_details_for_referral(DataTable dataTable) {
        WaitForVisibiltyOfElement(60, Pages.get().dashpage.getProfileImg());
        Pages.get().referpage.ClickOwnerDetails();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        Pages.get().referpage.EnterDetails(
            base.driver,
            row.get("City"), row.get("Phone"),
            row.get("Name"), row.get("PropType"), row.get("Description")
        );
        AllUtilities.info("Owner details entered: " + row.toString());
    }

    @Then("the referral details should be submitted")
    public void the_referral_details_should_be_submitted() {
        Assert.assertTrue(FetchApplicationUrl().contains("refer"), "Button is displayed");
        AllUtilities.info("Referral form submitted – URL contains 'refer'");
    }
}
