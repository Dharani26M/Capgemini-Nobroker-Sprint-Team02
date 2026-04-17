package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.DashboardPage;

import com.nobroker.sprint.pages.*;

public class Pages {
	public static DashboardPage dashpage;

	
	public static PackersAndMoversPage moverspage;
	public static AddInventoryPage inventorypage;
	public static OrderSummary summary;
	
	public static HomeInteriorsPage homeinteriorpage;
	public static NewIconPage iconpage;
	public static PaintingsAndCleaningPage paintpage;
	public static PostYourPropertyPage postpage;
	public static ProfilePage profilepage;
	public static ReferAndEarnPage referpage;
	public static RentReceiptPage rentpage;
	public static Buy buy;
	public static MapPage mapPage;
	
	public static void LoadAllPages(WebDriver driver) {
		dashpage=new DashboardPage(driver);
		dashpage=PageFactory.initElements(driver, DashboardPage.class);
		moverspage=new PackersAndMoversPage(driver);
		moverspage = PageFactory.initElements(driver,PackersAndMoversPage.class);
		inventorypage = PageFactory.initElements(driver, AddInventoryPage.class);
		
		summary = PageFactory.initElements(driver, OrderSummary.class);
    
    		buy = new Buy(driver);
		buy = PageFactory.initElements(driver, Buy.class);
		
		mapPage = new MapPage();
		mapPage = PageFactory.initElements(driver, MapPage.class);

		
		
		homeinteriorpage=new HomeInteriorsPage(driver);
		homeinteriorpage=PageFactory.initElements(driver, HomeInteriorsPage.class);
		iconpage=PageFactory.initElements(driver, NewIconPage.class);
		paintpage=new PaintingsAndCleaningPage(driver);
		paintpage=PageFactory.initElements(driver, PaintingsAndCleaningPage.class);
		postpage=PageFactory.initElements(driver, PostYourPropertyPage.class);
		profilepage=PageFactory.initElements(driver, ProfilePage.class);
		referpage=new ReferAndEarnPage(driver);
		referpage=PageFactory.initElements(driver, ReferAndEarnPage.class);
		rentpage=PageFactory.initElements(driver, RentReceiptPage.class);


	}

}
