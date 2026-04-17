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

public class Scenario1 extends AllUtilities {
	
	private BaseClass base;

	public Scenario1(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
//1.
	@Given("the user has successfully logged into the application")
	public void the_user_has_successfully_logged_into_the_application() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
	@Given("the user navigates to the Profile page")
	public void the_user_navigates_to_the_profile_page() {
	    Pages.dashpage.getProfileImg().click();
	    Pages.dashpage.getProfileFeature().click();
	}
	@When("the user updates the profile name to {string}")
	public void the_user_updates_the_profile_name_to(String name) {
		Pages.profilepage.setupUserName(name);
	}
	@When("the user refreshes the current page")
	public void the_user_refreshes_the_current_page() {
	    RefreshCurrentpage();
	}
	@Then("the profile name should be displayed as {string}")
	public void the_profile_name_should_be_displayed_as(String expectedname) {
	    Assert.assertEquals(Pages.profilepage.getUserName().getAttribute("value"),expectedname,"profile mismatch");
	}
	
	//2.
	@Then("an error message should be displayed indicating an invalid name format")
	public void an_error_message_should_be_displayed_indicating_an_invalid_name_format() {
	    WaitForVisibiltyOfElement(20, Pages.profilepage.getErrorMsg());
	    Assert.assertTrue(Pages.profilepage.getErrorMsg().isDisplayed(),"Invalid message is not showing");
	}
	@Then("the profile changes should not be saved {string}")
	public void the_profile_changes_should_not_be_saved(String passingname) {
	    Assert.assertNotEquals(Pages.profilepage.getUserName().getAttribute("value"), passingname,"Invalid Name is saved to th profile");
	}
	
	//3.
	@When("the user clicks on Post Your Property from the menu")
	public void the_user_clicks_on_post_your_property_from_the_menu() {
	    Pages.profilepage.ClickPostYourProperty();
	}
	@When("the user toggles the property status")
	public void the_user_toggles_the_property_status() {
	    WaitForVisibiltyOfElement(20,Pages.postpage.getToggle());
	    Pages.postpage.ClickOnToggle();
	}
	@Then("the user should see no property listing options")
	public void the_user_should_no_the_property_listing_options() {
	   WaitForVisibiltyOfElement(20, Pages.postpage.getNoPropertyContentField());
	   Assert.assertTrue(Pages.postpage.getNoPropertyContentField().isDisplayed(),"Active Property is Present");
	}
	
	
	// 4.
	
	@When("the user navigates to the Rent Receipts section")
	public void the_user_navigates_to_the_rent_receipts_section() {
	    Pages.profilepage.ClickRentReceipts();
	}
	@When("the user fills the rent receipt form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void the_user_fills_the_rent_receipt_form(String tName, String oName, String tPhone, String oPhone, String rent, String pan, String addr, String oAddr, String email) {
        Pages.rentpage.CompleteGenerateRent(tName, oName, tPhone, oPhone, rent, pan, addr, oAddr, email);
    }
	@When("the user clicks on Generate Receipt")
	public void the_user_clicks_on_generate_receipt() {
	    Pages.rentpage.getGenerateBtn().click();
	}
	@When("the user clicks on Download Receipt")
	public void the_user_clicks_on_download_receipt() {
	    WaitForVisibiltyOfElement(20,Pages.rentpage.getDownloadBtn());
	    Pages.rentpage.getDownloadBtn().click();
	}
	@Then("the page should navigate to a URL containing {string}")
	public void the_page_should_navigate_to_a_url_containing(String pdfurl) {
		SwitchWindowUsingUrl(pdfurl);
		Assert.assertTrue(FetchApplicationUrl().contains(pdfurl),"Failed to Navigate");
	    
	}
	
	//5.
	
	@When("the user navigates to the Painting and Cleaning section")
	public void the_user_navigates_to_the_painting_and_cleaning_section() {
	    Pages.profilepage.ClickPaintingsAndCleaning();
	}
	@When("the user selects the city {string} for cleaning services")
	public void the_user_selects_the_city_for_cleaning_services(String city) {
		Pages.paintpage.SelectingCity(driver, city);
	}
	@When("the user selects Interior and Renovation")
	public void the_user_selects_interior_and_renovation() {
	    Pages.paintpage.SelectingHomeServices(driver);
	}
	@When("the user schedules a visit for Home Interiors")
	public void the_user_schedules_a_visit_for_home_interiors() {
		Pages.homeinteriorpage.ClickOnScheduleVisit(base.driver);
	}
	@Then("the share button should be visible on the interiors page")
	public void the_share_button_should_be_visible_on_the_interiors_page() {
		WaitForVisibiltyOfElement(20, Pages.homeinteriorpage.getShareBtn());
	    Assert.assertTrue(Pages.homeinteriorpage.getShareBtn().isDisplayed(), "Share button is not visible");
	}
	
	//6.
	
	@When("the user navigates to the Refer and Earn section")
	public void the_user_navigates_to_the_refer_and_earn_section() {
	    Pages.profilepage.ClickReferAndEarn();
	    Pages.referpage.ClickEnterOwnerDetails();
	}
	@When("the user enters owner details for referral:")
	public void the_user_enters_owner_details_for_referral(DataTable dataTable) {
	    List<Map<String,String>> data=dataTable.asMaps(String.class ,String.class);
	    Map<String, String> row = data.get(0);
		Pages.referpage.ClickEnterOwnerDetails();
		Pages.referpage.EnterDetails(base.driver, 
			row.get("City"), 
			row.get("Phone"), 
			row.get("Name"), 
			row.get("PropType"), 
			row.get("Description")
		);
	}
	
	@Then("the referral details should be submitted")
	public void the_referral_details_should_be_submitted() {
		WaitForVisibiltyOfElement(20, Pages.referpage.getSendBtn());
		Assert.assertTrue(Pages.referpage.getSendBtn().isDisplayed(), "Button is displayed");
	}
	
	
}