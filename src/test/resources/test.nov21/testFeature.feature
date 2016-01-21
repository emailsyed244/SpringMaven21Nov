@firstProg
Feature: To test the framework

  Scenario: Verify the Company logo
    Given the user logins
    When user gets to the home page
    Then user should see the company logo


  Scenario: Verify the History Page
    Given the user logins
    When user clicks on "History" link
    Then user should see the "History" page

  Scenario: Verify the Favourite Page
    Given the user logins
    When user clicks on "Favourites" link
    Then user should see the "Favourite" page