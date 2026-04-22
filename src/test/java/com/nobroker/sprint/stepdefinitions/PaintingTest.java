package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		WaitForVisibiltyOfElement(20, Pages.get().dashpage.getProfileImg());
		Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed());
		AllUtilities.info("User session verified: Profile image is visible.");
	}
    

    @When("Click on Painting option for AC repair")
    public void click_on_painting_option_for_ac_repair() {


    	WaitForToBeClickableOfElement(5,Pages.get().paintingAc.getPaintIcon());
    	Pages.get().paintingAc.getPaintIcon().click();
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(d -> d.getWindowHandles().size() > 1);
    	SwitchWindowUsingTitle("NoBroker");
    	AllUtilities.info("Clicked Painting icon and switched to the NoBroker service window.");

    }

    @When("Select city for AC repair")
    public void select_city_for_ac_repair() {
    	WaitForToBeClickableOfElement(20,Pages.get().paintingAc.getLocation());
    	Pages.get().paintingAc.getLocation().click();
    	AllUtilities.info("Selected the city for AC repair service.");

    }

    @When("Select AC repair service")
    public void select_ac_repair_service() {
    	WaitForToBeClickableOfElement(20,Pages.get().paintingAc.getAcSection());
    	Pages.get().paintingAc.getAcSection().click();
    	WaitForToBeClickableOfElement(20,Pages.get().paintingAc.getAcRepair());
    	Pages.get().paintingAc.getAcRepair().click();
    	AllUtilities.info("Navigated through AC Section and selected AC Repair service.");
        
    }

    @When("Add AC service")
    public void add_ac_service() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'busy-holder')]")));
        } catch (Exception e) {
            // Continue if no overlay is found
        }

        WaitForVisibiltyOfElement(20, Pages.get().paintingAc.getAdd());
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", Pages.get().paintingAc.getAdd());
        
        js.executeScript("arguments[0].click();", Pages.get().paintingAc.getAdd());
        AllUtilities.info("Clicked initial 'Add' button for AC service.");

        WebElement addSpecific = Pages.get().paintingAc.getAddSpecific();
        WaitForVisibiltyOfElement(20, addSpecific);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", addSpecific);
        js.executeScript("arguments[0].click();", addSpecific);
        AllUtilities.info("Confirmed specific AC service selection.");

        WaitForToBeClickableOfElement(20, Pages.get().paintingAc.getProceed());
        js.executeScript("arguments[0].click();", Pages.get().paintingAc.getProceed());
        AllUtilities.info("Clicked 'Proceed' button via Javascript.");
        


    	
    
    	}
    	
    

    @Then("payment page should be displayed verified")
    public void login_popup_should_be_displayed_for_ac_repair() {

        WaitForVisibiltyOfElement(20, Pages.get().paintingAc.getVerify());

        String actualText = Pages.get().paintingAc.getVerify().getText();
        Assert.assertTrue(
        	    Pages.get().paintingAc.getVerify().getText().contains("Order Summary")
        	);
        AllUtilities.info("Verified: Payment/Order Summary page reached. Displayed text: " + actualText);
    }
}