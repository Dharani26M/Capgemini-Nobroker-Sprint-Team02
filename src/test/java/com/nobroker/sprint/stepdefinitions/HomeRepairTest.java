package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    	
    	
    	
        WaitForInvisibilityOfElement(2, Pages.homerepair.getOverlay());

        
        WaitForToBeClickableOfElement(2, Pages.homerepair.getPaintIcon());

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Pages.homerepair.getPaintIcon());

        new WebDriverWait(driver, Duration.ofSeconds(5))
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

    @When("Click on first product")
    public void click_on_switch_and_socket() throws InterruptedException {
    	

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//    	
//   	     WaitForToBeClickableOfElement(5, Pages.homerepair.getSwitchReplacement());
//
//    		js.executeScript("arguments[0].scrollIntoView({block:'center'});",Pages.homerepair.getSwitchReplacement());
//    		js.executeScript("arguments[0].click();",Pages.homerepair.getSwitchReplacement());
//        
//    		Thread.sleep(500);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement firstProd = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[text()='Switch Replacement']/following::button[text()='Add'][1]")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstProd);
        js.executeScript("arguments[0].click();", firstProd);
        
        Thread.sleep(1000); // Give the DOM a moment to process the addition

       
    }

    @When("Add second product")
    public void add_product_and_proceed_in_home_repair() throws InterruptedException {
    	
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement firstProd = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[text()='Switch Replacement']/following::button[text()='Add'][1]")));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstProd);
        js.executeScript("arguments[0].click();", firstProd);
        
        Thread.sleep(1000); // Give the DOM a moment to process the addition
    	
    	
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
////        
////        new WebDriverWait(driver, Duration.ofSeconds(10))
////            .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'busy-holder')]")));
////
////        
////        WebElement secondProduct = new WebDriverWait(driver, Duration.ofSeconds(10))
////            .until(ExpectedConditions.presenceOfElementLocated(
////                By.xpath("//div[text()='Home Cleaning']/ancestor::div//div[text()='Add']") 
////                
////            ));
////
////        js.executeScript("arguments[0].scrollIntoView({block:'center'});", secondProduct);
////        js.executeScript("arguments[0].click();", secondProduct);
//    	
//    	
//    	
//
//        WebElement proceedBtn = Pages.homerepair.getProceed(); 
//        js.executeScript("arguments[0].click();", proceedBtn);
//    	
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//    	
//  	     WaitForToBeClickableOfElement(5, Pages.homerepair.getSocketReplacement());
//
//
//    		js.executeScript("arguments[0].scrollIntoView({block:'center'});",Pages.homerepair.getSocketReplacement());
//    		js.executeScript("arguments[0].click();",Pages.homerepair.getSocketReplacement());
//     	 


    }

    @Then("Order Summary should be displayed")
    public void login_popup_should_be_displayed() {
          
       WaitForVisibiltyOfElement(20, Pages.homerepair.getVerify());

        String actualText = Pages.homerepair.getVerify().getText();
        Assert.assertTrue(
        	    Pages.homerepair.getVerify().getText().contains("Order Summary")
        	);
        System.out.println("Order Summary is displayed");
    }
}