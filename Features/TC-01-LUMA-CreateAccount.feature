Feature: Create Account in LUMA Website

  @CreateAccount
  @Severity=Critical
  Scenario: As a User, I want to validate the functionality for Log In using Valid Credentials
    Given User Launch "Chrome" Browser
    When User Opens URL
    And User click Create Account Link
    Then User validate page title as "Create New Customer Account"
    And User enters First Name on Crate Account Page
    And User enters Last Name on Crate Account Page
    And User enters Email on Crate Account Page
    And User enters Password on Crate Account Page
    And User enters Confirms Password on Crate Account Page
    And User click Create Account Button
    Then User validate page title as "My Account"