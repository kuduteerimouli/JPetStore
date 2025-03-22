Feature: Signin to JPetStore

Scenario: Signin with valid credentials
    Given User navigates to JPetStore login page
    When User enters username  
    And User enters password
    Then User clicks on login button
    Then User should be logged in successfully
