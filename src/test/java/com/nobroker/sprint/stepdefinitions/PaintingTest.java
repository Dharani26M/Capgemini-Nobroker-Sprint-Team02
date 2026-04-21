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
    	JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'busy-holder')]")));
        } catch (Exception e) {
            // Continue if no overlay is found
        }

        WaitForVisibiltyOfElement(20, Pages.paintingAc.getAdd());
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", Pages.paintingAc.getAdd());
        
        js.executeScript("arguments[0].click();", Pages.paintingAc.getAdd());

        WebElement addSpecific = Pages.paintingAc.getAddSpecific();
        WaitForVisibiltyOfElement(20, addSpecific);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", addSpecific);
        js.executeScript("arguments[0].click();", addSpecific);

        WaitForToBeClickableOfElement(20, Pages.paintingAc.getProceed());
        js.executeScript("arguments[0].click();", Pages.paintingAc.getProceed());


    	
    
    	}
    	
    

    @Then("payment page should be displayed verified")
    public void login_popup_should_be_displayed_for_ac_repair() {

        WaitForVisibiltyOfElement(20, Pages.paintingAc.getVerify());

        String actualText = Pages.paintingAc.getVerify().getText();
        Assert.assertTrue(
        	    Pages.paintingAc.getVerify().getText().contains("Order Summary")
        	);
        System.out.println("Order Summary is displayed");
    }
}