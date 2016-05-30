@firstProg
Feature: As a User, I want to check items of history and Favourite pages

  Scenario: Verify the History Items on the History Page
    Given the user logins
    When user clicks on "History" link
    Then user should see the "History" page

  Scenario: Verify the Favourite Page
    Given the user logins
    When user clicks on "Favourites" link
    Then user should see the "Favourite" page