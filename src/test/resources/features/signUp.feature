Feature: signUp

  User is able to sign up at demoblaze portal


  Scenario: Sign up successfully

    Given User navigates to sign up form
    When User fill in Username with "@@@@@@@@@@@@@@22@@@14111223222"
    And User fill in Password with "@@@@@@@@@@@@@@@2@2@1412122212"
    And User  press Sign Up
    Then User should see "Sign up successful." confirmation message