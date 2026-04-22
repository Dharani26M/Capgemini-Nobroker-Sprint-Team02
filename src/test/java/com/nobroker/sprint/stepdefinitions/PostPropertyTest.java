package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostPropertyTest extends AllUtilities {
	private BaseClass base;

	public PostPropertyTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);

	}

	@When("User clicks on Post Your Property button")
	public void user_clicks_on_post_your_property_button() {
		WaitForAllElements(20);
		Pages.get().PostProperty.getMenu().click();
		AllUtilities.info("Clicking on menu");
		Pages.get().PostProperty.getPropertylink().click();
		AllUtilities.info("Clicking on 'Post Your Property' link");

	}

	@When("User Click PostNow")
	public void user_click_post_now() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WaitForToBeClickableOfElement(20, Pages.get().PostProperty.getPostNowBtn());

		scrollToElement(Pages.get().PostProperty.getPostNowBtn());

		try {
			Pages.get().PostProperty.getPostNowBtn().click(); // normal click
		} catch (Exception e) {
			// fallback JS click (important)
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Pages.get().PostProperty.getPostNowBtn());
		}

		AllUtilities.info("Clicking on 'Post Now' button");
	}

	@When("User click SelectCity")
	public void user_click_select_city() {
//		WaitForAllElements(30);

		scrollToElement(Pages.get().PostProperty.getSelectCity());
		Pages.get().PostProperty.getSelectCity().click();

		WaitForAllElements(30);
		navigateDownDropdown(Pages.get().PostProperty.getSelectCity(), 1, 10);
		AllUtilities.info("City selected successfully");
	}

	@When("User click StartPosting")
	public void user_click_start_posting() {
		Pages.get().PostProperty.getPost().click();
		Pages.get().PostProperty.getclick().click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WaitForToBeClickableOfElement(5, Pages.get().PostProperty.getYes());

			scrollToElement(Pages.get().PostProperty.getYes());
			Pages.get().PostProperty.getYes().click();

			System.out.println("Popup handled");

		} catch (Exception e) {
			System.out.println("Popup not present, continuing...");
		}

		AllUtilities.info("Clicking on Start Posting");

	}

	@When("User click the preview")
	public void user_click_the_preview() {
		Pages.get().PostProperty.getPreview().click();
		AllUtilities.info("Clicking on Preview button");
	}

	@Then("User should be navigated to the preview page")
	public void user_should_be_navigated_to_the_preview_page() {
		Assert.assertTrue(base.driver.getCurrentUrl().contains("manage/rent"));
		AllUtilities.info("User successfully navigated to preview page");
	}

}
