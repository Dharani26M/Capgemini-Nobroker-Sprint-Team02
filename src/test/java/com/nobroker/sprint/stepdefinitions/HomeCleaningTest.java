package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class HomeCleaningTest extends AllUtilities {

	private BaseClass base;

	public HomeCleaningTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}

	@When("User clicks on Home tile")
	public void user_clicks_on_home_tile() throws InterruptedException {
		Pages.get().homecleaning.getMenu().click();
		 AllUtilities.info("Clicking on Menu button");
		WaitForAllElements(20);
		scrollToElement(Pages.get().homecleaning.getPaintandClean());
		Pages.get().homecleaning.getPaintandClean().click();
		 AllUtilities.info("Clicking on Paint and Clean option");
	}

	@When("User selects Home Cleaning option")
	public void user_selects_home_cleaning_option() {
		WaitForAllElements(20);
		WebElement Location = Pages.get().homecleaning.getLocation();
		scrollToElement(Location);
		WaitForToBeClickableOfElement(20, Location);
		Location.click();
		 AllUtilities.info("Clicking on Location");
		WaitForAllElements(20);
		WebElement element = Pages.get().homecleaning.getHomeCleaningOption();
		scrollToElement(element);
		WaitForToBeClickableOfElement(20, element);
		element.click();
		AllUtilities.info("Clicking on Home Cleaning option");
	}

	@When("User selects Weekly Cleaning service")
	public void user_selects_weekly_cleaning_service() {
		WaitForAllElements(20);
		WebElement element = Pages.get().homecleaning.getWeeklyCleaning();
		scrollToElement(element);
		WaitForToBeClickableOfElement(20, element);
		element.click();

        AllUtilities.info("Weekly Cleaning service selected");
	}

	@When("User selects number of bathrooms")
	public void user_selects_number_of_bathrooms() {
		WaitForAllElements(20);
		scrollToElement(Pages.get().homecleaning.getNoOfBathrooms());
		Pages.get().homecleaning.getNoOfBathrooms().click();
		 AllUtilities.info("Number of bathrooms selected");
	}

	@When("User selects frequency as Once in {int} weeks")
	public void user_selects_frequency_as_once_in_weeks(Integer int1) {
		Pages.get().homecleaning.getOnceInTwoWeeks().click();
		AllUtilities.info("Frequency selected successfully");
	}

	@When("User clicks on Proceed button")
	public void user_clicks_on_proceed_button() {
		Pages.get().homecleaning.getProceedButton().click();
		 AllUtilities.info("Proceed button clicked");
	}

	@Then("Bathroom Clean Page should be displayed")
	public void bathroom_clean_page_should_be_displayed() {
		WaitForAllElements(30);
		Assert.assertTrue(driver.getCurrentUrl().contains("bathroom-cleaning"), "User is NOT on Home Cleaning page");
		AllUtilities.info("Bathroom Cleaning page displayed successfully");
	}
}
