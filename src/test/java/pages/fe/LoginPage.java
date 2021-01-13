package pages.fe;

import utilities.Assertions;
import utilities.ConfigUtil;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

public class LoginPage {
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
            {"Entry doesn't match the requested format. Please enter the customer number."
            , "Eingabe entspricht nicht dem gültigen Format.\nBitte tragen Sie Ihre Kundennummer ein."};
    String accountNumberInlineErrorText[] =
            {"Entry doesn't match the requested format. Please enter the account number."
            , "Eingabe entspricht nicht dem gültigen Format.\nBitte tragen Sie Ihre Rechnungskonto Nr. ein."};
    String accessIDInlineErrorText[] =
            {"Please enter a valid access number."
            , "Bitte tragen Sie Ihre Anschlusskennung ein."};
    String signInButtonText[] = {"Sign in", "Einloggen"};
    String termsFooterText[] = {"Terms", "Impressum"};
    String privacyFooterText[] = {"Privacy", "Datenschutz"};
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

    public void assertSignInHintTitleText()
    {
        Assertions.assertOnElementText(signInHintTitle,signInHintTitleText[CommonPage.languageIndex]);
    }

    public void assertSignInHintBodyText()
    {
        Assertions.assertOnElementText(signInHintBody,signInHintBodyText[CommonPage.languageIndex]);
    }

    public void assertSignInButtonText()
    {
        Assertions.assertOnElementText(signInButton,signInButtonText[CommonPage.languageIndex]);
    }
}
