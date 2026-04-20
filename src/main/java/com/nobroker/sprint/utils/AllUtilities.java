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
import org.openqa.selenium.JavascriptExecutor;
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
	private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
	private static ExtentReports extent;

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	public HandleCookies hc = new HandleCookies();
	public ReaderUtilities ru = new ReaderUtilities();

<<<<<<< HEAD
=======
	
>>>>>>> 035fff0 (Resolved Conflicts occured During updation of Hooks with Extent Reports)
	public void initializeDriver(WebDriver driver) {
		this.driver = driver;
		tlDriver.set(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.action = new Actions(driver);
	}

	// --- Browser Configuration Methods ---

	public void ConfigMaximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void ConfigMinmizeBrowser() {
		driver.manage().window().minimize();
	}

	public void ConfigFullscreenBrowser() {
		driver.manage().window().fullscreen();
	}

	public Dimension FetchBrowserSize() {
		return driver.manage().window().getSize();
	}

	public void ConfigBrowserSize(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	public Point FetchBrowserCoordinates() {
		return driver.manage().window().getPosition();
	}

	public void ConfigBrowserCoordinates(int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}

	// --- Navigation Methods ---

	public void navigateToApplication(String url) {
		driver.navigate().to(url);
	}

	public void navigateToForward() {
		driver.navigate().forward();
	}

	public void navigateToBackward() {
		driver.navigate().back();
	}

	public void RefreshCurrentpage() {
		driver.navigate().refresh();
	}

	public void EnterUrl(String url) {
		driver.get(url);
	}

	public String FetchApplicationTitle() {
		return driver.getTitle();
	}

	public String FetchApplicationUrl() {
		return driver.getCurrentUrl();
	}

	public void CloseParentTab() {
		driver.close();
	}

	public void QuitBrowser() {
		driver.quit();
	}

	// --- Wait Utility Methods ---

	public void WaitForAllElements(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void WaitForVisibiltyOfElement(long seconds, WebElement ele) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		explicitWait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void WaitForInvisibilityOfElement(int seconds, By locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForInvisibilityOfElement(WebElement element, int seconds) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void WaitForToBeClickableOfElement(long seconds, WebElement ele) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		explicitWait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public WebElement WaitForToBeClickableOfElement(int timeout, By locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForRefreshedVisibility(By locator, int timeout) {
		return wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
	}

	public void waitForElementOrTimeout(By locator, int timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Element not found within " + timeout + "s, continuing: " + locator);
		}
	}

	// --- JavaScript & Scroll Utilities ---

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		pauseOnAction(300);
	}

	public void scrollBypixcel(int pixels) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,arguments[0]);", pixels);
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void clearField(WebElement element) {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	// --- Popups & Windows ---

	public void AcceptAlertMessage() {
		driver.switchTo().alert().accept();
	}

	public void DismissAlertMessage() {
		driver.switchTo().alert().dismiss();
	}

	public void EnterPromptInPopup(String message) {
		driver.switchTo().alert().sendKeys(message);
	}

	public void DisplayPopupMessage() {
		System.out.println(driver.switchTo().alert().getText());
	}

	public void SwitchWindowUsingTitle(String wantedTitle) {
		Set<String> weblist = driver.getWindowHandles();
		for (String handle : weblist) {
			driver.switchTo().window(handle);
			if (driver.getTitle().contains(wantedTitle))
				break;
		}
	}

	public void SwitchWindowUsingUrl(String wantedURL) {
		Set<String> weblist = driver.getWindowHandles();
		for (String handle : weblist) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(wantedURL))
				break;
		}
	}

	// --- File & Property Readers ---

	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fs = new FileInputStream("./src/test/resources/Readers/Common.properties");
		Properties prop = new Properties();
		prop.load(fs);
		return prop.getProperty(key);
	}

	// --- Action Class Wrappers ---

	public void pauseOnAction(long timeInMilliseconds) {
		action.pause(timeInMilliseconds).perform();
	}

	public void clickOnElement(WebElement element) {
		action.click(element).perform();
	}

	public void sendKeys(WebElement element, String value) {
		action.sendKeys(element, value).perform();
	}

	public void navigateDownDropdown(WebElement element, int count, long milliseconds) {
		action.click(element).pause(milliseconds);
		for (int i = 0; i < count; i++) {
			action.sendKeys(Keys.ARROW_DOWN);
		}
		action.sendKeys(Keys.ENTER).perform();
	}

	// --- Date & Random Generators ---

	public int getRandomNumber(int range) {
		return new Random().nextInt(range);
	}

	public String getCurrentDate(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(new Date());
	}

	public String getFutureDate(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}

	public String getDay(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.valueOf(LocalDate.parse(dateStr, formatter).getDayOfMonth());
	}

	public String getMonthYear(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		String month = date.getMonth().name();
		return month.substring(0, 1) + month.substring(1).toLowerCase() + " " + date.getYear();
	}

	// --- Extent Reports & Screenshots ---

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
				testThreadLocal.get().fail("Test Failed: " + testName + " (driver was null)");
				return;
			}
			String name = testName.replaceAll(" ", "_");
			String relativePath = takeScreenshot(d, name);
			File f = new File(relativePath);
			String absolutePath = f.getAbsolutePath();
			testThreadLocal.get().fail("Test Failed: " + name);
			testThreadLocal.get().addScreenCaptureFromPath(absolutePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String takeScreenshot(WebDriver driver, String name) {
		String path = "Screenshot/" + name + "_" + System.currentTimeMillis() + ".png";
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}