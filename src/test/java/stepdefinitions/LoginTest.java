package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.pages.LoginPage;
import com.nobroker.sprint.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginTest{
	WebDriver driver;
	ConfigReader conf=new ConfigReader();
	LoginPage lp;
	@Given("user opens the browser")
	public void user_opens_the_browser() {
		driver=Hooks.driver;
		lp=new LoginPage(driver);

	}
	@Given("navigates to the application")
	public void navigates_to_the_application() {
		String URL=conf.geturl();
	    driver.get(URL);
	    lp.setLoginBtn();
	}
	@When("user enters phone number and clicks continue")
	public void user_enters_phone_number_and_clicks_continue() {
		String phoneNum=conf.getuserphoneno();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(lp.getPhoneInput()));
	    lp.enterPhoneNumber(phoneNum);
	    lp.clickContinueBtn();

	}
	@When("user enters OTP")
	public void user_enters_otp() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		wait.until(ExpectedConditions.visibilityOf(lp.getOtp()));
		 Thread.sleep(20000);
	    lp.clickContinueBtn();

	}

}
