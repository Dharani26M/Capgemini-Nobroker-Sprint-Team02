Feature: Packers and Movers Location Validation

Scenario Outline: Verify error handling for invalid location inputs

  Given User is on Packers and Movers page

  When User enters ShiftingFrom as "<from>"
  And User enters ShiftingTo as "<to>"
  And User clicks on Check Prices

  Then pickup error should be "<pickupError>"
  And destination error should be "<destinationError>"

Examples:
| from                  | to                    | pickupError | destinationError |
|                       |                       | true        | true             | 
| Egmore railyway station|                      | false       | true             | 
| Chennai Trade center  | Chennai Trade center  | true        | true              | 