@LoginFeature
Feature: Login Feature

  Background: Open the Login Page
    Given User has navigated to the login page

  @Regression @Sanity
  Scenario: Positive Login Scenario
    When User eneters correct username and password
    And User clicks on the Login Button
    Then User should be navigated to the Home Page
@Regression
  Scenario: Positive Login Scenario with parameters
    When User eneters correct username "avc@xyz.com" and password "Abc@1234"
    And User clicks on the Login Button
    Then User should be navigated to the Home Page

  Scenario Outline: Positive Login Scenario with parameters
    When User eneters correct username "<UserName>" and password "<Password>"
    And User clicks on the Login Button
    Then User should be navigated to the Home Page

    Examples: 
      | UserName    | Password |
      | abc@xyz.com | Abc@1234 |
      | pqr@abc.com | Abc1234! |

  Scenario Outline: Negative Login Scenario with parameters
    When User eneters correct username "<UserName>" and password "<Password>"
    And User clicks on the Login Button
    Then User should be getting the error message "<Error>"

    Examples: 
      | UserName    | Password | Error                                              |
      | abc@xyz.com | Abc@1234 | The email or password you have entered is invalid. |
      | pqr@abc.com | Abc1234! | The email or password you have entered is invalid. |

  @DataTable
  Scenario: Positive Login Scenario with Cucumber DataTable
    When User eneters correct credentials
      | Field    | Value       |
      | UserName | abc@xyz.com |
      | Password | Abc@1234    |
    And User clicks on the Login Button
    Then User should be navigated to the Home Page
