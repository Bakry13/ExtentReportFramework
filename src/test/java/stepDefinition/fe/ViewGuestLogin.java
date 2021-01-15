package stepDefinition.fe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.fe.CommonPage;
import pages.fe.CommonPageActions;
import pages.fe.LoginPage;
import utilities.Assertions;
import utilities.actions.BrowserActions;
import utilities.common.Paths;

public class ViewGuestLogin extends LoginPage
{
    //=====Scenario 1: Login to easy ticket and check that elements exist======
    @Given("I open Easy Ticket Portal")
    public void userDeeplinksToTicketingTrackerPortal() {
        login();
    }

    @When("I check login page content")
    public void i_check_login_page_content() {
        System.out.println("Verifying login page contents");
    }

    @Then("I should see SignInHintTitle in login page")
    public void i_should_see_sign_in_hint_title_in_login_page() {
        assertSignInHintTitle();
    }

    @Then("I should see SignInHintBody in login page")
    public void i_should_see_sign_in_hint_body_in_login_page() {
        assertSignInHintBody();
    }

    @Then("I should see CustomerNumber in login page")
    public void i_should_see_customer_number_in_login_page() {
        assertCustomerNumber();
    }

    @Then("I should see AccountNumber in login page")
    public void i_should_see_account_number_in_the_page() {
        assertAccountNumber();
    }

    @Then("I should see AccessID in login page")
    public void i_should_see_access_id_in_the_page() {
        assertAccessID();
    }

    @Then("I should see SignInButton in login page")
    public void i_should_see_sign_in_button_in_the_page() {
        assertSignInButton();
    }

    @Then("I should see ChangeLanguageButton in login page")
    public void i_should_see_change_language_button_in_the_page() {
        assertChangeLanguageButton();
    }
//===Scenario 2: Login to easy ticket and check elements text in "<language>" language===
    @When("I set {string}")
    public void set(String language) {
        CommonPage.setLanguage(language);
    }

    @Then("I should see SignInHintTitle has the translated text in login page")
    public void i_should_see_sign_in_hint_title_has_the_translated_text_in_login_page() {
        assertSignInHintTitleText();
    }

    @Then("I should see SignInHintBody has the translated text in login page")
    public void i_should_see_sign_in_hint_body_has_the_translated_text_in_login_page() {
        assertSignInHintBodyText();
    }

    @Then("I should see SignInButton has the translated text in login page")
    public void i_should_see_sign_in_button_has_the_translated_text_in_login_page() {
        assertSignInButtonText();
    }
}