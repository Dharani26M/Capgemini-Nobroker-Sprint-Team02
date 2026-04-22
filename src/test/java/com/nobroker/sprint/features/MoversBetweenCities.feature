Feature: Between City Shifting Flow - Packers and Movers

  Scenario Outline: Verify between city shifting navigation to inventory page

    When User clicks on Packer and Mover
    And User clicks on Between City
    Then Between City option should be selected

    When User enters From City as "<FromCity>"
    And User enters To City as "<ToCity>"
    And User select shifting date as "<Date>"
    And User clicks on Check Price
    
    When User enters modal ShiftingFrom as "<ShiftingFrom>" ShiftingTo as "<ShiftingTo>" clicks on Update Location
    

    When User clicks on Continue without adding items
    Then A popup message should be displayed

  Examples:
    | FromCity | ToCity     | Date        |    ShiftingFrom        | ShiftingTo           |
    | Mumbai  | Kerala  | 28/05/2026  | Madurai                | Chennai |
 