package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.ContactPage;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.NotaryAdvocatePage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeLoanPage;
import com.nobroker.sprint.pages.HomeRenovationPage;

public class Pages {
private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();
	
	public  DashboardPage dashPage;
	public  Buy buy;
	public  MapPage mapPage;
	public  HomeRenovationPage renovationPage;
	public  HomeLoanPage loanPage;
	public  NotaryAdvocatePage notaryPage;
	public ContactPage contactPage;
	
	public static void LoadAllPages(WebDriver driver) {
		Pages p = new Pages();
	
		p.dashPage=PageFactory.initElements(driver, DashboardPage.class);
		p.buy = PageFactory.initElements(driver, Buy.class);
		p.mapPage = PageFactory.initElements(driver, MapPage.class);
		p.renovationPage = PageFactory.initElements(driver, HomeRenovationPage.class);
		p.loanPage = PageFactory.initElements(driver, HomeLoanPage.class);	
		p.notaryPage = PageFactory.initElements(driver, NotaryAdvocatePage.class);
		p.contactPage = PageFactory.initElements(driver, ContactPage.class);
		
		threadPages.set(p);
	}
	
	public static Pages get() {
		return threadPages.get();
	}

	public static void remove() {
		threadPages.remove();
	}
	
	public static DashboardPage getDashpage() {
		return get().dashPage;
	}

}
