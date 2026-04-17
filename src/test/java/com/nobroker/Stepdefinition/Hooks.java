package com.nobroker.Stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void setUp() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.nobroker.in");
		}
	@After
	public void tearDown() {
//		driver.quit();
	}
}
