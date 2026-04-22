Feature:Buy property on No Broker
Background:
Given the user is not logged in

Scenario:select User search property with different location and locality
When  user clicks on buy button 
And user selects the city "Chennai"
And user enters the locality "velachery"
And user clicks on search 
And user skips the popup 
And user applies filter
And user clicks on View All projects
And user selects the property from list 
Then user clicks on contact builder 
