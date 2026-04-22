package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.CareersPage;
import com.nobroker.sprint.pages.HomeCleaningPage;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareersTest extends AllUtilities {
	private BaseClass base;

	public CareersTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);

	}

	@When("User clicks on menu button")
	public void user_clicks_on_menu_button() {
		Pages.get().Careers.getMenu().click();
		AllUtilities.info("Menu button clicked successfully");

	}

	@When("User clicks on Careers option from menu")
	public void user_clicks_on_careers_option_from_menu() {
		WaitForToBeClickableOfElement(20, Pages.get().Careers.getCareersLink());
		Pages.get().Careers.getCareersLink().click();
		AllUtilities.info("Careers option clicked successfully");
	}

	@Then("Careers page should be displayed")
	public void careers_page_should_be_displayed() {

		Assert.assertTrue(driver.getCurrentUrl().contains("careers"));
		AllUtilities.info("Careers page validation successful");
	}

	@When("User clicks on See all opportunities button")
	public void user_clicks_on_see_all_opportunities_button() {
		Pages.get().Careers.getSeeAllOpportunities().click();
		AllUtilities.info("'See all opportunities' button clicked");

	}

	@Then("User should be redirected to LinkedIn page")
	public void user_should_be_redirected_to_linked_in_page() {
		SwitchWindowUsingUrl("linkedin");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("linkedin"));
		AllUtilities.info("Successfully redirected to LinkedIn page");
	}
}
