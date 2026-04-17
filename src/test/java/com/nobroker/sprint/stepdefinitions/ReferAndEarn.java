package com.nobroker.sprint.stepdefinitions;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import com.nobroker.sprint.utils.AllUtilities;
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
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
    
    @When("the user navigates to the Refer and Earn section")
    public void the_user_navigates_to_the_refer_and_earn_section() {
        Pages.dashpage.ClickReferAndEarn();
        Pages.referpage.ClickOwnerDetails();
    }

    @When("the user enters owner details for referral:")
    public void the_user_enters_owner_details_for_referral(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        Pages.referpage.EnterDetails(base.driver, row.get("City"), row.get("Phone"), row.get("Name"), row.get("PropType"), row.get("Description"));
    }

    @Then("the referral details should be submitted")
    public void the_referral_details_should_be_submitted() {
        WaitForVisibiltyOfElement(20, Pages.referpage.getSendBtn());
        Assert.assertTrue(Pages.referpage.getSendBtn().isDisplayed(), "Button is displayed");
    }
}