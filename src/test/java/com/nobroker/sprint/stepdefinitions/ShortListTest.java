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
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
	@When("user clicks MyDashBoard")
	public void user_clicks_my_dash_board() {
		   WaitForToBeClickableOfElement(10, Pages.shortlist.getIcon());
	       Pages.shortlist.setIcon();
	       
	       WaitForToBeClickableOfElement(10, Pages.shortlist. getDashBoard());
	       Pages.shortlist.setDashBoard();
	      
	    
	}
	@When("clicks shortlist")
	public void clicks_shortlist() {
		 WaitForToBeClickableOfElement(10, Pages.shortlist.getShortList());
	       Pages.shortlist.setShortList();
	      
	    
	}
	@When("your shortlistand clicks sales")
	public void your_shortlistand_clicks_sales() {

	       
	       WaitForToBeClickableOfElement(10, Pages.shortlist.getYourShortlist());
	       Pages.shortlist.setYourShortlist();
	       
			 WaitForToBeClickableOfElement(10, Pages.shortlist.getSaleshortlisttab());
	       Pages.shortlist.setSaleshortlisttab();
	    
	}
	@Then("verify property available")
	public void verify_property_available() {
		WaitForToBeClickableOfElement(10, Pages.shortlist.getSale());
	       Pages.shortlist.getSale().click();;
		List<WebElement> cards = driver.findElements(
			    By.xpath("//button[contains(text(),'Get Owner Details')]")
			);

			Assert.assertTrue(cards.size() > 0, "No properties displayed");
			System.out.println("Properties found: " + cards.size());
	}

}
