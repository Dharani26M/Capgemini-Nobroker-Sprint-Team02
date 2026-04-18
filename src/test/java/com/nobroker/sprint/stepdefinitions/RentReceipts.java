package com.nobroker.sprint.stepdefinitions;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RentReceipts extends AllUtilities {

	private BaseClass base;

	public RentReceipts(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}

	@Given("user has successfully logged in the app")
	public void user_has_successfully_logged_in_the_app() {
		WaitForVisibiltyOfElement(90, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
	
	@When("the user navigates to the Rent Receipts section")
	public void the_user_navigates_to_the_rent_receipts_section() {
		Pages.dashpage.ClickRentReceipts();
	}

	@When("the user fills the rent receipt form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void the_user_fills_the_rent_receipt_form(String tName, String oName, String tPhone, String oPhone,
			String rent, String pan, String addr, String oAddr, String email) {
		Pages.rentpage.CompleteGenerateRent(tName, oName, tPhone, oPhone, rent, pan, addr, oAddr, email);
	}

	@When("the user clicks on Generate Receipt")
	public void the_user_clicks_on_generate_receipt() {
		Pages.rentpage.getGenerateBtn().click();
	}

	@When("the user clicks on Download Receipt")
	public void the_user_clicks_on_download_receipt() {
		WaitForVisibiltyOfElement(90, Pages.rentpage.getDownloadBtn());
		Pages.rentpage.getDownloadBtn().click();
	}

	@Then("the page should navigate to a URL containing {string}")
	public void the_page_should_navigate_to_a_url_containing(String pdfurl) {
		SwitchWindowUsingUrl(pdfurl);
		Assert.assertTrue(FetchApplicationUrl().contains(pdfurl), "Failed to Navigate");
	}
}