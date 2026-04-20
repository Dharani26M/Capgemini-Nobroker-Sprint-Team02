package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.*;

public class Pages {
	public static DashboardPage dashpage;

	
	public static PackersAndMoversPage moverspage;
	public static AddInventoryPage inventorypage;
	public static OrderSummary summary;
	
	public static VechicleAddInventoryPage vechicleinventory;
	public static PaymentPage payment;
    public static NobrokerAskQuestion askquestion;
    public static NobrokerForumPage forumpage;
	
	public static void LoadAllPages(WebDriver driver) {
		dashpage=new DashboardPage(driver);
		dashpage=PageFactory.initElements(driver, DashboardPage.class);
		moverspage=new PackersAndMoversPage(driver);
		moverspage = PageFactory.initElements(driver,PackersAndMoversPage.class);
		inventorypage = new AddInventoryPage(driver);
		inventorypage = PageFactory.initElements(driver, AddInventoryPage.class);
		vechicleinventory = new VechicleAddInventoryPage(driver);
		vechicleinventory = PageFactory.initElements(driver, VechicleAddInventoryPage.class);
		summary = PageFactory.initElements(driver, OrderSummary.class);
		payment  = PageFactory.initElements(driver, PaymentPage.class);
		askquestion = PageFactory.initElements(driver, NobrokerAskQuestion.class);
        forumpage = PageFactory.initElements(driver, NobrokerForumPage.class);
		
		

		
	}

}
