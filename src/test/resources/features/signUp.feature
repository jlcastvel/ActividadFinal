Feature: signUp

  User is able to sign up in demoblaze portal


  Scenario: Sign up successfully

    Given User navigates to sign up form
    When User fill in Username with "@@@@@@@@@@@@@@@@@14"
    And User fill in Password with "@@@@@@@@@@@@@@@@@14"
    And User  press Sign Up
    Then User should see "Sign up successful." confirmation message