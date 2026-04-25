Feature: Apply the home loan
Background:
Given The user should be logged in

Scenario:4 The user wants to take loan and check the interest
When user clicks on the Apply Home Loan 
And user request for loan amount 
|loanamt|
|1000000|
And user set the rate of interest
|interest|
|3| 
And user set the tenure 
|tenure|
|10|
And check the eligibility criteria 
And user should give pan number 
|pan|
|ABCDE1234F|
And user will proceed future and clicks continue 
Then loan page should get displayed