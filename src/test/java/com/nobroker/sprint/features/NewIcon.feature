Feature: NoBroker Rewards and Membership Navigation

  Background:
    Given the user has successfully logged into the application

  @Navigation @Rewards @Membership
  Scenario: End-to-End validation of Rewards and VIP Membership flow
    When the user clicks on the "New" icon in the header
    Then the user should be redirected to the NoBroker Rewards page
    And the page title should contain "Rewards"
    When the user clicks on the Buy VIP button
    Then the user should navigate to the NoBroker VIP Memberships page
    And the URL should contain "vip"
