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
import io.cucumber.java.en.When;

public class PgHostelTest extends AllUtilities {
	private BaseClass base;
	Actions action;

	public PgHostelTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
		this.action = new Actions(driver);
	}
//	@Given("the user has successfully logged into the application")
//	public void the_user_has_successfully_logged_into_the_application() {
//		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
//		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
//	}

	@When("User clicks on the location field and enters location")
	public void user_clicks_on_the_location_field_and_enters_location() {
		WaitForAllElements(40);
		Pages.get().PgHostel.getLocation().click();
		navigateDownDropdown(Pages.PgHostel.getLocation(), 3, 10);

	}

	@When("User selects the locality {string}")
	public void user_selects_the_locality(String locality) throws InterruptedException {

		WebElement localityField = Pages.PgHostel.getSearchLocality();
		localityField.click();
		localityField.sendKeys(locality);
		Thread.sleep(2000);
		navigateDownDropdown(localityField, 1, 60);
	}

	@When("User clicks on PG Hostel tab")
	public void user_clicks_on_pg_hostel_tab() {
		WaitForAllElements(20);
		Pages.PgHostel.getPg().click();
	}

	@When("User clicks the Search button")
	public void user_clicks_the_search_button() {
		Pages.PgHostel.getSearch().click();
		

	}

	@When("User clicks the filters")
	public void user_clicks_the_filters() throws InterruptedException  {
		Pages.PgHostel.getSorting().click();
		Thread.sleep(2000);
		navigateDownDropdown(Pages.PgHostel.getSorting(), 2, 10);
		scrollToElement(Pages.PgHostel.getShortlist());
		WaitForToBeClickableOfElement(20, Pages.PgHostel.getShortlist());
		Pages.PgHostel.getShortlist().click();
		Pages.PgHostel.getclick().click();
		SwitchWindowUsingUrl("pg-hostel");
		Pages.PgHostel.getOwner().click();

		
	}

}
