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
import java.util.Properties;
import java.util.Random;

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

	
	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();
	private static final ThreadLocal<ExtentTest> stepNode = new ThreadLocal<>();

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	public HandleCookies hc = new HandleCookies();
	public ReaderUtilities ru = new ReaderUtilities();

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

	public void ConfigBrowserSize(int w, int h) {
		driver.manage().window().setSize(new Dimension(w, h));
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
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(ele));
	}

	public void WaitForInvisibilityOfElement(int seconds, By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForInvisibilityOfElement(WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.invisibilityOf(element));
	}

	public void WaitForToBeClickableOfElement(long seconds, WebElement ele) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(ele));
	}

	public WebElement WaitForToBeClickableOfElement(int timeout, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.until(ExpectedConditions.elementToBeClickable(locator));
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
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		pauseOnAction(300);
	}

	public void scrollBypixcel(int pixels) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,arguments[0]);", pixels);
	}

	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
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

	public void EnterPromptInPopup(String msg) {
		driver.switchTo().alert().sendKeys(msg);
	}

	public void DisplayPopupMessage() {
		System.out.println(driver.switchTo().alert().getText());
	}

	public void SwitchWindowUsingTitle(String wantedTitle) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().contains(wantedTitle))
				break;
		}
	}

	public void SwitchWindowUsingUrl(String wantedURL) {
		for (String handle : driver.getWindowHandles()) {
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
	public void pauseOnAction(long ms) {
		action.pause(ms).perform();
	}

	public void clickOnElement(WebElement element) {
		action.click(element).perform();
	}

	public void sendKeys(WebElement element, String value) {
		action.sendKeys(element, value).perform();
	}

	public void navigateDownDropdown(WebElement element, int count, long ms) {
		action.click(element).pause(ms);
		for (int i = 0; i < count; i++)
			action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER).perform();
	}

	// --- Date & Random Generators ---
	public int getRandomNumber(int range) {
		return new Random().nextInt(range);
	}

	public String getCurrentDate(String fmt) {
		return new SimpleDateFormat(fmt).format(new Date());
	}

	public String getFutureDate(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}

	public String getDay(String dateStr) {
		return String.valueOf(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getDayOfMonth());
	}

	public String getMonthYear(String dateStr) {
		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String month = date.getMonth().name();
		return month.substring(0, 1) + month.substring(1).toLowerCase() + " " + date.getYear();
	}

	public static synchronized ExtentReports getReport() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/extent.html");
			reporter.config().setReportName("NoBroker Automation Report");
			reporter.config().setDocumentTitle("NoBroker Test Results");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Application", "NoBroker");
			extent.setSystemInfo("Team", "Capgemini Sprint Team 02");
		}
		return extent;
	}

	public static synchronized void createTest(String scenarioName) {
		ExtentTest test = getReport().createTest(scenarioName);
		scenarioTest.set(test);
		stepNode.set(null); // clear any leftover step node
	}

	public static void createStepNode(String keyword, String stepText) {
		ExtentTest parent = scenarioTest.get();
		if (parent != null) {
			ExtentTest node = parent.createNode("<b>" + keyword + "</b> " + stepText);
			stepNode.set(node);
		}
	}

	public static void pass(String msg) {
		ExtentTest node = stepNode.get();
		if (node != null) {
			node.pass(msg);
			return;
		}
		ExtentTest test = scenarioTest.get();
		if (test != null)
			test.pass(msg);
	}

	public static void fail(String msg) {
		ExtentTest node = stepNode.get();
		if (node != null) {
			node.fail(msg);
			return;
		}
		ExtentTest test = scenarioTest.get();
		if (test != null)
			test.fail(msg);
	}

	public static void info(String msg) {
		ExtentTest node = stepNode.get();
		if (node != null) {
			node.info(msg);
			return;
		}
		ExtentTest test = scenarioTest.get();
		if (test != null)
			test.info(msg);
	}
	public static void captureFailure(WebDriver driver, String testName) {
		try {
			WebDriver d = (driver != null) ? driver : tlDriver.get();
			String name = testName.replaceAll(" ", "_");
			if (d == null) {
				fail("Test Failed: " + name + " (driver was null)");
				return;
			}
			String relativePath = takeScreenshot(d, name);
			String absolutePath = new File(relativePath).getAbsolutePath();

			// Mark the current step node
			ExtentTest node = stepNode.get();
			if (node != null) {
				node.fail("Step FAILED: " + name);
				node.addScreenCaptureFromPath(absolutePath);
			}
			// Also mark the parent scenario node
			ExtentTest test = scenarioTest.get();
			if (test != null) {
				test.fail("Scenario FAILED at: " + name);
				if (node == null)
					test.addScreenCaptureFromPath(absolutePath);
			}
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
