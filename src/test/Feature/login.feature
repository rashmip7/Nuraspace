Feature: Login Functionality
  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters valid username "tester.nura@nuraspace.com" and password "tester@Nura1"
    Then the user should be logged in successfully


