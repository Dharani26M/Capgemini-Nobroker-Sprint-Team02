
package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.ExcelUtility;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.*;

public class RentalTest extends AllUtilities {

    private BaseClass base;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    public RentalTest(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("user logged in for rental")
    public void the_user_has_logged_into_the_application() {
        WaitForVisibiltyOfElement(15, Pages.dashpage.getProfileImg());
        Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed(), "User profile image not displayed!");
    }

    @When("user clicks on Rental Agreement module")
    public void user_clicks_on_rental_agreement_module() {
        WaitForToBeClickableOfElement(15, Pages.rental.getRentalAgreementIcon());
        Pages.rental.getRentalAgreementIcon().click();

        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        try {
            WaitForVisibiltyOfElement(10, Pages.rental.getCityPopupInput());
            Pages.rental.getCityPopupInput().sendKeys("Chennai");
            WaitForToBeClickableOfElement(10, Pages.rental.getChennaiOption());
            Pages.rental.getChennaiOption().click();
        } catch (Exception e) {
            System.out.println("City selection popup did not appear, proceeding...");
        }

        WaitForVisibiltyOfElement(20, Pages.rental.getUploadDraft());
        js.executeScript("arguments[0].click();", Pages.rental.getUploadDraft());
    }

    @When("user uploads the draft document")
    public void user_uploads_the_draft_document() {
        js.executeScript("arguments[0].click();", Pages.rental.getUploadFile());

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        js.executeScript("arguments[0].style.display='block';", fileInput);
        
        fileInput.sendKeys("C:\\Users\\KARTHIKEYAN\\Downloads\\Acceptance proof.pdf");
        System.out.println("File uploaded successfully");

//        WaitForToBeClickableOfElement(20, Pages.rental.getCaution());
//        js.executeScript("arguments[0].click();", Pages.rental.getCaution());
        
        
     // Replace your Caution click logic with this:
        By cautionLocator = By.xpath("//div[contains(text(),'Caution')]");
        WebElement caution = wait.until(ExpectedConditions.presenceOfElementLocated(cautionLocator));

        // Scroll to it first so JS doesn't click off-screen
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", caution);
        // Force the click
        js.executeScript("arguments[0].click();", caution);
    }

    @When("user enters required contract details")
    public void user_enters_required_contract_details() throws InterruptedException {
        // 1. Fill Refundable Amount
        fillField(Pages.rental.getRefundableAmount(), "9999");

        // 2. Select Stamp Duty
        WebElement stamp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'100 Stamp')]")));
        js.executeScript("arguments[0].click();", stamp);

        // 3. Maintenance selection
        WaitForToBeClickableOfElement(15, Pages.rental.getRadioBtnNo());
        Pages.rental.getRadioBtnNo().click();

        // 4. Calendar Handling
        WebElement dateInput = Pages.rental.getDateInput();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", dateInput);
        js.executeScript("arguments[0].click();", dateInput);

        String day = "5";
        WebElement date = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("(//div[contains(@class,'react-datepicker__day') and normalize-space()='" + day + "'])[last()]")
        ));
        js.executeScript("arguments[0].click();", date);
        
        // CRITICAL: Close calendar by clicking on a neutral element or background
        js.executeScript("document.body.click();");
        Thread.sleep(1000); 

        // 5. Fill Landlord and Tenant details from Excel
        ExcelUtility excel = new ExcelUtility();
        
        fillField(Pages.rental.getLandlordName(), excel.readdata("Sheet1", 1, 0));
        fillField(Pages.rental.getLandlordEmail(), excel.readdata("Sheet1", 1, 1));
        fillField(Pages.rental.getLandlordPhone(), excel.readdata("Sheet1", 1, 2));

        fillField(Pages.rental.getTenantName(), excel.readdata("Sheet1", 1, 3));
        fillField(Pages.rental.getTenantEmail(), excel.readdata("Sheet1", 1, 4));
        fillField(Pages.rental.getTenantPhone(), excel.readdata("Sheet1", 1, 5));
    }

    @When("user clicks on Save and Continue")
    public void user_clicks_on_save_and_continue() {
        WebElement btn = Pages.rental.getContinueButton();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        
        // Use JS click to ensure it bypasses any invisible overlays
        wait.until(ExpectedConditions.elementToBeClickable(btn));
        js.executeScript("arguments[0].click();", btn);
    }

    @Then("user should be navigated to Summary page")
    public void user_should_be_navigated_to_summary_page() {
    	
        By digitalCopyOption = By.xpath("//div[contains(text(),'Get Digital Copy')]");
        
        WebElement digitalBtn = wait.until(ExpectedConditions.elementToBeClickable(digitalCopyOption));
        js.executeScript("arguments[0].click();", digitalBtn);
        
        System.out.println("Clicked on Digital Copy option inside the popup.");

        try {
            wait.until(ExpectedConditions.urlContains("summary"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("summary"), "Navigation to summary page failed!");
            System.out.println("Passed: Successfully navigated to " + currentUrl);
        } catch (TimeoutException e) {
            
            switchWindowAndVerify();
        }
    }

    // Helper to handle the "New Tab" scenario if the above fails
    private void switchWindowAndVerify() {
        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
            }
        }
        wait.until(ExpectedConditions.urlContains("summary"));
        Assert.assertTrue(driver.getCurrentUrl().contains("summary"));
    }
    

    private void fillField(WebElement element, String data) {
        WaitForVisibiltyOfElement(15, element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(data);
    }
}