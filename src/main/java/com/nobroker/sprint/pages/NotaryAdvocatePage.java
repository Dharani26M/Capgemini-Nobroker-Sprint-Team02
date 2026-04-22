package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;


public class NotaryAdvocatePage {
WebDriver driver;
	
	public AllUtilities utilities; 
	public NotaryAdvocatePage(WebDriver driver) {
		utilities =new AllUtilities();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.utilities.initializeDriver(driver);
	}
	
	@FindBy(xpath = "//a[.='Notary Advocate']")
	private WebElement notary;
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(css = "[placeholder='Phone Number']")
	private WebElement phnum;
	
	@FindBy(name = "useremail")
	private WebElement email;
	
	@FindBy(name = "citySelect")
	private WebElement selectcity;
	
	@FindBy(css = "[type='submit']")
	private WebElement submit;
	
	public WebElement getNotary() {
		return notary;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPhnum() {
		return phnum;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSelectcity() {
		return selectcity;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void goToNotary() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement not = wait.until(ExpectedConditions.elementToBeClickable(getNotary()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", not);
		
	}

	public void setUsername(String username) {
		utilities.SwitchWindowUsingUrl("advocate");
		utilities.WaitForVisibiltyOfElement(10, getUsername());
		getUsername().sendKeys(username);
	}

	public void setPhnum(String phnum) {
		utilities.WaitForVisibiltyOfElement(10, getPhnum());
		getPhnum().sendKeys(phnum);
	}

	public void setEmail(String email) {
		utilities.WaitForVisibiltyOfElement(10, getEmail());
		getEmail().sendKeys(email);
	}

	public void setSelectcity() {
		utilities.WaitForToBeClickableOfElement(10, getSelectcity());
		getSelectcity().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[.='Bangalore']"))).click();
	}

	public void clickSubmit() {
		utilities.WaitForToBeClickableOfElement(10, getSubmit());
		getSubmit().click();
	}
}
