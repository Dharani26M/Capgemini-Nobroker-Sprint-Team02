Feature:add NoBroker PG Search and Shortlist
Scenario Outline: Search for PG with filters using multiple data sets
    
    When User clicks on the location field and enters location
    And User selects the locality "<locality>"
    And User clicks on PG Hostel tab
    And User clicks the Search button
    And User clicks the filters
    And login using mobno "<mobileno>"
    

    Examples:
    | locality| |mobileno|         
    |  porur  | |9486778413|
    


