package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.AvoidBrokers;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeRepair;
import com.nobroker.sprint.pages.Painiting_AC;
import com.nobroker.sprint.pages.RentalPage;
import com.nobroker.sprint.pages.Shortlist;



public class Pages {
	public static DashboardPage dashpage;
	public static AvoidBrokers  Broker;
	public static HomeRepair homerepair;
	public static Painiting_AC paintingAc;
	public static RentalPage rental;
	public static Shortlist shortlist;
	
	public static void LoadAllPages(WebDriver driver) {
	    dashpage = PageFactory.initElements(driver, DashboardPage.class);
		Broker=PageFactory.initElements(driver,AvoidBrokers.class);
		homerepair=PageFactory.initElements(driver,HomeRepair.class);
		paintingAc=PageFactory.initElements(driver, Painiting_AC.class);
		rental=PageFactory.initElements(driver, RentalPage.class);
		shortlist=PageFactory.initElements(driver,Shortlist.class);
	}

	}


