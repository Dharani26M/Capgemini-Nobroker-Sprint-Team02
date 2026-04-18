package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewIcon extends AllUtilities {

    private BaseClass base;

    public NewIcon(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @When("the user clicks on the {string} icon in the header")
    public void the_user_clicks_on_the_icon_in_the_header(String iconName) {
        Pages.dashpage.clickNewIcon(base.driver);
    }

    @Then("the user should be redirected to the NoBroker Rewards page")
    public void the_user_should_be_redirected_to_the_no_broker_rewards_page() {
        SwitchWindowUsingUrl("rewards");
        WaitForVisibiltyOfElement(20, Pages.iconpage.getbuybtn());
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        String actualTitle = FetchApplicationTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), 
            "Title mismatch! Expected to contain: " + expectedTitle + " but found: " + actualTitle);
    }

    @When("the user clicks on the Buy VIP button")
    public void the_user_clicks_on_the_buy_vip_button() {
        WaitForToBeClickableOfElement(20, Pages.iconpage.getbuybtn());
        Pages.iconpage.clickBuyBtn();
    }

    @Then("the user should navigate to the NoBroker VIP Memberships page")
    public void the_user_should_navigate_to_the_no_broker_vip_memberships_page() {
        WaitForAllElements(10); 
    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String expectedUrlPart) {
        String actualUrl = FetchApplicationUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlPart), 
            "URL mismatch! Expected to contain: " + expectedUrlPart + " but found: " + actualUrl);
    }

}