package stepDefinition.fe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.fe.CommonPageActions;
import utilities.Assertions;
import utilities.actions.BrowserActions;
import utilities.common.Paths;

public class Login_StepDef extends CommonPageActions
{
    @Given("I open Easy Ticket Portal")
    public void userDeeplinksToTicketingTrackerPortal() {
        login();
    }

    @When("I check login page content")
    public void iCheckPageContent() {
        setPageDataPath(Paths.loginPage);
        System.out.println("Checking Page Content");
    }

    @Then("I {string} see {string} in the page")
    public void iSeeInLoginPage(String visiblity, String elementString) {
        boolean expectedVisiblity = (visiblity.equals("should"));
        Assertions.assertElementVisibility(expectedVisiblity,getLocator(elementString));
    }
    //=================================Second Scenario==================================
    @When("set {string}")
    public void theLanguageIs(String language) {
        setLanguage(language);
    }
    @Then("I should see {string} has the translated text in the page")
    public void iSeeHasThetranslatedText( String elementString) {
        String expectedElementText= getDisplayText(elementString,getLanguage());
        Assertions.assertOnElementText(getLocator(elementString),expectedElementText);
    }
//=========================================================================================
    @And("{string} should be {string}")
    public void inShouldBeEmpty(String elementString,String status) {
        switch (status)
        {
            case "empty":
                Assertions.assertOnElementText(getLocator(elementString),"");
                break;
            case "dimmed":
                Assertions.assertOnElementText(getLocator(elementString),"");
                break;
        }

    }

    @Then("I should see {string} has the text {string} in login page")
    public void iSeeHasTheText( String elementString, String expectedElementText) {
        Assertions.assertOnElementText(getLocator(elementString),expectedElementText);

    }
    //status assertion
    @And("{string} status should be {string}")
    public void buttonStatusShouldBe(String elementString, String enabled) {
        boolean expectedStatus = (enabled.equals("enabled"));
        Assertions.assertElementEnabled(expectedStatus,getLocator(elementString));
    }


    //user actions
    @When("I click on {string}")
    public void iClickOnInElectronicContactTab(String elementString) {
        click(elementString);
    }
    @When("I clear {string} TextBox")
    public void iClearTextBox(String elementString) {clearText(elementString); }
    @And("I type {string} in {string} TextBox")
    public void iTypeInInTextBox(String input, String elementString) {
        input = input.replace('^', ' ');
        System.out.println(elementString+": "+input);
        setText(elementString, input);
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
