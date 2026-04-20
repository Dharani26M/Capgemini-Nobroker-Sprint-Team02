Feature: AC and Appliance Repair Service on NoBroker

  Scenario: User books a Microwave Repair service in Chennai
    When User clicks on the "Painting" icon
    And User verifies the location is "Chennai"
    And User clicks on "AC & Appliance" section
    And User clicks on "Appliance Repair" option
    And User clicks on "Microwave" category
    And User clicks on "View details" for Microwave Repair
    And User clicks on "Add" button
    And User clicks on "Proceed" button
    Then User should be navigated to the booking page