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
		WaitForVisibiltyOfElement(20, Pages.get().dashpage.getProfileImg());
		Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
	}

	@When("User clicks on Post Your Property button")
	public void user_clicks_on_post_your_property_button() {
		WaitForAllElements(20);
		Pages.get().postPage.getMenu().click();
		Pages.get().postPage.getPropertylink().click();

	}

	@When("User Click PostNow")
	public void user_click_post_now() {
		WaitForToBeClickableOfElement(20,Pages.get().postPage.getPostNowBtn() );
		scrollToElement(Pages.get().postPage.getPostNowBtn());
//		WaitForToBeClickableOfElement(20,Pages.PostProperty.getPostNowBtn() );
		Pages.get().postPage.getPostNowBtn().click();

	}

	@When("User click SelectCity")
	public void user_click_select_city() {
//		WaitForAllElements(30);
		scrollToElement(Pages.get().postPage.getSelectCity());
		Pages.get().postPage.getSelectCity().click();

		WaitForAllElements(30);
		navigateDownDropdown(Pages.get().postPage.getSelectCity(), 1, 10);

	}

	@When("User click StartPosting")
	public void user_click_start_posting() {
		Pages.get().postPage.getPost().click();

	}

	@When("User Enters the Property Details")
	public void user_enters_the_property_details() {
		Pages.get().postPage.accept(driver);

		scrollToElement(Pages.get().postPage.getNotification());
		Pages.get().postPage.getNotification().click();

		Pages.get().postPage.getApartmentType().click();
		navigateDownDropdown(Pages.get().postPage.getApartmentType(), 1, 10);

		Pages.get().postPage.getBHK().click();
		navigateDownDropdown(Pages.get().postPage.getBHK(), 1, 10);

		Pages.get().postPage.getFloor().click();
		navigateDownDropdown(Pages.get().postPage.getFloor(), 1, 10);

		Pages.get().postPage.getTotalFloor().click();
		navigateDownDropdown(Pages.get().postPage.getTotalFloor(), 1, 10);

		Pages.get().postPage.getPropertyAge().click();
		navigateDownDropdown(Pages.get().postPage.getPropertyAge(), 1, 10);

		Pages.get().postPage.getPropertyFacing().click();
		navigateDownDropdown(Pages.get().postPage.getPropertyFacing(), 1, 10);

		Pages.get().postPage.getSize().click();
		Pages.get().postPage.getSize().sendKeys("100");
		Pages.get().postPage.getNotification1().click();

	}

	@When("User Enters the Location")
	public void user_enters_the_location() {
		Pages.get().postPage.getCity().click();
		navigateDownDropdown(Pages.get().postPage.getCity(), 5, 10);
		Pages.get().postPage.getLocality().sendKeys("Porur");
		navigateDownDropdown(Pages.get().postPage.getLocality(), 1, 10);

		Pages.get().postPage.getStreet().sendKeys("Sivan Kovil");
	}

	@When("User click the preview")
	public void user_click_the_preview() {
		Pages.get().postPage.getPreview().click();

	}

	@Then("User should be navigated to the preview page")
	public void user_should_be_navigated_to_the_preview_page() {
		Assert.assertTrue(base.driver.getCurrentUrl().contains("manage/rent"));
	}

}
