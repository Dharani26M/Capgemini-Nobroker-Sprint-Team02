Feature: Verfying the metro lines

Background:
Given the user is not log in

Scenario Outline:2 The user wants to see the nearby metro lines
When user clicks on the buy button
And user selects a city "<city>"
And user enter the locality "<locality>"
And user clicks on search button 
And user skips the popups 
And user clicks on map 
And user clicks on metro 
Then user should see the lines 

Examples:
|city    |locality |
|Chennai |velachery|
|Chennai |guindy   |
