package com.nobroker.sprint.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeLoanTest extends AllUtilities {
	private BaseClass base;

	public HomeLoanTest(BaseClass base) {
		this.base = base;
		this.initializeDriver(base.driver);
	}
	
	@Given("The user should be logged in")
	public void the_user_should_be_logged_in() {
		 Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"));
	}
	@When("user clicks on the Apply Home Loan")
	public void user_clicks_on_the_apply_home_loan() {
		Pages.loanPage.clickLoan();
		Pages.loanPage.clickRadio();
	}
	@When("user request for loan amount")
	public void user_request_for_loan_amount(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String, String>>data=dataTable.asMaps();
	    String loanamt = data.get(0).get("loanamt");
	    Pages.loanPage.setLoanamt(loanamt);
	}
	@When("user set the rate of interest")
	public void user_set_the_rate_of_interest(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>>data=dataTable.asMaps();
	    String interest = data.get(0).get("interest");
	    Pages.loanPage.setInterest(interest);
	}
	@When("user set the tenure")
	public void user_set_the_tenure(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>>data=dataTable.asMaps();
	    String tenure = data.get(0).get("tenure");
	    Pages.loanPage.setTenure(tenure);
	}
	@When("check the eligibility criteria")
	public void check_the_eligibility_criteria() {
	    Pages.loanPage.setCheckbtn();
	}
	@When("user should give pan number")
	public void user_should_give_pan_number(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>>data=dataTable.asMaps();
	    String pan = data.get(0).get("pan");
	    Pages.loanPage.setPan(pan);
	}
	@When("user will proceed future and clicks continue")
	public void user_will_proceed_future_and_clicks_continue() {
	    Pages.loanPage.setContinueBtn();
	}
	@Then("loan page should get displayed")
	public void loan_page_should_get_displayed() {
	    Pages.loanPage.setLoanPage();
	}
}
