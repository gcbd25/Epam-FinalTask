Feature: Create Account

  @CreateAccount
  @Severity=Normal
  Scenario: As a User, I want to validate cannot Create an Account with an empty form
    Given User Launch "Chrome" Browser
    When User Opens URL
    And User click Create Account Link
    Then User validate page title as "Create New Customer Account"
    And User click Create Account Button
    Then User validate "5" error messages on Create Account Page