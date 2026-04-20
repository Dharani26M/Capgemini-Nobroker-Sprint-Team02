
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
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrokerTest extends AllUtilities{
	
	private BaseClass base;
    public BrokerTest(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

   

    @Given("the user has logged into  application")
	public void the_user_has_logged_into_the_application() {
		WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
		Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
	}


    @When("user selects Avoid Broker option")
    public void user_selects_avoid_broker_option() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        
        System.out.println(Pages.Broker.getAvoidBrokers());

        WaitForToBeClickableOfElement(20,Pages.Broker.getAvoidBrokers());

        Pages.Broker.setAvoidBrokers();
    }
    
    

    @When("user navigates to blog section")
    public void user_navigates_to_blog_section() {
    	Pages.Broker.setOurBlog();
        SwitchWindowUsingTitle("No Broker");
        
    }

    @When("user clicks subscribe option in blog")
    public void user_clicks_subscribe_option_in_blog() {
    	Pages.Broker.setSubscribe();
    }

    @When("user enters email in blog subscription field {string}")
    public void user_enter_email_in_subscription_field(String email) {
    	
    	WaitForVisibiltyOfElement(20,Pages.Broker.getEmailField());
    	WaitForToBeClickableOfElement(20,Pages.Broker.getEmailField());
        Pages.Broker.setEmailField(email);     
    }

    @When("user enters preferences in blog form")
    public void user_enters_preferences_in_blog_form() {
    	Pages.Broker.setNRI();
    	Pages.Broker.setPayment();
    	Pages.Broker.setFinance();

    }

    @When("user submits blog subscription")
    public void user_submits_blog_subscription() {
    	Pages.Broker.setSubscribebtn();;

    }

    @Then("blog subscription should be successful")
    public void blog_subscription_should_be_successful() {
    	
    	WaitForVisibiltyOfElement(10,Pages.Broker.getVerifying());
    	String msg = Pages.Broker.getVerifying().getText();
    	

        Assert.assertTrue(msg.toLowerCase().contains("set"),
                "Subscription message not displayed");

        System.out.println("Blog subscription successful");
    }
}