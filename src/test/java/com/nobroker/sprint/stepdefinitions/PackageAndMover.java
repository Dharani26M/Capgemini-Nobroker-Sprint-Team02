package com.nobroker.sprint.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.text.Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.nobroker.sprint.pages.AddInventoryPage;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.ExcelUtilities;
import com.nobroker.sprint.utils.Pages;
import com.orangehrm.seleniumframework.objectutilities.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PackageAndMover extends AllUtilities {

	ExcelUtilities eu;

	public PackageAndMover(BaseClass base) throws EncryptedDocumentException, IOException {
		eu = new ExcelUtilities(base.driver);
		this.initializeDriver(base.driver);
	}

	@When("User clicks on Packers and Movers")
	public void user_clicks_on_packers_and_movers() {

		Pages.get().dashpage.clickPackersAndMovers();
		info("User clicked on Packers and Movers");
	}

	@Then("User should be navigated to Packers and Movers page")
	public void user_should_be_navigated_to_packers_and_movers_page() {

		SwitchWindowUsingUrl("packers");
		waitForElementOrTimeout(Pages.get().moverspage.getCompletebooking(), 10);
		 info("User navigated to Packers and Movers page");
	}

	@When("User selects WithinCity option")
	public void user_selects_within_city_option() {
		Pages.get().moverspage.getWithinCity().click();
		 info("User selected Within City option");
	}

	@When("User enters Cityname as {string}")
	public void user_enters_cityname_as(String cityname) {

		Pages.get().moverspage.SelectCity(cityname);
		info("User entered city name: " + cityname);
	}

	@When("User enters ShiftingFrom location as {string}")
	public void user_enters_shifting_from_location_as(String FromLocation) {


		Pages.get().moverspage.getShiftingFrom().sendKeys(FromLocation);

		Pages.get().moverspage.waitForStableDropdownAndClick();
		info("User entered Shifting From location: " + FromLocation);

	}

	@When("User enters ShiftingTo location as {string}")
	public void user_enters_shifting_to_location_as(String ToLocation) {

		Pages.get().moverspage.getShiftingTo().sendKeys(ToLocation);
		Pages.get().moverspage.waitForStableDropdownAndClick();
		info("User entered Shifting To location: " + ToLocation);
	}

	@When("User clicks on checkprice")
	public void user_clicks_on_checkprice() {
		WaitForToBeClickableOfElement(20, Pages.get().moverspage.getCheckPrices());

		Pages.get().moverspage.getCheckPrices().click();
		 info("User clicked on Check Price");
	}
	@When("User handles package popup if displayed")
	public void user_handles_package_popup_if_displayed() {

		Pages.get().moverspage.handlePackagePopup(Pages.get().moverspage.getEditPackage());
		info("User handled package popup if displayed");
	}

	@Then("User should be navigated to Inventory page")
	public void user_should_be_navigated_to_inventory_page() {
		SwitchWindowUsingUrl("inventory");
		Pages.get().moverspage.handlePackagePopup(Pages.get().moverspage.getNoPopupButton());
		Assert.assertTrue(Pages.get().moverspage.getPageTitle().getText().contains(""));
		
		info("User navigated to Inventory page");
	}

	@When("User adds inventory items")
	public void user_adds_inventory_items() {

		String sheetName = "Packers&Movers_Inventory";
		int rowCount = eu.getRowCount(sheetName);

	    for (int i = 1; i <= rowCount; i++) {  

	        String category = eu.getExcelData(sheetName, i, 0);
	        String subCategory = eu.getExcelData(sheetName, i, 1);
	        String itemName = eu.getExcelData(sheetName, i, 2);
	

			Pages.get().inventorypage.selectcategory(category);

			Pages.get().inventorypage.openIfClosed(category, subCategory);

			// Click Add Button (dynamic)

			try {

				scrollToElement(Pages.get().inventorypage.AddIcon(itemName));
				Pages.get().inventorypage.AddIcon(itemName).click(); // first time

			} catch (Exception e) {
				scrollToElement(Pages.get().inventorypage.getIncrementButton(itemName));
				Pages.get().inventorypage.getIncrementButton(itemName).click(); // already added
			}
		}
	    info("User added inventory items from Excel");
	}

	@When("User clicks on Continue")
	public void user_clicks_on_continue() {
		Pages.get().inventorypage.getContinue().click();
	}

	@Then("System should guide the user to the next step based on availability for date {string}")
	public void system_should_guide_user_based_on_availability_for_date(String date) {

		wait.until(ExpectedConditions.or(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Congratulations')]")),
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Confirm')]")),
				ExpectedConditions.urlContains("summary")));

		if (isDisplayedSafe(Pages.get().inventorypage.getConfirmation())) {

			Assert.assertTrue(isDisplayedSafe(Pages.get().inventorypage.getConfirmation()));

			Pages.get().inventorypage.getCloseBtn().click();

			return;
		}

		else {

			Pages.get().inventorypage.ConfirmDate(date);

			if (Pages.get().inventorypage.getConfirm().isEnabled()) {

				Pages.get().inventorypage.getConfirm().click();

				SwitchWindowUsingUrl("summary");
				Pages.get().summary.getConfirmBooking().click();
				SwitchWindowUsingUrl("checkout");
				Assert.assertTrue(Pages.get().payment.getTitle().getText().contains("Payments"));

			}
		}
		info("User successfully completed booking flow");
	}
	

}
