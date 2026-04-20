package com.nobroker.sprint.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nobroker.sprint.utils.AllUtilities;

public class AvoidBrokers {
	public WebDriver driver;
	public AllUtilities utility;
	
	public AvoidBrokers(WebDriver driver) {
		this.driver=driver;
		this.utility = new AllUtilities();
		this.utility.initializeDriver(driver); 
	}
	
	@FindBy(xpath="//div[contains(text(),'Avoid')]")
	private WebElement AvoidBrokers;
	
	@FindBy(xpath="//div[.='Our Blog']")
	private WebElement OurBlog;
	
	@FindBy(xpath="//button[.='Subscribe to our blogs']")
	private WebElement Subscribe;
	
	@FindBy(id="blog_input_email")
	private WebElement EmailField;
	
	
	@FindBy(xpath="//div[contains(text(),'Finance')]")
	private WebElement Finance;
	
	@FindBy(xpath="//div[contains(text(),'NRI')]")
	private WebElement NRI;
	
	@FindBy(xpath="//button[.='Subscribe Now']")
	private WebElement Subscribebtn;
	
	
	@FindBy(xpath="//div[contains(text(),'Payments')]")
	private WebElement payment;
	
	@FindBy(xpath="//p[contains(text(),'set')]")
	private WebElement Verifying;
	

	public WebElement getVerifying() {
		return Verifying;
	}

	public WebElement getPayment() {
		return payment;
	}

	public void setPayment() {
		getPayment().click();
	}

	public WebElement getAvoidBrokers() {
		return AvoidBrokers;
	}

	public void setAvoidBrokers() {
		getAvoidBrokers().click();
	}

	public WebElement getOurBlog() {
		return OurBlog;
	}

	public void setOurBlog() {
		 getOurBlog().click();
	}

	public WebElement getSubscribe() {
		return Subscribe;
	}

	public void setSubscribe() {
		getSubscribe().click();
	}

	public WebElement getEmailField() {
		return EmailField;
	}

	public void setEmailField(String email) {
		getEmailField().sendKeys(email);
	}

	public WebElement getFinance() {
		return Finance;
	}

	public void setFinance() {
		getFinance().click();
	}

	public WebElement getNRI() {
		return NRI;
	}

	public void setNRI() {
		getNRI().click();
	}

	public WebElement getSubscribebtn() {
		return Subscribebtn;
	}

	public void setSubscribebtn() {
		getSubscribebtn().click();
	}
	
	
	

}
