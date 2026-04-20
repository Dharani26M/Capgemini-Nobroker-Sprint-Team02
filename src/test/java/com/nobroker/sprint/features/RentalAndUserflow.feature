Feature: Combined Functionalities - Blog, AC Repair, Home Repair, Rental, Shortlist


 



  @Rental
  Scenario: Upload draft successfully

    Given user logged in for rental
    And user clicks on Rental Agreement module
    And user uploads the draft document
    And user enters required contract details
    And user clicks on Save and Continue
    Then user should be navigated to Summary page
 




