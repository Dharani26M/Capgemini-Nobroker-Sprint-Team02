Feature: Between City Shifting Flow - Packers and Movers

  Scenario: Verify between city shifting navigation to inventory page

    When User clicks on Packer and Mover
    And User clicks on Between City
    Then Between City option should be selected

    When User enters From City as "Mumbai"
    And User enters To City as "Kerala"
    And User select shifting date as "28/05/2026"
    And User clicks on Check Price
    
    When User enters modal ShiftingFrom as "Madurai" ShiftingTo as "Chennai" clicks on Update Location
    
    When User clicks on Continue without adding items
    Then A popup message should be displayed
