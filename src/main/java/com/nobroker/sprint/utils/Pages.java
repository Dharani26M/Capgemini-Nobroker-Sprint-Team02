package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.*;

public class Pages {

	private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();

	public DashboardPage dashpage;
	public HomeInteriorsPage homeinteriorpage;
	public NewIconPage iconpage;
	public PaintingsAndCleaningPage paintpage;
	public PropertyPremium postpage;
	public ProfilePage profilepage;
	public ReferAndEarnPage referpage;
	public RentReceiptPage rentpage;

	public static void LoadAllPages(WebDriver driver) {
		Pages p = new Pages();
		p.dashpage = PageFactory.initElements(driver, DashboardPage.class);
		p.homeinteriorpage = PageFactory.initElements(driver, HomeInteriorsPage.class);
		p.iconpage = PageFactory.initElements(driver, NewIconPage.class);
		p.paintpage = PageFactory.initElements(driver, PaintingsAndCleaningPage.class);
		p.postpage = PageFactory.initElements(driver, PropertyPremium.class);
		p.profilepage = PageFactory.initElements(driver, ProfilePage.class);
		p.referpage = PageFactory.initElements(driver, ReferAndEarnPage.class);
		p.rentpage = PageFactory.initElements(driver, RentReceiptPage.class);
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
}
