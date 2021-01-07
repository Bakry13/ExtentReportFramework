Feature:Validate Guest Login Form
  As a customer, I want guidance to fill the login form, so that I can enter valid data.
  Scenario:User enters a valid input
    Given I open Easy Ticket Portal
    When I type "{string}" in "CustomerNumber" TextBox
    When I type "{string}" in "AccountNumber" TextBox
    When I type "{string}" in "AccessID" TextBox
    When I type "{string}" in "CustomerNumber" TextBox