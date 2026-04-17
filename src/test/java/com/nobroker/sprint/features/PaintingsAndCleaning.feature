Feature: Paintings and Cleaning Validation

  Background: 
    Given the user has successfully logged into application
  # Scenario 6: Home Services Module
  @Services
  Scenario: Navigate to Painting and Cleaning Home Interiors
    When the user navigates to the Painting and Cleaning section
    And the user selects the city "Bangalore" for cleaning services
    And the user selects Interior and Renovation
    And the user schedules a visit for Home Interiors
    Then the share button should be visible on the interiors page