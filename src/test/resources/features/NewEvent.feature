@DICETests
Feature: MIO Sign up Page Functionality for MIO Users

  @test2
  Scenario: MIO User can create and submit a new event
    Given User is registered and signed into MIO
    When User clicks New Event button and creates a new event
    Then The Event is created successfully with following details
      | Field        | Value                           |
      | Type         | Comedy                          |
      | Title        | Test Event                      |
      | Genre        | Parody                          |
      | Venue        | London                          |
      | Timezone     | (GMT+01:00) British Summer Time |
      | Announcement | Current Date                    |
      | Lineup       | 6:00 PM                         |
      | Description  | Test                            |
      | Age limit    | This is an 18+ event            |
      | Currency     | GBP                             |
