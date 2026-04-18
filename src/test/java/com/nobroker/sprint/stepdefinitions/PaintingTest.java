package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.Painiting_AC;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaintingTest {

    WebDriver driver;
    Painiting_AC pa;

    @Given("user launches browser for AC repair module")
    public void user_launches_browser_for_ac_repair_module() {
        driver = Hooks.driver;
        pa = new Painiting_AC(driver);
    }

    @Given("user opens NoBroker application for AC repair")
    public void user_opens_nobroker_application_for_ac_repair() {
        driver.get("https://www.nobroker.in/");
    }

    @When("Click on Painting option for AC repair")
    public void click_on_painting_option_for_ac_repair() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'busy-holder')]")
        ));

        pa.clickPainting();

        // window switch
        String parent = driver.getWindowHandle();
        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
            }
        }
    }

    @When("Select city for AC repair")
    public void select_city_for_ac_repair() {
        pa.selectCity();
    }

    @When("Select AC repair service")
    public void select_ac_repair_service() {
        pa.clickACSection();
        pa.clickACRepair();
    }

    @When("Add AC service")
    public void add_ac_service() {
        pa.clickAddButton();   
    }

    @Then("login popup should be displayed for AC repair")
    public void login_popup_should_be_displayed_for_ac_repair() {

        boolean status = pa.isLoginPopupDisplayed();

        Assert.assertTrue(status, "❌ Login popup not displayed for AC repair");

        System.out.println("✅ Login popup displayed for AC repair");
    }
}