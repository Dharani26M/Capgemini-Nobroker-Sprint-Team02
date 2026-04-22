Feature: Careers Page Functionality

Scenario: Navigate to Careers page and view all opportunities
When User clicks on menu button
And User clicks on Careers option from menu
Then Careers page should be displayed
When User clicks on See all opportunities button
Then User should be redirected to LinkedIn page

  
  Scenario: User books a home cleaning service successfully
   Background: 

    When User clicks on Home tile
    And User selects Home Cleaning option
    And User selects Weekly Cleaning service
    And User selects number of bathrooms 
    And User selects frequency as Once in 2 weeks
    And User clicks on Proceed button
    Then Bathroom Clean Page should be displayed 
    
Scenario: Validate loan eligibility using Excel data
    When User clicks on Loan Eligibility option
    And User enters the details
    Then Loan eligibility should be calculated successfully
    
    
Scenario Outline: Search for PG with filters using multiple data sets
    
    When User clicks on the location field and enters location
    And User selects the locality "<locality>"
    And User clicks on PG Hostel tab
    And User clicks the Search button
    And User clicks the filters
    Then The shortlist page should be displayed
    

    Examples:
    | locality| |mobileno|         
    |  porur  | |9486778413|
    
    

Scenario: User posts a property with valid details
Background: 
 
    When User clicks on Post Your Property button
    And User Click PostNow 
    And User click SelectCity
    And User click StartPosting 
    And User click the preview 
    Then User should be navigated to the preview page


    


