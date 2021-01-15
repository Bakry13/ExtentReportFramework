package pages.fe;

import org.openqa.selenium.Keys;
import utilities.assertions.Assertions_FE;
import utilities.TestBase;
import utilities.actions.ElementActions;
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
    String wrongCustomerClassText[] = {"Easy Ticket is only available to Vodafone business customers.\n" +
            "Please contact your responsible customer service"
            ,"Easy Ticket steht ausschließlich Vodafone Geschäftskunden zur Verfügung.\n" +
            "Bitte wenden Sie sich an Ihre zuständige Kundenbetreuung."};
    String dataWasNotFoundText[] = {"The entered data is not found. Easy Ticket is only available to Vodafone business customers.\n" +
            "Please contact your responsible customer service."
            ,"Die von Ihnen eingegeben Daten wurden nicht gefunden.  \n" +
            "Bitte beachten Sie, dass Easy Ticket nur für Festnetzanschlüsse von Vodafone Geschäftskunden zur Verfügung steht.\n" +
            "Bitte wenden Sie sich an Ihre zuständige Kundenbetreuung."};
    String noAvailableProductText[] = {"No product available.","Kein Produkt vorhanden."};
    String dataDoesNotMatchText[] = {"The data you have entered do not match the same customer account. Please check your entered data."
            ,"Die von Ihnen eingegeben Daten passen nicht zum selben Kundenkonto. Bitte überprüfen Sie Ihre Eingaben."};
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

    public void clickSignIn() {
        ElementActions.getElement(signInButton).click();
    }
    //-----------------------------------Assertions--------------------------------
    public void assertSignInHintTitle()
    {
        Assertions_FE.assertElementExist(signInHintTitle);
    }

    public void assertSignInHintBody()
    {
        Assertions_FE.assertElementExist(signInHintBody);
    }

    public void assertCustomerNumber()
    {
        Assertions_FE.assertElementExist(customerNumber);
    }

    public void assertAccountNumber()
    {
        Assertions_FE.assertElementExist(accountNumber);
    }

    public void assertAccessID()
    {
        Assertions_FE.assertElementExist(accessID);
    }

    public void assertSignInButton()
    {
        Assertions_FE.assertElementExist(signInButton);
    }

    public void assertChangeLanguageButton()
    {
        Assertions_FE.assertElementExist(changeLanguageButton);
    }

    public void assertCustomerNumberInlineError() { Assertions_FE.assertElementExist(customerNumberInlineError);}

    public void assertNoCustomerNumberInlineError() { Assertions_FE.assertElementNotExist(customerNumberInlineError);}

    public void assertAccountNumberInlineError() { Assertions_FE.assertElementExist(accountNumberInlineError);}

    public void assertNoAccountNumberInlineError() { Assertions_FE.assertElementNotExist(accountNumberInlineError);}

    public void assertAccessIDInlineError() { Assertions_FE.assertElementExist(accessIDInlineError);}

    public void assertNoAccessIDInlineError() { Assertions_FE.assertElementNotExist(accessIDInlineError);}

    public void assertSignInButtonEnabled() { Assertions_FE.assertElementEnabled(signInButton);}

    public void assertSignInButtonDisabled() { Assertions_FE.assertElementDisabled(signInButton);}

    public void assertCustomerNumberDisabled() { Assertions_FE.assertElementDisabled(customerNumber);}

    public void assertAccountNumberDisabled() { Assertions_FE.assertElementDisabled(accountNumber);}

    public void assertAccessIDDisabled() { Assertions_FE.assertElementDisabled(accessID);}
    //------------------------------Text Assertions----------------------------------
    public void assertSignInHintTitleText() {
        Assertions_FE.assertElementText(signInHintTitle,signInHintTitleText[languageIndex]);
    }

    public void assertSignInHintBodyText() {
        Assertions_FE.assertElementText(signInHintBody,signInHintBodyText[languageIndex]);
    }

    public void assertSignInButtonText() {
        Assertions_FE.assertElementText(signInButton,signInButtonText[languageIndex]);
    }

    public void assertCustomerNumberInlineErrorText() {
        Assertions_FE.assertElementText(customerNumberInlineError,customerNumberInlineErrorText[languageIndex]);
    }

    public void assertAccountNumberInlineErrorText() {
        Assertions_FE.assertElementText(accountNumberInlineError,accountNumberInlineErrorText[languageIndex]);
    }

    public void assertaccessIDInlineErrorText() {
        Assertions_FE.assertElementText(accessIDInlineError,accessIDInlineErrorText[languageIndex]);
    }

    public void assertWrongCustomerClassText() {
        Assertions_FE.assertElementText(signInErrorMsg,wrongCustomerClassText[languageIndex]);
    }

    public void assertDataWasNotFoundText() {
        Assertions_FE.assertElementText(signInErrorMsg,dataWasNotFoundText[languageIndex]);
    }

    public void assertNoAvailableProductText() {
        Assertions_FE.assertElementText(signInErrorMsg,noAvailableProductText[languageIndex]);
    }

    public void assertDataDoesNotMatchText() {
        Assertions_FE.assertElementText(signInErrorMsg,dataDoesNotMatchText[languageIndex]);
    }
}
