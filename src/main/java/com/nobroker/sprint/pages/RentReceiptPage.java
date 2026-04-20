package com.nobroker.sprint.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RentReceiptPage {

	//locating the tenant name
	@FindBy(id = "rentrecipt-form-tenant_name-nbInput")
	private WebElement TenantName;
	
	//locating the owner name
	@FindBy(id = "rentrecipt-form-owner_name-nbInput")
	private WebElement OwnerName;
	
	//locating the tenant phone no
	@FindBy(id = "rentrecipt-form-tenant_phone-nbInput")
	private WebElement TenantPhoneNo;
	
	//locating the owner phone no
	@FindBy(id = "rentrecipt-form-owner_phone-nbInput")
	private WebElement OwnerPhoneNo;
	
	//locating the rent amount
	@FindBy(id = "rentrecipt-form-rent-nbInput")
	private WebElement RentAmt;
	
	//locating the owner pan number
	@FindBy(id = "rentrecipt-form-owner_pan-nbInput")
	private WebElement OwnerPanAcc;
	
	//locating the property address
	@FindBy(id = "rentrecipt-form-tenant_address-nbInput")
	private WebElement propertyAddress;
	
	//locating the owner address
	@FindBy(id = "rentrecipt-form-owner_address-nbInput")
	private WebElement OwnerAddress;
	
	//locating the email
	@FindBy(id = "rentrecipt-form-email-nbInput")
	private WebElement Email;
	
	//locating the rent generate btn
	@FindBy(css = "[type='submit']")
	private WebElement GenerateBtn;
	
	@FindBy(xpath = "//button[contains(@class,'download-receipt')]")
	private WebElement DownloadBtn;

	//getters for all web element
	public WebElement getTenantName() {
		return TenantName;
	}

	public WebElement getDownloadBtn() {
		return DownloadBtn;
	}
	
	public WebElement getOwnerName() {
		return OwnerName;
	}

	public WebElement getTenantPhoneNo() {
		return TenantPhoneNo;
	}

	public WebElement getOwnerPhoneNo() {
		return OwnerPhoneNo;
	}

	public WebElement getRentAmt() {
		return RentAmt;
	}

	public WebElement getOwnerPanAcc() {
		return OwnerPanAcc;
	}

	public WebElement getPropertyAddress() {
		return propertyAddress;
	}

	public WebElement getOwnerAddress() {
		return OwnerAddress;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getGenerateBtn() {
		return GenerateBtn;
	}
	
	// complete business logic for generating rent receipt
	public void CompleteGenerateRent(String Tenantname,String ownername,String Tenantphoneno,String ownerphoneno,String rent,String panNo,String property, String owneraddress,String email) {
		getTenantName().sendKeys(Tenantname);
		getOwnerName().sendKeys(ownername);
		getTenantPhoneNo().sendKeys(Tenantphoneno);
		getOwnerPhoneNo().sendKeys(ownerphoneno);
		getRentAmt().sendKeys(rent);
		getOwnerPanAcc().sendKeys(panNo);
		getPropertyAddress().sendKeys(property);
		// setting the receipt validity for one day without accessing date field
		getOwnerAddress().sendKeys(owneraddress,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER);
		getEmail().sendKeys(email);
		
		
	}
}
