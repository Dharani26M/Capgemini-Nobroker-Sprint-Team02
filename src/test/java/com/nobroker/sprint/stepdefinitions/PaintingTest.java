package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.HomeRepair;
import com.nobroker.sprint.pages.Painiting_AC;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaintingTest extends AllUtilities{
	

	private BaseClass base;
    public PaintingTest(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }
    

    @Given("the user has logged into the application")
	public void the_user_has_logged_into_the_application() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}
    

    @When("Click on Painting option for AC repair")
    public void click_on_painting_option_for_ac_repair() {


    	WaitForToBeClickableOfElement(5,Pages.paintingAc.getPaintIcon());
    	Pages.paintingAc.getPaintIcon().click();
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(d -> d.getWindowHandles().size() > 1);
    	SwitchWindowUsingTitle("NoBroker");

    }

    @When("Select city for AC repair")
    public void select_city_for_ac_repair() {
    	WaitForToBeClickableOfElement(20,Pages.paintingAc.getLocation());
    	Pages.paintingAc.getLocation().click();

    }

    @When("Select AC repair service")
    public void select_ac_repair_service() {
    	WaitForToBeClickableOfElement(20,Pages.paintingAc.getAcSection());
    	Pages.paintingAc.getAcSection().click();
    	WaitForToBeClickableOfElement(20,Pages.paintingAc.getAcRepair());
    	Pages.paintingAc.getAcRepair().click();
        
    }

    @When("Add AC service")
    public void add_ac_service() {

        WaitForToBeClickableOfElement(20, Pages.paintingAc.getAdd());
        Pages.paintingAc.getAdd().click();

        WaitForToBeClickableOfElement(20, Pages.paintingAc.getAddSpecific());
        Pages.paintingAc.getAddSpecific().click();

        WaitForToBeClickableOfElement(20, Pages.paintingAc.getProceed());
        Pages.paintingAc.getProceed().click();
    	
    }

    @Then("payment page should be displayed verified")
    public void login_popup_should_be_displayed_for_ac_repair() {
        Assert.assertEquals(Pages.paintingAc.getVerify(), "Order Summary");

        System.out.println("Order Summary is displayed");
    }
}