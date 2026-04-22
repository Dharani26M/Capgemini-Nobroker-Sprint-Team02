Feature: Post property Validation

  Background:
    Given the user has successfull of logged into the application
# Scenario 3: Property Module

  @Property
  Scenario: Navigate to Post Your Property section
    When the user clicks on Post Your Property from the menu
    And the user toggles the property status
<<<<<<< HEAD
    Then the user should see no property listing options
=======
Feature: Post Your Property on NoBroker

Scenario: User posts a property with valid details
Background: 
  
    When User clicks on Post Your Property button
    And User Click PostNow 
    And User click SelectCity
    And User click StartPosting 
    And User click the preview 
    Then User should be navigated to the preview page

>>>>>>> PGandHostel-Module
=======
    Then the user should see property listing options
>>>>>>> 9ceadec66fab79b1c3037331d3754939938af090
