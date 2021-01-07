package stepDefinition.fe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Assertions;
import pages.fe.LoginPage;

public class Login_StepDef {
    LoginPage loginPage=new LoginPage();

    @Given("I open Easy Ticket Portal")
    public void userDeeplinksToTicketingTrackerPortal() {
        loginPage.login();
    }
    @Given("I check page content")
    public void iCheckPageContent() {
        System.out.println("Checking Page Content");
    }
    @And("I refresh the page")
    public void heRefreshedThePage() {
        //BrowserActions.refreshPage();
    }
    @And("the language is {string}")
    public void theLanguageIs(String language) {
        loginPage.setLanguage(language);
    }

    @Then("I {string} see {string} in login page")
    public void iSeeInLoginPage(String visiblity, String elementString) {
        boolean expectedVisiblity = (visiblity.equals("should"));
       if (expectedVisiblity == true)
        Assertions.assertElementExist(loginPage.getLocator(elementString));
       else
        Assertions.assertElementNotExist(loginPage.getLocator(elementString));
    }
    @Then("I should see {string} has the text {string} in login page")
    public void iSeeHasTheText( String elementString, String expectedElementText) {
        Assertions.assertOnElementText(loginPage.getLocator(elementString),expectedElementText);

    }
    @Then("I should see {string} has the translated text in Login page")
    public void iSeeHasThetranslatedText( String elementString) {
        String expectedElementText= loginPage.getDisplayText(elementString,loginPage.getLanguage());
        Assertions.assertOnElementText(loginPage.getLocator(elementString),expectedElementText);

    }

//    @Then("I {string} see {string} warning message")
//    public void iSeeWarningMessage(String visibility, String elementString) {
//        boolean expectedVisiblity = (visibility.equals("should"));
//        boolean actualVisibility = electronicContactTab.getElementVisibility(elementString);
//        softAssert.assertEquals(actualVisibility, expectedVisiblity, elementString + " has inappropriate behaviour");
//    }

   //status assertion
//    @And("{string} status should be {string}")
//    public void buttonStatusShouldBe(String elementString, String enabled) {
//        boolean expectedVisiblity = (enabled.equals("enabled"));
//        boolean actualVisibility = electronicContactTab.isEnabled(elementString);
//        softAssert.assertEquals(actualVisibility, expectedVisiblity, "Send Button should be " + enabled);
//
//    }
//    @And("{string} should be mandatory")
//    public void inShouldBeMandatory(String elementString) {
//        boolean actualValue = electronicContactTab.isMandatory(elementString);
//        softAssert.assertTrue(actualValue);
//    }
    @And("{string} should be empty")
    public void inShouldBeEmpty(String elementString) {
        Assertions.assertOnElementText(loginPage.getLocator(elementString),"");
    }

   //user actions
    @When("I click on {string}")
    public void iClickOnInElectronicContactTab(String elementString) {
        loginPage.click(elementString);
    }
    @When("I clear {string} TextBox")
    public void iClearTextBox(String elementString) {
        loginPage.clearText(elementString);
    }
    @And("I type {string} in {string} TextBox")
    public void iTypeInInTextBox(String input, String elementString) {
        input = input.replace('^', ' ');
        loginPage.setText(elementString, input);
    }
}
