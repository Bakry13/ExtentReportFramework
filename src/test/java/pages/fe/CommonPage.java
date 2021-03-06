package pages.fe;

import org.openqa.selenium.By;
import utilities.assertions.Assertions_FE;
import utilities.TestBase;
import utilities.actions.ElementActions;

public class CommonPage extends TestBase{
    //=============================Locators==================================
    static By changeLanguageButton = By.id("ChangeLanguage_btn");
    By termsFooter = By.id("Impressum_dl");
    By privacyFooter = By.id("Datenschutz_dl");
    //=============================Strings==================================
    String signInButtonText[] = {"Sign in", "Einloggen"};
    String termsFooterText[] = {"Terms", "Impressum"};
    String privacyFooterText[] = {"Privacy", "Datenschutz"};
    //=====================================Actions=========================================
    public static String getChangeLanguageButtonText()
    {
        String language= ElementActions.getElement(changeLanguageButton).getText();
        return language;
    }

    public String getLanguage()
    {   String language ="";
        if (getChangeLanguageButtonText().equals("English"))
            language="Deutsch";
        else if (getChangeLanguageButtonText().equals("Deutsch"))
            language="English";
        else
            System.out.println("error in getting the language ");
        return language;
    }

    public static void setLanguage(String language)
    {
        if (getChangeLanguageButtonText().equals(language))
            ElementActions.getElement(changeLanguageButton).click();
        System.out.println(language+" is selected");
        if (language.equals("English"))
            languageIndex = 0;
        else if (language.equals("Deutsch"))
            languageIndex = 1;
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //===================================Text Assertions=====================================
    public void assertChangeLanguageButtonText(String expectedLanguage)
    {
        Assertions_FE.assertElementText(changeLanguageButton,expectedLanguage);
    }

    public void assertTermsFooterText()
    {
        Assertions_FE.assertElementText(termsFooter,termsFooterText[languageIndex]);
    }

    public void assertprivacyFooterText()
    {
        Assertions_FE.assertElementText(privacyFooter,privacyFooterText[languageIndex]);
    }
}
