package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.*;

public class Pages {
	public static DashboardPage dashpage;
	
	public static PackersAndMoversPage moverspage;
	public static AddInventoryPage inventorypage;
	
	
	public static void LoadAllPages(WebDriver driver) {
		dashpage=PageFactory.initElements(driver, DashboardPage.class);
		
		moverspage = PageFactory.initElements(driver,PackersAndMoversPage.class);
		
		inventorypage = PageFactory.initElements(driver, AddInventoryPage.class);
		
		
		
	}

}
