package pages.fe;

import org.openqa.selenium.By;
import utilities.ConfigUtil;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;

public class CommonPage {
    public static int languageIndex = 0;
    //=============================Locators==================================
    static By changeLanguageButton = By.id("ChangeLanguage_btn");
    By termsFooter = By.id("Impressum_dl");
    By privacyFooter = By.id("Datenschutz_dl");
    //=============================Strings==================================
    String signInButtonText[] = {"Sign in", "Einloggen"};
    String termsFooterText[] = {"Terms", "Impressum"};
    String privacyFooterText[] = {"Privacy", "Datenschutz"};
    //=====================================Actions=========================================
    public static void login()
    {
        BrowserActions.navigateToPage(ConfigUtil.WebSTURL);
    }

    public static String getChangeLanguageButtonText()
    {
        String language= ElementActions.getTextOfElement(changeLanguageButton);
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
            ElementActions.forceClickOnElementByLocator(changeLanguageButton);
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
}
