package com.nobroker.sprint.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.HandleCookies;
import com.nobroker.sprint.utils.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends AllUtilities {
	// call the driver base using dependency injection -DI
	private BaseClass bhook;

	public Hooks(BaseClass b) {
		this.bhook = b;
	}

	// DI part
	// setup precondition
	@Before
	public void setup() throws IOException {

		String Url = getPropertyKeyValue("Url");
		String phone = getPropertyKeyValue("PhoneNo");
		String Browser=getPropertyKeyValue("browser");

		// lanuch the browser
		if(Browser.equalsIgnoreCase("Edge"))
			bhook.driver = new EdgeDriver();
		else if(Browser.equalsIgnoreCase("chrome"))
			bhook.driver= new ChromeDriver();
		else
			bhook.driver=new FirefoxDriver();
		initializeDriver(bhook.driver);
		ConfigMaximizeBrowser();
		WaitForAllElements(60);
		EnterUrl(Url);
		
		// initialize the pages
		// login
		// Cookie handling implementation
		Pages.LoadAllPages(bhook.driver);
		   HandleCookies cookiesUtil = new HandleCookies();
		   String cookieFile = "app.data";

		   // 1. Attempt to inject existing cookies
		   cookiesUtil.loadCookies(bhook.driver, cookieFile);
			    
		   // 2. Refresh is usually handled inside loadCookies, but ensure UI settles
		   System.out.println("🔍 Checking session status...");

		   // 3. Verify with Profile Image
		   if (!Pages.dashPage.isUserLoggedIn()) {
		       System.out.println("👉 Session not found. Redirecting to Login...");
			        
		       Pages.dashPage.LoginIn(bhook.driver, phone);
			        
		       System.out.println("⏳ Please enter OTP manually. Waiting 30s...");
		       try {
		           Thread.sleep(30000); 
		       } catch (InterruptedException e) {
		           e.printStackTrace();
		       }

		       // 4. VERIFY LOGIN SUCCESS before saving
		       if (Pages.dashPage.isUserLoggedIn()) {
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
	public void teardown() {
		if (bhook.driver != null) {
//			QuitBrowser();
		}
			}
}
