package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;


public class HomeRenovationPage {
WebDriver driver;
	
	public AllUtilities utilities; 
	public HomeRenovationPage(WebDriver driver) {
		utilities =new AllUtilities();
		this.driver = driver;
		this.utilities.initializeDriver(driver);
	}
	//painting and cleaning
	@FindBy(xpath="//div[@id='hsHomeTile']")
	private WebElement clean;
	
	//select the city
	@FindBy(xpath="//img[@alt='Chennai']")
	private WebElement city;
	
	//home renovation
	@FindBy(xpath="//div[text()='Home Renovation']")
	private WebElement renovation;
	
	//wall panel
	@FindBy(xpath="//div[text()='Wall Panel']")
	private WebElement wall;
	
	//charcoal panel
	@FindBy(xpath="//div[text()='Charcoal Panel']")
	private WebElement charcoal;
	
	//view price and details
	@FindBy(xpath="//h1[text()='Charcoal Wall Panelling']")
	private WebElement price;

	public WebElement getClean() {
		return clean;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getRenovation() {
		return renovation;
	}

	public WebElement getWall() {
		return wall;
	}

	public WebElement getCharcoal() {
		return charcoal;
	}

	public boolean checkPrice() {
		return price.isDisplayed();
	}

	public void clickClean() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
		utilities.WaitForToBeClickableOfElement(10, getClean());
		getClean().click();
	}

	public void setCity() {
		utilities.SwitchWindowUsingUrl("services");
		utilities.WaitForToBeClickableOfElement(10, getCity());
		getCity().click();
	}

	public void setRenovation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement renovationBtn = wait.until(ExpectedConditions.elementToBeClickable(getRenovation()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", renovationBtn);
	}

	public void setWall() {
		utilities.SwitchWindowUsingUrl("renovation");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
		utilities.WaitForToBeClickableOfElement(10, getWall());
		getWall().click();
	}

	public void setCharcoal() {
		utilities.WaitForToBeClickableOfElement(10, getCharcoal());
		getCharcoal().click();
	}



}
