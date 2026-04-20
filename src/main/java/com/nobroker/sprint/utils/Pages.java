package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeLoanPage;
import com.nobroker.sprint.pages.HomeRenovationPage;

public class Pages {
	public static DashboardPage dashPage;
	public static Buy buy;
	public static MapPage mapPage;
	public static HomeLoanPage loanPage;
	public static HomeRenovationPage renovationPage;
	
	public static void LoadAllPages(WebDriver driver) {
		dashPage = new DashboardPage(driver);
		dashPage=PageFactory.initElements(driver, DashboardPage.class);
		
		buy = new Buy(driver);
		buy = PageFactory.initElements(driver, Buy.class);
		
		mapPage = new MapPage();
		mapPage = PageFactory.initElements(driver, MapPage.class);
		
		loanPage = new HomeLoanPage(driver);
		loanPage = PageFactory.initElements(driver, HomeLoanPage.class);
		
		renovationPage = new HomeRenovationPage(driver);
		renovationPage = PageFactory.initElements(driver, HomeRenovationPage.class);
	}

}
