package utilities;

import utilities.actions.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class Assertions extends ElementActions{
    public static void assertElementNotExist(By locator) {
        boolean elementDisplayed = false;
        try {
            elementDisplayed = goToElementByLocator(locator).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] exist.");
        }
        if (elementDisplayed==true)
        { System.out.println("Assertions passed - Element by locator: [" + locator + "] not exist successfully.");
            Assert.fail();
        }
    }

    public static void assertElementExist(By locator) {
        try {
            assert goToElementByLocator(locator).isDisplayed();
            System.out.println("Assertions passed - Element by locator: [" + locator + "] exist successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist.");
            Assert.fail();
        }
    }

    public static void assertElementEnabled(boolean enabled, By locator) {
        boolean value= false;
        try {
            value  = goToElementByLocator(locator).isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist.");
        }
        if (enabled==value)
            { System.out.println("Status Assertions passed - Element by locator: [" + locator + "] ."); }
        else
            { System.out.println("Status Assertions failed - Element by locator: [" + locator + "].");
            Assert.fail();
            }
    }

    public static void assertOnElementText(By locator, String text) {
        String elementText = null;
            elementText = "";
        try {
            elementText = goToElementByLocator(locator).getText();
            assertEquals(elementText, text);
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does not match expected text successfully.");
            Assert.fail();
        }
    }
/*
    public static void assertElementVisibility(boolean Visibility, By locator) {
        if (Visibility==true)
        {
            assertElementExist(locator);
        }
        else
        {
            assertElementNotExist(locator);
        }
    }

    public static void assertOnElementTextByIndex(By locator, int index, String text) {
        ElementActions.waitForElementToBeVisible(locator);
        String elementText = ElementActions.findElementTextByIndex(locator, index);
        try {
            assertEquals(elementText, text);
            ElementActions.highlightElementByLocator(locator);
            ElementActions.unhighlightElementByLocator(locator);
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully [" + text + "].");
        } catch (AssertionError e) {
            Assert.fail("Assertions failed - Actual Text: [" + elementText + "] does not match expected text [" + text + "].", e);
        }
    }

    public static void assertInlineErrorMessage(String ExpectedText , By locator) {
        String Actual = ElementActions.getTextOfElement(locator);
        Assert.assertEquals(Actual, ExpectedText);
    }
 */
}
