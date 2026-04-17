package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.HomeRepair;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeRepairTest {

    WebDriver driver;
    HomeRepair hr;

    @Given("user launches browser for home repair module")
    public void user_launches_browser_for_home_repair_module() {
        driver = Hooks.driver;
        hr = new HomeRepair(driver);
    }

    @Given("user opens NoBroker application for home repair")
    public void user_opens_nobroker_application_for_home_repair() {
        driver.get("https://www.nobroker.in/");
    }

    // ✅ STEP 1
    @When("Click on Painting option for home repair")
    public void click_on_painting_option_for_home_repair() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'busy-holder')]")
        ));

        hr.clickPainting();

        // window switch
        String parent = driver.getWindowHandle();

        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
            }
        }
    }

    // ✅ STEP 2
    @When("Select city for home repair")
    public void select_city_for_home_repair() {
        hr.selectCity();
    }

    // ✅ STEP 3
    @When("Select Home Repair service")
    public void select_home_repair_service() {
        hr.clickHomeRepair();
    }

    // ✅ STEP 4
    @When("Click on Switch and Socket")
    public void click_on_switch_and_socket() {
        hr.clickSwitchSocket();
    }

    // ✅ STEP 5
    @When("Add product and proceed in home repair")
    public void add_product_and_proceed_in_home_repair() {
        hr.clickAdd();   // triggers login popup
    }

    // ✅ FINAL ASSERTION
    @Then("login popup should be displayed")
    public void login_popup_should_be_displayed() {

        boolean status = hr.isLoginPopupDisplayed();

        Assert.assertTrue(status, "❌ Login popup not displayed");

        System.out.println("✅ Login popup displayed successfully");
    }
}