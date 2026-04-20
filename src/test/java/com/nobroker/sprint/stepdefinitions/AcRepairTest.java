package com.nobroker.sprint.stepdefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcRepairTest extends AllUtilities{

	   
	
	@When("User clicks on the {string} icon")
	public void user_clicks_on_the_icon(String string) {
		scrollToElement(Pages.acrepair.getPaintIcon());
		Pages.acrepair.getPaintIcon().click();
    	
	    
	}
	@When("User verifies the location is {string}")
	public void user_verifies_the_location_is(String string) {
		SwitchWindowUsingTitle("NoBroker");
		WaitForToBeClickableOfElement(20,Pages.acrepair.getLocation());
		Pages.acrepair.getLocation().click();
	   
	}
	@When("User clicks on {string} section")
	public void user_clicks_on_section(String string) {
		scrollToElement(Pages.acrepair.getAcSection());
		Pages.acrepair.getAcSection().click();
		
	  
	}
	@When("User clicks on {string} option")
	public void user_clicks_on_option(String string) {
		WaitForAllElements(20);
		WebElement element = Pages.acrepair.getAplianceRepair();
		scrollToElement(element);
		WaitForToBeClickableOfElement(20, element);
		element.click();
	    
	}
	@When("User clicks on {string} category")
	public void user_clicks_on_category(String string) throws InterruptedException {
		scrollToElement(Pages.acrepair.getfrige());
		Thread.sleep(6000);
		Pages.acrepair.getfrige().click();
	  
	}
	@When("User clicks on {string} for Microwave Repair")
	public void user_clicks_on_for_microwave_repair(String string) {
		scrollToElement(Pages.acrepair.getDetails());
		Pages.acrepair.getDetails().click();
		
	 
	}
	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) {
		scrollToElement(Pages.acrepair.getAdd());
		Pages.acrepair.getAdd().click();
		scrollToElement(Pages.acrepair.getProceed());
		Pages.acrepair.getProceed().click();
	   
	}
	@Then("User should be navigated to the booking page")
	public void user_should_be_navigated_to_the_booking_page() {
		String currentUrl = FetchApplicationUrl();
        Assert.assertTrue(currentUrl.contains("booking") || currentUrl.contains("checkout"),
            "❌ User is NOT on booking page. Current URL: " + currentUrl);
        System.out.println("✅ User is on booking page: " + currentUrl);
	   
	}


}
