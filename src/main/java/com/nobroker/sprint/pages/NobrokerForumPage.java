package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;

public class NobrokerForumPage {
	
	public WebDriver driver;
	public AllUtilities Utilities;

	public  NobrokerForumPage(WebDriver driver) {
		Utilities = new AllUtilities();
		this.driver = driver;
		this.Utilities.initializeDriver(driver);

	}
@FindBy(xpath="//button[text()='Post Question']")
private WebElement PostQuestion;

public WebElement getPostQuestion() {
	return PostQuestion;
}



}
