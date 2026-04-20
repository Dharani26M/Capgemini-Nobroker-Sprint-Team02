package com.nobroker.sprint.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {
@FindBy(css="[class='title visible-desktop']")
private WebElement Title;

public WebElement getTitle() {
	return Title;
}



}
