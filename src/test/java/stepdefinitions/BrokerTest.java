package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.AvoidBrokers;
import com.nobroker.sprint.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrokerTest {

    WebDriver driver;
    ConfigReader conf = new ConfigReader();
    AvoidBrokers ab;

    @Given("user launches browser for blog module")
    public void user_launches_browser_for_blog_module() {
        driver = Hooks.driver;
        ab = new AvoidBrokers(driver);
    }

    @Given("user opens Avoid Broker application")
    public void user_opens_avoid_broker_application() {
        driver.get(conf.geturl());
    }

    @When("user selects Avoid Broker option")
    public void user_selects_avoid_broker_option() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(ab.getAvoidBrokers()));

        ab.setAvoidBrokers();
    }

    @When("user navigates to blog section")
    public void user_navigates_to_blog_section() {

        ab.setOurBlog();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    @When("user clicks subscribe option in blog")
    public void user_clicks_subscribe_option_in_blog() {
        ab.setSubscribe();
    }

    @When("user enters email in blog subscription field")
    public void user_enters_email_in_blog_subscription_field() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(ab.getEmailField()));
        wait.until(ExpectedConditions.elementToBeClickable(ab.getEmailField()));

        ab.setEmailField("eef@gmail.com");
    }

    @When("user enters preferences in blog form")
    public void user_enters_preferences_in_blog_form() {
        ab.setFinance();
        ab.setNRI();
        ab.setPayment();
    }

    @When("user submits blog subscription")
    public void user_submits_blog_subscription() {
        ab.setSubscribebtn();
    }

    @Then("blog subscription should be successful")
    public void blog_subscription_should_be_successful() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'set')]")
        )).getText();

        Assert.assertTrue(msg.toLowerCase().contains("set"),
                "❌ Subscription message not displayed");

        System.out.println("✅ Blog subscription successful");
    }
}