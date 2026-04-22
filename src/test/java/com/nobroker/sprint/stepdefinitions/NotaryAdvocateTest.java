package com.nobroker.sprint.stepdefinitions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.ExcelUtilities;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NotaryAdvocateTest extends AllUtilities{
	private BaseClass base;
	ExcelUtilities eu;
	public NotaryAdvocateTest(BaseClass base) throws EncryptedDocumentException, IOException {
		this.base = base;
		this.initializeDriver(base.driver);
		eu = new ExcelUtilities(base.driver);
	}
	
	@Given("the user logged in")
	public void the_user_logged_in() {
		 Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"));
	}
	@When("the user clicks on notary Advocate")
	public void the_user_clicks_on_notary_advocate() {
	    Pages.get().notaryPage.goToNotary();
	    AllUtilities.info("User navigates to Notary/Advocate section");
	}
	@When("enter their name")
	public void enter_their_name() {
	    eu.init("Advocate details"); 
	    String name = eu.getData(1, 0);
	    Pages.get().notaryPage.setUsername(name);
	    AllUtilities.info("User enters name: " + name);
	}
	@When("enter phone number")
	public void enter_phone_number() {
		eu.init("Advocate details"); 
	    String phnum = eu.getData(1, 1);
	    Pages.get().notaryPage.setPhnum(phnum);
	    AllUtilities.info("User enters phone number");
	}
	@When("enter email id")
	public void enter_email_id() {
		eu.init("Advocate details"); 
		String email = eu.getData(1, 2);
	    Pages.get().notaryPage.setEmail(email);
	    AllUtilities.info("User enters email id: " + email);
	}
	@When("selects the city")
	public void selects_the_city() {
		Pages.get().notaryPage.setSelectcity();
		AllUtilities.info("User selects city for notary service");
	}
	@Then("user will submit")
	public void user_will_submit() {
	    Pages.get().notaryPage.clickSubmit();
	    AllUtilities.info("User submits the notary/advocate request form");
	}

}
