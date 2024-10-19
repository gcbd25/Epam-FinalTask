Feature: Create Account

  @CreateAccount
  @Severity=Normal
  Scenario Outline: As a User, I want to validate the different strength types for password field
    Given User Launch "Edge" Browser
    When User Opens URL
    And User click Create Account Link
    Then User validate page title as "Create New Customer Account"
    And User enters "<Password>" on Create Account Page
    Then User validate password strength as "<Security>"

    Examples:
      |Password       | Security   |
      |Abc            | Weak       |
      |Test12345      | Medium     |
      |Test12345?     | Strong     |
      |###Test12345?  | Very Strong|
