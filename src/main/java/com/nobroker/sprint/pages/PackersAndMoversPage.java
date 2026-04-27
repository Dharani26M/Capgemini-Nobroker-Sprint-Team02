package com.nobroker.sprint.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

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

	@FindBy(xpath = "//div[@class=\"flex gap-4 overflow-auto hide-scrollbar\"]//a")
	private WebElement comment;

	@FindBy(xpath = "//div[@class='grid justify-between grid-cols-2 gap-2 p-2 rounded-32 md:bg-background-color']//div[text()='Within City']")
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

	@FindBy(css = "[style='box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;']")
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

	@FindBy(xpath = "//div[text()='Where are you going to relocate?']")
	private WebElement ShiftingRelocation;

	@FindBy(xpath = "//div[text()='Update Location']")
	private WebElement UpdateLocation;

	@FindBy(xpath = "//span[contains(text(),'Complete booking')]")
	private WebElement Completebooking;

	@FindBy(xpath = "//div[contains(text(),'pickup locality')]")
	private WebElement PickupError;

	@FindBy(xpath = "//div[contains(text(),'destination locality')]")
	private WebElement DestinationError;

	@FindBy(xpath = "//button[text()='Edit Package']")
	private WebElement EditPackage;

	
	@FindBy(xpath="//button[text()='No']")
	private WebElement NoPopupButton;
	
	public WebElement getPickupError() {
		return PickupError;
	}

	public WebElement getEditPackage() {
		return EditPackage;
	}

	public WebElement getDestinationError() {
		return DestinationError;
	}

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
	
	public WebElement getNoPopupButton() {
		return NoPopupButton;
	}

	private By getDropDown() {
		return By.xpath("(//div[@id='autocomplete-dropdown-container']//div)[1]");
	}


	public void SelectDate(String Date) {
		
		//DD/MM/YYYY

		getDateInput().click();

		// calendar select
		String Month = Utilities.getMonthYear(Date);
		String date = Utilities.getDay(Date);

		// Navigate to correct month
		while (getDateNextArrow().getAttribute("style").equals("opacity: 1;")) {
			String currentMonth = driver.findElement(By.cssSelector("[class='text-13']")).getText();

			if (getCalendarMonth().getText().equalsIgnoreCase(Month)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[@class='cursor-pointer p-1p'][2]")).click();
			}
		}

		// Locate day
		List<WebElement> days = driver
				.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]//div[text()='" + date + "']"));

		for (WebElement d : days) {

			String classes = d.getAttribute("class");

			if (!classes.contains("react-datepicker__day--disabled") && !classes.contains("--outside-month")) {
				d.click();
			}
		}

	}

	public void SelectBetweenFromcity(String city) {

		Utilities.clearField(getSearchSourceCity());
		getSearchSourceCity().sendKeys(city);
		Utilities.WaitForToBeClickableOfElement(5, getFromcityDropDown());
		getFromcityDropDown().click();
	}

	public void SelectBetweenTocity(String city) {
		Utilities.clearField(getSearchDestinationCity());
		getSearchDestinationCity().sendKeys(city);
		Utilities.WaitForToBeClickableOfElement(5, getToCityDropDown());
		getToCityDropDown().click();

	}

	public void SelectCity(String City) {

		getSelectCity().click();
		driver.findElement(By.xpath("//div[@class='relative rounded-12 ']//div[text()='" + City + "']")).click();

	}

	public void ShiftingCity(String fromcity, String tocity) {

		if (isModalPresent()) {
			getShiftingFrom().sendKeys(fromcity);
			getShiftingTo().sendKeys(tocity);
			waitForStableDropdownAndClick();
			getUpdateLocation().click();
		}

	}

	private boolean isModalPresent() {
		try {
			Utilities.wait.until(ExpectedConditions.visibilityOf(getShiftingFrom()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isPickupErrorDisplayed() {
		try {
			WebElement error = driver.findElement(By.xpath(
					"//input[@placeholder='Shifting From']/following-sibling::div[contains(@class,'error')] | //div[contains(text(),'Shifting From') and contains(@class,'error')]"));
			return error.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForStableDropdownAndClick() {

		String previousText = "";
		int stableCount = 0;

		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)) // max wait time
				.pollingEvery(Duration.ofMillis(300)) // check every 300ms
				.ignoring(StaleElementReferenceException.class) // ignore stale during poll
				.ignoring(NoSuchElementException.class); // ignore if not found yet

		for (int i = 0; i < 20; i++) {

			try {
				List<WebElement> items = fluentWait.until(driver -> {
					List<WebElement> elements = driver.findElements(getDropDown());

					// 👇 Add this to see what's happening in console
					if (!elements.isEmpty()) {
					}

					return elements.isEmpty() ? null : elements;
				});

				if (items.isEmpty()) {
					stableCount = 0;
					continue;
				}

				String currentText = items.get(0).getText();

				if (currentText.equals(previousText)) {
					stableCount++;
				} else {
					stableCount = 0;
					previousText = currentText;
				}

				if (stableCount >= 3) {
					items.get(0).click();
					return;
				}

			} catch (StaleElementReferenceException e) {
				stableCount = 0;
			}
		}
		throw new RuntimeException("❌ Dropdown never stabilized!");
	}

	public void handlePackagePopup(WebElement element) {
		try {

		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(300)).ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);

		fluentWait.until(driver -> {
		     // throws if missing → ignored
			return element.isDisplayed() ? true : null; // null = keep polling
		});

		final int[] prevY = { -1 };
		final int[] stable = { 0 };

		fluentWait.until(driver -> {
			
			int y = element.getLocation().getY();

			if (y == prevY[0])
				stable[0]++;
			else {
				stable[0] = 0;
				prevY[0] = y;
			}

			if (stable[0] >= 3) {
			    element.click(); 
			    return true;
			}
			return null;
		});
	}
		catch(Exception e) {
			
		}
	}
	


}
