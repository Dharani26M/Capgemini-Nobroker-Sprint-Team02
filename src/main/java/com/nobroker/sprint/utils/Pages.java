package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nobroker.sprint.pages.AddInventoryPage;
import com.nobroker.sprint.pages.AvoidBrokers;
import com.nobroker.sprint.pages.Buy;
import com.nobroker.sprint.pages.CareersPage;
import com.nobroker.sprint.pages.ContactPage;
import com.nobroker.sprint.pages.DashboardPage;
import com.nobroker.sprint.pages.HomeCleaningPage;
import com.nobroker.sprint.pages.HomeInteriorsPage;
import com.nobroker.sprint.pages.HomeLoan;
import com.nobroker.sprint.pages.HomeLoanPage;
import com.nobroker.sprint.pages.HomeRenovationPage;
import com.nobroker.sprint.pages.HomeRepair;
import com.nobroker.sprint.pages.MapPage;
import com.nobroker.sprint.pages.NewIconPage;
import com.nobroker.sprint.pages.NobrokerAskQuestion;
import com.nobroker.sprint.pages.NobrokerForumPage;
import com.nobroker.sprint.pages.NotaryAdvocatePage;
import com.nobroker.sprint.pages.OrderSummary;
import com.nobroker.sprint.pages.PG_HostelPage;
import com.nobroker.sprint.pages.PackersAndMoversPage;
import com.nobroker.sprint.pages.Painiting_AC;
import com.nobroker.sprint.pages.PaintingsAndCleaningPage;
import com.nobroker.sprint.pages.PaymentPage;
import com.nobroker.sprint.pages.PostyourPropertyPage;
import com.nobroker.sprint.pages.ProfilePage;
import com.nobroker.sprint.pages.PropertyPremium;
import com.nobroker.sprint.pages.ReferAndEarnPage;
import com.nobroker.sprint.pages.RentReceiptPage;
import com.nobroker.sprint.pages.RentalPage;
import com.nobroker.sprint.pages.Shortlist;
import com.nobroker.sprint.pages.VechicleAddInventoryPage;

public class Pages {

	private static final ThreadLocal<Pages> threadPages = new ThreadLocal<>();
	public DashboardPage dashpage;
	public AvoidBrokers Broker;
	public HomeRepair homerepair;
	public Painiting_AC paintingAc;
	public RentalPage rental;
	public Shortlist shortlist;
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
	public HomeLoanPage homeloan;
	public PackersAndMoversPage moverspage;
	public AddInventoryPage inventorypage;
	public OrderSummary summary;
	public VechicleAddInventoryPage vechicleinventory;
	public PaymentPage payment;
	public NobrokerAskQuestion askquestion;
	public NobrokerForumPage forumpage;
	public Buy buy;
	public MapPage mapPage;
	public HomeRenovationPage renovationPage;
	public HomeLoanPage loanPage;
	public NotaryAdvocatePage notaryPage;
	public ContactPage contactPage;
	public HomeLoan home;

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
		p.homeloan = PageFactory.initElements(driver, HomeLoanPage.class);
		p.Broker = PageFactory.initElements(driver, AvoidBrokers.class);
		p.homerepair = PageFactory.initElements(driver, HomeRepair.class);
		p.paintingAc = PageFactory.initElements(driver, Painiting_AC.class);
		p.rental = PageFactory.initElements(driver, RentalPage.class);
		p.shortlist = PageFactory.initElements(driver, Shortlist.class);
		p.moverspage = PageFactory.initElements(driver, PackersAndMoversPage.class);
		p.inventorypage = PageFactory.initElements(driver, AddInventoryPage.class);
		p.vechicleinventory = PageFactory.initElements(driver, VechicleAddInventoryPage.class);
		p.summary = PageFactory.initElements(driver, OrderSummary.class);
		p.payment = PageFactory.initElements(driver, PaymentPage.class);
		p.askquestion = PageFactory.initElements(driver, NobrokerAskQuestion.class);
		p.forumpage = PageFactory.initElements(driver, NobrokerForumPage.class);
		p.buy = PageFactory.initElements(driver, Buy.class);
		p.mapPage = PageFactory.initElements(driver, MapPage.class);
		p.renovationPage = PageFactory.initElements(driver, HomeRenovationPage.class);
		p.loanPage = PageFactory.initElements(driver, HomeLoanPage.class);
		p.notaryPage = PageFactory.initElements(driver, NotaryAdvocatePage.class);
		p.contactPage = PageFactory.initElements(driver, ContactPage.class);
		p.home=PageFactory.initElements(driver, HomeLoan.class);
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

	public static HomeLoanPage getHomeLoanPage() {
		return get().homeloan;
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
	
	public static HomeLoan gethomeloan() {
		return get().home;
	}

	public static Shortlist getShortlist() {
		return get().shortlist;
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
