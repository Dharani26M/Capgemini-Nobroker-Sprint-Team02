
package com.nobroker.sprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllUtilities {

	public static WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public HandleCookies hc=new HandleCookies();
	
	public void initializeDriver(WebDriver driver) {
		this.driver = driver;
	}

	// maximize browser
	public void ConfigMaximizeBrowser() {
		driver.manage().window().maximize();
	}

	// minimize browser
	public void ConfigMinmizeBrowser() {
		driver.manage().window().minimize();
	}

	// Full screen browser
	public void ConfigFullscreenBrowser() {
		driver.manage().window().fullscreen();
	}

	// Get Dimension
	public Dimension FetchBrowserSize() {
		return driver.manage().window().getSize();
	}

	// set Dimension
	public void ConfigBrowserSize(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	// Get point
	public Point FetchBrowserCoordinates() {
		return driver.manage().window().getPosition();
	}

	// set point
	public void ConfigBrowserCoordinates(int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}

	// Navigate
	public void navigateToApplication(String url) {
		driver.navigate().to(url);
	}

	// forward
	public void navigateToForward() {
		driver.navigate().forward();
	}

	// backward
	public void navigateToBackward() {
		driver.navigate().back();
	}

	// backward
	public void RefreshCurrentpage() {
		driver.navigate().refresh();
	}

	// get Url
	public void EnterUrl(String url) {
		driver.get(url);
	}

	// get Title
	public String FetchApplicationTitle() {
		return driver.getTitle();
	}

	// get Current url
	public String FetchApplicationUrl() {
		return driver.getCurrentUrl();
	}

	// driver close
	public void CloseParentTab() {
		driver.close();
	}

	// driver quit
	public void QuitBrowser() {
		driver.quit();
	}

	// Implicit wait
	public void WaitForAllElements(long Seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Seconds));
	}

	// Explicit wait
	public void WaitForVisibiltyOfElement(long seconds, WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void WaitForInvisibilityOfElement(long seconds, WebElement ele) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	// Explicit wait
	public void WaitForToBeClickableOfElement(long seconds, WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// popups
	// Alert Accept
	public void AcceptAlertMessage() {
		driver.switchTo().alert().accept();
	}

	// Alert Dismiss
	public void DismissAlertMessage() {
		driver.switchTo().alert().dismiss();
	}

	// prompt popup
	public void EnterPromptInPopup(String Message) {
		driver.switchTo().alert().sendKeys(Message);
	}

	// display popup message
	public void DisplayPopupMessage() {
		System.out.println(driver.switchTo().alert().getText());
	}

	// child window switch using Title
	public void SwitchWindowUsingTitle(String Wantedtitle) {
		Set<String> weblist = driver.getWindowHandles();
		Iterator<String> it = weblist.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			if (driver.getTitle().contains(Wantedtitle))
				break;
		}
	}

	// child window switch using URL
	public void SwitchWindowUsingUrl(String WantedURL) {
		Set<String> weblist = driver.getWindowHandles();
		Iterator<String> it = weblist.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			if (driver.getCurrentUrl().contains(WantedURL))
				break;
		}
	}

	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fs = new FileInputStream("./src/main/resources/Common.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String value = prop.getProperty(key);
		return value;
	}

	// Generate random number
	public int getRandomNumber(int range) {
		Random randomNumber = new Random();
		int randomNum = randomNumber.nextInt(range);
		return randomNum;
	}

	// Generate current date
	public String getCurrentDate(String dateFormat) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	// Counting days (add days to current date)
	public String getFutureDate(int days) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.format(date);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiredDays = sdf.format(cal.getTime());
		return requiredDays;
	}

	// pause
	public void pauseOnAction(long timeInSeconds) {
		action.pause(timeInSeconds);
	}

	// Click using Actions
	public void clickOnElement(WebElement element) {
		action.click(element).perform();
	}

	// SendKeys using Actions
	public void sendKeys(WebElement element, String value) {
		action.sendKeys(element, value).perform();
	}

	// keys down
	public void navigateDownDropdown(WebElement element, int count, long milliseconds) {
		Actions a = action.click(element).pause(milliseconds);
		for (int i = 1; i <= count; i++) {
			a.sendKeys(Keys.ARROW_DOWN);
		}
		a.perform();
	}
	
	public String getDay(String Date) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(Date, formatter);
	    return String.valueOf(date.getDayOfMonth());
	    
	}
	
	public String getMonthYear(String Date) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    LocalDate date = LocalDate.parse(Date, formatter);
		return date.getMonth().name().substring(0,1) + 
                date.getMonth().name().substring(1).toLowerCase() 
                + " " + date.getYear();
	}
	
	
	
	
}
