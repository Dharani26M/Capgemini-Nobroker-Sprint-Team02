Feature: Refer and Earn Validation

  Background:
    Given the user has successfully logged into the app

  # Scenario 5: Referral Module (Data Table)
  @Referral
  Scenario: Refer an Owner and Earn
    When the user navigates to the Refer and Earn section
    And the user enters owner details for referral:
      | City    | Phone      | Name      | PropType | Description        |
      | Chennai | 9123456789 | Raj Kumar | Rent     | Interested in Rent |
    Then the referral details should be submitted
