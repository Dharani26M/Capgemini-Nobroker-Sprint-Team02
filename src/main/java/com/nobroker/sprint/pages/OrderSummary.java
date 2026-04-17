package com.nobroker.sprint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummary {
	
@FindBy(xpath="//div[@class=\"flex items-center justify-between mb-2p\"]//div[.='Edit']")

private WebElement EditLocation;


@FindBy(xpath="//div[@class=\"flex items-center justify-between mb-2p\"]//div[.='Edit']")

private WebElement EditDate;

//Clearing the From Relocation

@FindBy(xpath="//div[@controlid='pnmLandingPageFromRelocationFormLocalitySearch']//span[@class='right-input-icon ']")
private WebElement ClearFromRelocation;

//Clearing the To Relocation

@FindBy(xpath="//div[@controlid=\"pnmLandingPageToRelocationLocalitySearch\"]//span[@class='right-input-icon ']")
private WebElement ClearToRelocation;

//Locate Webelement Relocate From Location

@FindBy(id="pnmLandingPageFromRelocationFormLocalitySearch")
private WebElement RelocateFromLocation;

//Locate Webelement Relocate To Location

@FindBy(id="pnmLandingPageToRelocationLocalitySearch")
private WebElement RelocateToLocation;

@FindBy(id="getRealPriceButtonMobile")
private WebElement SaveAndContinue;


@FindBy(xpath="//header//div[@class=\"font-bold text-22 undefined\"]")
private WebElement PageTitle;


@FindBy(xpath="//div[text()='Your Added Inventory (']")
private WebElement AddYourInventory;

@FindBy(xpath="//div[.='Edit Items']")
private WebElement EditItems;

@FindBy(xpath="//button[.='Done']")
private WebElement Done;


@FindBy(xpath="//div[@class=\"flex-none hidden 1mr-8 md:text-sm md:block mr-1p hide-scroll-bar\"]//div[.='Total Amount to be Paid']/..")
private WebElement TotalamountToPay;


public WebElement getEditLocation() {
	return EditLocation;
}


public WebElement getEditDate() {
	return EditDate;
}


public WebElement getClearFromRelocation() {
	return ClearFromRelocation;
}

public WebElement getClearToRelocation() {
	return ClearToRelocation;
}

public WebElement getRelocateFromLocation() {
	return RelocateFromLocation;
}


public WebElement getRelocateToLocation() {
	return RelocateToLocation;
}


public WebElement getSaveAndContinue() {
	return SaveAndContinue;
}




public WebElement getPageTitle() {
	return PageTitle;
}


public WebElement getAddYourInventory() {
	return AddYourInventory;
}


public WebElement getEditItems() {
	return EditItems;
}


public WebElement getDone() {
	return Done;
}


public WebElement getTotalamountToPay() {
	return TotalamountToPay;
}


public void ConfirmTimeAndDate(String date , String periods , String TimeSlot , WebDriver driver) {
	driver.findElement(By.xpath(
	        "//div[contains(normalize-space(),'Pickup Date')]/..//div[normalize-space()='" + date + "' and not(contains(@class,'disabled'))]"
	    )).click();
	if(!periods.equals("Morning")) {
	driver.findElement(By.xpath("//div[text()='Select Pickup Slot']/..//div[text()='"+periods+"']")).click();
	driver.findElement(By.xpath("//div[@class=\"font-normal text-14\" and text()='"+TimeSlot+"']")).click();
	driver.findElement(By.xpath("//div[text()='Confirm']")).click();
	}
}
}
