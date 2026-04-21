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

    private BaseClass bhook;

    public Hooks(BaseClass b) {
        this.bhook = b;
    }

    @Before
    public void setup(Scenario scenario) throws IOException {
        // Create the parent Extent Report node for this scenario
        AllUtilities.createTest(scenario.getName());

        // Read config
        String Url     = ru.getPropertyKeyValue("Url");
        String phone   = ru.getPropertyKeyValue("PhoneNo");
        String Browser = ru.getPropertyKeyValue("browser");

        // Launch browser
        WebDriver driver;
        if (Browser.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();
        else if (Browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else
            driver = new FirefoxDriver();

        bhook.setDriver(driver);
        initializeDriver(driver);
        ConfigMaximizeBrowser();
        WaitForAllElements(60);
        EnterUrl(Url);

        // Initialize pages & handle cookies/login
        Pages.LoadAllPages(bhook.driver);
        HandleCookies cookiesUtil = new HandleCookies();
        String cookieFile = "nobroker.data";

        cookiesUtil.loadCookies(bhook.driver, cookieFile);
        System.out.println("🔍 Checking session status...");

        if (!Pages.get().dashpage.isUserLoggedIn()) {
            System.out.println("👉 Session not found. Redirecting to Login...");
            Pages.get().dashpage.LoginIn(bhook.driver, phone);
            System.out.println("⏳ Please enter OTP manually. Waiting 30s...");
            try { Thread.sleep(30000); } catch (InterruptedException e) { e.printStackTrace(); }

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

    @After
    public void teardown(Scenario scenario) {
        String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        if (scenario.isFailed()) {
            AllUtilities.captureFailure(bhook.driver, name);
        }
        if (bhook.driver != null) {
            bhook.driver.quit();
        }
        BaseClass.removeDriver();
        Pages.remove();
        AllUtilities.getReport().flush();
    }
}
