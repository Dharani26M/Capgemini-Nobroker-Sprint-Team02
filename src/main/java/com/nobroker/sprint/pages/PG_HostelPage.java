package com.nobroker.sprint.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PG_HostelPage {
	WebDriver driver;

	public PG_HostelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// DashBoard Page
	@FindBy(id = "searchCity")
	private WebElement location;

	@FindBy(id = "listPageSearchLocality")
	private WebElement searchLocality;

	@FindBy(id = "PG")
	private WebElement Pg;

	@FindBy(xpath = "//button[.='Search']")
	private WebElement Search;

	// Filter


	
	@FindBy(id = "sortingSection")
	private WebElement Sorting;
	
	@FindBy(id = "shortlistProperty")
	private WebElement Shortlist;
	
	@FindBy(id = "listCardContainer")
	private WebElement click;
	
	

	
	public WebElement getclick() {
		return click;
	}
	public WebElement getShortlist() {
		return Shortlist;
	}
	
	
	

	public WebElement getLocation() {
		return location;
	}

	

	public WebElement getSearchLocality() {
		return searchLocality;
	}

	public WebElement getPg() {
		return Pg;
	}

	public WebElement getSearch() {
		return Search;
	}
	public WebElement getSorting() {
		return Sorting;
	}
	

}
