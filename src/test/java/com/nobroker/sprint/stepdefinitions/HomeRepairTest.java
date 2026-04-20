package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.AvoidBrokers;
import com.nobroker.sprint.pages.HomeRepair;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeRepairTest extends AllUtilities{


	private BaseClass base;
    public HomeRepairTest(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }


    @When("Click on Painting option for home repair")
    public void click_on_painting_option_for_home_repair() {
    	
    	
    	
        WaitForInvisibilityOfElement(5, Pages.homerepair.getOverlay());

        
        WaitForToBeClickableOfElement(5, Pages.homerepair.getPaintIcon());

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Pages.homerepair.getPaintIcon());

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        SwitchWindowUsingTitle("NoBroker");
    	
    	

    }

    @When("Select city for home repair")
    public void select_city_for_home_repair() {
    	 WaitForToBeClickableOfElement(5, Pages.homerepair.getLocation());
         Pages.homerepair.getLocation().click();
    	
    }

    @When("Select Home Repair service")
    public void select_home_repair_service() {
    	WaitForVisibiltyOfElement(10, Pages.homerepair.getHomeRepair());

    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", Pages.homerepair.getHomeRepair());
    	js.executeScript("arguments[0].click();", Pages.homerepair.getHomeRepair());
    }

    @When("Click on Switch and Socket")
    public void click_on_switch_and_socket() {

        WaitForToBeClickableOfElement(10, Pages.homerepair.getSwitchSocket());
        Pages.homerepair.getSwitchSocket().click();
    }

    @When("Add product and proceed in home repair")
    public void add_product_and_proceed_in_home_repair() {
        WaitForToBeClickableOfElement(20,Pages.homerepair.getAddProduct());
        Pages.homerepair.getAddProduct().click();
        WaitForToBeClickableOfElement(20,Pages.homerepair.getAddSpecificProduct());
        Pages.homerepair.getAddSpecificProduct().click();


    }

    @Then("login popup should be displayed")
    public void login_popup_should_be_displayed() {
        WaitForInvisibilityOfElement(20, Pages.homerepair.getLoginpopup());

        Assert.assertEquals(Pages.homerepair.getLoginpopup(), "Enter mobile number to continue");

        System.out.println("Login popup displayed for AC repair");
    }
}