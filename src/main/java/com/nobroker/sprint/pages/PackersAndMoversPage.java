package com.nobroker.sprint.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nobroker.sprint.utils.AllUtilities;

public class PackersAndMoversPage {

	// Relocate within inside City

	// Locating WithinCity WebElement

	public WebDriver driver;
	public AllUtilities Utilities;

	public PackersAndMoversPage(WebDriver driver) {
		Utilities = new AllUtilities();
		this.driver = driver;
		this.Utilities.initializeDriver(driver);

	}

	@FindBy(xpath = "//div[text()='Vehicle Shifting']")
	private WebElement VechicleShifting;

	@FindBy(xpath="//div[@class=\"flex gap-4 overflow-auto hide-scrollbar\"]//a")
	private WebElement comment;
	
	
	
	

	@FindBy(xpath = "//div[text()='Within City']")
	private WebElement WithinCity;

	// Locating SelectCity WebElement

	@FindBy(css = "[placeholder='Select your city']")
	private WebElement SelectCity;

	// Locating ShiftFrom WebElement

	@FindBy(css = "[placeholder='Shifting From']")
	private WebElement ShiftingFrom;

	@FindBy(xpath = "(//div[@id='autocomplete-dropdown-container']//div)[1]")
	private WebElement ShiftingDropDowm;

	// Locating ClearShiftFrom WebElement

	@FindBy(xpath = "//input[@placeholder='Shifting From']/..//span")
	private WebElement ClearShiftingFrom;

	// Locating ShiftTo WebElement

	@FindBy(css = "[placeholder='Shifting To']")
	private WebElement ShiftingTo;

	// Locating ClearShiftTo WebElement

	@FindBy(xpath = "//input[@placeholder='Shifting To']/..//span")
	private WebElement ClearShiftingTo;

	// Relocate Between Cities

	// Locating WebElement BetweenCities
	@FindBy(xpath = "//div[text()='Between Cities']")
	private WebElement BetweenCities;

	@FindBy(xpath = "//div[text()='Between City']")
	private WebElement BetweenCity;

	// Locating WebElement FromCity

	@FindBy(id = "fromCity")
	private WebElement SearchSourceCity;

	// Locating WebElement ClearFromCity

	@FindBy(xpath = "//input[@placeholder='Search Source City']/..//span")
	private WebElement ClearSourceCity;

	// Locating WebElement ToCity

	@FindBy(id = "toCity")
	private WebElement SearchDestinationCity;

	// Locating WebElement ClearToCity
	@FindBy(xpath = "//input[@placeholder='Search Destination City']/..//span")
	private WebElement ClearDestinationCity;

	// Locating DateInputField

	@FindBy(css = "[placeholder='Shifting Date']")
	private WebElement DateInput;

	// Locating CalendarPrevious month arrow

	@FindBy(xpath = "//div[@class='cursor-pointer p-1p']")
	private WebElement DatePrevArrow;

	// locating services in other cities
	@FindBy(xpath = "//h3[text()='Explore Packers and Movers Services in Other Cities']/../..//span[1]")
	private WebElement SerivcesInOtherCities;

	// Locating CalendarPrevious next month arrow

	@FindBy(xpath = "//div[@class='cursor-pointer p-1p'][2]")
	private WebElement DateNextArrow;

	// Locating AllDates in the Calendar
	@FindBy(css = "[.='react-datepicker__month']")
	private WebElement CalendarDates;

	@FindBy(css = "[class='text-13']")
	private WebElement CalendarMonth;
	
	@FindBy(css="[style='box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;']")
	private WebElement chatbox;

	// Locating CheckPrice

	@FindBy(xpath = "//div[text()='Check Prices']")
	private WebElement CheckPrices;

	@FindBy(css = "[class='hidden md:contents']")
	private WebElement PageTitle;

	@FindBy(xpath = "//div[@controlid='fromCity']/..//li")
	private WebElement FromcityDropDown;

	@FindBy(xpath = "//div[@controlid='toCity']/..//li")
	private WebElement ToCityDropDown;

	@FindBy(xpath="//div[text()='Where are you going to relocate?']")
	private WebElement ShiftingRelocation;
	
	@FindBy(xpath="//div[text()='Update Location']")
	private WebElement UpdateLocation;
	
	@FindBy(xpath="//span[contains(text(),'Complete booking')]")
	private WebElement Completebooking;
	
	public WebElement getCompletebooking() {
		return Completebooking;
	}
	
	public WebElement getComment() {
		return comment;
	}

	public WebElement getUpdateLocation() {
		return UpdateLocation;
	}

	public WebElement getShiftingRelocation() {
		return ShiftingRelocation;
	}

	public WebElement getFromcityDropDown() {
		return FromcityDropDown;
	}

	public WebElement getToCityDropDown() {
		return ToCityDropDown;
	}

	public WebElement getBetweenCities() {
		return BetweenCities;
	}

	public WebElement getWithinCity() {
		return WithinCity;
	}

	public WebElement getSearchSourceCity() {
		return SearchSourceCity;
	}

	public WebElement getClearSourceCity() {
		return ClearSourceCity;
	}

	public WebElement getSearchDestinationCity() {
		return SearchDestinationCity;
	}

	public WebElement getClearDestinationCity() {
		return ClearDestinationCity;
	}

