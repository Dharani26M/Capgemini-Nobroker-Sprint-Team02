package com.nobroker.sprint.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nobroker.sprint.utils.AllUtilities;

public class PackersAndMoversPage {
	
	// Relocate within inside City
	
	// Locating WithinCity WebElement
	
	AllUtilities Utilities = new AllUtilities();
	
	@FindBy(xpath="//div[text()='Within City']")
	private WebElement  WithinCity;
	
	// Locating SelectCity WebElement
	
	@FindBy(css="[placeholder='Select your city']")
	private WebElement SelectCity;
	
	// Locating ShiftFrom WebElement
	
	@FindBy(css="[placeholder='Shifting From']")
	private WebElement  ShiftingFrom;
	
	@FindBy(xpath="(//div[@id='autocomplete-dropdown-container']//div)[1]")
	private WebElement ShiftingDropDowm;
	
	// Locating ClearShiftFrom WebElement
	
	@FindBy(xpath="//input[@placeholder='Shifting From']/..//span")
	private WebElement ClearShiftingFrom;
	
	// Locating ShiftTo WebElement
	
	@FindBy(css = "[@placeholder='Shifting To]")
	private WebElement ShiftingTo;
	
	
	// Locating ClearShiftTo WebElement
	
	@FindBy(xpath="//input[@placeholder='Shifting To']/..//span")
	private WebElement ClearShiftingTo;
	
	
	//Relocate Between Cities
	
	//Locating WebElement BetweenCities
	@FindBy(xpath="//div[text()='Between Cities']")
	private WebElement BetweenCities;
	
	//Locating WebElement FromCity
	
	@FindBy(id="fromCity")
	private WebElement  SearchSourceCity;
	
	//Locating WebElement ClearFromCity
	
	@FindBy(xpath="//input[@placeholder='Search Source City']/..//span")
	private WebElement ClearSourceCity;
	
	//Locating WebElement ToCity
	
	@FindBy(id = "toCity")
	private WebElement SearchDestinationCity;
	

	//Locating WebElement ClearToCity
	@FindBy(xpath="//input[@placeholder='Search Destination City']/..//span")
	private WebElement ClearDestinationCity;
	
	
	// Locating DateInputField
	
	
	@FindBy(css="[placeholder='Shifting Date']")
	private WebElement DateInput;
	
	//Locating CalendarPrevious month arrow
	
	@FindBy(xpath="//div[@class='cursor-pointer p-1p']")
	private WebElement DatePrevArrow;
	
	
	//Locating CalendarPrevious next month arrow
	
	@FindBy(xpath="//div[@class='cursor-pointer p-1p'][2]")
	private WebElement DateNextArrow;
	
	//Locating AllDates in the  Calendar 
	@FindBy(css="[.='react-datepicker__month']")
	private WebElement CalendarDates;

	@FindBy(css="[class='text-13']")
	private WebElement CalendarMonth;
	
	//Locating CheckPrice
	
		@FindBy(id = "getRealPriceButtonMobile")
		private WebElement CheckPrices;
		
		
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

	
	public void MoversWithinCity(String City, String ShiftingFrom,String ShiftingTo,WebDriver driver) {
		
		getWithinCity().click();
		SelectCity(driver, City);
		getShiftingFrom().sendKeys(ShiftingFrom);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		getShiftingDropDowm().click();
		getShiftingTo().sendKeys(ShiftingTo);
		Utilities.WaitForToBeClickableOfElement(40, getShiftingDropDowm());
		getShiftingDropDowm().click();
		getCheckPrices().click();
		
	}
	


public void RelocateBetweenCity(String SourceCity,String DestinationCity,String Date,WebDriver driver) {
		
		
		getSearchSourceCity().sendKeys(SourceCity,Keys.ARROW_DOWN.ENTER);
		getSearchDestinationCity().sendKeys(DestinationCity,Keys.ARROW_DOWN.ENTER);
		
		getDateInput().click();
		
		// calendar select 
		String Month = Utilities.getMonthYear(Date);
		String date = Utilities.getDay(Date);
	        while(getDateNextArrow().getAttribute("style").equals("opacity: 1;")) {
	        	
	        	if(Month.equals(getCalendarMonth().getText())) {
	        		break;
	        	}	
	        }
	        
	    List<WebElement> days = driver.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]//div[text()='"+date+"']" ));
	    for (WebElement d : days) {

	        String classes = d.getAttribute("class");
	        if (!classes.contains("react-datepicker__day--disabled") && 
	        	    !classes.contains("--outside-month")) {
	        	    d.click();
	        	}
	    }
	    
	    getCheckPrices().click();
	    
	    }

public void SelectCity(WebDriver driver, String City) {
	
	getSelectCity().click();
	driver.findElement(By.xpath("//div[@class='relative rounded-12 ']//div[text()='"+City+"']")).click();
}

		
	}
	
	
	
	
