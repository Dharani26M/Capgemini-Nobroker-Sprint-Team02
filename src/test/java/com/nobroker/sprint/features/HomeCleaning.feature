Feature: Home Cleaning Service Booking
  
  Scenario: User books a home cleaning service successfully
   Background: 
    Given the user has successfully logged into the application
    When User clicks on Home tile
    And User selects Home Cleaning option
    And User selects Weekly Cleaning service
    And User selects number of bathrooms 
    And User selects frequency as Once in 2 weeks
    And User clicks on Proceed button
    Then Bathroom Clean Page should be displayed 