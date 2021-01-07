package stepDefinition.fe;

import io.cucumber.java.en.And;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;

public class CustomBrowser_StepDef {

    @And("I set browser language to {string}")
    public void iSetBrowserLanguageTo(String language) {
        BrowserActions.SetChromeBrowserLanguage(language);
        BrowserActions.maximizeWindow();
        ElementActions.reloadDriver();
    }

}
