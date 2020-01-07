@smoke_test
Feature: Smoke test
This is for all the important functionality
  this is another line created by local machine

  Background: open login page and login as store manager
    Given user is on the login page
    Then user logs in as store manager
  @reg
  Scenario: Verify dashboard page
    And user verifies that "Dashboard" page subtitle is displayed

  Scenario: Verify Manage Dashboards page
    And user navigates to "Dashboards" then to "Manage Dashboards"
    Then user verifies that "All Manage Dashboards" page subtitle is displayed
  @reg
  Scenario: Verify Vehicle page
    And user navigates to "Fleet" then to "Vehicles"
    Then user verifies that "All Cars" page subtitle is displayed

  Scenario: Verify Accounts page
    And user navigates to "Customers" then to "Accounts"
    Then user verifies that "All Accounts" page subtitle is displayed
