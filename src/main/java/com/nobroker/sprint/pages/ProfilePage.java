package com.nobroker.sprint.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;

public class ProfilePage {
	public WebDriver driver;
	public AllUtilities utility;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	}

	// Locating Name Field
	@FindBy(id = "nameText")
	private WebElement userName;

	// locating saveBtn
	@FindBy(id = "saveProfile")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='help-block']")
	private WebElement ErrorMsg;

	// getters for WebElement
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getErrorMsg() {
		return ErrorMsg;
	}

	// Method to set new username
	public void setupUserName(String newUser) {
		utility.WaitForVisibiltyOfElement(20, getUserName());
	    getUserName().click();
	    getUserName().sendKeys(Keys.CONTROL + "a");
	    getUserName().sendKeys(newUser);
	    getSaveBtn().click();
	}

}
