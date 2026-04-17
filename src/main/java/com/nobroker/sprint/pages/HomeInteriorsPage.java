package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;

public class HomeInteriorsPage {
	
	public WebDriver driver;
	public AllUtilities utility;

	public HomeInteriorsPage(WebDriver driver) {
		this.driver = driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	} 
	//locating Schedule visit Field
		@FindBy(xpath = "//div[text()='Schedule Visit']")
		private WebElement ScheduleVisitField;
		
		//locating Share Button
		@FindBy(xpath = "//div[text()='Share']")
		private WebElement ShareBtn;

		//getters
		public WebElement getScheduleVisitField() {
			return ScheduleVisitField;
		}

		public WebElement getShareBtn() {
			return ShareBtn;
		}
			
		// click on share btn
		public void ClickOnScheduleVisit(WebDriver driver) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement scheduleBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Schedule Visit']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", scheduleBtn);
		}

}
