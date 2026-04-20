package com.nobroker.sprint.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.nobroker.sprint.utils.AllUtilities;

public class NobrokerAskQuestion {
	

	public WebDriver driver;
	public AllUtilities Utilities;

	public NobrokerAskQuestion(WebDriver driver) {
		Utilities = new AllUtilities();
		this.driver = driver;
		this.Utilities.initializeDriver(driver);

	}
@FindBy(id="username")
private WebElement username;

@FindBy(id="email")
private WebElement email;

@FindBy(id="question_title")
private WebElement questiontitle;

@FindBy(id="question_description")
private WebElement question_description;

@FindBy(id="parent-category")
private WebElement categories;

@FindBy(css="[value='Publish Your Question']")
private WebElement PostYourQuestion;

@FindBy(css="[class='alert-message success']")
private WebElement confirmation;

@FindBy(css="[class='error-field']")
private WebElement errormessage;

public WebElement getErrormessage() {
	return errormessage;
}

public WebElement getUsername() {
	return username;
}

public WebElement getPostYourQuestion() {
	return PostYourQuestion;
}

public WebElement getConfirmation() {
	return confirmation;
}

public WebElement getEmail() {
	return email;
}

public WebElement getQuestiontitle() {
	return questiontitle;
}

public WebElement getQuestion_description() {
	return question_description;
}

public WebElement getCategories() {
	return categories;
}

public void select_Categories(String category) {
	Select select = new Select(getCategories());
	select.selectByVisibleText(category);
	
}


}
