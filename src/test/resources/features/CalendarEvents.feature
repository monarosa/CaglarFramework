@calendar_events

Feature: All calendar events
  Scenario: Verify column names
    Given User is in the login page
    And  As a user I log in to the application with username and password
    Then user navigates to "Activities" then to "Calendar Events"
    And user verifies that column names are displayed
      | TITLE             |
      | CALENDAR          |
      | START             |
      | END               |
      | RECURRENT         |
      | RECURRENCE        |
      | INVITATION STATUS |