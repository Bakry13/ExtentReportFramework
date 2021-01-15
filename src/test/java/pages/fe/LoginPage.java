package pages.fe;

import org.openqa.selenium.Keys;
import utilities.Assertions;
import utilities.ConfigUtil;
import utilities.TestBase;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {
    //=============================Locators==================================
    By loginPageTitle = By.id("LoginPageTitle_lbl");
    By loginPageSubtitle = By.id("LoginPageSubtitle_lbl");
    By signInHintTitle = By.id("SignInHintTitle_lbl");
    By signInHintBody = By.id("SignInHintBody_lbl");
    By customerNumber = By.id("CustomerNumber_tb");
    By customerNumberInlineError = By.id("CustomerNumberInlineError_lbl");
    By accountNumber = By.id("AccountNumber_tb");
    By accountNumberInlineError = By.id("AccountNumberInlineError_lbl");
    By accessID = By.id("AccessID_tb");
    By accessIDInlineError = By.id("AccessIDInlineError_lbl");
    By signInButton = By.id("SignIn_btn");
    By signInErrorMsg = By.id("SignInErrorMsg_lbl");
    By changeLanguageButton = By.id("ChangeLanguage_btn");
    By termsFooter = By.id("Impressum_dl");
    By privacyFooter = By.id("Datenschutz_dl");
    //=============================Strings==================================
    String signInHintTitleText[] =
            {"Please provide two of the three fields."
            , "Bitte befüllen Sie zwei der drei Felder."};
    String signInHintBodyText[] =
            {"You can find the required info on the invoice or the welcome letter."
            ,"Sie finden die benötigten Daten auf Ihrer Rechnung oder auf Ihrem Willkommensbrief."};
    String customerNumberInlineErrorText[] =
            {"Entry doesn't match the requested format.\nPlease enter the customer number."
            , "Eingabe entspricht nicht dem gültigen Format.\nBitte tragen Sie Ihre Kundennummer ein."};
    String accountNumberInlineErrorText[] =
            {"Entry doesn't match the requested format.\nPlease enter the account number."
            , "Eingabe entspricht nicht dem gültigen Format.\nBitte tragen Sie Ihre Rechnungskonto Nr. ein."};
    String accessIDInlineErrorText[] =
            {"Please enter a valid access number."
            , "Bitte tragen Sie Ihre Anschlusskennung ein."};
    String signInButtonText[] = {"Sign in", "Einloggen"};
    String termsFooterText[] = {"Terms", "Impressum"};
    String privacyFooterText[] = {"Privacy", "Datenschutz"};
    //===================================Actions===================================
    public void typeInCustomerNumber(String customerNumberText) {
        ElementActions.getElement(customerNumber).sendKeys(customerNumberText+"\t");
    }

    public void typeInAccountNumber(String accountNumberText) {
        ElementActions.getElement(accountNumber).sendKeys(accountNumberText+"\t");
    }

    public void typeInAccessID(String accessIDText) {
        try { ElementActions.getElement(accessID).sendKeys(accessIDText+"\t");
        } catch (Exception e) { e.printStackTrace(); } }

    public void clearCustomerNumber() {
        ElementActions.getElement(customerNumber).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void clearAccountNumber() {
        ElementActions.getElement(accountNumber).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void clearAccessID() {
        ElementActions.getElement(accessID).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
    //-----------------------------------Assertions--------------------------------
    public void assertSignInHintTitle()
    {
        Assertions.assertElementExist(signInHintTitle);
    }

    public void assertSignInHintBody()
    {
        Assertions.assertElementExist(signInHintBody);
    }

    public void assertCustomerNumber()
    {
        Assertions.assertElementExist(customerNumber);
    }

    public void assertAccountNumber()
    {
        Assertions.assertElementExist(accountNumber);
    }

    public void assertAccessID()
    {
        Assertions.assertElementExist(accessID);
    }

    public void assertSignInButton()
    {
        Assertions.assertElementExist(signInButton);
    }

    public void assertChangeLanguageButton()
    {
        Assertions.assertElementExist(changeLanguageButton);
    }

    public void assertCustomerNumberInlineError() { Assertions.assertElementExist(customerNumberInlineError);}

    public void assertNoCustomerNumberInlineError() { Assertions.assertElementNotExist(customerNumberInlineError);}

    public void assertAccountNumberInlineError() { Assertions.assertElementExist(accountNumberInlineError);}

    public void assertNoAccountNumberInlineError() { Assertions.assertElementNotExist(accountNumberInlineError);}

    public void assertAccessIDInlineError() { Assertions.assertElementExist(accessIDInlineError);}

    public void assertNoAccessIDInlineError() { Assertions.assertElementNotExist(accessIDInlineError);}

    public void assertsignInButtonEnabled() { Assertions.assertElementEnabled(true,signInButton);}

    public void assertsignInButtonDisabled() { Assertions.assertElementEnabled(false,signInButton);}

    public void assertCustomerNumberDisabled() { Assertions.assertElementEnabled(false,customerNumber);}

    public void assertAccountNumberDisabled() { Assertions.assertElementEnabled(false,accountNumber);}

    public void assertAccessIDDisabled() { Assertions.assertElementEnabled(false,accessID);}
    //------------------------------Text Assertions----------------------------------
    public void assertSignInHintTitleText() {
        Assertions.assertOnElementText(signInHintTitle,signInHintTitleText[languageIndex]);
    }

    public void assertSignInHintBodyText() {
        Assertions.assertOnElementText(signInHintBody,signInHintBodyText[languageIndex]);
    }

    public void assertSignInButtonText() {
        Assertions.assertOnElementText(signInButton,signInButtonText[languageIndex]);
    }

    public void assertCustomerNumberInlineErrorText() {
        Assertions.assertOnElementText(customerNumberInlineError,customerNumberInlineErrorText[languageIndex]);
    }

    public void assertAccountNumberInlineErrorText() {
        Assertions.assertOnElementText(accountNumberInlineError,accountNumberInlineErrorText[languageIndex]);
    }

    public void assertaccessIDInlineErrorText() {
        Assertions.assertOnElementText(accessIDInlineError,accessIDInlineErrorText[languageIndex]);
    }
}
