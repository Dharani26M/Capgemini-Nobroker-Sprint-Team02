package com.nobroker.sprint.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class HomeRepair {

    WebDriver driver;
    WebDriverWait wait;

    public HomeRepair(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // 🔹 Elements
    @FindBy(xpath = "//span[contains(text(),'Painting')]")
    private WebElement paintIcon;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement location;

    @FindBy(xpath = "//div[contains(text(),'Home Repairs')]")
    private WebElement homeRepair;

    @FindBy(xpath = "//p[contains(text(),'Switch')]")
    private WebElement switchSocket;

    // 🔹 Common reusable methods

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
        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(paintIcon)
        );
        scrollAndClick(element);
    }

    public void selectCity() {
        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(location)
        );
        scrollAndClick(element);
    }

    public void clickHomeRepair() {

        waitForLoader();

        WebElement element = wait.until(
            ExpectedConditions.visibilityOf(homeRepair)
        );

        scrollAndClick(element);
    }

    public void clickSwitchSocket() {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOf(switchSocket)
        );

        scrollAndClick(element);

        // wait for ADD buttons to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//button[normalize-space()='Add']")
        ));
    }

    public void clickAdd() {

        waitForLoader();

        List<WebElement> buttons = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//button[normalize-space()='Add']")
            )
        );

        for (WebElement btn : buttons) {

            if (btn.isDisplayed()) {

                scrollAndClick(btn);
                break;
            }
        }
    }

    // 🔹 Validation

    public boolean isLoginPopupDisplayed() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@type='tel']")
                ),
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(text(),'Continue')]")
                )
            ));

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}