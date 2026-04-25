Feature: Post property Validation

  Background:
    Given the user has successfull of logged into the application
# Scenario 3: Property Module

  @Property
  Scenario: Navigate to Post Your Property section
    When the user clicks on Post Your Property from the menu
    And the user toggles the property status
    Then the user should see property listing options

