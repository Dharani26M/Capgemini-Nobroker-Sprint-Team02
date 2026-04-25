package com.nobroker.sprint.stepdefinitions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.ExcelUtilities;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeProfile extends AllUtilities {

    private BaseClass base;

    public NegativeProfile(BaseClass base) throws EncryptedDocumentException, IOException {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @Given("the user has log into the application")
    public void the_user_has_log_into_the_application() {
        WaitForVisibiltyOfElement(20, Pages.get().dashpage.getProfileImg());
        Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
        AllUtilities.info("User is logged in – profile image visible");
    }

    @Given("the user navigates has the Profile page")
    public void the_user_navigates_has_the_profile_page() {
        Pages.get().dashpage.getProfileImg().click();
        Pages.get().dashpage.getProfileFeature().click();
        AllUtilities.info("Navigated to Profile page");
    }

    @When("the user updates the profile name")
    public void the_user_updates_the_profile_name() {
        String dataFromExcel = ExcelUtilities.getExcelData("Sheet1", 1, 1);
        Pages.get().profilepage.setupUserName(dataFromExcel);
        AllUtilities.info("Profile name updated with invalid data: " + dataFromExcel);
    }

    @Then("an error message should be displayed indicating an invalid name format")
    public void an_error_message_should_be_displayed_indicating_an_invalid_name_format() {
        WaitForVisibiltyOfElement(20, Pages.get().profilepage.getErrorMsg());
        Assert.assertTrue(Pages.get().profilepage.getErrorMsg().isDisplayed(),
                "Invalid message is not showing");
        AllUtilities.info("Error message is displayed for invalid name format");
    }

    @Then("the profile changes should not be saved")
    public void the_profile_changes_should_not_be_saved() {
        String invalidNameFromExcel = ExcelUtilities.getExcelData("Sheet1", 1, 1);
        driver.navigate().refresh();
        Pages.get().dashpage.getProfileImg().click();
        Pages.get().dashpage.getProfileFeature().click();
        String actualName = Pages.get().profilepage.getUserName().getAttribute("value");
        Assert.assertNotEquals(actualName, invalidNameFromExcel,
                "BUG: The application saved an invalid name format");
        AllUtilities.info("Confirmed: invalid name was NOT persisted after refresh");
    }
}
