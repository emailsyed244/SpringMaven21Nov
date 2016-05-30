@firstProg1
Feature: As a User, I want to run Company Logo and History Tests
  @wip
  Scenario: Verify the Company logo
    Given the user logins
    When user gets to the home page
    Then user should see the company logo


  Scenario: Verify the History Page
    Given the user logins
    When user clicks on "History" link
    Then user should see the "History" page

