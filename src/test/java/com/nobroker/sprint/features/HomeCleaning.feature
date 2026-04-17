Feature: Home Cleaning Service Booking

  Scenario: User books a home cleaning service successfully
   
    When User clicks on Home tile
    And User selects Home Cleaning option
    And User selects Weekly Cleaning service
    And User selects number of bathrooms as 4
    And User selects frequency as Once in 2 weeks
    And User clicks on Proceed button
    Then Mobile number popup should be displayed