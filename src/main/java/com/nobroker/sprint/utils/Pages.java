package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.CareersPage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeCleaningPage;
import com.nobroker.sprint.pages.PG_HostelPage;
import com.nobroker.sprint.pages.PostyourPropertyPage;

public class Pages {
	private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();
	public DashboardPage dashpage;
	public HomeCleaningPage homecleaning;
	public CareersPage Careers;
	public PG_HostelPage PgHostel;
	public PostyourPropertyPage PostProperty;

	public static void LoadAllPages(WebDriver driver) {
		Pages p = new Pages();
		// TODO Auto-generated method stub
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
