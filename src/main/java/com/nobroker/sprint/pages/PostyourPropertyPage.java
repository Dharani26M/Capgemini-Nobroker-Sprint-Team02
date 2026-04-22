package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class PostyourPropertyPage {
	public WebDriver driver;
	public AllUtilities utility;

	public PostyourPropertyPage(WebDriver driver) {
		this.driver = driver;
		utility = new AllUtilities();
		this.utility.initializeDriver(driver);// Pass the active driver to utility
	}

	@FindBy(xpath = "//div[@id='main-menu']")
	private WebElement Menu;

	@FindBy(xpath = "//*[normalize-space()='Post Your Property']")
	private WebElement Propertylink;

	@FindBy(id = "postNow")
	private WebElement PostNowBtn;

	@FindBy(xpath = "//div[contains(text(),'Select City')]")
	private WebElement SelectCity;

	@FindBy(xpath = "//button[.='Start Posting Your Ad For FREE']")
	private WebElement Post;
	
	@FindBy(xpath="//div[.='Property Details']")
	private WebElement click;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement Yes;

	@FindBy(xpath = "//button[.='Preview']")
	private WebElement Preview;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMenu() {
		return Menu;
	}

	public WebElement getPropertylink() {
		return Propertylink;
	}

	public WebElement getPostNowBtn() {
		return PostNowBtn;
	}

	public WebElement getSelectCity() {
		return SelectCity;
	}

	public WebElement getPost() {
		return Post;
	}

	public WebElement getPreview() {
		return Preview;
	}

	public WebElement getYes() {
		return Yes;
	}
	public WebElement getclick() {
		return click;
	}

}