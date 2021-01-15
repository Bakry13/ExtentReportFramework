@THOR-24 @FERegression
Feature: View Guest Login
  As a customer, I want to find the correct login form displayed in terms of  UX, UI layout and components, so that I have an easy consistent experience using the website.
  @THOR-96
  Scenario: Login to easy ticket and check that elements exist
    Given I open Easy Ticket Portal
    When I check login page content
    Then I should see SignInHintTitle in login page
    And I should see SignInHintBody in login page
    And I should see CustomerNumber in login page
    And I should see AccountNumber in login page
    And I should see AccessID in login page
    And I should see SignInButton in login page
    And I should see ChangeLanguageButton in login page

  @THOR-96
  Scenario Outline: Login to easy ticket and check elements text in "<language>" language
    Given I open Easy Ticket Portal
    When I set "<language>"
    Then I should see SignInHintTitle has the translated text in login page
    And I should see SignInHintBody has the translated text in login page
    And I should see SignInButton has the translated text in login page

    Examples:
      | language |
      |  English |
      |  Deutsch |