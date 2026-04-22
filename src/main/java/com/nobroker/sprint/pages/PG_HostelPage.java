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
	
	@FindBy(id="pg_girls")
	private WebElement female;
	
	@FindBy(id="sharing_four")
	private WebElement Room;
	
	@FindBy(id="Prefence_professional")
	private WebElement Preference;
	
	@FindBy(id="food_breakfast")
	private WebElement Breakfast;
	
	@FindBy(id="food_dinner")
	private WebElement Dinnner;
	
	
	
	@FindBy(id = "sortingSection")
	private WebElement Sorting;

	@FindBy(id = "shortlistProperty")
	private WebElement Shortlist;

	@FindBy(id = "listCardContainer")
	private WebElement click;
	
	@FindBy(id="contactOwnerClose")
	private WebElement close;
	
	@FindBy(css = "[alt='shortlist']")
	private WebElement shortlist;

	public WebElement getShortlist() {
	    return shortlist;
	}
	
	public WebElement getclose() {
		return close;
	}

	public WebElement getclick() {
		return click;
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
	
	public WebElement getFemale() {
		return female;
	}

	public WebElement getRoom() {
		return Room;
	}

	

	public WebElement getPreference() {
		return Preference;
	}

	

	public WebElement getBreakfast() {
		return Breakfast;
	}

	
	public WebElement getDinnner() {
		return Dinnner;
	}

	


}
