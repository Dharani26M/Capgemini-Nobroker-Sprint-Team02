Feature: Negative Profile and Feature Validation

  Background:
    Given the user has log into the application
# Scenario 2: Negative Profile Update

  @Profile @Negative
  Scenario: Update user profile name with invalid format 
    And the user navigates to the Profile page
    When the user updates the profile name
    Then an error message should be displayed indicating an invalid name format
    And the profile changes should not be saved 
    