Feature: Text Checks

  Scenario: Verify Multiple Text Elements on the Page
    Given the user login to "https://dashboard-testing.nuraspace.com/login"
    When the user checks the page text
    Then the page should contain the following text
      | Nuraspace          |
      | DevTNtester        |
      | nuraVehiclesBookings |
      | CalendarVehicle    |
      | RegisterUsersFloor |
      | planMy             |
      | TeamUser           |
      | Guides & FAQ’s     |
      | ProfileLogout      |



