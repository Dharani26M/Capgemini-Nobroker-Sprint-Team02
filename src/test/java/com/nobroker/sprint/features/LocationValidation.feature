Feature: Packers and Movers  Location Validation

Scenario Outline: Verify error messages for invalid location inputs

Given User is on Packers and Movers page

When User enters ShiftingFrom as "<from>"
And User enters ShiftingTo as "<to>"
And User clicks on Check Prices
Then "<pickupError>" pickup error should be displayed
And "<destinationError>" destination error should be displayed

Examples:
| from     | to       | pickupError | destinationError |
|          |          | true        | true             |