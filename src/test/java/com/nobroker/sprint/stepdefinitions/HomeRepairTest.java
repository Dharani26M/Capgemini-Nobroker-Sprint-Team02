package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    	
    	
    	
    	waitForInvisibilityOfElement(Pages.get().homerepair.getOverlay(),2);

        
        WaitForToBeClickableOfElement(2, Pages.get().homerepair.getPaintIcon());

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Pages.get().homerepair.getPaintIcon());

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() > 1);

        SwitchWindowUsingTitle("NoBroker");
        AllUtilities.info("Switched to the new NoBroker painting window.");
    	
    	

    }

    @When("Select city for home repair")
    public void select_city_for_home_repair() {
    	 WaitForToBeClickableOfElement(5, Pages.get().homerepair.getLocation());
         Pages.get().homerepair.getLocation().click();
         AllUtilities.info("Selected the city for home repair services.");
    	
    }

    @When("Select Home Repair service")
    public void select_home_repair_service() {
    	WaitForVisibiltyOfElement(10, Pages.get().homerepair.getHomeRepair());

    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", Pages.get().homerepair.getHomeRepair());
    	js.executeScript("arguments[0].click();", Pages.get().homerepair.getHomeRepair());
    	AllUtilities.info("Scrolled to and selected the 'Home Repair' service category.");
    }


    @When("Click on first product")
    public void click_on_switch_and_socket() {
        try {
            executeSafeScrollAndClick(Pages.get().homerepair.getSwitchReplacement());
            AllUtilities.info("Selected the first product: Switch Replacement.");
        } catch (StaleElementReferenceException e) {
        	AllUtilities.info("Stale element encountered for first product, retrying click...");
            executeSafeScrollAndClick(Pages.get().homerepair.getSwitchReplacement());
            
        }
        
    }

    @When("Add second product")
    public void add_product_and_proceed_in_home_repair() {
        try {
            executeSafeScrollAndClick(Pages.get().homerepair.getSocketReplacement());
            AllUtilities.info("Added the second product: Socket Replacement.");
        } catch (StaleElementReferenceException e) {
        	AllUtilities.info("Stale element encountered for second product, retrying click...");
            executeSafeScrollAndClick(Pages.get().homerepair.getSocketReplacement());
        }
    }

    
  

    @Then("Order Summary should be displayed")
    public void login_popup_should_be_displayed() {
          
       WaitForVisibiltyOfElement(20, Pages.get().homerepair.getVerify());

        String actualText = Pages.get().homerepair.getVerify().getText();
        Assert.assertTrue(
        	    Pages.get().homerepair.getVerify().getText().contains("Order Summary")
        	);
        AllUtilities.info("Verification Successful: Order Summary is displayed on screen.");
    }
    
    private void executeSafeScrollAndClick(WebElement element) {
        WaitForVisibiltyOfElement(10, element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        
       
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}