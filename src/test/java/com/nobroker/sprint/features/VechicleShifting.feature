Feature: Vehicle Shifting Flow - Packers and Movers

  Scenario Outline: Verify vehicle shifting flow and summary page using Excel data

    When User clicks on Packers and Mover
    And User selects Vehicle Shifting

    And User enters source city  as "<FromCity>"
    And User enters destination city  as "<ToCity>"
    And User selects shifting date "<Date>"
    And User clicks on Checks Price
    Then User should be navigated to Vechicle Inventorys page

    When User selects vehicle type  as "<VehicleType>"
    And User edits location "<RelocationFromCity>" And "<RelocationToCity>"
    And User clicks on Continue
    Then User should navigate to summarypage

Examples:
  | FromCity | ToCity    |Date        | VehicleType | RelocationFromCity | RelocationToCity |
  | Chennai  | Bangalore |25/05/2026  | SUV Car     | Chennai        | Bangalore        |