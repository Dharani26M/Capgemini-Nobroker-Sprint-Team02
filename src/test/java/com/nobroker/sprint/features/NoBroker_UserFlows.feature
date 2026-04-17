Feature: NoBroker End-to-End Functional Validation

  @Blog
  Scenario: User subscribes to blog successfully

    Given user launches browser for blog module
    And user opens Avoid Broker application
    When user selects Avoid Broker option
    And user navigates to blog section
    And user clicks subscribe option in blog
    And user enters email in blog subscription field
    And user enters preferences in blog form
    And user submits blog subscription
    Then blog subscription should be successful


  @HomeRepair
  Scenario: Verify login is required before booking home repair service

    Given user launches browser for home repair module
    And user opens NoBroker application for home repair
    When Click on Painting option for home repair
    And Select city for home repair
    And Select Home Repair service
    And Click on Switch and Socket
    And Add product and proceed in home repair
    Then login popup should be displayed


  @ACRepair
  Scenario: Verify user can trigger login in AC repair

    Given user launches browser for AC repair module
    And user opens NoBroker application for AC repair
    When Click on Painting option for AC repair
    And Select city for AC repair
    And Select AC repair service
    And Add AC service
    Then login popup should be displayed for AC repair


  @Rental
  Scenario: Upload draft successfully

    Given user opens the browser for rental module
    And user navigates to rental application
    When user enters phone number for rental and clicks continue
    And user enters OTP for rental
    And user clicks on Rental Agreement module
    And user uploads the draft document
    And user enters required contract details
    And user clicks on Save and Continue
    Then user should be navigated to Summary page