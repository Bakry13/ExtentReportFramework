package stepDefinition.fe;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.fe.LoginPage;
import utilities.Assertions;

public class ValidateGuestLogin_StepDef extends LoginPage {
    //==========================THOR-223=======================================
    @When("I type {string} in CustomerNumber TextBox")
    public void i_type_in_customer_number_text_box(String customerNumberText) {
        typeInCustomerNumber(customerNumberText);
    }

    @When("I type {string} in AccountNumber TextBox")
    public void i_type_in_account_number_text_box(String accountNumberText) {
        typeInAccountNumber(accountNumberText);
    }

    @Then("I should not see CustomerNumberInlineError in login page")
    public void i_should_not_see_customer_number_inline_error_in_login_page() {
        assertNoCustomerNumberInlineError();
    }

    @Then("I should not see AccountNumberInlineError in login page")
    public void i_should_not_see_account_number_inline_error_in_login_page() {
        assertNoAccountNumberInlineError();
    }

    @Then("SignInButton status should be enabled")
    public void sign_in_button_status_should_be_enabled() {
        assertSignInButtonEnabled();
    }
//=============================THOR-224==========================================
    @When("I clear CustomerNumber TextBox")
    public void i_clear_customer_number_text_box() {
        clearCustomerNumber();
    }

    @Then("I should see CustomerNumberInlineError in login page")
    public void i_should_see_customer_number_inline_error_in_login_page() {
        assertCustomerNumberInlineError();
    }

    @Then("SignInButton status should be disabled")
    public void sign_in_button_status_should_be_disabled() {
        assertSignInButtonDisabled();
    }

    @Then("I should see CustomerNumberInlineError has the translated text in login page")
    public void i_should_see_customer_number_inline_error_has_the_translated_text_in_login_page() {
        assertCustomerNumberInlineErrorText();
    }

    @Then("I should see AccountNumberInlineError in login page")
    public void i_should_see_account_number_inline_error_in_login_page() {
        assertAccountNumberInlineError();
    }

    @Then("I should see AccountNumberInlineError has the translated text in Login page")
    public void i_should_see_account_number_inline_error_has_the_translated_text_in_login_page() {
        assertAccountNumberInlineErrorText();
    }
//===========================================THOR-225======================================
    @When("I clear AccountNumber TextBox")
    public void i_clear_account_number_text_box() {
        clearAccountNumber();
    }
    //================================THOR-226===========================================
    @When("I type {string} in AccessID TextBox")
    public void i_type_in_access_id_text_box(String accessIDText) {
        typeInAccessID(accessIDText);
    }

    @When("I clear AccessID TextBox")
    public void i_clear_access_id_text_box() {
        clearAccessID();
    }

    @Then("I should see AccessIDInlineError in login page")
    public void i_should_see_access_id_inline_error_in_login_page() {
        assertAccessIDInlineError();
    }

    @Then("I should see AccessIDInlineError has the translated text in login page")
    public void i_should_see_access_id_inline_error_has_the_translated_text_in_login_page() {
        assertaccessIDInlineErrorText();
    }

    @Then("I should not see AccessIDInlineError in login page")
    public void i_should_not_see_access_id_inline_error_in_login_page() {
        assertNoAccessIDInlineError();
    }
    //================================THOR-227===========================================
    @Then("I should see {string} field disabled")
    public void i_should_see_field_disabled(String emptyField) {
        if(emptyField=="customerNumber")
        {assertCustomerNumberDisabled();}
        else if(emptyField=="accountNumber")
        {assertAccountNumberDisabled();}
        else if(emptyField=="accessID")
        {assertAccessIDDisabled();}
    }
}