package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoversBetweenCities extends AllUtilities {

	public MoversBetweenCities(BaseClass base) {

		this.initializeDriver(base.driver);
	}

	@When("User clicks on Packer and Mover")
	public void user_clicks_on_packer_and_mover() {

		Pages.get().dashpage.clickPackersAndMovers();
		info("User clicked on Packers and Movers");
	}

	@When("User clicks on Between City")
	public void user_clicks_on_between_city() {

		SwitchWindowUsingUrl("packers");
		waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
		Pages.get().moverspage.getBetweenCity().click();
		info("User selected Between City option");
	}

	@Then("Between City option should be selected")
	public void between_city_option_should_be_selected() {

		Assert.assertTrue(
				Pages.get().moverspage.getBetweenCities().getAttribute("style").contains("background-color:"));
		info("Between City option is successfully selected");
	}

	@When("User enters From City as {string}")
	public void user_enters_from_city_as(String FromCity) {

		Pages.get().moverspage.SelectBetweenFromcity(FromCity);

		info("User entered From City: " + FromCity);
	}

	@When("User enters To City as {string}")
	public void user_enters_to_city_as(String ToCity) {
		Pages.get().moverspage.SelectBetweenTocity(ToCity);
		info("User entered To City: " + ToCity);

	}

	@When("User select shifting date as {string}")
	public void user_select_shifting_date_as(String Date) {
		Pages.get().moverspage.SelectDate(Date);
		info("User selected shifting date: " + Date);
	}

	@When("User clicks on Check Price")
	public void user_clicks_on_check_price() {
		Pages.get().moverspage.getCheckPrices().click();
		info("User clicked on Check Price");

	}

	@When("User enters modal ShiftingFrom as {string} ShiftingTo as {string} clicks on Update Location")
	public void user_enters_modal_shifting_from_as_shifting_to_as_clicks_on_update_location(String fromcity,
			String tocity) {

		Pages.get().moverspage.ShiftingCity(fromcity, tocity);
		info("User updated modal locations From: " + fromcity + " To: " + tocity);

	}

	@When("User clicks on Continue without adding items")
	public void user_clicks_on_continue_without_adding_items() {

		SwitchWindowUsingUrl("inventory");

		Pages.get().inventorypage.removeitems();

		Pages.get().inventorypage.getContinue().click();
		info("User clicked Continue without adding items");
	}

	@Then("A popup message should be displayed")
	public void a_popup_message_should_be_displayed() {

		String message = Pages.get().inventorypage.getAlert().getText();
		Assert.assertTrue(message.contains("Please add items"));
		info("Popup message displayed: " + message);

	}

}
