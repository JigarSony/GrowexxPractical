Feature: MakeMyTrip flight Search

  Scenario: Flight Booking
    Given User is on MakeMyTrip homePage
    When User click on Login button
    Then Verify Login Signup Pop up should be displayed
    When User Enter Username and click on Continue button
    And User Enter Password and click on Login button
    Then Verify User redirected to MMT Homepage
    When User Selects fromLocation toLocation selectDate passengerType travelClass and click on Search
    Then Verify User redirected to flightSearch Page
    When User select checkbox for Air India
    Then Verify the number of total flights for AirIndia