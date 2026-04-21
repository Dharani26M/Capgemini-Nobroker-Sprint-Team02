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

    @FindBy(xpath = "//div[contains(@class,'cursor-pointer')]//p[text()='Switch & socket']")
    private WebElement switchSocket;

    @FindBy(xpath = "//div[contains(@class,'busy-holder')]")
    private WebElement overlay;
    
    @FindBy(xpath="//div[@id='SWITCH_BOARD']//button[text()='Add']")
    private WebElement AddProduct;

    @FindBy(xpath="//div[.='Switchboard Installation']/following::div[.='Add']")
    private WebElement AddSpecificProduct;
    
    @FindBy(xpath="//div[contains(text(),'Order Summary')]")
    private WebElement Verify;
	
    @FindBy(xpath="//div[text()='Switch Replacement']/following::button[text()='Add'][1]")
    private WebElement SwitchReplacement;
    
    
    
    @FindBy(xpath="//div[text()='Socket Replacement']/following::button[text()='Add'][1]")
    private WebElement SocketReplacement;
    
    
    
    public WebElement getSwitchReplacement() {
		return SwitchReplacement;
	}


	


	public WebElement getSocketReplacement() {
		return SocketReplacement;
	}


	

	@FindBy(id = "add-ons-proceed")
    private WebElement Proceed;
    
    public WebElement getProceed() {
		return Proceed;
	}
	

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


	public WebElement getVerify() {
		return Verify;
	}
	

	
}