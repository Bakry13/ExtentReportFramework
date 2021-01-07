package utilities;

import utilities.actions.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class Assertions {
    public static void assertElementNotExist(By locator) {
        boolean result = ElementActions.checkElementExists(locator);
        try {
            assertFalse(result);
            System.out.println("Assertions passed - Element by locator: [" + locator + "] not exist successfully.");
        } catch (AssertionError e) {
            System.out.println("Assertions failed - Element by locator: [" + locator + "] exist.");
            Assert.fail();
        }
    }

    public static void assertElementExist(By locator) {
        boolean result = ElementActions.checkElementExists(locator);
        try {
            assertTrue(result);
            System.out.println("Assertions passed - Element by locator: [" + locator + "] exist successfully.");
        } catch (AssertionError e) {
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist.");
            Assert.fail();
        }
    }

    public static void assertOnElementText(By locator, String text) {
        ElementActions.waitForElementToBeVisible(locator);
        String elementText = ElementActions.getTextOfElement(locator);
        try {
            assertEquals(elementText, text);
            ElementActions.highlightElementByLocator(locator);
            ElementActions.unhighlightElementByLocator(locator);
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully [" + text + "].");
        } catch (AssertionError e) {
//            System.out.println("Assertions failed - Actual Text: [" + elementText + "] does not match expected text [" + text + "].");
            Assert.fail("Assertions failed - Actual Text: [" + elementText + "] does not match expected text [" + text + "].", e);
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
}