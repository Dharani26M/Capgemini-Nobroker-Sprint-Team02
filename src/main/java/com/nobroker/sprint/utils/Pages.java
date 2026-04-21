package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.CareersPage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeLoanPage;
import com.nobroker.sprint.pages.HomeRenovationPage;

import com.nobroker.sprint.pages.*;

public class Pages {
	
	private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();

	public DashboardPage dashpage;
	public HomeInteriorsPage homeinteriorpage;
	public NewIconPage iconpage;
	public PaintingsAndCleaningPage paintpage;
	public PostyourPropertyPage postPage;
	public PropertyPremium postpage;
	public ProfilePage profilepage;
	public ReferAndEarnPage referpage;
	public RentReceiptPage rentpage;
	public HomeCleaningPage homecleaning;
	public CareersPage Careers;
	public PG_HostelPage PgHostel;
	public PostyourPropertyPage PostProperty;

	public static void LoadAllPages(WebDriver driver) {
		Pages p = new Pages();
		p.dashpage = PageFactory.initElements(driver, DashboardPage.class);
		p.homeinteriorpage = PageFactory.initElements(driver, HomeInteriorsPage.class);
		p.iconpage = PageFactory.initElements(driver, NewIconPage.class);
		p.paintpage = PageFactory.initElements(driver, PaintingsAndCleaningPage.class);
		p.postPage = PageFactory.initElements(driver, PostyourPropertyPage.class);
		p.postpage = PageFactory.initElements(driver, PropertyPremium.class);
		p.profilepage = PageFactory.initElements(driver, ProfilePage.class);
		p.referpage = PageFactory.initElements(driver, ReferAndEarnPage.class);
		p.rentpage = PageFactory.initElements(driver, RentReceiptPage.class);
		p.dashpage = PageFactory.initElements(driver, DashboardPage.class);
		p.homecleaning = PageFactory.initElements(driver, HomeCleaningPage.class);
		p.Careers = PageFactory.initElements(driver, CareersPage.class);
		p.PgHostel = PageFactory.initElements(driver, PG_HostelPage.class);
		p.PostProperty = PageFactory.initElements(driver, PostyourPropertyPage.class);
		threadPages.set(p);
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

	public static PostyourPropertyPage getPostPage() {
		return get().postPage;
		
	}
	public static PropertyPremium getPostpage() {
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
	public static HomeCleaningPage getHomeCleaningpage() {
		return get().homecleaning;
	}

	public static CareersPage getCareerspage() {
		return get().Careers;
	}

	public static PG_HostelPage getPghostelpage() {
		return get().PgHostel;
	}

	public static PostyourPropertyPage getPostproperty() {
		return get().PostProperty;
	}

}
