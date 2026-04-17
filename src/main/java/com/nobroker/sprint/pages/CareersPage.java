package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
	WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	@FindBy(xpath="//div[@id='main-menu']")
    private WebElement Menu;

    
	@FindBy(xpath = "//*[normalize-space()='Careers']")
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
