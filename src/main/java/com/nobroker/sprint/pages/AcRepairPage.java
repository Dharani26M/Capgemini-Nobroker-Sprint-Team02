package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;

public class AcRepairPage {
	public WebDriver driver;
	public AllUtilities utility;

	public AcRepairPage (WebDriver driver) {
		this.driver = driver;
		utility = new AllUtilities();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	} 
	
	@FindBy(xpath = "//span[contains(text(),'Painting')]")
    private WebElement paintIcon;

    @FindBy(xpath = "//div[text()='Chennai']")
    private WebElement location;

    @FindBy(xpath = "//div[contains(text(),'AC & Appliance')]")
    private WebElement acSection;

    @FindBy(xpath = "//div[contains(text(),'AC Repair')]")
    private WebElement acRepair;
    
    @FindBy(xpath ="//div[.='Appliance Repair']")
    private WebElement AplianceRepair;
    
    @FindBy(xpath = "//p[.='Refrigerator']")
    private WebElement frige;
    
    @FindBy(xpath="//div[@id=\"APPLIANCE_MICROWAVE_MICROWAVE_REPAIR\"]/..//span[.='View details']")
    private WebElement Details;
    
    @FindBy(xpath = "//div[contains(text(),'Add')]")
    private WebElement Add;
    

    @FindBy(xpath = "//div[contains(text(),'add-ons-proceed')]")
    private WebElement Proceed;


	public WebElement getPaintIcon() {
		return paintIcon;
	}


	public void setPaintIcon(WebElement paintIcon) {
		this.paintIcon = paintIcon;
	}


	public WebElement getLocation() {
		return location;
	}


	public void setLocation(WebElement location) {
		this.location = location;
	}


	public WebElement getAcSection() {
		return acSection;
	}


	public void setAcSection(WebElement acSection) {
		this.acSection = acSection;
	}


	public WebElement getAcRepair() {
		return acRepair;
	}


	public void setAcRepair(WebElement acRepair) {
		this.acRepair = acRepair;
	}


	public WebElement getAplianceRepair() {
		return AplianceRepair;
	}


	public void setAplianceRepair(WebElement aplianceRepair) {
		AplianceRepair = aplianceRepair;
	}


	public WebElement getfrige() {
		return frige;
	}


	public void setMicrowave(WebElement microwave) {
		frige = frige;
	}


	public WebElement getDetails() {
		return Details;
	}


	public void setDetails(WebElement details) {
		Details = details;
	}


	public WebElement getAdd() {
		return Add;
	}


	public void setAdd(WebElement add) {
		Add = add;
	}


	public WebElement getProceed() {
		return Proceed;
	}


	public void setProceed(WebElement proceed) {
		Proceed = proceed;
	}
    
    
   

}
