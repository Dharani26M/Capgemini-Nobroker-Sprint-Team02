package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.*;

public class Pages {
	public DashboardPage dashpage;
	public PackersAndMoversPage moverspage;
	public AddInventoryPage inventorypage;
	public OrderSummary summary;
	public VechicleAddInventoryPage vechicleinventory;
	public PaymentPage payment;
	public NobrokerAskQuestion askquestion;
	public NobrokerForumPage forumpage;

	private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();

	public static void LoadAllPages(WebDriver driver) {
		Pages p = new Pages();
		p.dashpage = PageFactory.initElements(driver, DashboardPage.class);
		p.moverspage = PageFactory.initElements(driver, PackersAndMoversPage.class);
		p.inventorypage = PageFactory.initElements(driver, AddInventoryPage.class);
		p.vechicleinventory = PageFactory.initElements(driver, VechicleAddInventoryPage.class);
		p.summary = PageFactory.initElements(driver, OrderSummary.class);
		p.payment = PageFactory.initElements(driver, PaymentPage.class);
		p.askquestion = PageFactory.initElements(driver, NobrokerAskQuestion.class);
		p.forumpage = PageFactory.initElements(driver, NobrokerForumPage.class);
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

	public static PackersAndMoversPage getMoversPage() {
		return get().moverspage;
	}

	public static AddInventoryPage getInventoryPage() {
		return get().inventorypage;
	}

	public static OrderSummary getSummaryPage() {
		return get().summary;
	}

	public static VechicleAddInventoryPage getVechicleInventoryPage() {
		return get().vechicleinventory;
	}

	public static PaymentPage getPaymentPage() {
		return get().payment;
	}

	public static NobrokerAskQuestion getAskQuestionPage() {
		return get().askquestion;
	}

	public static NobrokerForumPage getForumPage() {
		return get().forumpage;
	}

}
