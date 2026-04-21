package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.sprint.utils.AllUtilities;


public class HomeLoanPage {
WebDriver driver;
	
	public AllUtilities utilities; 
	public HomeLoanPage(WebDriver driver) {
		utilities =new AllUtilities();
		this.driver = driver;
		this.utilities.initializeDriver(driver);
	}
	
	//home loan
	@FindBy(xpath="//a[text()='Apply Home Loan']")
	private WebElement loan;
	
	//property finialized radio button
	@FindBy(xpath="//label[text()='No']//..//input")
	private WebElement radio;
	
	//loan amount
	@FindBy(xpath="(//span[text()='Loan Amount']/..//input[@type='text'])[1]")
	private WebElement loanamt;
	
	//rate of intrest
	@FindBy(xpath="(//span[text()='Rate of Interest (P.A)']/..//input[@type='Number'])[1]")
	private WebElement interest;
	
	//loan tenure
	@FindBy(xpath="(//span[text()='Loan Tenure']/..//input[@type='Number'])[1]")
	private WebElement tenure;
	
	//check loan eligibility
	@FindBy(xpath="(//button[text()='Check Eligibility'])[2]")
	private WebElement checkbtn;
	
	//pan number
	@FindBy(xpath="(//span[text()='PAN Number *'])[2]/..//input")
	private WebElement pan;
	
	//continue
	@FindBy(xpath="(//button[text()='Continue'])[3]")
	private WebElement continueBtn;
	
	//assert the loan page
	@FindBy(xpath="//p[.='Income Details']")
	private WebElement loanPage;
	
	//getters
	public WebElement getLoan() {
		return loan;
	}

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getLoanamt() {
		return loanamt;
	}

	public WebElement getInterest() {
		return interest;
	}

	public WebElement getTenure() {
		return tenure;
	}

	public WebElement getCheckbtn() {
		return checkbtn;
	}

	public WebElement getPan() {
		return pan;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public boolean checkLoanPage() {
		return loanPage.isDisplayed();
	}
	
	//setters
	public void clickLoan() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loanBtn = wait.until(ExpectedConditions.elementToBeClickable(getLoan()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loanBtn);
	}
	
	public void clickRadio() {
		utilities.SwitchWindowUsingUrl("loan");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getRadio())).click();
	}

	public void setLoanamt(String loanamt) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement amt =wait.until(ExpectedConditions.visibilityOf(getLoanamt()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", amt);
		getLoanamt().sendKeys(Keys.CONTROL+"a");
		getLoanamt().sendKeys(Keys.BACK_SPACE);
		getLoanamt().sendKeys(loanamt);
	}

	public void setInterest(String interest) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement intr =wait.until(ExpectedConditions.visibilityOf(getInterest()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", intr);
		getInterest().sendKeys(Keys.CONTROL+"a");
		getInterest().sendKeys(Keys.BACK_SPACE);
		getInterest().sendKeys(interest);
	}

	public void setTenure(String tenure) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement yr =wait.until(ExpectedConditions.visibilityOf(getTenure()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", yr);
		getTenure().sendKeys(Keys.CONTROL+"a");
		getTenure().sendKeys(Keys.BACK_SPACE);
		getTenure().sendKeys(tenure);
	}

	public void setCheckbtn() {
		
		utilities.WaitForToBeClickableOfElement(10, getCheckbtn());
		getCheckbtn().click();
	}

	public void setPan(String pan) {
		utilities.WaitForVisibiltyOfElement(10, getPan());
		getPan().sendKeys(pan);
	}

	public void setContinueBtn() {
		utilities.WaitForToBeClickableOfElement(10, getContinueBtn());
		getContinueBtn().click();
	}

	public void setLoanPage() {
		System.out.println("Loge page is displayed");
	}	

}
