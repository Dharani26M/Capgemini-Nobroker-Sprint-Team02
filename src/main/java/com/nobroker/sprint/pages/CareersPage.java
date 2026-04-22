package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.utils.AllUtilities;

public class CareersPage {
	
	
	public WebDriver driver;
	public AllUtilities utility;

	public CareersPage(WebDriver driver) {
		this.driver = driver;
		utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	} 


		@FindBy(xpath="//div[@id='main-menu']")
    private WebElement Menu;

    
	@FindBy(xpath = "//a[.='Careers']")
    private WebElement careersLink;

    @FindBy(xpath = "//button[contains(text(),'See all opportunities')]")
    private WebElement seeAllOpportunities;
    
    
    public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMenu() {
		return Menu;
	}

	public WebElement getCareersLink() {
		return careersLink;
	}

	public WebElement getSeeAllOpportunities() {
		return seeAllOpportunities;
	}

}
