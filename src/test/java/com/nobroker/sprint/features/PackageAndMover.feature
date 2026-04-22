Feature: Within City Shifting Flow - Packers and Movers

  Scenario: Verify within city shifting with multiple inventory items 
    When User clicks on Packers and Movers
    Then User should be navigated to Packers and Movers page
    When User selects WithinCity option
    And User enters Cityname as "Bangalore"
    And User enters ShiftingFrom location as "Chennai Trade Centre"
    And User enters ShiftingTo location as "Egmore railway station"
    And User clicks on checkprice
    And User handles package popup if displayed
    Then User should be navigated to Inventory page
    When User adds inventory items
    And User clicks on Continue
    Then System should guide the user to the next step based on availability for date "25 Apr"

    