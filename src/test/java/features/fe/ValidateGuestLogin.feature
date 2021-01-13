#@THOR-25
#Feature:Validate Guest Login Form
#  As a customer, I want guidance to fill the login form, so that I can enter valid data.
#
#  @THOR-223
#  Scenario Outline:GC12 || Thor-25 || Chrome || user deeplinks to Easy Ticket ,
#  enters a valid inputs then checks no inline error appears
#  and Sign in button is enabled
#    Given I open Easy Ticket Portal
#    When I type "<customer number>" in "CustomerNumber" TextBox
#    And I type "<account number>" in "AccountNumber" TextBox
#    Then I "should not" see "CustomerNumberInlineError" in login page
#    And I "should not" see "AccountNumberInlineError" in login page
#    And "SignInButton" status should be "enabled"
#    Examples:
#      | customer number | account number |
#      | 123             | 123            |
#      | 12345678912     | 123456789      |
#      | 654321          | 54321          |
#
#  @THOR-224
#  Scenario Outline:BC13 || Thor-25 || Chrome || user deeplinks to Easy Ticket ,
#  enters invalid customer number
#  and checks inline error
#  then changes language to German
#  and checks again
#    Given I open Easy Ticket Portal
#    When I type "<customer number>" in "CustomerNumber" TextBox
#    And I type "<account number>" in "AccountNumber" TextBox
#    Then I "should" see "CustomerNumberInlineError" in login page
#    And "SignInButton" status should be "disabled"
#    And the language is "English"
#    And I should see "CustomerNumberInlineError" has the translated text in Login page
#    And the language is "Deutsch"
#    And I should see "CustomerNumberInlineError" has the translated text in Login page
#    And I type "123" in "CustomerNumber" TextBox
#    And I "should not" see "CustomerNumberInlineError" in login page
#    Examples:
#      | customer number | account number |
#      | 12              | 123            |
#      | 1234567890123   | 123            |
#      | validate        | 123            |
#      | #$%^&           | 123            |
#      | azAZÄÖÜäöüß     | 123            |
#
#  @THOR-225
#  Scenario Outline:BC14|| Thor-25 || Chrome || user deeplinks to Easy Ticket
#  enters invalid account number
#  and checks inline error
#  then changes language to German and checks again
#    Given I open Easy Ticket Portal
#    When I type "<customer number>" in "CustomerNumber" TextBox
#    And I type "<account number>" in "AccountNumber" TextBox
#    Then I "should" see "AccountNumberInlineError" in login page
#    And "SignInButton" status should be "disabled"
#    And the language is "English"
#    And I should see "AccountNumberInlineError" has the translated text in Login page
#    And the language is "Deutsch"
#    And I should see "AccountNumberInlineError" has the translated text in Login page
#    And I type "123" in "AccountNumber" TextBox
#    And I "should not" see "AccountNumberInlineError" in login page
#    Examples:
#      | customer number | account number |
#      | 123             | 12             |
#      | 123             | 12345678901    |
#      | 123             | validate       |
#      | 123             | #$%^&          |
#      | 123             | azAZÄÖÜäöüß    |
#
#  @THOR-226
#  Scenario Outline:BC15 || Thor-25 || Chrome || user deeplinks to Easy Ticket
#  enters invalid Access ID and checks inline error
#  then changes language to German and checks again
#    Given I open Easy Ticket Portal
#    When I type "<customer number>" in "CustomerNumber" TextBox
#    And I type "<access id>" in "AccessID" TextBox
#    Then I "should" see "AccessIDInlineError" in login page
#    And "SignInButton" status should be "disabled"
#    And the language is "English"
#    And I should see "AccessIDInlineError" has the translated text in Login page
#    And the language is "Deutsch"
#    And I should see "AccessIDInlineError" has the translated text in Login page
#    And I type "product2021" in "AccessID" TextBox
#    And I "should not" see "AccessIDInlineError" in login page
#    Examples:
#      | customer number | access id                                           |
#      | 123             | !@#%^&*                                             |
#      | 123             | char_char_char_char_char_char_char_char_char_char_c |
#      | 123             | <script></script>                                   |
#      | 123             | <textarea _ngcontent-jhx-c9></textarea>             |
#      | 123             | ^      ^                                            |
#
#  @THOR-227
#  Scenario Outline:GC16 || Thor-25 || Chrome || user deeplinks to Easy Ticket ,
#  enters valid Access ID
#  and checks no inline error
#  and Sign in button is enabled
#    Given I open Easy Ticket Portal
#    When I type "<customer number>" in "CustomerNumber" TextBox
#    And I type "<access id>" in "AccessID" TextBox
#    Then I "should not" see "AccessIDInlineError" in login page
#    And "SignInButton" status should be "enabled"
#    Examples:
#      | customer number | access id                                          |
#      | 123             | g                                                  |
#      | 123             | azAZÄÖÜäöüß                                        |
#      | 123             | 123456789                                          |
#      | 123             | m!@#%&*                                           |
#      | 123             | valid access_id                                    |
#      | 123             | char_char_char_char_char_char_char_char_char_char_ |
#
#  @THOR-228
#  Scenario:GC17 || Thor-25 || Chrome || user deeplinks to Easy Ticket ,
#  checks entering any two fields will dim the third.
#    Given I open Easy Ticket Portal
#    #CustomerNumber - AccountNumber
#    When I type "123" in "CustomerNumber" TextBox
#    And I type "123" in "AccountNumber" TextBox
#    Then "AccessID" status should be "disabled"
#    #CustomerNumber - AccessId
#    And I clear "AccountNumber" TextBox
#    And I type "p123" in "AccessID" TextBox
#    And "AccountNumber" status should be "disabled"
#    #AccountNumber - AccessId
#    And I clear "CustomerNumber" TextBox
#    And I type "123" in "AccountNumber" TextBox
#    And "CustomerNumber" status should be "disabled"
#
#  @THOR-229
#  Scenario:BC18 || Thor-25 || Chrome || user deeplinks to Easy Ticket ,
#  checks login fields enters two invalid inputs
#  and checks inline error
#    Given I open Easy Ticket Portal
#    When I type "12" in "CustomerNumber" TextBox
#    And I type "12" in "AccountNumber" TextBox
#    Then I "should" see "CustomerNumberInlineError" in login page
#    And I "should" see "AccountNumberInlineError" in login page
#    And "SignInButton" status should be "disabled"
#    #CustomerNumber - AccessId
#    And I clear "AccountNumber" TextBox
#    And I type "!@#%^&*" in "AccessID" TextBox
#    And I "should" see "CustomerNumberInlineError" in login page
#    And I "should" see "AccessIDInlineError" in login page
#    And "SignInButton" status should be "disabled"
#   #AccountNumber - AccessId
#    And I clear "CustomerNumber" TextBox
#    And I type "12" in "AccountNumber" TextBox
#    And I "should" see "AccountNumberInlineError" in login page
#    And I "should" see "AccessIDInlineError" in login page
#    And "SignInButton" status should be "disabled"
#