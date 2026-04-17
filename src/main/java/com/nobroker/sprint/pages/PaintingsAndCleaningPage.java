package com.nobroker.sprint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.nobroker.sprint.utils.AllUtilities;

public class PaintingsAndCleaningPage {
	public WebDriver driver;
	public AllUtilities utility;

	public PaintingsAndCleaningPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	} 
	
	//locating Select your city field
		@FindBy(xpath = "//span[text()='Select Your City']")
		private WebElement SelectYourCity;
		
		//locating Interior and Renovation in web page
		@FindBy(xpath = "//div[text()='Interior and Renovation']")
		private WebElement InteriorRenovationField;
		
		//Locating Home interiors 
		@FindBy(xpath = "//div[text()='Home Interiors']")
		private WebElement HomeInteriors;

		// getter for all web element
		public WebElement getInteriorRenovationField() {
			return InteriorRenovationField;
		}

		public WebElement getHomeInteriors() {
			return HomeInteriors;
		}
		
		public WebElement getSelectYourCity() {
			return SelectYourCity;
		}
		
		public void SelectingCity(WebDriver driver, String cityname) {
			utility.WaitForVisibiltyOfElement(30,getSelectYourCity());
			driver.findElement(By.xpath("//img/following-sibling::div[contains(.,'"+cityname+"')]")).click();
		}
		
		public void SelectingHomeServices(WebDriver driver) {
			utility.WaitForToBeClickableOfElement(30,getInteriorRenovationField());
			utility.WaitForToBeClickableOfElement(30,getHomeInteriors());
		}

}
