Feature: Vehicle Shifting Flow - Packers and Movers

  Scenario: Verify vehicle shifting flow and summary page using Excel data

    When User clicks on Packers and Mover
    And User selects Vehicle Shifting

    And User enters source city  as "Chennai"
    And User enters destination city  as "Bangalore"
    And User selects shifting date "29/05/2026"
    And User clicks on Checks Price
    Then User should be navigated to Vechicle Inventorys page

    When User selects vehicle types:
  | VehicleType             | Count |
  | Premium Hatchback Car   | 1     |
  | Sedan Car               | 2     |
  | Luxury Car              | 1     |
  
    And User edits location "Bangalore" And "Chennai"
    Then User should either see confirmation popup or navigate to summary page
