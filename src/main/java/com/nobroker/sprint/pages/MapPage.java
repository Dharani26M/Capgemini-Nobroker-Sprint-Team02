package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nobroker.sprint.utils.Pages;


public class MapPage {
WebDriver driver;
	
	@FindBy(css = "[class='w-1/2 leading-none  ']")
	private WebElement map;
	
	@FindBy(xpath="//span[text()='Metro']")
	private WebElement metro;
	
	@FindBy(xpath="//div[text()='Lines']")
	private WebElement lines;
	
	public WebElement getMap() {
		return map;
	}

	public WebElement getMetro() {
		return metro;
	}

	public boolean isLinesDisplayed() {
	    return lines.isDisplayed();
	}

	public void clickMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getMap())).click();
	}
	
	public void clickMetro() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getMetro())).click();
	}
	public void checkLines() {		
		Assert.assertTrue(Pages.mapPage.isLinesDisplayed());
		System.out.println("Assertion is passed");
		
	}

}
