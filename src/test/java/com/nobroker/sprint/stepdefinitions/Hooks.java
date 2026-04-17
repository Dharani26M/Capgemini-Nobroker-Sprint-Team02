package com.nobroker.sprint.stepdefinitions;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
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
			Pages.LoadAllPages(bhook.driver);

			// login
			Pages.dashpage.LoginIn(bhook.driver, phone);

		}

		// post condition
		@After
		public void teardown() {
			if (bhook.driver != null) {
//				QuitBrowser();
			}
		}
}
