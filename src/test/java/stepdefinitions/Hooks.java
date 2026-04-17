package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.nobroker.sprint.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	public static WebDriver driver;
	ConfigReader conf=new ConfigReader();


	@Before
	public void setUp() {
		String browser=conf.getbrowser();
		if(browser.equalsIgnoreCase("chrome")) {
	        ChromeOptions options=new ChromeOptions();
	        options.addArguments("incognito");
	        options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.nobroker.in/");


		}
		if(browser.equalsIgnoreCase("firefox")) {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
	}
	if(browser.equalsIgnoreCase("edge")) {
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--disable-notifications");
		driver=new EdgeDriver(options);
        driver.manage().window().maximize();
        
	}
		
	}
	@After
	public void teardown() {
		
	}

}
