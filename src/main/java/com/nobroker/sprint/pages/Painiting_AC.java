package com.nobroker.sprint.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class Painiting_AC {

    WebDriver driver;
    WebDriverWait wait;

    public Painiting_AC(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @FindBy(xpath = "//span[contains(text(),'Painting')]")
    private WebElement paintIcon;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement location;

    @FindBy(xpath = "//div[contains(text(),'AC & Appliance')]")
    private WebElement acSection;

    @FindBy(xpath = "//div[contains(text(),'AC Repair')]")
    private WebElement acRepair;
    
    @FindBy(xpath="//div[contains(@class,'busy-holder')]")
    private WebElement Overlay;
    
    @FindBy(xpath="//div[contains(text(),'Foam Blast AC Service')]/ancestor::div//button[.='Add']")
    private WebElement Add;
    
    @FindBy(xpath = "//div[contains(text(),'Split AC Service')]/following::button[1]")
    private WebElement AddSpecific;
    
    @FindBy(id = "add-ons-proceed")
    private WebElement Proceed;
    
    
    @FindBy(xpath="//div[contains(text(),'Order Summary')]")
    private WebElement Verify;
    

    public WebElement getVerify() {
		return Verify;
	}

	public WebElement getPaintIcon() {
		return paintIcon;
	}
    
    public WebElement getLocation() {
		return location;
	}

	public WebElement getOverlay() {
		return Overlay;
	}

	public WebElement getAcSection() {
		return acSection;
	}

	
	public WebElement getAcRepair() {
		return acRepair;
	}

	public WebElement getProceed() {
		return Proceed;
	}

	public WebElement getAdd() {
		return Add;
	}

	public WebElement getAddSpecific() {
		return AddSpecific;
	}

	
	
	

}