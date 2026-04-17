package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;


public class Buy {
	
	WebDriver driver;
	public AllUtilities au;
	public Buy(WebDriver driver) {
		this.au=new AllUtilities();
		this.driver=driver;
		this.au.initializeDriver(driver);
	}
	@FindBy(xpath="//span[text()='Skip']")
	private WebElement skip;
	
	//apply the filter
	@FindBy(name="appartment2BHK")
	private WebElement filter;
	
	//view all the options
	@FindBy (className = "nb__lTQuH")
	private WebElement viewAll;
	
	//select the property
	@FindBy(css = "[class=\"overflow-hidden text-ellipsis whitespace-nowrap max-w-15p font-semibold\"]")
	private WebElement property;
	
	//reaching out to the builder
	@FindBy(xpath="//div[.='Contact Builder']")
	private WebElement contact;

	public WebElement getSkip() {
		return skip;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getViewAll() {
		return viewAll;
	}

	public WebElement getProperty() {
		return property;
	}

	public WebElement getContact() {
		return contact;
	}
	
	public void clickSkip(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getSkip())).click();
	}
	
	public void clickFiter() {
		getFilter().click();
	}
	
	public void clickViewAll(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
		getViewAll().click();
	}

	public void setProperty(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String parent = driver.getWindowHandle();

		wait.until(d -> d.getWindowHandles().size() > 1);

		for (String win : driver.getWindowHandles()) {
		    if (!win.equals(parent)) {
		        driver.switchTo().window(win);
		        break;
		    }
		}
		getProperty().click();
		
		String child1 = driver.getWindowHandle();

		wait.until(d -> d.getWindowHandles().size() > 1);

		for (String win : driver.getWindowHandles()) {
		    if (!win.equals(parent)&&!win.equals(child1)) {
		        driver.switchTo().window(win);
		        break;
		    }
		}
		
	}
	
	public void clickContact(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
		getContact().click();
		
	}

}