	public WebElement getCheckPrices() {
		return CheckPrices;
	}

	public WebElement getDateInput() {
		return DateInput;
	}

	public WebElement getDatePrevArrow() {
		return DatePrevArrow;
	}

	public WebElement getDateNextArrow() {
		return DateNextArrow;
	}

	public WebElement getCalendarDates() {
		return CalendarDates;
	}

	public WebElement getCalendarMonth() {
		return CalendarMonth;
	}

	public WebElement getSelectCity() {
		return SelectCity;
	}

	public WebElement getShiftingFrom() {
		return ShiftingFrom;
	}

	public WebElement getClearShiftingFrom() {
		return ClearShiftingFrom;
	}

	public WebElement getShiftingTo() {
		return ShiftingTo;
	}

	public WebElement getClearShiftingTo() {
		return ClearShiftingTo;
	}

	public WebElement getShiftingDropDowm() {
		return ShiftingDropDowm;
		
	}

	public WebElement getPageTitle() {
		return PageTitle;
	}

	public WebElement getBetweenCity() {
		return BetweenCity;
	}

	public WebElement getVechicleShifting() {
		return VechicleShifting;
	}

	public WebElement getSerivcesInOtherCities() {
		return SerivcesInOtherCities;
	}
	
	public WebElement getChatbox() {
		return chatbox;
	}

	
 
	public void MoversWithinCity(String City, String ShiftingFrom, String ShiftingTo) {

		getWithinCity().click();
		SelectCity(City);
		getShiftingFrom().sendKeys(ShiftingFrom);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		getShiftingDropDowm().click();
		getShiftingTo().sendKeys(ShiftingTo);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		getShiftingDropDowm().click();
		getCheckPrices().click();

	}

	public void SelectDate(String Date) {

		getDateInput().click();

		// calendar select
		String Month = Utilities.getMonthYear(Date);
		String date = Utilities.getDay(Date);
		
		  //  Navigate to correct month
	    while (getDateNextArrow().getAttribute("style").equals("opacity: 1;")) {
	        String currentMonth = driver.findElement(By.cssSelector("[class='text-13']")).getText();

	        if (getCalendarMonth().getText().equalsIgnoreCase(Month)) {
	            break;
	        } else {
	            driver.findElement(By.xpath("//div[@class='cursor-pointer p-1p'][2]")).click();
	        }
	    }

	    //  Locate day
	    List<WebElement> days = driver.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]//div[text()='"+date+"']" ));

	    for (WebElement d : days) {

	        String classes = d.getAttribute("class");

	        if (!classes.contains("react-datepicker__day--disabled") && 
	        	    !classes.contains("--outside-month")) {
	        	    d.click();
	        	}
	    }

	}

	public void RelocateBetweenCity(String SourceCity, String DestinationCity, String Date) {

		getSearchSourceCity().sendKeys(SourceCity, Keys.ARROW_DOWN.ENTER);
		getSearchDestinationCity().sendKeys(DestinationCity, Keys.ARROW_DOWN.ENTER);

		getDateInput().click();

		// calendar select
		String Month = Utilities.getMonthYear(Date);
		String date = Utilities.getDay(Date);
		while (getDateNextArrow().getAttribute("style").equals("opacity: 1;")) {

			if (Month.equals(getCalendarMonth().getText())) {
				break;
			}
		}

		List<WebElement> days = driver
				.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]//div[text()='" + date + "']"));
		for (WebElement d : days) {

			String classes = d.getAttribute("class");
			if (!classes.contains("react-datepicker__day--disabled") && !classes.contains("--outside-month")) {
				d.click();
			}
		}

		getCheckPrices().click();

	}

	public void SelectBetweenFromcity(String city) {

		Utilities.clearField(getSearchSourceCity());
		getSearchSourceCity().sendKeys(city);
		Utilities.WaitForToBeClickableOfElement(20, getFromcityDropDown());
		getFromcityDropDown().click();
	}

	public void SelectBetweenTocity(String city) {
		Utilities.clearField(getSearchDestinationCity());
		getSearchDestinationCity().sendKeys(city);
		Utilities.WaitForToBeClickableOfElement(20, getToCityDropDown());
		getToCityDropDown().click();
	}
	
	

	public void SelectCity(String City) {

		getSelectCity().click();
		driver.findElement(By.xpath("//div[@class='relative rounded-12 ']//div[text()='" + City + "']")).click();
	}
	
	public void ShiftingCity(String fromcity,String tocity) {
		

		
		if(isModalPresent()){
		getShiftingFrom().sendKeys(fromcity);
		Utilities.WaitForToBeClickableOfElement(20, getShiftingDropDowm());
		getShiftingDropDowm().click();
		getShiftingTo().sendKeys(tocity);
		Utilities.WaitForToBeClickableOfElement(20, getShiftingDropDowm());
		getShiftingDropDowm().click();
		getUpdateLocation().click();
		}
		
	}

    private boolean isModalPresent() {
        try {
            Utilities.WaitForVisibiltyOfElement(30, getShiftingFrom());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isPickupErrorDisplayed() {
        try {
            WebElement error = driver.findElement(By.xpath("//input[@placeholder='Shifting From']/following-sibling::div[contains(@class,'error')] | //div[contains(text(),'Shifting From') and contains(@class,'error')]"));
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

