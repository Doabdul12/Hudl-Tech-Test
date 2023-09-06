@DICETests @MioLoginTests
Feature: MIO Sign up Page Functionality for MIO Users

  @test1
  Scenario: A user can sign into MIO as a mio user
    Given User is on the MIO Sign In page
    When User signs in with their MIO username and password
    Then User is signed into MIO successfully
