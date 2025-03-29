Feature: Log In

  Scenario: As a User, I want to validate error message when trying to Log In without information on Username and Password fields
    Given User launch Sauce Demo website
    And User enter a Valid Username
    And User enter a Valid Password
    And User clear Username Field
    #And User clear Username Field
    #When User click login button
    #Then User should be able to see