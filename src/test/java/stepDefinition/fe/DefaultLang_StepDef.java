package stepDefinition.fe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.fe.CommonPage;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;

public class DefaultLang_StepDef extends CommonPage {

    @Given("I set browser language to {string}")
    public void i_set_browser_language_to(String language) {
        BrowserActions.SetChromeBrowserLanguage(language);
        BrowserActions.maximizeWindow();
    }

    @Then("I should see ChangeLanguageButton has the text {string} in login page")
    public void i_should_see_change_language_button_has_the_text_in_login_page(String language) {
        assertChangeLanguageButtonText(language);
    }

    @Then("I should see TermsFooter has the translated text in Login page")
    public void i_should_see_terms_footer_has_the_translated_text_in_login_page() {
        assertTermsFooterText();
    }

    @Then("I should see PrivacyFooter has the translated text in Login page")
    public void i_should_see_privacy_footer_has_the_translated_text_in_login_page() {
        assertprivacyFooterText();
    }
}
