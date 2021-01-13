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

public class Login_StepDef extends LoginPage
{
    //=====Scenario 1: Login to easy ticket and check that elements exist======
    @Given("I open Easy Ticket Portal")
    public void userDeeplinksToTicketingTrackerPortal() {
        CommonPage.login();
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

    @Then("I should see AccountNumber in the page")
    public void i_should_see_account_number_in_the_page() {
        assertAccountNumber();
    }

    @Then("I should see AccessID in the page")
    public void i_should_see_access_id_in_the_page() {
        assertAccessID();
    }

    @Then("I should see SignInButton in the page")
    public void i_should_see_sign_in_button_in_the_page() {
        assertSignInButton();
    }

    @Then("I should see ChangeLanguageButton in the page")
    public void i_should_see_change_language_button_in_the_page() {
        assertChangeLanguageButton();
    }
//===Scenario 2: Login to easy ticket and check elements text in "<language>" language===
    @When("set {string}")
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

//public class Login_StepDef {
//    LoginPage loginPage=new LoginPage();
//
//    @Given("I open Easy Ticket Portal")
//    public void userDeeplinksToTicketingTrackerPortal() {
//        loginPage.login();
//    }
//    @Given("I check page content")
//    public void iCheckPageContent() {
//        System.out.println("Checking Page Content");
//    }
//    @And("I refresh the page")
//    public void heRefreshedThePage() {
//        BrowserActions.refreshPage();
//    }
//    @And("the language is {string}")
//    public void theLanguageIs(String language) {
//        loginPage.setLanguage(language);
//    }
//
//    @Then("I {string} see {string} in login page")
//    public void iSeeInLoginPage(String visiblity, String elementString) {
//        boolean expectedVisiblity = (visiblity.equals("should"));
//        Assertions.assertElementVisibility(expectedVisiblity,loginPage.getLocator(elementString));
//           }
//    @Then("I should see {string} has the text {string} in login page")
//    public void iSeeHasTheText( String elementString, String expectedElementText) {
//        Assertions.assertOnElementText(loginPage.getLocator(elementString),expectedElementText);
//
//    }
//    @Then("I should see {string} has the translated text in Login page")
//    public void iSeeHasThetranslatedText( String elementString) {
//        String expectedElementText= loginPage.getDisplayText(elementString,loginPage.getLanguage());
//        Assertions.assertOnElementText(loginPage.getLocator(elementString),expectedElementText);
//
//    }
//
////    @Then("I {string} see {string} warning message")
////    public void iSeeWarningMessage(String visibility, String elementString) {
////        boolean expectedVisiblity = (visibility.equals("should"));
////        boolean actualVisibility = electronicContactTab.getElementVisibility(elementString);
////        softAssert.assertEquals(actualVisibility, expectedVisiblity, elementString + " has inappropriate behaviour");
////    }
//
//   //status assertion
//    @And("{string} status should be {string}")
//    public void buttonStatusShouldBe(String elementString, String enabled) {
//        boolean expectedStatus = (enabled.equals("enabled"));
//        Assertions.assertElementEnabled(expectedStatus,loginPage.getLocator(elementString));
//    }
////    @And("{string} should be mandatory")
////    public void inShouldBeMandatory(String elementString) {
////        boolean actualValue = electronicContactTab.isMandatory(elementString);
////        softAssert.assertTrue(actualValue);
////    }
//    @And("{string} should be {string}")
//    public void inShouldBeEmpty(String elementString,String status) {
//        switch (status)
//        {
//            case "empty":
//                Assertions.assertOnElementText(loginPage.getLocator(elementString),"");
//                break;
//            case "dimmed":
//                Assertions.assertOnElementText(loginPage.getLocator(elementString),"");
//                break;
//        }
//
//    }
//
//
//   //user actions
//    @When("I click on {string}")
//    public void iClickOnInElectronicContactTab(String elementString) {
//        loginPage.click(elementString);
//    }
//    @When("I clear {string} TextBox")
//    public void iClearTextBox(String elementString) { loginPage.clearText(elementString); }
//    @And("I type {string} in {string} TextBox")
//    public void iTypeInInTextBox(String input, String elementString) {
//        input = input.replace('^', ' ');
//        System.out.println(elementString+": "+input);
//        loginPage.setText(elementString, input);
//    }
//
//}
