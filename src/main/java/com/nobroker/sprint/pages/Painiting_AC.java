package com.nobroker.sprint.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class Painiting_AC {

    WebDriver driver;
    WebDriverWait wait;

    public Painiting_AC(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // 🔹 Elements

    @FindBy(xpath = "//span[contains(text(),'Painting')]")
    private WebElement paintIcon;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement location;

    @FindBy(xpath = "//div[contains(text(),'AC & Appliance')]")
    private WebElement acSection;

    @FindBy(xpath = "//div[contains(text(),'AC Repair')]")
    private WebElement acRepair;

    // 🔹 Utility

    private void waitForLoader() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'busy-holder')]")
        ));
    }

    private void scrollAndClick(WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element
        );

        try { Thread.sleep(800); } catch (Exception e) {}

        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    // 🔹 Actions

    public void clickPainting() {
        waitForLoader();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(paintIcon));
        scrollAndClick(element);
    }

    public void selectCity() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(location));
        scrollAndClick(element);
    }

    public void clickACSection() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(acSection));
        scrollAndClick(element);
    }

    public void clickACRepair() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(acRepair));
        scrollAndClick(element);
    }

    public void clickAddButton() {

        waitForLoader();

        List<WebElement> addButtons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//button[contains(text(),'Add')]")
                )
        );

        for (WebElement btn : addButtons) {
            if (btn.isDisplayed()) {

                scrollAndClick(btn);
                break;
            }
        }
    }

    // 🔹 Validation

    public boolean isLoginPopupDisplayed() {

        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue')]"))
            ));
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}