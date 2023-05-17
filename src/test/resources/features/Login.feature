@HudlRegression @LoginTests
Feature: Login Functionality for Hudl

  Background:
    Given User is on the Hudl login page

  @test1
  Scenario: User can successfully login with valid credentials
    Given User enters a valid username and password
    When User clicks on the login button
    Then User should be logged in successfully

  @test2
  Scenario Outline: User cannot login with invalid or empty credentials
    Given User enters an invalid "<username>" and "<password>"
    When User clicks on the login button
    Then User should see an error message on the Login Page indicating "<error_message>"

    Examples:
      | username             | password        | error_message                                             |
      | invalid@email.com    | invalidPassword | We didn't recognize that email and/or password.Need help? |
      | dappznasir@gmail.com | invalidPassword | We didn't recognize that email and/or password.Need help? |
      | invalid@email.com    | Inno@123        | We didn't recognize that email and/or password.Need help? |
    #I would store error messages in an enum file with more time

  @test3
  Scenario: User can Navigate to the to the Login Help page
    When User clicks on the Need Help Link
    Then User should be redirected to the password reset page

  @test4
  Scenario Outline: User cannot send a password reset request with an Email that doesn't exist in Hudl
    Given User enters an invalid "<username>" and "<password>"
    When User clicks on the Need Help Link
    And User should be redirected to the password reset page
    And User clicks the password reset button
    Then User should see an error message on the Login Help Page indicating "<error_message>"

    Examples:
      | username                  | password        | error_message                                                                                                        |
      | testnotexist@nonexist.com | invalidPassword | That email address doesn't exist in Hudl. Check with your coach to ensure they have the right email address for you. |

  @test5
  Scenario: User can Logout of their Hudl account successfully
    Given User enters a valid username and password
    When User clicks on the login button
    And User should be logged in successfully
    And User clicks on the user navigation bar
    Then User can logout successfully