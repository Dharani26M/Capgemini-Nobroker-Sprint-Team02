Feature: Profile and Feature Validation

  Background: 
    Given the user has successfully logged into the application

  # Scenario 1: Positive Profile Update
  @Profile @Positive
  Scenario: Profile Name Persistence and Refresh Validation
    And the user navigates has the Profile page
    When the user updates profile name to "Dharani Raj"
    And the user refreshes the current page
    Then the profile name should be displayed as "Dharani Raj"

