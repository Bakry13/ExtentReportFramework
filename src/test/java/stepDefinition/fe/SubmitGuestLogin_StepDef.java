package stepDefinition.fe;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.fe.LoginPage;

public class SubmitGuestLogin_StepDef extends LoginPage {
    @When("I click on SignInButton")
    public void i_click_on_sign_in_button() {
        clickSignIn();
    }

    @Then("I should be redirected to Dashboard")
    public void i_should_be_redirected_to_dashboard() {
    }

    @Then("I should see WrongCustomerClassText")
    public void i_should_see_wrong_customer_class_text() {
        assertWrongCustomerClassText();
    }

    @Then("I should see DataWasNotFoundText")
    public void i_should_see_data_was_not_found_text() {
        assertDataWasNotFoundText();
    }

    @Then("I should see NoAvailableProductText")
    public void i_should_see_no_available_product_text() {
        assertNoAvailableProductText();
    }

    @Then("I should see DataDoesNotMatchText")
    public void i_should_see_data_does_not_match_text() {
        assertDataDoesNotMatchText();
    }
}
