package com.nobroker.sprint.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShortListTest extends AllUtilities{
	@Given("user logged in for shortlisting")
	public void user_opens_the_browser() {
		WaitForVisibiltyOfElement(20, Pages.get().dashpage.getProfileImg());
		Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
		AllUtilities.info("User successfully logged in: Profile image is visible.");
	}
	@When("user clicks MyDashBoard")
	public void user_clicks_my_dash_board() {
		   WaitForToBeClickableOfElement(10, Pages.get().shortlist.getIcon());
	       Pages.get().shortlist.setIcon();
	       AllUtilities.info("Clicked on the User Profile icon.");
	       WaitForToBeClickableOfElement(10, Pages.get().shortlist. getDashBoard());
	       Pages.get().shortlist.setDashBoard();
	       AllUtilities.info("Selected 'My Dashboard' from the dropdown menu.");
	      
	    
	}
	@When("clicks shortlist")
	public void clicks_shortlist() {
		 WaitForToBeClickableOfElement(10, Pages.get().shortlist.getShortList());
	       Pages.get().shortlist.setShortList();
	       AllUtilities.info("Clicked on the 'Shortlist' option within the dashboard.");
	      
	    
	}
	@When("your shortlistand clicks sales")
	public void your_shortlistand_clicks_sales() {

	       
	       WaitForToBeClickableOfElement(10, Pages.get().shortlist.getYourShortlist());
	       Pages.get().shortlist.setYourShortlist();
	       AllUtilities.info("Navigated to the 'Your Shortlist' section.");
	       
			 WaitForToBeClickableOfElement(10, Pages.get().shortlist.getSaleshortlisttab());
	       Pages.get().shortlist.setSaleshortlisttab();
	       AllUtilities.info("Switched to the 'Sales' tab in the shortlist.");
	    
	}
	@Then("verify property available")
	public void verify_property_available() {
	    WaitForToBeClickableOfElement(10, Pages.get().shortlist.getSale());
	    Pages.get().shortlist.getSale().click();
	    AllUtilities.info("Clicked on a specific property from the Sales shortlist.");
	    
	    WebElement ownerBtn = Pages.get().shortlist.getOwnerdetails();
	    
	    WaitForVisibiltyOfElement(10, ownerBtn);

	    Assert.assertTrue(ownerBtn.isDisplayed(), "Owner Details button is not visible!");
	    AllUtilities.info("Verification Successful: 'Get Owner Details' button is displayed for the shortlisted property.");
	    
	
	}

}
