package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;

public class HomeRepair {
	public WebDriver driver;
	public AllUtilities utility;
	
	public HomeRepair(WebDriver driver) {
		this.driver=driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); 
	}

    @FindBy(xpath = "//span[contains(text(),'Painting')]")
    private WebElement paintIcon;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement location;

    @FindBy(xpath = "//div[contains(text(),'Home Repairs')]")
    private WebElement homeRepair;

    @FindBy(xpath = "//p[contains(text(),'Switch')]")
    private WebElement switchSocket;

    @FindBy(xpath = "//div[contains(@class,'busy-holder')]")
    private WebElement overlay;
    
    @FindBy(xpath="//div[.='Switch Board']/../../..//button[.='Add']")
    private WebElement AddProduct;

    @FindBy(xpath="//div[.='Switchboard Installation']/../../..//div[.='Add']")
    private WebElement AddSpecificProduct;
    
    @FindBy(xpath="//div[.='Enter mobile number to continue']")
    private WebElement loginpopup;

	

	

	public WebElement getPaintIcon() {
        return paintIcon;
    }

    public WebElement getLocation() {
        return location;
    }

    public WebElement getHomeRepair() {
        return homeRepair;
    }

    public WebElement getSwitchSocket() {
        return switchSocket;
    }

    public WebElement getOverlay() {
        return overlay;
    }

	public WebElement getAddProduct() {
		return AddProduct;

	}

	public WebElement getAddSpecificProduct() {
		return AddSpecificProduct;
	}



	public WebElement getLoginpopup() {
		return loginpopup;
	}

	
}