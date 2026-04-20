
package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;

import com.nobroker.sprint.pages.RentalPage;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.*;

public class RentalTest extends AllUtilities {

    private BaseClass base;

    public RentalTest(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @Given("user logged in for rental")
    public void the_user_has_logged_into_the_application() {
    	WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
        Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
    }


    @When("user clicks on Rental Agreement module")
    public void user_clicks_on_rental_agreement_module() {

        WaitForToBeClickableOfElement(20, Pages.rental.getRentalAgreementIcon());
        Pages.rental.getRentalAgreementIcon().click();

        // Switch window
        String parent = driver.getWindowHandle();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        try {
            WaitForVisibiltyOfElement(10, Pages.rental.getCityPopupInput());
            Pages.rental.getCityPopupInput().sendKeys("Chennai");

            WaitForToBeClickableOfElement(10, Pages.rental.getChennaiOption());
            Pages.rental.getChennaiOption().click();

        } catch (Exception e) {
            System.out.println("Popup not present, continuing...");
        }

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,1500)");

        WaitForToBeClickableOfElement(20, Pages.rental.getProceed());
        Pages.rental.getProceed().click();

        WaitForVisibiltyOfElement(20, Pages.rental.getUploadDraft());
        Pages.rental.getUploadDraft().click();
    }


    @When("user uploads the draft document")
    public void user_uploads_the_draft_document() {

        WaitForVisibiltyOfElement(20, Pages.rental.getUploadFile());
        Pages.rental.getUploadFile()
                .sendKeys("C:\\Users\\KARTHIKEYAN\\Desktop\\sample.pdf");
    }


    @When("user enters required contract details")
    public void user_enters_required_contract_details() {

        // City selection
        WaitForToBeClickableOfElement(20, Pages.rental.getCityDropdown());
        Pages.rental.getCityDropdown().click();

        WaitForVisibiltyOfElement(20, Pages.rental.getCitySearch());
        Pages.rental.getCitySearch().sendKeys("Chennai");

        WaitForToBeClickableOfElement(20, Pages.rental.getChennaiOption());
        Pages.rental.getChennaiOption().click();

        // Deposit
        WaitForVisibiltyOfElement(20, Pages.rental.getRefundableAmount());
        Pages.rental.getRefundableAmount().sendKeys("9999");

        // Stamp & Maintenance
        WaitForToBeClickableOfElement(20, Pages.rental.getStampPaperAmt());
        Pages.rental.getStampPaperAmt().click();

        WaitForToBeClickableOfElement(20, Pages.rental.getRadioBtnYes());
        Pages.rental.getRadioBtnYes().click();

        // Landlord details
        Pages.rental.getLandlordName().sendKeys("Owner Name");
        Pages.rental.getLandlordEmail().sendKeys("owner@gmail.com");
        Pages.rental.getLandlordPhone().sendKeys("9876543210");

        // Tenant details
        Pages.rental.getTenantName().sendKeys("Tenant Name");
        Pages.rental.getTenantEmail().sendKeys("tenant@gmail.com");
        Pages.rental.getTenantPhone().sendKeys("9123456789");

        // Owner selection
        WaitForToBeClickableOfElement(20, Pages.rental.getOwner());
        Pages.rental.getOwner().click();
    }


    @When("user clicks on Save and Continue")
    public void user_clicks_on_save_and_continue() {

        WaitForToBeClickableOfElement(20, Pages.rental.getContinueButton());
        Pages.rental.getContinueButton().click();
    }


    @Then("user should be navigated to Summary page")
    public void user_should_be_navigated_to_summary_page() {

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("summary"));
    }
}