Feature: Profile and Feature Validation

  Background: 
    Given the user has successfully logged into the application

  # Scenario 1: Positive Profile Update
  @Profile @Positive
  Scenario: Profile Name Persistence and Refresh Validation
    And the user navigates to the Profile page
    When the user updates the profile name to "Dharani Raj"
    And the user refreshes the current page
    Then the profile name should be displayed as "Dharani Raj"

  # Scenario 2: Negative Profile Update
  @Profile @Negative
  Scenario: Update user profile name with invalid format
    And the user navigates to the Profile page
    When the user updates the profile name to "123456!@#"
    Then an error message should be displayed indicating an invalid name format
    And the profile changes should not be saved "123456!@#"

  # Scenario 3: Property Module
  @Property
  Scenario: Navigate to Post Your Property section
    When the user clicks on Post Your Property from the menu
    And the user toggles the property status
    Then the user should see no property listing options

  # Scenario 4: Rent Receipt Module (Scenario Outline + PDF Validation)
  @RentReceipt
  Scenario Outline: Generate and download a Rent Receipt
    When the user navigates to the Rent Receipts section
    And the user fills the rent receipt form with "<TenantName>", "<OwnerName>", "<TenantPhone>", "<OwnerPhone>", "<RentAmount>", "<PAN>", "<Address>", "<OwnerAddress>", and "<Email>"
    And the user clicks on Generate Receipt
    And the user clicks on Download Receipt
    Then the page should navigate to a URL containing ".pdf"

    Examples: 
      | TenantName | OwnerName | TenantPhone | OwnerPhone | RentAmount | PAN        | Address      | OwnerAddress | Email            |
      | Dharani    | Raj M     | 6374118559  | 9876543210 | 15000      | ABCDE1234F | Shanti Nagar | Anna Nagar   | dharani@test.com |
      | Suresh     | Kumar     | 7374118550  | 8876543211 | 22000      | WXYZP9876Q | Whitefield   | Indiranagar  | suresh@test.com  |

  # Scenario 5: Referral Module (Data Table)
  @Referral
  Scenario: Refer an Owner and Earn
    When the user navigates to the Refer and Earn section
    And the user enters owner details for referral:
      | City    | Phone      | Name      | PropType | Description        |
      | Chennai | 9123456789 | Raj Kumar | House    | Interested in Rent |
    Then the referral details should be submitted

  # Scenario 6: Home Services Module
  @Services
  Scenario: Navigate to Painting and Cleaning Home Interiors
    When the user navigates to the Painting and Cleaning section
    And the user selects the city "Bangalore" for cleaning services
    And the user selects Interior and Renovation
    And the user schedules a visit for Home Interiors
    Then the share button should be visible on the interiors page