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

//	@Given("the user has successfully logged into the application")
//	public void the_user_has_successfully_logged_into_the_application() {
//		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
//		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
//	}

	@When("User clicks on Home tile")
	public void user_clicks_on_home_tile() throws InterruptedException {
		Pages.homecleaning.getMenu().click();
		WaitForAllElements(20);
		scrollToElement(Pages.homecleaning.getPaintandClean());
		Pages.homecleaning.getPaintandClean().click();
	}

	@When("User selects Home Cleaning option")
	public void user_selects_home_cleaning_option() {
		WaitForAllElements(20);
		WebElement Location = Pages.homecleaning.getLocation();
		scrollToElement(Location);
		WaitForToBeClickableOfElement(20, Location);
		Location.click();
		WaitForAllElements(20);
		WebElement element = Pages.homecleaning.getHomeCleaningOption();
		scrollToElement(element);
		WaitForToBeClickableOfElement(20, element);
		element.click();
	}
	
	@When("User selects Weekly Cleaning service")
	public void user_selects_weekly_cleaning_service() {
		WaitForAllElements(20);
		WebElement element = Pages.homecleaning.getWeeklyCleaning();
		scrollToElement(element);
		WaitForToBeClickableOfElement(20, element);
		element.click();
	}

	@When("User selects number of bathrooms")
	public void user_selects_number_of_bathrooms() {
		WaitForAllElements(20);
		scrollToElement(Pages.homecleaning.getNoOfBathrooms());
		Pages.homecleaning.getNoOfBathrooms().click();
	}

	@When("User selects frequency as Once in {int} weeks")
	public void user_selects_frequency_as_once_in_weeks(Integer int1) {
		Pages.homecleaning.getOnceInTwoWeeks().click();
	}

	@When("User clicks on Proceed button")
	public void user_clicks_on_proceed_button() {
		Pages.homecleaning.getProceedButton().click();
	}

	@Then("Bathroom Clean Page should be displayed")
	public void bathroom_clean_page_should_be_displayed() {
		WaitForAllElements(30);
		Assert.assertTrue(driver.getCurrentUrl().contains("bathroom-cleaning"),
		        "User is NOT on Home Cleaning page");
	}
}
