package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.HomeCleaningPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeCleaning {

	HomeCleaningPage HP;
	WebDriver driver;

	public HomeCleaning() {

		driver = Hooks.driver; // get driver from Hooks

		HP = new HomeCleaningPage(driver); // initialize page class

	}

	@When("User clicks on Home tile")
	public void user_clicks_on_home_tile() {
		HP.getHomeTile().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		String parent = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);
			}
		}

		HP.getLocation().click();
	}

	@When("User selects Home Cleaning option")
	public void user_selects_home_cleaning_option() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Home Cleaning')]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@When("User selects Weekly Cleaning service")
	public void user_selects_weekly_cleaning_service() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By weeklyCleaning = By.xpath("//*[contains(text(),'Weekly')]");

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(weeklyCleaning));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@When("User selects number of bathrooms as {int}")
	public void user_selects_number_of_bathrooms_as(Integer num) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By bathrooms = By.xpath("//button[.='" + num + "']");

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(bathrooms));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@When("User selects frequency as Once in {int} weeks")
	public void user_selects_frequency_as_once_in_weeks(Integer int1) {
		HP.getOnceInTwoWeeks().click();

	}

	@When("User clicks on Proceed button")
	public void user_clicks_on_proceed_button() {
		HP.getProceedButton().click();

	}

	@Then("Mobile number popup should be displayed")
	public void mobile_number_popup_should_be_displayed() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement popup = wait.until(ExpectedConditions.visibilityOf(HP.getMobilePopupTitle()));
		Assert.assertTrue(popup.isDisplayed(), "Mobile number popup is not displayed");
	}

}
