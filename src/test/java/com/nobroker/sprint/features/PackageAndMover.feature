Feature: Within City Shifting Flow - Packers and Movers

  Scenario Outline: Verify within city shifting with multiple location inputs


    When User clicks on Packers and Movers
    Then User should be navigated to Packers and Movers page

    When User selects WithinCity option
    And User enters Cityname as "<CityName>"
    And User enters ShiftingFrom location as "<FromLocation>"
    And User enters ShiftingTo location as "<ToLocation>"
    And User clicks on checkprice
    Then User should be navigated to Inventory page

    
  When User adds inventory items:
    | Category   | SubCategory  | Item Name                     |
    | Bedrooms   | Chair          | Arm Chair              |
  

  And User clicks on Continue

  

    When User selects shifting date as "<Date>" 
    Then User click Confirm Booking

  Examples:
   | CityName | FromLocation         | ToLocation           | Date      | Period  | TimeSlot |
    | Mumbai  | Chennai TradeCentre | Chennai Nandapakkam  | 20 Apr    | Evening | 4PM-5PM  |
   

  

