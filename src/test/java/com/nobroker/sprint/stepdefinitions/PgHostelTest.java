package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.CareersPage;
import com.nobroker.sprint.pages.PG_HostelPage;
import com.nobroker.sprint.utils.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PgHostelTest extends AllUtilities {
	private BaseClass base;
	Actions action;

	public PgHostelTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
		this.action = new Actions(driver);
	}

	@When("User clicks on the location field and enters location")
	public void user_clicks_on_the_location_field_and_enters_location() {
		WaitForAllElements(40);
		Pages.get().PgHostel.getLocation().click();
		navigateDownDropdown(Pages.get().PgHostel.getLocation(), 3, 10);

	}

	@When("User selects the locality {string}")
	public void user_selects_the_locality(String locality) throws InterruptedException {

		WebElement localityField = Pages.get().PgHostel.getSearchLocality();
		localityField.click();
		localityField.sendKeys(locality);
		Thread.sleep(2000);
		navigateDownDropdown(localityField, 1, 60);
	}

	@When("User clicks on PG Hostel tab")
	public void user_clicks_on_pg_hostel_tab() {
		WaitForAllElements(20);
		Pages.get().PgHostel.getPg().click();
	}

	@When("User clicks the Search button")
	public void user_clicks_the_search_button() {
		Pages.get().PgHostel.getSearch().click();

	}

	@When("User clicks the filters")
	public void user_clicks_the_filters() {

	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getSorting());
	    Pages.get().PgHostel.getSorting().click();
	    navigateDownDropdown(Pages.get().PgHostel.getSorting(), 2, 10);

	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getFemale());
	    Pages.get().PgHostel.getFemale().click();
	    
	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getRoom());
	    Pages.get().PgHostel.getRoom().click();
	  
	    
	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getPreference());
	    Pages.get().PgHostel.getPreference().click();
	    
	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getBreakfast());
	    Pages.get().PgHostel.getBreakfast().click();
	    
	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getDinnner());
	    Pages.get().PgHostel.getDinnner().click();

	    scrollToElement(Pages.get().PgHostel.getShortlist());

	    WaitForToBeClickableOfElement(20, Pages.get().PgHostel.getShortlist());
	    Pages.get().PgHostel.getShortlist().click();


	    
//	    WaitForToBeClickableOfElement(20, Pages.PgHostel.getclose());
//	    Pages.PgHostel.getclose().click();
	    

	}
	@Then("The shortlist page should be displayed")
	public void the_shortlist_page_should_be_displayed() throws InterruptedException {
//		System.out.println("pass");
//		Thread.sleep(3000);
		   Assert.assertTrue(driver.getCurrentUrl().contains("my_shortlist_header"), 
			        "Shortlist page is NOT displayed. Current URL: " +driver.getCurrentUrl() );
	}

}
