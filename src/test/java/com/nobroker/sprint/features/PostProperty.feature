Feature: Post Your Property on NoBroker

Scenario: User posts a property with valid details
Background: 
  
    When User clicks on Post Your Property button
    And User Click PostNow 
    And User click SelectCity
    And User click StartPosting 
    And User click the preview 
    Then User should be navigated to the preview page

