package com.nobroker.sprint.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.HandleCookies;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends AllUtilities {

	// call the driver base using dependency injection -DI
	private BaseClass bhook;

	public Hooks(BaseClass b) {
		this.bhook = b;
	}

	// DI part
	// setup precondition
	@Before
	public void setup(Scenario scenario) throws IOException {
		//Report generation
		AllUtilities.createTest(scenario.getName());
		
		// getting value for common property file
		String Url = ru.getPropertyKeyValue("Url");
		String phone =ru. getPropertyKeyValue("PhoneNo");
		String Browser =ru. getPropertyKeyValue("browser");

		// lanuch the browser
		WebDriver driver;
		if (Browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else
			driver = new FirefoxDriver();
		
		bhook.setDriver(driver);
		// initialize the driver
		initializeDriver(driver);
		ConfigMaximizeBrowser();
		WaitForAllElements(60);
		EnterUrl(Url);
		
		// initialize the pages
		// login
		// Cookie handling implementation
		Pages.LoadAllPages(bhook.driver);
	    HandleCookies cookiesUtil = new HandleCookies();
	    String cookieFile = "nobroker.data";
	    // 1. Attempt to inject existing cookies
	    cookiesUtil.loadCookies(bhook.driver, cookieFile);
	    
	    // 2. Refresh is usually handled inside loadCookies, but ensure UI settles
	    System.out.println("🔍 Checking session status...");

	    // 3. Verify with Profile Image
	    if (!Pages.get().dashpage.isUserLoggedIn()) {
	        System.out.println("👉 Session not found. Redirecting to Login...");
	        
	        Pages.get().dashpage.LoginIn(bhook.driver, phone);
	        
	        System.out.println("⏳ Please enter OTP manually. Waiting 30s...");
	        try {
	            Thread.sleep(30000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // 4. VERIFY LOGIN SUCCESS before saving
	        if (Pages.get().dashpage.isUserLoggedIn()) {
	            cookiesUtil.saveCookies(bhook.driver, cookieFile);
	            System.out.println("✅ Login verified! Cookies captured for future use.");
	        } else {
	            System.out.println("❌ Login verification failed after 30s. Cookies not saved.");
	        }
	    } else {
	        System.out.println("✅ Session restored via cookies. Profile image detected.");
	    }
	
	}

	// post condition
	@After
	public void teardown(Scenario scenario) {
		String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        if (scenario.isFailed()) {
            //  Failure → screenshot + report
            AllUtilities.captureFailure(bhook.driver, name);
        } else {
            //  Pass log
            AllUtilities.pass("Test Passed: " + name);
        }
        //  Close browser
        if (bhook.driver != null) {
            bhook.driver.quit();
        }
        BaseClass.removeDriver();
        Pages.remove();
        //  Save report
        AllUtilities.getReport().flush();
		
	}
}
