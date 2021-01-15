@THOR-25 @FERegression
Feature:Validate Guest Login Form
  As a customer, I want guidance to fill the login form, so that I can enter valid data.

  @THOR-223 @GC12
  Scenario Outline: User opens Easy Ticket , enters a valid inputs then checks no inline error appears and Sign in button is enabled
    Given I open Easy Ticket Portal
    When I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    Then I should not see CustomerNumberInlineError in login page
    And I should not see AccountNumberInlineError in login page
    And SignInButton status should be enabled
    Examples:
      | customerNumber | accountNumber |
      | 123            | 123           |
      | 12345678912    | 123456789     |
      | 654321         | 54321         |
#============================================================================================
  @THOR-224 @BC13
  Scenario Outline: User opens Easy Ticket, enters invalid customer number and checks inline error then changes language to German and checks again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    Then I should see CustomerNumberInlineError in login page
    And I should see CustomerNumberInlineError has the translated text in login page
    And SignInButton status should be disabled
    Examples:
      | language | customerNumber | accountNumber |
      | English  | 12             | 123           |
      | English  | 1234567890123  | 123           |
      | English  | validate       | 123           |
      | English  | #$%^&          | 123           |
      | English  | azAZÄÖÜäöüß    | 123           |
      | Deutsch  | 12             | 123           |
      | Deutsch  | 1234567890123  | 123           |
      | Deutsch  | validate       | 123           |
      | Deutsch  | #$%^&          | 123           |
      | Deutsch  | azAZÄÖÜäöüß    | 123           |

  @THOR-224 @BC13
  Scenario Outline: User deeplinks to Easy Ticket ,
  enters invalid customer number
  and checks inline error disapears after replacing number with valid number
  then changes language to German
  and checks again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I clear CustomerNumber TextBox
    And I type "<customerNumber2>" in CustomerNumber TextBox
    Then I should not see CustomerNumberInlineError in login page
    And SignInButton status should be enabled
    Examples:
      | language | customerNumber | accountNumber | customerNumber2 |
      | English  | validate       | 123           | 123             |
      | Deutsch  | validate       | 123           | 123             |
#=============================================================================================
  @THOR-225 @BC14
  Scenario Outline: User deeplinks to Easy Ticket
  enters invalid account number
  and checks inline error
  then changes language to German and checks again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    Then I should see AccountNumberInlineError in login page
    And SignInButton status should be disabled
    And I should see AccountNumberInlineError has the translated text in Login page
    Examples:
      | language | customerNumber | accountNumber |
      | English  | 123            | 12            |
      | English  | 123            | 12345678901   |
      | English  | 123            | validate      |
      | English  | 123            | #$%^&         |
      | English  | 123            | azAZÄÖÜäöüß   |
      | Deutsch  | 123            | 12            |
      | Deutsch  | 123            | 12345678901   |
      | Deutsch  | 123            | validate      |
      | Deutsch  | 123            | #$%^&         |
      | Deutsch  | 123            | azAZÄÖÜäöüß   |
#===============================================================================================
  @THOR-225 @BC14
  Scenario Outline: User deeplinks to Easy Ticket
  enters invalid account number
  and checks inline error disapears after replacing number with valid number
  then changes language to German and checks again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I clear AccountNumber TextBox
    And I type "<accountNumber2>" in AccountNumber TextBox
    Then I should not see AccountNumberInlineError in login page
    And SignInButton status should be enabled
    Examples:
      | language | customerNumber | accountNumber | accountNumber2 |
      | English  | 123            | validate      | 123            |
      | Deutsch  | 123            | validate      | 123            |
