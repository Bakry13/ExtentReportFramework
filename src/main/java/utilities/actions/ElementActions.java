package utilities.actions;

import utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ElementActions extends TestBase {
    public static WebDriverWait wait; //= new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    public static Actions action = new Actions(getDriver());

    public static WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = getDriver().findElement(locator);
            action.moveToElement(element).perform();
            highlightElement(element);
            unhighlightElement(element);
        } catch (Exception e) {
            System.out.println("Element with locator: [" + locator + "] not exist.");
            e.printStackTrace();
        }
        return element;
    }

    //To highlight which button and field the script is currently clicking or typing in
    static public void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('style', 'background: #ffffe6; border: 2px solid yellow;');", element);
    }

    //To remove the highlight
    static public void unhighlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].removeAttribute('style','')", element);
    }
    //=============================================================================
 /*   public static void reloadDriver() {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    }

    public static String findElementTextByIndex(By locator, int index) {
        WebElement element = getDriver().findElements(locator).get(index);
        scrollPageToElement(element);
        highlightElement(element);
        unhighlightElement(element);
        return element.getText();
    }

    public static void clickOnRadioButtonWithIndex(By locator, int index) {
        WebElement element = getDriver().findElements(locator).get(index);
        scrollPageToElement(element);
        highlightElement(element);
        unhighlightElement(element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            forceClickOnElementByLocator(locator);
        }
    }

    public static boolean checkElementExists(By locator) {
        try {
            WebElement webElement = getDriver().findElement(locator);
            highlightElement(webElement);
            unhighlightElement(webElement);
        } catch (NoSuchElementException e) {
            System.out.println("Element with locator: [" + locator + "] not exist.");
            return false;
        }
        return true;
    }

    //To highlight which button and field the script is currently clicking or typing in
    static public void highlightElementByLocator(By locator) {
        try {
            WebElement webElement = getDriver().findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].setAttribute('style', 'background: #ffffe6; border: 2px solid yellow;');", webElement);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException, Trying to highlight element again.");
            WebElement webElement = getDriver().findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].setAttribute('style', 'background: #ffffe6; border: 2px solid yellow;');", webElement);
        }
    }

    //To remove the highlight
    static public void unhighlightElementByLocator(By locator) {
        try {
            WebElement webElement = getDriver().findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].removeAttribute('style','')", webElement);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException, Trying to unhighlight element again.");
            WebElement webElement = getDriver().findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].removeAttribute('style','')", webElement);
        }
    }


    public static boolean waitForElementToBeVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Locator: [" + locator + "] was not found in the DOM.");
            return false;
        }
        return true;
    }

    public static boolean waitForElementTextToBePresent(By locator, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (TimeoutException e) {
            System.out.println("Text in locator: [" + locator + "] not present.");
            return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////Old Methods/////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////

    //wait till specific element disappear (used mainly for loaders)
    public static void checkDisappearanceOf(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is currently located on the ViewPort");
        }
    }

    //Scroll to a specific element using the WebElement
    public static void scrollPageToElement(WebElement element) {
        // ((JavascriptExecutor) WebDriverSingleton.getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);",element);
    }

    //Scroll to a specific element using Locator
    public static void scrollPageToElementByLocator(By locator) {
        checkPresenceOf(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", getDriver().findElement(locator));
    }

    //Return the status of a specific element is viewed or not
    public static boolean isViewed(By locator) {
        WebElement element = retrieveElement(locator);
        Dimension elementSize = element.getSize();
        Point elementLocation = element.getLocation();
        Dimension viewSize = getDriver().manage().window().getSize();

        int x = viewSize.getWidth();
        int y = viewSize.getHeight();
        int elementAbsX = elementSize.getWidth() + elementLocation.getX();
        int elementAbsY = elementSize.getHeight() + elementLocation.getY();

        return elementAbsX <= x && elementAbsY <= y;
    }

    //return the WebElement but wait until it is clickable (can be called only to wait until the element is clickable)
    public static WebElement checkAvailabilityOf(By locator) throws Exception {
        WebElement element = retrieveElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (element.isEnabled()) return element;
        else throw new Exception("Element " + locator.getClass().getName() + " is not interactable");
    }

    //wait till the element appears in the HTML DOM
    public static void checkPresenceOf(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not present on the current DOM");
        }
    }

    public static boolean isElementPresent(By locator) {
        try {
            ExpectedConditions.presenceOfElementLocated(locator);
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not present on the current DOM");
            return false;
        }
        return true;
    }

    //wait till all the elements by the same locator appears in the HTML DOM
    public static void checkPresenceOfAllElements(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not present on the current DOM");
        }
    }

    //wait till the element visibly appear on the window itself
    public static void checkExistenceOf(By locator) {
        checkPresenceOf(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not visible on the current DOM");
        }
    }

    //wait till all the elements with the same locator visibly appear on the window itself
    public static void checkExistenceOfAllElements(By locator) {
        checkPresenceOf(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is not visible on the current DOM");
        }
    }

    //wait till the element is refreshed and not in stall status
    public static void refreshStalenessOf(By locator) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(retrieveElement(locator))));
    }

    //used for drag and drop
    public static void dragAndDrop(By locator1, By locator2) {
        wait.until(ExpectedConditions.elementToBeClickable(locator1));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        action.dragAndDrop(retrieveElement(locator1), retrieveElement(locator2)).build().perform();
    }

    //used to click on an element by locator(includes the scroll and wait)
    public static void clickOnElementByLocator(By locator) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            scrollPageToElement(element);
            highlightElement(element);
            unhighlightElement(element);
            element.click();
        } catch (Exception e) {
            System.out.println("Couldn't click on locator, Please check it.");
            e.printStackTrace();
        }
    }

    //Used to click on an element by web element
    public static void clickOnWebElement(WebElement element) {
        scrollPageToElement(element);
        highlightElement(element);
        unhighlightElement(element);
        element.click();
    }

    //used to force click on element using locator with java script(include scroll and wait)
    public static void forceClickOnElementByLocator(By locator) {
        checkPresenceOf(locator);
        WebElement element = getDriver().findElement(locator);
        scrollPageToElement(element);
        highlightElement(element);
        unhighlightElement(element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);
    }

    //used to force click on element using WebElement with java script(include scroll and wait)
    public static void forceClickOnElement(WebElement element) {
        scrollPageToElement(element);
        highlightElement(element);
        unhighlightElement(element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);
    }

    //Used to add date on calendar field using java script
    public static void setTimer(By locator, String date) {
        WebElement element = retrieveElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value=\'" + date + "\'", element);
    }

    //Some fields have problems with the normal clear() function so in this case use this instead
    public static void overwriteTextField(By locator, String value) {
        try {
            WebElement element = checkAvailabilityOf(locator);
            scrollPageToElement(element);
            highlightElement(element);
            unhighlightElement(element);
            element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //return the checkbox status (true or false)
    public static boolean isCheckBoxChecked(String locatorID) {
        checkPresenceOf(By.id(locatorID));
        return (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return $('#" + locatorID + "').prop('checked')");
    }

    //Type in normal text field
    public static void typeInTextField(By locator, String string) {
        try {
            checkExistenceOf(locator);
            WebElement element = checkAvailabilityOf(locator);
            scrollPageToElement(element);
            highlightElement(element);
            unhighlightElement(element);
            element.clear();
            element.sendKeys(string);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //File upload by Robot Class
    public static void uploadFileWithRobot(String imagePath) {
        StringSelection stringSelection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    ///////////type text
    public static void uploadFile(By locator, String string) {
        try {

            WebElement element = getDriver().findElement(locator);
            element.click();
            Thread.sleep(1000);

            uploadFileWithRobot(string);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //return the text of any element
    public static String getTextOfElement(By locator) {
        try {
            return retrieveElement(locator).getText();
        } catch (StaleElementReferenceException e) {
            return retrieveElement(locator).getText();
        }
    }

    //return specific attribute value for any element
    public static String getAttributeValueOfElement(By locator, String attribute) {
        return retrieveElement(locator).getAttribute(attribute);
    }

    //retrieve WebElement (use to define any WebElement object)
    public static WebElement retrieveElement(By locator) {
        checkExistenceOf(locator);
        return getDriver().findElement(locator);
    }

    //retrieve WebElements (use to define any WebElements list)
    public static List<WebElement> retrieveElements(By locator) {
        checkExistenceOf(locator);
        return getDriver().findElements(locator);
    }

    //retrieve WebElement using xpath with different attributes(use to define any WebElements Object)
    public static WebElement retrieveElementByAttributeValue(String attribute, String value) {
        checkExistenceOf(By.xpath("//*[@" + attribute + "='" + value + "']"));
        return getDriver().findElement(By.xpath("//*[@" + attribute + "='" + value + "']"));
    }

    //Wrapper for using labels for overwriting text fields (Use according to the HTML hierarchy)
    public static void overwriteTextFieldByLabel(String label, String data) {
        By locator = By.xpath("//*[label[text()='" + label + "']]//input");
        overwriteTextField(locator, data);
    }

    //Wrapper for using labels for writing in text fields (Use according to the HTML hierarchy)
    public static void typeInTextFieldByLabel(String Label, String Data) {
        By locator = By.xpath("//*[label[text()='" + Label + "']]//input");
        typeInTextField(locator, Data);
    }

    //Switching to frame
    public static void switchToFrame(By frameLocator) {
        WebElement frame = retrieveElement(frameLocator);
        getDriver().switchTo().frame(frame);
    }

    //Switching to Original frame
    public static void switchToOriginalFrame(By frameLocator) {
        getDriver().switchTo().defaultContent();
    }

    //Wrapper for using labels for writing in text areas (Use according to the HTML hierarchy)
    public static void typeInTextAreaByLabel(String Label, String Data) {
        typeInTextField(By.xpath("//*[label[text()='" + Label + "']]//textarea"), Data);
    }

    //Wrapper for using labels for clicking on elements with overlay label (Use according to the HTML hierarchy)
    public static void clickOnElementWithOverlayLabel(String Label) {
        forceClickOnElementByLocator(By.xpath("//*[self::a or self::input or self::div or self::button][contains(text(),'" + Label + "') or contains(@value,'" + Label + "')]"));
    }

    //Wrapper for using labels to check if element have specific text (Use according to the HTML hierarchy)
    public static void checkElementHaveTextByLabel(String label, String value) {
        By locator = By.xpath("//*[label[text()='" + label + "']]//input");
        checkElementHaveTextByLocator(locator, value);
    }

    //wait till element have specific text
    public static void checkElementHaveTextByLocator(By locator, String value) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(locator, value));
    }

    //click on check box using label (Use according to the HTML hierarchy))
    public static void checkACheckBoxWithLabel(String Label) {
        clickOnElementByLocator(By.xpath("//label[contains(text(),'" + Label + "')]/preceding-sibling::Input"));
    }

    //Wrapper for using labels for clicking on elements with label (Use according to the HTML hierarchy)
    public static void clickOnElementWithLabel(String Label) {
        clickOnElementByLocator(By.xpath("//*[label[text()='" + Label + "']]/*[self::a or self::input or self::div or self::button]"));
    }


    //Wrapper for using labels for selecting an element from dropdown that is not implemented as Select item in the HTML (Use according to the HTML hierarchy)
    public static void selectElementFromLabeledDropdownMenuSwift(String Label, String Selection) {
        selectFromDropDownMenuSwift(By.xpath("//*[label[text()='" + Label + "']]/div"), Selection);
    }

    //Wrapper for using labels for selecting an element force click from dropdown that is not implemented as Select item in the HTML (Use according to the HTML hierarchy)
    public static void selectElementFromLabeledDropdownMenuSwiftForceClick(String Label, String Selection) {
        selectFromDropDownMenuSwiftForceClick(By.xpath("//*[label[text()='" + Label + "']]/div"), Selection);
    }

    //selecting an element force click from dropdown that is not implemented as Select item in the HTML
    public static void selectFromDropDownMenuSwiftForceClick(By locator, String YourSelection) {
        checkExistenceOf(locator);
        forceClickOnElementByLocator(locator);
        searchWithinMenuSwift(locator, YourSelection);
    }

    //selecting an element from dropdown that is not implemented as Select item in the HTML
    public static void selectFromDropDownMenuSwift(By locator, String YourSelection) {
        checkExistenceOf(locator);
        clickOnElementByLocator(locator);
        searchWithinMenuSwift(locator, YourSelection);
    }

    //Searching and selecting item from open dropdown using XPATH
    public static void searchWithinMenuSwift(By locator, String yourSelection) {
        By elementLocator = By.xpath(getSelector(locator).trim() + "//following-sibling::ul//*[self::a or self::input or self::li][contains(text(),'" + yourSelection + "')]");
        clickOnElementByLocator(elementLocator);
    }

    //searching and selecting item from open dropdown selected by label using XPATH(according to HTML hierarchy)
    public static void searchWithinMenuSwiftByLabel(String label, String yourSelection) {
        By elementLocator = By.xpath("//*[label[text()='" + label + "']]/div//following-sibling::ul//*[self::a or self::input or self::li][contains(text(),'" + yourSelection + "')]");
        clickOnElementByLocator(elementLocator);
    }

    //Wrapper for using labels for selecting an element from dropdown that is not implemented as Select item in the HTML (Use according to the HTML hierarchy)
    public static void selectElementFromLabeledDropdownMenuSlow(String Label, String Selection) {
        selectFromDropDownMenuSlow(By.xpath("//*[label[text()='" + Label + "']]/div"), Selection);
    }

    //selecting an element force click from dropdown that is not implemented as Select item in the HTML (Use according to the HTML hierarchy)
    public static void selectFromDropDownMenuSlow(By locator, String YourSelection) {
        checkExistenceOf(locator);
        scrollPageToElementByLocator(locator);
        clickOnElementByLocator(locator);
        searchWithinMenuSlow(locator, YourSelection);
    }

    //search withing dropdown that is not using Select item in the HTML but by looping through all the items in the dropdown
    public static void searchWithinMenuSlow(By locator, String YourSelection) {
        List<WebElement> droppedItems = getDriver().findElements(By.xpath(getSelector(locator).trim() + "//ul//*"));
        for (WebElement item : droppedItems) {
            String text = item.getAttribute("textContent").trim();
            if (text.equalsIgnoreCase(YourSelection)) {
                highlightElement(item);
                unhighlightElement(item);
                BrowserActions.scrollDownToView(item);
                wait.until(ExpectedConditions.visibilityOf(item));
                if (!item.isDisplayed()) System.out.println("Element is not Displayed !!");
                item.click();
                //forceClickOnElement(item);
                break;
            }
        }
    }

    private static String getSelector(By by) {
        return (by.toString().split(":")[1]).trim();
    }

    private static String getLocatingMethod(By by) {
        return by.toString().split(":")[0]; //returns "By.cssSelector", "By.xpath" etc
    }

    //Selecting an element from a dropdown using the normal Select (if the dropdown is implemented as Select in the HTML)
    public static void selectUsingSelectDropDown(By locator, String yourSelection) {
        checkPresenceOf(locator);
        WebElement element = retrieveElement(locator);
        highlightElement(element);
        unhighlightElement(element);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(yourSelection);
    }

    //Hover on a specific element using locator
    public static void hoverOnElement(By locator) {
        WebElement element = retrieveElement(locator);
        scrollPageToElement(element);
        highlightElement(element);
        unhighlightElement(element);
        action.moveToElement(element).build().perform();
    }

    public static boolean isElementClickable(By locator) {
        WebElement element = retrieveElement(locator);
        return (element.isEnabled());
    }

    public static void clearTestBox(By locator) {
        WebElement element = retrieveElement(locator);
        element.clear();
    }

    public static void forceClearTestBox(By locator) {
        WebElement element = retrieveElement(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public static String getDateTime(String dateTime) {

        String date = dateTime.substring(0, dateTime.length() - 1);

        System.out.println("Daaaaattttttttteeee" + date);
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm");

        ZonedDateTime berTime2 = LocalDateTime.parse(date.replace(" ", "T"))
                .atZone(ZoneId.of("Etc/GMT")).withZoneSameInstant(ZoneId.of("Europe/Berlin"));

        System.out.println("Time in Germaney: " + berTime2.format(formatter));
        Reporter.log("Time in Germaney: " + berTime2.format(formatter));
        return berTime2.format(formatter);
    }

    public static boolean isElementenabled(By locator) {
        WebElement element = retrieveElement(locator);
        return element.isEnabled();
    }

    public static String capitalizeFirstChar(String str) {
        String output = "";

// uppercase first letter of each word
        if (str.length() > 1) {
            output = Arrays.stream(str.split("\\s+"))
                    .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                    .collect(Collectors.joining(" "));
        } else {
            output = str.substring(0, 1).toUpperCase() + str.substring(1);
            System.out.println(output);
        }
// print the string
        System.out.println(output);
        System.out.println("String lengthhhhh" + str.length());
        return output;
    }

    public static void takeScreenShot(String imageName) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("/src/test/resources/ActualResultsScreenshots/" + imageName + " - screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}