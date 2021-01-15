package utilities.assertions;

import utilities.actions.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class Assertions_FE extends ElementActions{
 //=================================Assert on existance of element=====================
    public static void assertElementExist(By locator) {
        try {
            assert getElement(locator).isDisplayed();
            System.out.println("Assertions passed - Element by locator: [" + locator + "] exist successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist.");
            Assert.fail();
        }
    }

    public static void assertElementNotExist(By locator) {
        try {
            assert getElement(locator).isDisplayed();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist.");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions passed - Element by locator: [" + locator + "] exist successfully.");
        }
    }
//============================assert if element is enabled=================================
    public static void assertElementEnabled(By locator) {
        try {
            assert getElement(locator).isEnabled();
            System.out.println("Status Assertions passed - Element by locator: [" + locator + "] is enabled");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist or disabled.");
            Assert.fail();
        }
    }

    public static void assertElementDisabled(By locator) {
        try {
            assert getElement(locator).isEnabled();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] not exist or disabled.");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions failed - Element by locator: [" + locator + "] is enabled.");
        }
    }
//==============================================================================================
    public static void assertElementText(By locator, String text) {
        String elementText = "";
        try {
            elementText = getElement(locator).getText();
            assertEquals(elementText, text);
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does not match expected text successfully.");
            Assert.fail();
        }
    }
 //==============================================================================================
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
 */
}
