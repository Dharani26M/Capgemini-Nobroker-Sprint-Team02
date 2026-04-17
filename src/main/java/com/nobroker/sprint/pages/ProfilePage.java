package com.nobroker.sprint.pages;

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
		
		//locating saveBtn
		@FindBy(id ="saveProfile")
		private WebElement saveBtn;
		
		//locating menu
		@FindBy(xpath = "//div[.='Menu']")
		private WebElement MenuField;
		
		//locating post your property
		@FindBy(xpath = "//div[@id='main-menu']//a[.='Post Your Property']")
		private WebElement PostProperty;
		
		//locating rent receipts
		@FindBy(xpath = "//div[@id='main-menu']//a[.='Rent Receipts']")
		private WebElement RentReceipts;
		
		//locating refer and earn field
		@FindBy(xpath = "//div[@id='main-menu']//a[.='Refer & Earn']")
		private WebElement ReferEarn;
		
		//locating paintings and cleaning
		@FindBy(xpath = "//div[@id='main-menu']//a[.='Painting & Cleaning']")
		private WebElement PaintingsCleaning;
		
		@FindBy(xpath = "//span[@class='help-block']")
		private WebElement ErrorMsg;

		// getters for WebElement
		public WebElement getUserName() {
			return userName;
		}
		
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public WebElement getMenuField() {
			return MenuField;
		}
		public WebElement getPostProperty() {
			return PostProperty;
		}

		public WebElement getRentReceipts() {
			return RentReceipts;
		}

		public WebElement getReferEarn() {
			return ReferEarn;
		}
		
		public WebElement getErrorMsg() {
			return ErrorMsg;
		}

		public WebElement getPaintingsCleaning() {
			return PaintingsCleaning;
		}
		
		// Method to set  new username
		public void setupUserName(String newUser) {
			utility.WaitForVisibiltyOfElement(20, getUserName());
			getUserName().clear();
			getUserName().sendKeys(newUser);
			getSaveBtn().click();
		}
		
		public void ClickPostYourProperty() {
			getMenuField().click();
			getPostProperty().click();
		}
		
		public void ClickRentReceipts() {
			getMenuField().click();
			getRentReceipts().click();
		}
		
		public void ClickReferAndEarn() {
			getMenuField().click();
			getReferEarn().click();
		}
		
		public void ClickPaintingsAndCleaning() {
			getMenuField().click();
			getPaintingsCleaning().click();
		}

}
