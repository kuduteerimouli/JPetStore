Feature: Signin to JPetStore

@signin
Scenario Outline: Signin with different credentials
    Given User navigates to JPetStore login page
    When User enters username "<username>"
    And User enters password "<password>"
    Then User clicks on login button
    Then User should see "<login_status>"

    Examples:
      | username         | password         | login_status      |
      | invalid_username | invalid_password | Login failed      |
      | rage             | Ruling           | Login successful  |
