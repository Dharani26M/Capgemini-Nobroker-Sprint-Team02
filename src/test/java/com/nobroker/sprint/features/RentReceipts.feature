Feature: Rent Receipts Validation
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
      | Dha        | Raj       | 6374888559  | 9876543210 | 15000      | ABCDE1234F | Shanti Nagar | Anna Nagar   |      dh@test.com |
      | Suresh     | Kumar     | 7374118550  | 8876543211 | 22000      | WXYZP9876Q | Whitefield   | Indiranagar  | suresh@test.com  |
