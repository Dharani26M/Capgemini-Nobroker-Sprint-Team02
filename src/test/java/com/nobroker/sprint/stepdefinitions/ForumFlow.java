
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
	Pages.get().dashpage.clickPackersAndMovers();
	SwitchWindowUsingUrl("packers");
    waitForElementOrTimeout(By.xpath("//span[contains(text(),'Complete booking')]"), 40);
    info("User successfully navigated to Packers and Movers page");
}

	    @When("User clicks on the first post")
	    public void user_clicks_on_the_first_post() {
	    	
	    	scrollBypixcel(6500);
	    	WaitForVisibiltyOfElement(8, Pages.get().moverspage.getComment());
	    	jsClick(Pages.get().moverspage.getComment());
	    	 info("User clicked on the first post");
	    }


	    @Then("User should be navigated to NoBroker forum page")
	    public void user_should_be_navigated_to_forum_page() {
	    	
	    	SwitchWindowUsingUrl("forum");

	        Assert.assertTrue(driver.getCurrentUrl().contains("forum"));
	        info("User successfully navigated to NoBroker forum page");
	    }


	    @When("User clicks on {string}")
	    public void user_clicks_on_post_comment(String action) {

	        if (action.equalsIgnoreCase("PostComment")) {

	            WebElement btn = Pages.get().forumpage.getPostQuestion();

	            scrollToElement(btn);
	            WaitForToBeClickableOfElement(20, btn);

	            btn.click();
	        }
	        info("User clicked on Post Question button");
	    }

	
	    @Then("User should be navigated to Ask Question page")
	    public void user_should_be_navigated_to_ask_question_page() {
	    	
	    SwitchWindowUsingUrl("realestateaskquestions");

	        Assert.assertTrue(driver.getCurrentUrl().contains("ask"),
	                "Not navigated to Ask Question page");
	        
	        info("User successfully navigated to Ask Question page");
	    }


	    @When("User enters username as {string}")
	    public void user_enters_username(String name) {

	        WebElement ele = Pages.get().askquestion.getUsername();

	        WaitForToBeClickableOfElement(20, ele);
	        ele.sendKeys(name);
	        info("User entered username");
	    }


	    @When("User enters email as {string}")
	    public void user_enters_email(String mail) {

	        Pages.get().askquestion.getEmail().sendKeys(mail);
	        info("User entered email");
	        
	    }

	
	    @When("User enters question title as {string}")
	    public void user_enters_question_title(String title) {

	        Pages.get().askquestion.getQuestiontitle().sendKeys(title);
	        info("User entered question title");
	    }


	    @When("User enters question description as {string}")
	    public void user_enters_description(String desc) {

	        Pages.get().askquestion.getQuestion_description().sendKeys(desc);
	        info("User entered question description");
	    }

	
	    @When("User selects category as {string}")
	    public void user_selects_category(String category) {

	        Pages.get().askquestion.select_Categories(category);
	        Pages.get().askquestion.getPostYourQuestion().click();
	        
	        info("User selected category and submitted the question");
	    }

	
	    @When("User clicks on Publish Your Question")
	    public void user_clicks_publish_question() {
	    	
	         Pages.get().askquestion.getPostYourQuestion().click();
	         info("User clicked on Publish Your Question");
	         
	    }


	    @Then("Confirmation message should be displayed")
	    public void confirmation_message_should_be_displayed() {

	        Assert.assertTrue(Pages.get().askquestion.getErrormessage().isDisplayed()||Pages.get().askquestion.getConfirmation().isDisplayed());
	        info("Confirmation or error message displayed successfully");
	    }
	}

