Feature: Forum post navigation and Ask Question flow

Scenario: Verify forum post navigation and ask question flow


When User should navigate to Packers and Movers page

When User clicks on the first post
Then User should be navigated to NoBroker forum page

When User clicks on "PostComment"
Then User should be navigated to Ask Question page

When User enters username as "TestUser"
And User enters email as "testuser@gmail.com"
And User enters question title as "Test Question Title"
And User enters question description as "This is a test description for automation"
And User selects category as "Packers and Movers"
And User clicks on Publish Your Question

Then Confirmation message should be displayed
