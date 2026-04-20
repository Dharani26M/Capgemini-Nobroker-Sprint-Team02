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

	@FindBy(xpath = "//div[text()='Skip'] | //span[text()='Skip']")
	private WebElement notification;
	
	@FindBy(xpath = "//label[contains(text(),'PG/Hostel')]")
	private WebElement Gender;

//	@FindBy(name = "pgTypeGirls")
//	private WebElement Gender;

	@FindBy(xpath = "//span[.='Four Room']")
	private WebElement SharingType;

	@FindBy(xpath = "//span[.='Student']")
	private WebElement PreferedFor;

	@FindBy(id = "food_breakfast")
	private WebElement Food;

	@FindBy(id = "food_dinner")
	private WebElement Foods;

	@FindBy(id = "shortlistProperty")
	private WebElement ShortListBtn;

	@FindBy(xpath = "//button[.='Post Your Property']/../../../../..//img[@alt='shortlist']")
	private WebElement shortlist;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getshortlist() {
		return shortlist;
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

	public WebElement getNotification() {
		return notification;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getSharingType() {
		return SharingType;
	}

	public WebElement getPreferedFor() {
		return PreferedFor;
	}

	public WebElement getFood() {
		return Food;
	}

	public WebElement getFoods() {
		return Foods;
	}

	public WebElement getShortlistBtn() {
		return ShortListBtn;
	}

}
