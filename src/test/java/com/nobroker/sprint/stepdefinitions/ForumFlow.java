
	package com.nobroker.sprint.stepdefinitions;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;

	import com.nobroker.sprint.utils.AllUtilities;
	import com.nobroker.sprint.utils.BaseClass;
	import com.nobroker.sprint.utils.Pages;

	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class ForumFlow extends AllUtilities {

	    public ForumFlow(BaseClass base) {
	        this.initializeDriver(base.driver);
	    }
	    

@When("User should navigate to Packers and Movers page")
public void user_should_navigate_to_packers_and_movers_page() {
	Pages.dashpage.clickPackersAndMovers();
	SwitchWindowUsingUrl("packers");
    waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
}


	    @When("User clicks on the first post")
	    public void user_clicks_on_the_first_post() {
	    	
	    	scrollBypixcel(5000);
	    	WaitForVisibiltyOfElement(5, Pages.moverspage.getComment());
	    	Pages.moverspage.getComment().click();
	    }


	    @Then("User should be navigated to NoBroker forum page")
	    public void user_should_be_navigated_to_forum_page() {
	    	
	    	SwitchWindowUsingUrl("forum");

	        Assert.assertTrue(driver.getCurrentUrl().contains("forum"));
	    }


	    @When("User clicks on {string}")
	    public void user_clicks_on_post_comment(String action) {

	        if (action.equalsIgnoreCase("PostComment")) {

	            WebElement btn = Pages.forumpage.getPostQuestion();

	            scrollToElement(btn);
	            WaitForToBeClickableOfElement(20, btn);

	            btn.click();
	        }
	    }

	
	    @Then("User should be navigated to Ask Question page")
	    public void user_should_be_navigated_to_ask_question_page() {
	    	
	    SwitchWindowUsingUrl("realestateaskquestions");

	        Assert.assertTrue(driver.getCurrentUrl().contains("ask"),
	                "Not navigated to Ask Question page");
	    }


	    @When("User enters username as {string}")
	    public void user_enters_username(String name) {

	        WebElement ele = Pages.askquestion.getUsername();

	        WaitForToBeClickableOfElement(20, ele);
	        ele.sendKeys(name);
	    }


	    @When("User enters email as {string}")
	    public void user_enters_email(String mail) {

	        Pages.askquestion.getEmail().sendKeys(mail);
	    }

	
	    @When("User enters question title as {string}")
	    public void user_enters_question_title(String title) {

	        Pages.askquestion.getQuestiontitle().sendKeys(title);
	    }


	    @When("User enters question description as {string}")
	    public void user_enters_description(String desc) {

	        Pages.askquestion.getQuestion_description().sendKeys(desc);
	    }

	
	    @When("User selects category as {string}")
	    public void user_selects_category(String category) {

	        Pages.askquestion.select_Categories(category);
	        Pages.askquestion.getPostYourQuestion().click();
	    }

	
	    @When("User clicks on Publish Your Question")
	    public void user_clicks_publish_question() {
	    	
	         Pages.askquestion.getPostYourQuestion().click();
	         
	    }


	    @Then("Confirmation message should be displayed")
	    public void confirmation_message_should_be_displayed() {

	        Assert.assertTrue(Pages.askquestion.getErrormessage().isDisplayed()||Pages.askquestion.getConfirmation().isDisplayed());
	    }
	}

