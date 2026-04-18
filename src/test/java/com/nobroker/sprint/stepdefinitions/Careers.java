package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.CareersPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Careers {
	CareersPage Cs;
	WebDriver driver;

	public Careers() {

		driver = Hooks.driver; // get driver from Hooks

		Cs = new CareersPage(driver); // initialize page class

	}

	@When("User clicks on menu button")
	public void user_clicks_on_menu_button() {
		
		Cs.getMenu().click();
	    
	}
	@When("User clicks on Careers option from menu")
	public void user_clicks_on_careers_option_from_menu() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // wait for menu to open first
	    wait.until(ExpectedConditions.visibilityOf(Cs.getMenu()));

	    // now locate Careers dynamically
	    WebElement careers = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//*[normalize-space()='Careers']")
	        )
	    );

	    careers.click();
	}
	@Then("Careers page should be displayed")
	public void careers_page_should_be_displayed() {
		Assert.assertTrue(driver.getCurrentUrl().contains("careers"));
		}
		
	    
	
	@When("User clicks on See all opportunities button")
	public void user_clicks_on_see_all_opportunities_button() {
		Cs.getSeeAllOpportunities().click();
	   
	}
	@Then("User should be redirected to LinkedIn page")
	public void user_should_be_redirected_to_linked_in_page() {
		
		// Switch to new window
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        driver.switchTo().window(window);
	    }

	    // Assertion using URL
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue(currentUrl.contains("linkedin"));
	}
	    
	}



