package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.nobroker.sprint.pages.*;

public class Pages {

    // ThreadLocal container to hold an instance of Pages for each thread
    private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();

    // Instance variables (not static) for your specific pages
    public  DashboardPage dashpage;
    public  AvoidBrokers Broker;
    public  HomeRepair homerepair;
    public  Painiting_AC paintingAc;
    public  RentalPage rental;
    public  Shortlist shortlist;

   
    public static void LoadAllPages(WebDriver driver) {
        Pages p = new Pages();
        p.dashpage = PageFactory.initElements(driver, DashboardPage.class);
        p.Broker = PageFactory.initElements(driver, AvoidBrokers.class);
        p.homerepair = PageFactory.initElements(driver, HomeRepair.class);
        p.paintingAc = PageFactory.initElements(driver, Painiting_AC.class);
        p.rental = PageFactory.initElements(driver, RentalPage.class);
        p.shortlist = PageFactory.initElements(driver, Shortlist.class);
        
        threadPages.set(p);
    }

   
    public static Pages get() {
        return threadPages.get();
    }

    
    public static void remove() {
        threadPages.remove();
    }

    // --- Static Getters for easier access in Test scripts ---

    public static DashboardPage getDashpage() {
        return get().dashpage;
    }

    public static AvoidBrokers getBroker() {
        return get().Broker;
    }

    public static HomeRepair getHomeRepair() {
        return get().homerepair;
    }

    public static Painiting_AC getPaintingAc() {
        return get().paintingAc;
    }

    public static RentalPage getRental() {
        return get().rental;
    }

    public static Shortlist getShortlist() {
        return get().shortlist;
    }
}
