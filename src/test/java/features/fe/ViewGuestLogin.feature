@THOR-24 @FERegression
Feature: Login
  As a customer, I want to find the correct login form displayed in terms of  UX, UI layout and components, so that I have an easy consistent experience using the website.
  @THOR-96 @Test
  Scenario: Login to easy ticket and check elements text in both languages
    Given I open Easy Ticket Portal
    When I check page content
    Then I "should" see "SignInHintTitle" in login page
    And I "should" see "SignInHintBody" in login page
    And I "should" see "CustomerNumber" in login page
    And I "should" see "AccountNumber" in login page
    And I "should" see "AccessID" in login page
    And I "should" see "SignInButton" in login page
    And I "should" see "ChangeLanguageButton" in login page
    When the language is "English"
    Then I should see "SignInHintTitle" has the translated text in Login page
    And I should see "SignInHintBody" has the translated text in Login page
    And I should see "SignInButton" has the translated text in Login page
    When the language is "Deutsch"
    Then I should see "SignInHintTitle" has the translated text in Login page
    And I should see "SignInHintBody" has the translated text in Login page
    And I should see "SignInButton" has the translated text in Login page