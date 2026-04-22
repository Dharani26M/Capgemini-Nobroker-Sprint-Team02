package com.nobroker.sprint.stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.ExcelUtilities;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeLoanTest extends AllUtilities {
	private BaseClass base;

	public HomeLoanTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}

	@When("User clicks on Loan Eligibility option")
	public void user_clicks_on_loan_eligibility_option() throws InterruptedException {
		Pages.get().homeloan.getCheck().click();
		AllUtilities.info("Clicking on 'Check Loan Eligibility' option");
		SwitchWindowUsingTitle("desktopBanner");
		AllUtilities.info("Switching to new window using title: desktopBanner");
		scrollToElement(Pages.get().homeloan.getEligibility());
		WaitForVisibiltyOfElement(20, Pages.get().homeloan.getEligibility());
		jsClick(Pages.get().homeloan.getEligibility());
		AllUtilities.info("Loan Eligibility option clicked successfully");
	}

	@When("User enters the details")
	public void user_enters_the_details() throws EncryptedDocumentException, IOException {
		ExcelUtilities excel = new ExcelUtilities(driver);
		fillField(Pages.get().homeloan.getLoanAmount(), excel.getExcelData("Sheet3", 1, 0));
		fillField(Pages.get().homeloan.getMonthlyIncome(), excel.getExcelData("Sheet3", 1, 1));
		fillField(Pages.get().homeloan.getEMI(), excel.getExcelData("Sheet3", 1, 2));
		fillField(Pages.get().homeloan.getRateofInterest(), excel.getExcelData("Sheet3", 1, 3));
		AllUtilities.info("All loan details entered successfully");
	}

	@Then("Loan eligibility should be calculated successfully")
	public void loan_eligibility_should_be_calculated_successfully() {
		System.out.println();
		String text = Pages.get().homeloan.getVerify().getText();
		Assert.assertTrue(text.contains("₹"));
		AllUtilities.info("Loan eligibility calculated successfully");
	}

	private void fillField(WebElement element, String data) {
		WaitForVisibiltyOfElement(15, element);
		element.click();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(data);
	}

}