#===============================================================================================
  @THOR-226 @BC15
  Scenario Outline: User deeplinks to Easy Ticket
  enters invalid Access ID and checks inline error
  then changes language to German and checks again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    Then I should see AccessIDInlineError in login page
    And SignInButton status should be disabled
    And I should see AccessIDInlineError has the translated text in login page
    Examples:
      | language | customerNumber  | accessID                                            |
      | English  | 123             | !@#%^&*                                             |
      | English  | 123             | char_char_char_char_char_char_char_char_char_char_c |
      | English  | 123             | <script></script>                                   |
      | English  | 123             | <textarea _ngcontent-jhx-c9></textarea>             |
      | English  | 123             | ^      ^                                            |
      | Deutsch  | 123             | !@#%^&*                                             |
      | Deutsch  | 123             | char_char_char_char_char_char_char_char_char_char_c |
      | Deutsch  | 123             | <script></script>                                   |
      | Deutsch  | 123             | <textarea _ngcontent-jhx-c9></textarea>             |
      | Deutsch  | 123             | ^      ^                                            |

  @THOR-226 @BC15
  Scenario Outline: User deeplinks to Easy Ticket
  enters invalid Access ID and checks inline error disapears after replacing number with valid number
  then changes language to German and checks again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    And I clear AccessID TextBox
    And I type "<accessID2>" in AccessID TextBox
    Then I should not see AccessIDInlineError in login page
    And SignInButton status should be enabled
    Examples:
      | language | customerNumber  | accessID | accessID2   |
      | English  | 123             | !@#%^&*  | product2021 |
      | Deutsch  | 123             | !@#%^&*  | product2021 |
#=======================================================================================
  @THOR-227 @GC16
  Scenario Outline: User deeplinks to Easy Ticket ,
  enters valid Access ID
  and checks no inline error
  and Sign in button is enabled
    Given I open Easy Ticket Portal
    When I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    Then I should not see AccessIDInlineError in login page
    And SignInButton status should be enabled
    Examples:
      | customerNumber  | accessID                                           |
      | 123             | g                                                  |
      | 123             | azAZÄÖÜäöüß                                        |
      | 123             | 123456789                                          |
      | 123             | m!@#%&*                                            |
      | 123             | valid access_id                                    |
      | 123             | char_char_char_char_char_char_char_char_char_char_ |
#================================================================================================
  @THOR-228 @GC17
  Scenario Outline: User deeplinks to Easy Ticket ,
  checks entering any two fields will dim the third.
    Given I open Easy Ticket Portal
    When I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    Then I should see "<emptyField>" field disabled
    Examples:
      | customerNumber | accountNumber | accessID | emptyField     |
      |                | 123           |  p123    | customerNumber |
      | 123            |               |  p123    | accountNumber  |
      | 123            | 123           |          | accessID       |

  @THOR-228 @GC17
  Scenario Outline: User deeplinks to Easy Ticket ,
  checks entering any two fields will dim the third and it is enabled when one of the two fields is cleared
    Given I open Easy Ticket Portal
    When I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    #Now AccessID is dimmed
    And I clear CustomerNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    #Now CustomerNumber is dimmed
    And I clear AccountNumber TextBox
    And I type "<customerNumber>" in CustomerNumber TextBox
    #Now AccountNumber is dimmed
    And I clear AccessID TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    Then SignInButton status should be enabled
    Examples:
      | customerNumber | accountNumber | accessID |
      | 123            | 123           |  p123    |
#============================================================================================
  @THOR-229 @BC18
  Scenario Outline: User deeplinks to Easy Ticket ,
  checks login fields enters two invalid inputs
  and checks inline error (CustomerNumber-AccountNumber)
    Given I open Easy Ticket Portal
    When I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    Then I should see CustomerNumberInlineError in login page
    And I should see AccountNumberInlineError in login page
    And SignInButton status should be disabled
    Examples:
      | customerNumber | accountNumber|
      | 12             | 12           |

  @THOR-229 @BC18
  Scenario Outline: User deeplinks to Easy Ticket ,
  checks login fields enters two invalid inputs
  and checks inline error (CustomerNumber-AccessID)
    Given I open Easy Ticket Portal
    When I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    Then I should see CustomerNumberInlineError in login page
    And I should see AccessIDInlineError in login page
    And SignInButton status should be disabled
    Examples:
      | customerNumber | accessID |
      | 12             | !@#%^&*  |

  @THOR-229 @BC18
  Scenario Outline: User deeplinks to Easy Ticket ,
  checks login fields enters two invalid inputs
  and checks inline error (AccountNumber-AccessID)
    Given I open Easy Ticket Portal
    When I type "<AccountNumber>" in AccountNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    Then I should see AccountNumberInlineError in login page
    And I should see AccessIDInlineError in login page
    And SignInButton status should be disabled
    Examples:
      | AccountNumber | accessID |
      | 12            | !@#%^&*  |