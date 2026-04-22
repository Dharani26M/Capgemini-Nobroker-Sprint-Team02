
package com.nobroker.sprint.stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
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
import com.nobroker.sprint.utils.ExcelUtilities;
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
        WaitForVisibiltyOfElement(15, Pages.get().dashpage.getProfileImg());
        Assert.assertTrue(Pages.get().dashpage.getProfileImg().isDisplayed(), "User profile image not displayed!");
        AllUtilities.info("User successfully logged in for the Rental module.");
    }

    @When("user clicks on Rental Agreement module")
    public void user_clicks_on_rental_agreement_module() {
        WaitForToBeClickableOfElement(15, Pages.get().rental.getRentalAgreementIcon());
        Pages.get().rental.getRentalAgreementIcon().click();
        AllUtilities.info("Clicked Rental Agreement icon and switching to the new tab.");
        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        try {
            WaitForVisibiltyOfElement(10, Pages.get().rental.getCityPopupInput());
            Pages.get().rental.getCityPopupInput().sendKeys("Chennai");
            WaitForToBeClickableOfElement(10, Pages.get().rental.getChennaiOption());
            Pages.get().rental.getChennaiOption().click();
            AllUtilities.info("City selection popup handled: Chennai selected.");
        } catch (Exception e) {
        	AllUtilities.info("City selection popup did not appear, proceeding with default.");
        }

        WaitForVisibiltyOfElement(20, Pages.get().rental.getUploadDraft());
        js.executeScript("arguments[0].click();", Pages.get().rental.getUploadDraft());
        AllUtilities.info("Clicked on 'Upload Draft' button.");
    }

    @When("user uploads the draft document")
    public void user_uploads_the_draft_document() {
        js.executeScript("arguments[0].click();", Pages.get().rental.getUploadFile());

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        js.executeScript("arguments[0].style.display='block';", fileInput);
        
        fileInput.sendKeys("C:\\Users\\KARTHIKEYAN\\Downloads\\Acceptance proof.pdf");
        AllUtilities.info("Uploaded draft document from path: " + fileInput);

        WaitForToBeClickableOfElement(20, Pages.get().rental.getCaution());
        js.executeScript("arguments[0].click();", Pages.get().rental.getCaution());
        AllUtilities.info("Acknowledged the caution/terms checkbox.");
        
     
    }

    @When("user enters required contract details")
    public void user_enters_required_contract_details() throws InterruptedException, EncryptedDocumentException, IOException {
        // 1. Fill Refundable Amount
        fillField(Pages.get().rental.getRefundableAmount(), "9999");
        AllUtilities.info("Refundable amount set to 9999.");

        // 2. Select Stamp Duty
        WebElement stamp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'100 Stamp')]")));
        js.executeScript("arguments[0].click();", stamp);
        AllUtilities.info("Selected 100 Rupees Stamp Duty.");

        // 3. Maintenance selection
        WaitForToBeClickableOfElement(15, Pages.get().rental.getRadioBtnNo());
        Pages.get().rental.getRadioBtnNo().click();
        AllUtilities.info("Selected 'No' for maintenance.");

        // 4. Calendar Handling
        AllUtilities.info("Selecting date from the calendar...");
        WebElement dateInput = Pages.get().rental.getDateInput();
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
        AllUtilities.info("Fetching Landlord and Tenant details from Excel...");
        ExcelUtilities excel = new ExcelUtilities(driver);
        
        fillField(Pages.get().rental.getLandlordName(), excel.getExcelData("Sheet2", 1, 0));
        fillField(Pages.get().rental.getLandlordEmail(), excel.getExcelData("Sheet2", 1, 1));
        fillField(Pages.get().rental.getLandlordPhone(), excel.getExcelData("Sheet2", 1, 2));

        fillField(Pages.get().rental.getTenantName(), excel.getExcelData("Sheet2", 1, 3));
        fillField(Pages.get().rental.getTenantEmail(), excel.getExcelData("Sheet2", 1, 4));
        fillField(Pages.get().rental.getTenantPhone(), excel.getExcelData("Sheet2", 1, 5));
    }

    @When("user clicks on Save and Continue")
    public void user_clicks_on_save_and_continue() {
        WebElement btn = Pages.get().rental.getContinueButton();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        
        wait.until(ExpectedConditions.elementToBeClickable(btn));
        js.executeScript("arguments[0].click();", btn);
        AllUtilities.info("Clicked 'Save and Continue' button.");
    }

    @Then("user should be navigated to Summary page")
    public void user_should_be_navigated_to_summary_page() {
    	
        By digitalCopyOption = By.xpath("//div[contains(text(),'Get Digital Copy')]");
        
        WebElement digitalBtn = wait.until(ExpectedConditions.elementToBeClickable(digitalCopyOption));
        js.executeScript("arguments[0].click();", digitalBtn);
        AllUtilities.info("Selected 'Get Digital Copy' from the post-save popup.");
        
        try {
            wait.until(ExpectedConditions.urlContains("summary"));
            AllUtilities.info("Navigation confirmed: Currently on Summary page - " + driver.getCurrentUrl());
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("summary"), "Navigation to summary page failed!");
            System.out.println("Passed: Successfully navigated to " + currentUrl);
        } catch (TimeoutException e) {
        	AllUtilities.info("URL didn't update automatically, attempting fallback window switch...");
            switchWindowAndVerify();
        }
    }

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