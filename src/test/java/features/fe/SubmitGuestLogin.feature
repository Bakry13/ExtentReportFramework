@THOR-23 @FERegression
Feature:Submit Guest Login
  As a customer, I want to be directed to the dashboard to see my available products and their information when I press on submit, so that I become aware of my products and their information to ease the product selection process for me.

  @GC01 @GC02 @GC03 @GC04 @GC05 @GC06
  Scenario Outline: Enterprise fixed net customer of "<class>" class that have active CCBID& active products clicks on submit button in Guest login form, when he enters valid and matching Customer& account& ignoring zeros in the beginning of Customer Number and Account Number his language is English and German
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I click on SignInButton
    Then I should be redirected to Dashboard
    Examples:
      | language | customerNumber | accountNumber | class | startWithZeros |
      | English  | 123            | 123           | A     | No             |
      | English  | 123            | 123           | A1    | No             |
      | English  | 123            | 123           | A2    | No             |
      | English  | 123            | 123           | A3    | No             |
      | English  | 123            | 123           | AV    | No             |
      | English  | 123            | 123           | B     | No             |
      | English  | 123            | 123           | B1    | No             |
      | English  | 123            | 123           | B2    | No             |
      | English  | 123            | 123           | B3    | No             |
      | English  | 123            | 123           | B4    | No             |
      | English  | 000123         | 123           | VC    | yes            |
      | English  | 0123           | 00123         | GK    | yes            |
      | English  | 00123          | 0123          | Top A | yes            |
      | Deutsch  | 123            | 123           | C     | No             |
      | Deutsch  | 123            | 123           | C1    | No             |
      | Deutsch  | 123            | 123           | C2    | No             |
      | Deutsch  | 123            | 123           | C3    | No             |
      | Deutsch  | 123            | 000123        | X     | yes            |

  @BC07 @BC08
  Scenario Outline: Enterprise fixed net customer of Not Eligible class,has active CCBID & active product enters valid and matching Customer & Account no. clicks on submit button in Guest login form then changes language is German & try again
    Given I open Easy Ticket Portal
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I click on SignInButton
    Then I should see WrongCustomerClassText
    Examples:
      | language | customerNumber | accountNumber |
      | English  | 123            | 123           |
      | Deutsch  | 123            | 123           |

  @BC09 @BC10
  Scenario Outline: Enterprise fixed net customer of Eligible class, that have Inactive CCBID & active product enters valid and matching Customer & Account no. clicks on submit button in Guest login form, then changes language to German & try again
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I click on SignInButton
    Then I should see DataWasNotFoundText
    Examples:
      | language | customerNumber | accountNumber |
      | English  | 123            | 123           |
      | Deutsch  | 123            | 123           |

  @BC11 @BC12
  Scenario Outline: Enterprise fixed net customer of Eligible class has active CCBID but with "<productStatus>" product enters valid and matching Customer & Account no. clicks on submit button in Guest login form, then changes language is German & try again
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I click on SignInButton
    Then I should see NoAvailableProductText
    Examples:
      | language | customerNumber | accountNumber | productStatus |
      | English  | 123            | 123           | Inactive      |
      | English  | 123            | 123           | Zero          |
      | Deutsch  | 123            | 123           | Inactive      |
      | Deutsch  | 123            | 123           | Zero          |

  @BC13 @BC17
  Scenario Outline: Enterprise fixed net customer of Eligible class with active CCBID & active product enters different status of "<inputsCompination>" for Customer no. & Account no. & clicks on submit button in Guest login form, then changes language to German & try again
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accountNumber>" in AccountNumber TextBox
    And I click on SignInButton
    Then I should see DataDoesNotMatchText
    Examples:
      | language | customerNumber | accountNumber | inputsCompination                      |
      | English  | 123            | 123           | validCustomerNo. and invalidAccountNo. |
      | English  | 123            | 123           | invalidCustomerNo. and validAccessID   |
      | English  | 123            | 123           | ivalidCustomerNo. and invalidAccountNo.|
      | English  | 123            | 123           | invalidCustomerNo. and invalidAccessID |
      | English  | 123            | 123           | customerNo. doesn't match accountNo.   |
      | Deutsch  | 123            | 123           | validCustomerNo. and invalidAccountNo. |
      | Deutsch  | 123            | 123           | invalidCustomerNo. and validAccessID   |
      | Deutsch  | 123            | 123           | ivalidCustomerNo. and invalidAccountNo.|
      | Deutsch  | 123            | 123           | invalidCustomerNo. and invalidAccessID |
      | Deutsch  | 123            | 123           | customerNo. doesn't match accountNo.   |

  @BC14 @BC18
  Scenario Outline: Enterprise fixed net customer of Eligible class with active CCBID & active product enters different status of "<inputsCompination>" for Customer no. & Access ID& clicks on submit button in Guest login form, then changes language to German & try again
    When I set "<language>"
    And I type "<customerNumber>" in CustomerNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    And I click on SignInButton
    Then I should see DataDoesNotMatchText
    Examples:
      | language | customerNumber | accessID | inputsCompination                      |
      | English  | 123            | 123      | validCustomerNo. and invalidAccessID   |
      | English  | 123            | 123      | invalidCustomerNo. and validAccessID   |
      | English  | 123            | 123      | invalidCustomerNo. and invalidAccessID |
      | English  | 123            | 123      | customerNo. doesn't match accessID     |
      | Deutsch  | 123            | 123      | invalidCustomerNo. and validAccessID   |
      | Deutsch  | 123            | 123      | validCustomerNo. and invalidAccessID   |
      | Deutsch  | 123            | 123      | invalidCustomerNo. and invalidAccessID |
      | Deutsch  | 123            | 123      | customerNo. doesn't match accessID     |

  @BC15 @BC16 @BC19
  Scenario Outline: Enterprise fixed net customer of Eligible class with active CCBID & active product enters different status of "<inputsCompination>" for Account no. & Access ID& clicks on submit button in Guest login form, then changes language to German & try again
    When I set "<language>"
    And I type "<accountNumber>" in AccountNumber TextBox
    And I type "<accessID>" in AccessID TextBox
    And I click on SignInButton
    Then I should see DataDoesNotMatchText
    Examples:
      | language | accountNumber | accessID | inputsCompination                     |
      | English  | 123           | 123      | validAccountNo. and invalidAccessID   |
      | English  | 123           | 123      | invalidaccountNo. and validAccessID   |
      | English  | 123           | 123      | invalidaccountNo. and invalidAccessID |
      | English  | 123           | 123      | accountNo. doesn't match accessID     |
      | Deutsch  | 123           | 123      | validAccountNo. and invalidAccessID   |
      | Deutsch  | 123           | 123      | invalidaccountNo. and validAccessID   |
      | Deutsch  | 123           | 123      | invalidaccountNo. and invalidAccessID |
      | Deutsch  | 123           | 123      | accountNo. doesn't match accessID     |