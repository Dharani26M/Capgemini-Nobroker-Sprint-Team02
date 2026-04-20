package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeLoanPage;
import com.nobroker.sprint.pages.HomeRenovationPage;

import com.nobroker.sprint.pages.*;

public class Pages {

	//need to change for parallel execution 
	public static PackersAndMoversPage moverspage;
	public static AddInventoryPage inventorypage;
	public static OrderSummary summary;
	public static Buy buy;
	public static MapPage mapPage;
    public static AvoidBrokers avoidBrokers;
    public static CareersPage careersPage;
    public static HomeRepair homeRepair;
    public static HomeCleaningPage homeCleaningPage;
    public static Painiting_AC paintingAC;
    public static RentalPage rentalPage;
    public static LoginPage loginPage;
	public static VechicleAddInventoryPage vechicleinventory;
	public static PaymentPage payment;
    public static NobrokerAskQuestion askquestion;
    public static NobrokerForumPage forumpage;
	public static HomeLoanPage loanPage;
	public static HomeRenovationPage renovationPage;
	
	private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();

	public DashboardPage dashpage;
	public HomeInteriorsPage homeinteriorpage;
	public NewIconPage iconpage;
	public PaintingsAndCleaningPage paintpage;
	public PostYourPropertyPage postpage;
	public ProfilePage profilepage;
	public ReferAndEarnPage referpage;
	public RentReceiptPage rentpage;

	public static void LoadAllPages(WebDriver driver) {
		Pages p = new Pages();
		p.dashpage = PageFactory.initElements(driver, DashboardPage.class);
		p.homeinteriorpage = PageFactory.initElements(driver, HomeInteriorsPage.class);
		p.iconpage = PageFactory.initElements(driver, NewIconPage.class);
		p.paintpage = PageFactory.initElements(driver, PaintingsAndCleaningPage.class);
		p.postpage = PageFactory.initElements(driver, PostYourPropertyPage.class);
		p.profilepage = PageFactory.initElements(driver, ProfilePage.class);
		p.referpage = PageFactory.initElements(driver, ReferAndEarnPage.class);
		p.rentpage = PageFactory.initElements(driver, RentReceiptPage.class);
		threadPages.set(p);
		
		// need to delete this
		
		moverspage=new PackersAndMoversPage(driver);
		moverspage = PageFactory.initElements(driver,PackersAndMoversPage.class);
		inventorypage = new AddInventoryPage(driver);
		inventorypage = PageFactory.initElements(driver, AddInventoryPage.class);
		summary = PageFactory.initElements(driver, OrderSummary.class);
    	buy = new Buy(driver);
		buy = PageFactory.initElements(driver, Buy.class);
		mapPage = new MapPage();
		mapPage = PageFactory.initElements(driver, MapPage.class);
		avoidBrokers = PageFactory.initElements(driver, AvoidBrokers.class);
        careersPage = PageFactory.initElements(driver, CareersPage.class);
        homeRepair = PageFactory.initElements(driver, HomeRepair.class);
        homeCleaningPage = PageFactory.initElements(driver, HomeCleaningPage.class);
        paintingAC = PageFactory.initElements(driver, Painiting_AC.class);
        rentalPage = PageFactory.initElements(driver, RentalPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        
        
        // upto this delete
		vechicleinventory = new VechicleAddInventoryPage(driver);
		vechicleinventory = PageFactory.initElements(driver, VechicleAddInventoryPage.class);
		summary = PageFactory.initElements(driver, OrderSummary.class);
		payment  = PageFactory.initElements(driver, PaymentPage.class);
		askquestion = PageFactory.initElements(driver, NobrokerAskQuestion.class);
        forumpage = PageFactory.initElements(driver, NobrokerForumPage.class);
		
		

		
		
		loanPage = new HomeLoanPage(driver);
		loanPage = PageFactory.initElements(driver, HomeLoanPage.class);
		
		renovationPage = new HomeRenovationPage(driver);
		renovationPage = PageFactory.initElements(driver, HomeRenovationPage.class);
	}

	public static Pages get() {
		return threadPages.get();
	}

	public static void remove() {
		threadPages.remove();
	}

	public static DashboardPage getDashpage() {
		return get().dashpage;
	}

	public static HomeInteriorsPage getHomeinteriorpage() {
		return get().homeinteriorpage;
	}

	public static NewIconPage getIconpage() {
		return get().iconpage;
	}

	public static PaintingsAndCleaningPage getPaintpage() {
		return get().paintpage;
	}

	public static PostYourPropertyPage getPostpage() {
		return get().postpage;
	}

	public static ProfilePage getProfilepage() {
		return get().profilepage;
	}

	public static ReferAndEarnPage getReferpage() {
		return get().referpage;
	}

	public static RentReceiptPage getRentpage() {
		return get().rentpage;
	}
}
