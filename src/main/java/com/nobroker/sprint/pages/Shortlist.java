package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.utils.AllUtilities;

public class Shortlist {
	public WebDriver driver;
	public AllUtilities utility;
	
	public Shortlist(WebDriver driver) {
		this.driver=driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); 
	}
	
	@FindBy(id="profile-icon")
	private WebElement icon;
	
	@FindBy(xpath="//span[.='My Dashboard']")
	private WebElement DashBoard;
	
	@FindBy(xpath="//a[.='Shortlist']")
	private WebElement ShortList;
	
	@FindBy(xpath="//a[.='Your Shortlists']")
	private WebElement YourShortlist;
	
	@FindBy(id="saleShortlistTab")
	private WebElement saleshortlisttab;
	
	
	
	@FindBy(xpath="//div[text()='Sale']")
	private WebElement sale;
	
	
	@FindBy(id="getOwnerDetails")
	private WebElement Ownerdetails;
	
	


	


	public WebElement getSale() {
		return sale;
	}


	public WebElement getIcon() {
		return icon;
	}

	public void setIcon() {
		getIcon().click();
	}

	public WebElement getDashBoard() {
		return DashBoard;
	}

	public void setDashBoard() {
		getDashBoard().click();
	}

	public WebElement getShortList() {
		return ShortList;
	}

	public void setShortList() {
		getShortList().click();
	}

	public WebElement getYourShortlist() {
		return YourShortlist;
	}

	public void setYourShortlist() {
		getYourShortlist().click();
	}

	public WebElement getSaleshortlisttab() {
		return saleshortlisttab;
	}

	public void setSaleshortlisttab() {
		getSaleshortlisttab().click();
	}





	public WebElement getOwnerdetails() {
		// TODO Auto-generated method stub
		return Ownerdetails;
	}}