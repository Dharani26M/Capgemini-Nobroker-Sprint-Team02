package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.DashboardPage;

public class Pages {
	public static DashboardPage dashPage;
	public static Buy buy;
	public static MapPage mapPage;
	
	public static void LoadAllPages(WebDriver driver) {
		dashPage = new DashboardPage(driver);
		dashPage=PageFactory.initElements(driver, DashboardPage.class);
		
		buy = new Buy(driver);
		buy = PageFactory.initElements(driver, Buy.class);
		
		mapPage = new MapPage();
		mapPage = PageFactory.initElements(driver, MapPage.class);
	}

}
