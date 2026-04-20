package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.AcRepairPage;
import com.nobroker.sprint.pages.CareersPage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeCleaningPage;
import com.nobroker.sprint.pages.PG_HostelPage;
import com.nobroker.sprint.pages.PostyourPropertyPage;

public class Pages {
	public static DashboardPage dashpage;
	public static HomeCleaningPage homecleaning;
	public static CareersPage Careers;
	public static PG_HostelPage PgHostel;
	public static PostyourPropertyPage PostProperty;
	public static AcRepairPage acrepair;

	public static void LoadAllPages(WebDriver driver) {
		// TODO Auto-generated method stub
		dashpage = new DashboardPage(driver);
		dashpage = PageFactory.initElements(driver, DashboardPage.class);
		homecleaning=new HomeCleaningPage(driver);
		homecleaning = PageFactory.initElements(driver, HomeCleaningPage.class);
		Careers = new CareersPage(driver);
		Careers = PageFactory.initElements(driver, CareersPage.class);
		PgHostel=new PG_HostelPage(driver);
		PgHostel = PageFactory.initElements(driver, PG_HostelPage.class);
		 PostProperty= new PostyourPropertyPage(driver);
		 PostProperty = PageFactory.initElements(driver, PostyourPropertyPage.class);
		 acrepair= new AcRepairPage(driver);
		 acrepair = PageFactory.initElements(driver, AcRepairPage.class);

	}
}
