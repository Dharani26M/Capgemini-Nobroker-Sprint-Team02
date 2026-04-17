package com.nobroker.sprint.stepDefinition;

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

    private BaseClass bhook;

    public Hooks(BaseClass b) {
        this.bhook = b;
    }

    @Before
    public void setup() throws IOException {
        String Url = getPropertyKeyValue("Url");
        String phone = getPropertyKeyValue("PhoneNo");
        String Browser = getPropertyKeyValue("browser");

        if (Browser.equalsIgnoreCase("Edge"))
            bhook.driver = new EdgeDriver();
        else if (Browser.equalsIgnoreCase("chrome"))
            bhook.driver = new ChromeDriver();
        else
            bhook.driver = new FirefoxDriver();
        
        initializeDriver(bhook.driver);
        ConfigMaximizeBrowser();
        
        // I kept your 80 second wait to ensure stability
        WaitForAllElements(80); 
        EnterUrl(Url);

        Pages.LoadAllPages(bhook.driver);

        // Kept the Login logic from your local changes
        Pages.dashpage.LoginIn(bhook.driver, phone);
    }

    @After
    public void teardown() {
        if (bhook.driver != null) {
            // QuitBrowser(); 
        }
    }
}