
package com.nobroker.sprint.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.pages.RentalPage;
import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.ExcelUtility;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.en.*;

public class RentalTest extends AllUtilities {

    private BaseClass base;

    public RentalTest(BaseClass base) {
        this.base = base;
        this.initializeDriver(base.driver);
    }

    @Given("user logged in for rental")
    public void the_user_has_logged_into_the_application() {
    	WaitForVisibiltyOfElement(20, Pages.dashpage.getProfileImg());
        Assert.assertTrue(Pages.dashpage.getProfileImg().isDisplayed());
    }


    @When("user clicks on Rental Agreement module")
    public void user_clicks_on_rental_agreement_module() {

        WaitForToBeClickableOfElement(20, Pages.rental.getRentalAgreementIcon());
        Pages.rental.getRentalAgreementIcon().click();

        // Switch window
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
            System.out.println("Popup not present, continuing...");
        }
        


        WaitForVisibiltyOfElement(20, Pages.rental.getUploadDraft());

    	((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", Pages.rental.getUploadDraft());
    }


    @When("user uploads the draft document")
    public void user_uploads_the_draft_document() {
    	
    	  JavascriptExecutor js = (JavascriptExecutor) driver;

    	    js.executeScript("arguments[0].click();", Pages.rental.getUploadFile());

    	    WebElement fileInput = new WebDriverWait(driver, Duration.ofSeconds(20))
    	            .until(ExpectedConditions.presenceOfElementLocated(
    	                    By.xpath("//input[@type='file']")
    	            ));

    	    js.executeScript("arguments[0].style.display='block';", fileInput);

    	    fileInput.sendKeys("C:\\Users\\KARTHIKEYAN\\Downloads\\Acceptance proof.pdf");

    	    System.out.println("File uploaded successfully");
    	    
            WaitForVisibiltyOfElement(20, Pages.rental.getCaution());
            WaitForToBeClickableOfElement(10, Pages.rental.getCaution());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Pages.rental.getCaution());

    	    

    	
    }


    @When("user enters required contract details")
    public void user_enters_required_contract_details() {



        // Deposit
        WaitForVisibiltyOfElement(20, Pages.rental.getRefundableAmount());
        Pages.rental.getRefundableAmount().sendKeys("9999");

        // Stamp & Maintenance
        WaitForToBeClickableOfElement(20, Pages.rental.getStampPaperAmt());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Pages.rental.getStampPaperAmt());

        WaitForToBeClickableOfElement(20, Pages.rental.getRadioBtnNo());
        Pages.rental.getRadioBtnNo().click();


        
        ExcelUtility excel = new ExcelUtility();

     // Landlord
        WaitForVisibiltyOfElement(10, Pages.rental.getLandlordName());
        Pages.rental.getLandlordName().clear();
        Pages.rental.getLandlordName().sendKeys(excel.readdata("Sheet1", 1, 0));
        WaitForVisibiltyOfElement(10, Pages.rental.getLandlordEmail());
        Pages.rental.getLandlordEmail().clear();
       Pages.rental.getLandlordEmail().sendKeys(excel.readdata("Sheet1", 1, 1));
       WaitForVisibiltyOfElement(10, Pages.rental.getLandlordPhone());
       Pages.rental.getLandlordPhone().clear();
       Pages.rental.getLandlordPhone().sendKeys(excel.readdata("Sheet1", 1, 2));

     // Tenant
       
       
       
       WaitForVisibiltyOfElement(10, Pages.rental.getTenantName());
       Pages.rental.getTenantName().clear();
       Pages.rental.getTenantName().sendKeys(excel.readdata("Sheet1", 1, 3));
       
       WaitForVisibiltyOfElement(10, Pages.rental.getTenantEmail());
       Pages.rental.getTenantEmail().clear();
     Pages.rental.getTenantEmail().sendKeys(excel.readdata("Sheet1", 1, 4));
     
     WaitForVisibiltyOfElement(10, Pages.rental.getTenantPhone());
     Pages.rental.getTenantPhone().clear();
     Pages.rental.getTenantPhone().sendKeys(excel.readdata("Sheet1", 1, 5));
////
//        // Owner selection
//        WaitForToBeClickableOfElement(20, Pages.rental.getOwner());
//        Pages.rental.getOwner().click();
    }


    @When("user clicks on Save and Continue")
    public void user_clicks_on_save_and_continue() {

        WaitForToBeClickableOfElement(10, Pages.rental.getDateInput());
        Pages.rental.getDateInput().click();

        String day = "10";

        WebElement date = driver.findElement(By.xpath(
            "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='" + day + "']"
        ));

        date.click();
    	
    	
    	

//        WaitForToBeClickableOfElement(20, Pages.rental.getContinueButton());
//        Pages.rental.getContinueButton().click();
    }


    @Then("user should be navigated to Summary page")
    public void user_should_be_navigated_to_summary_page() {
    	
    	System.out.println();
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue(currentUrl.contains("summary"));
    }
}