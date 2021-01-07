@THOR-33
Feature:As a customer, I want to have the possibility to change the language of the data displayed in the Easy Ticket portal, in case I wasn't comfortable with Portal default Language display
  Scenario Outline:check default language
    Given I set browser language to "<language>"
    When I open Easy Ticket Portal
    Then I should see "ChangeLanguageButton" has the text "<ChangeLanguageButtonText>" in login page
    And I should see "TermsFooter" has the translated text in Login page
    And I should see "PrivacyFooter" has the translated text in Login page
    Examples:
      | language | ChangeLanguageButtonText |
      | English  | Deutsch    |
      | Arabic   | English    |
      | Deutsch  | English    |
