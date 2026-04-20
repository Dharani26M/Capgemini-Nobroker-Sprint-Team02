package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
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

	@Given("the user has successfully logged into the application")
	public void the_user_has_successfully_logged_into_the_application() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}

	@When("User clicks on Post Your Property button")
	public void user_clicks_on_post_your_property_button() {
		WaitForAllElements(20);
		Pages.PostProperty.getMenu().click();
		Pages.PostProperty.getPropertylink().click();

	}

	@When("User Click PostNow")
	public void user_click_post_now() {
		WaitForAllElements(20);
		scrollToElement(Pages.PostProperty.getPostNowBtn());
		Pages.PostProperty.getPostNowBtn().click();

	}

	@When("User click SelectCity")
	public void user_click_select_city() {
		WaitForAllElements(30);
		scrollToElement(Pages.PostProperty.getSelectCity());
		Pages.PostProperty.getSelectCity().click();

		WaitForAllElements(30);
		navigateDownDropdown(Pages.PostProperty.getSelectCity(), 1, 10);

	}

	@When("User click StartPosting")
	public void user_click_start_posting() {
		Pages.PostProperty.getPost().click();

	}

	@When("User Enters the Property Details")
	public void user_enters_the_property_details() {
		WaitForAllElements(60);
		scrollToElement(Pages.PostProperty.getNotification());
		Pages.PostProperty.getNotification().click();

		Pages.PostProperty.getApartmentType().click();
		navigateDownDropdown(Pages.PostProperty.getApartmentType(), 1, 10);

		Pages.PostProperty.getBHK().click();
		navigateDownDropdown(Pages.PostProperty.getBHK(), 1, 10);

		Pages.PostProperty.getFloor().click();
		navigateDownDropdown(Pages.PostProperty.getFloor(), 1, 10);

		Pages.PostProperty.getTotalFloor().click();
		navigateDownDropdown(Pages.PostProperty.getTotalFloor(), 1, 10);

		Pages.PostProperty.getPropertyAge().click();
		navigateDownDropdown(Pages.PostProperty.getPropertyAge(), 1, 10);

		Pages.PostProperty.getPropertyFacing().click();
		navigateDownDropdown(Pages.PostProperty.getPropertyFacing(), 1, 10);

		Pages.PostProperty.getSize().click();
		Pages.PostProperty.getSize().sendKeys("100");
		Pages.PostProperty.getNotification1().click();

	}

	@When("User Enters the Location")
	public void user_enters_the_location() {
		Pages.PostProperty.getCity().click();
		navigateDownDropdown(Pages.PostProperty.getCity(), 5, 10);
		Pages.PostProperty.getLocality().sendKeys("Porur");
		navigateDownDropdown(Pages.PostProperty.getLocality(), 1, 10);

		Pages.PostProperty.getStreet().sendKeys("Sivan Kovil");
	}

	@When("User click the preview")
	public void user_click_the_preview() {
		Pages.PostProperty.getPreview().click();

	}

	@Then("User should be navigated to the preview page")
	public void user_should_be_navigated_to_the_preview_page() {
		Assert.assertTrue(base.driver.getCurrentUrl().contains("manage/rent"));
	}

}
