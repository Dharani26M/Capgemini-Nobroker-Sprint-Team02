
package com.nobroker.sprint.utils;

import java.io.File;
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

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AllUtilities {
	private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver driver;
	WebDriverWait wait;
	Actions action;
	public HandleCookies hs = new HandleCookies();
	public ReaderUtilities ru = new ReaderUtilities();

	public void initializeDriver(WebDriver driver) {
		this.driver = driver;
		tlDriver.set(driver);  
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

	public void WaitForInvisibilityOfElement(int seconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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
		return date.getMonth().name().substring(0, 1) + date.getMonth().name().substring(1).toLowerCase() + " "
				+ date.getYear();
	}


	// EXTENT REPORT

	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

	public static synchronized ExtentReports getReport() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/extent.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

	public static synchronized void createTest(String name) {
		ExtentTest test = getReport().createTest(name);
		testThreadLocal.set(test);
	}

	public static void pass(String msg) {
		testThreadLocal.get().pass(msg);
	}

	public static void fail(String msg) {
		testThreadLocal.get().fail(msg);
	}

	public static void captureFailure(WebDriver driver, String testName) {
		try {
			WebDriver d = (driver != null) ? driver : tlDriver.get();
			if (d == null) {
				testThreadLocal.get().fail("Test Failed: " + testName + " (driver was null, no screenshot)");
				return;
			}
			String name = testName.replaceAll(" ", "_");
			String relativePath = takeScreenshot(driver, name);
			File f = new File(relativePath);
			String absolutePath = f.getAbsolutePath();
			testThreadLocal.get().fail("Test Failed: " + name);
			testThreadLocal.get().addScreenCaptureFromPath(absolutePath);
			System.out.println("Screenshot attached to report from: " + absolutePath);
		} catch (Exception e) {
			System.err.println("Failed to capture screenshot: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// SCREENSHOT
	public static String takeScreenshot(WebDriver driver, String name) {
//					String timestamp = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date());
		String path = "Screenshot/" + name + "_" + ".png";
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
