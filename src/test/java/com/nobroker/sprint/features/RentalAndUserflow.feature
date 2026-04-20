Feature: Combined Functionalities - Blog, AC Repair, Home Repair, Rental, Shortlist


  @Blog
  Scenario Outline: User subscribes to blog successfully

    Given the user has logged into  application
    When user selects Avoid Broker option
    And user navigates to blog section
    And user clicks subscribe option in blog
    And user enters email in blog subscription field "<email>"
    And user enters preferences in blog form
    And user submits blog subscription
    Then blog subscription should be successful

    Examples:
      | email              |
      | test1@gmail.com   |
      | user123@yahoo.com |
      | sample@mail.com   |



  @ACRepair
  Scenario: Verify user can trigger login in AC repair
  
    Given the user has logged into the application
    When Click on Painting option for AC repair
    And Select city for AC repair
    And Select AC repair service
    And Add AC service
    Then payment page should be displayed verified



  @HomeRepair
  Scenario: Verify login is required before booking home repair service

    When Click on Painting option for home repair
    And Select city for home repair
    And Select Home Repair service
    And Click on Switch and Socket
    And Add product and proceed in home repair
    Then login popup should be displayed



  @Rental
  Scenario: Upload draft successfully

    Given user logged in for rental
    And user clicks on Rental Agreement module
    And user uploads the draft document
    And user enters required contract details
    And user clicks on Save and Continue
    Then user should be navigated to Summary page



  @Shortlist
  Scenario: Shortlisting properties

    Given user logged in for shortlisting
    And navigates to the application
    When user enters phone number and clicks continue
    And user enters OTP
    When user clicks MyDashBoard 
    And clicks shortlist
    And your shortlistand clicks sales
    Then verify property available


