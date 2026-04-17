package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import com.nobroker.sprint.pages.LoginPage;
import com.nobroker.sprint.pages.RentalPage;
import com.nobroker.sprint.utils.ConfigReader;
import com.nobroker.sprint.utils.ExcelUtility;

import io.cucumber.java.en.*;


public class RentalTest {

    WebDriver driver;
    RentalPage rp;
    LoginPage lp;
    ConfigReader conf;
    ExcelUtility excel;
    WebDriverWait wait;

    @Given("user opens the browser for rental module")
    public void user_opens_browser() {

        driver = Hooks.driver;
        driver.manage().deleteAllCookies();   // ✅ clean session

        rp = new RentalPage(driver);
        lp = new LoginPage(driver);
        conf = new ConfigReader();
        excel = new ExcelUtility();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("user navigates to rental application")
    public void user_navigates() {
        driver.get(conf.geturl());
    }

    @When("user enters phone number for rental and clicks continue")
    public void user_enters_phone_number_and_clicks_continue() {

        lp.setLoginBtn();

        String phoneNum = conf.getuserphoneno();

        wait.until(ExpectedConditions.visibilityOf(lp.getPhoneInput()));
        lp.enterPhoneNumber(phoneNum);
        lp.clickContinueBtn();
    }

    @When("user enters OTP for rental")
    public void user_enters_otp() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(lp.getOtp()));

        Thread.sleep(20000); // manual OTP

        lp.clickContinueBtn();
    }

    @When("user clicks on Rental Agreement module")
    public void user_clicks_on_rental_agreement_module() {

    	rp.clickRentalAgreementIcon();

        // 🔥 SWITCH TO NEW WINDOW
        String parent = driver.getWindowHandle();

        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // 🔥 HANDLE CITY POPUP + CLICK DROPDOWN
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // wait for popup input
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[contains(@placeholder,'city')]")
            ));

            input.clear();
            input.sendKeys("Chennai");

            // 🔥 CLICK DROPDOWN SUGGESTION (IMPORTANT)
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[text()='Chennai'])[1]")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

            System.out.println("✅ City selected");

        } catch (Exception e) {
            System.out.println("✅ Popup not present, continuing...");
        }

        // 🔥 SCROLL + PROCEED
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1600)");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.='Proceed']")
        ));

        rp.clickProceed();

        // 🔥 WAIT FOR UPLOAD SECTION
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Upload')]")
        ));

        rp.clickUploadDraft();

    }

    @When("user uploads the draft document")
    public void user_uploads_the_draft_document() {

        rp.uploadFile("C:\\Users\\KARTHIKEYAN\\Desktop\\sample.pdf");
    }

    @When("user enters required contract details")
    public void user_enters_required_contract_details() {

        rp.selectCity("Chennai");

        rp.enterRefund("9999");
        rp.selectStamp();
        rp.selectMaintenanceYes();

        String landlordName = excel.readdata("Details", 1, 0);
        String landlordEmail = excel.readdata("Details", 1, 1);
        String landlordPhone = excel.readdata("Details", 1, 2);
        String tenantName = excel.readdata("Details", 1, 3);
        String tenantEmail = excel.readdata("Details", 1, 4);
        String tenantPhone = excel.readdata("Details", 1, 5);

        rp.enterLandlordDetails(landlordName, landlordEmail, landlordPhone);
        rp.enterTenantDetails(tenantName, tenantEmail, tenantPhone);

        rp.selectOwner();
    }

    @When("user clicks on Save and Continue")
    public void user_clicks_on_save_and_continue() {
        rp.clickContinue();
    }

    @Then("user should be navigated to Summary page")
    public void user_should_be_navigated_to_summary_page() {

        wait.until(ExpectedConditions.urlContains("summary"));

        Assert.assertTrue(driver.getCurrentUrl().contains("summary"));
    }
}