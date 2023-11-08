Feature: HTTP Response Validation

  Scenario: Verify HTTP status code
    Given the user navigates to "https://dashboard-testing.nuraspace.com/login"
    When the user checks the HTTP response
    Then the HTTP status code should be 200
