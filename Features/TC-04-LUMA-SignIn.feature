Feature: Sign In

  @SignIn
  @Severity=Critical
  Scenario: As a User, I want to successfully Sign In into my account
    Given User Launch "Edge" Browser
    When User Opens URL
    And User click Sign In Link
    Then User validate page title as "Customer Login"
    And User enters Valid Email on Sign In Page
    And User enters Valid Password on Sign In Page
    And User click Sign In Button
    Then User validate login dropdown message