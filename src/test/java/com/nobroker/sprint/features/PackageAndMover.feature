Feature: Within City Shifting Flow - Packers and Movers

  Scenario Outline: Verify within city shifting with multiple location inputs


    When User clicks on Packers and Movers
    Then User should be navigated to Packers and Movers page

    When User selects "Within City" option
    And User enters "SelectCity" as "<CityName>"
    And User enters "From" location as "<FromLocation>"
    And User enters "To" location as "<ToLocation>"
    And User clicks on "Check Price"
    Then User should be navigated to Inventory page

    When User adds bedroom items
    And User adds kitchen items
    And User adds living room items
    And User clicks on "Continue"

    When User selects shifting date
    Then Confirm Booking button should be enabled

  Examples:
   |CityName  | FromLocation            | ToLocation             |
   | Chennai  | Chennai TradeCentre     | Chennai TradeCentre    |
   | Chennai  | Chennai TradeCentre     | Chennai Central RailwayStation|
   | Chennai  | Chennai TradeCentre     | Chennai NandamPakkam   |
   
#Scenario: Verify between city shifting navigation to inventory page
 # Given User is on NoBroker homepage
  #When User clicks on "Packers and Movers"
  #And User selects "Between City"
  #And User enters "From City"
  #And User enters "To City"
  #And User selects shifting date
  #And User clicks on "Check Price"
  #Then User should be navigated to Inventory page
  
  #Scenario: Verify vehicle shifting flow and summary page
  #Given User is on NoBroker homepage
  #When User clicks on "Packers and Movers"
  #And User selects "Vehicle Shifting"
  #And User selects source and destination city
  #And User clicks on "Check Price"
  #Then User should be navigated to Inventory page

  #When User selects vehicle type
  #And User edits location
  #And User clicks on "Continue"
  #Then User should be navigated to Summary page
  
#Scenario: Verify clicking popular location updates within city field
 # Given User is on Packers and Movers page
  #When User scrolls down to popular locations section
#  And User clicks on any location
 # Then Selected city should be auto-filled in "Within City" field
  
# Scenario: Verify forum post navigation and ask question flow
 # Given User is on Packers and Movers page
 # When User clicks on the first post
  #Then User should be navigated to the post details page

 # When User clicks on "Comment"
  #And User enters a question
  #And User clicks on "Post Question"
  #Then User should be navigated to Ask Question confirmation or next page