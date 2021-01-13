package utilities.actions;

import utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BrowserActions extends TestBase {

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static void closeBrowser() {
        getDriver().close();

    }

    public static void quitBrowser() {
        quitDriver();

    }

    public static void restoreView() {
        getDriver().manage().window().maximize();
        getDriver().navigate().refresh();
    }

    public static void navigateToPage(String url) {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(url);
        getDriver().navigate().to(url);
        try {
            getDriver().switchTo().alert().accept();
        }
        catch (NoAlertPresentException Ex) {
            System.out.println("no alerts appear");
        }
    }


    //Scrolling
    public static void scrollDownToView(WebElement element) {
        ((JavascriptExecutor) getDriver()).
                executeScript("arguments[0].scrollIntoView({behavior:'smooth',block: 'center'});",
                        element);
    }

    public static void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public static void zoomOutOrIn(double percentageIndex) {
        ((JavascriptExecutor) getDriver()).executeScript("document.body.style.zoom='" + percentageIndex + "'");
    }

    public static void scrollVertically(int pixels) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + pixels + ")", "");

    }

    public static void scrollHorizontally(int pixels) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(" + pixels + ",0)");
    }

    public static void scrollDownToBottomOfPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Alerts
    public static void approveAlert() {
        getDriver().switchTo().alert().accept();
    }

    public static boolean checkIfAlertIsPresent() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //check if window is scrolled up or not (Used to test the back to top button)
    public static boolean isWindowScrolledUp() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        Long value = (Long) executor.executeScript("return window.pageYOffset;");
        if (value == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Get Browser Title
    public static String getBrowserTitle() {
        return getDriver().getTitle();
    }

    //Check if window is scrolled down or not
    public static boolean isWindowScrolledDown() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        Object currValueInnerHeightObj = executor.executeScript("return window.innerHeight");
        Object currValueYOffsetObj = executor.executeScript("return window.pageYOffset");
        Object docHeightObj = executor.executeScript("return document.body.scrollHeight");
        Long currValue = 0L;
        Long docHeight = 0L;

        System.out.println(currValueInnerHeightObj.getClass().toString());
        if (currValueInnerHeightObj.getClass().toString().toLowerCase().contains("long")) {
            currValue = (Long) currValueInnerHeightObj;
        } else {
            currValue = Math.round((Double) currValueInnerHeightObj);
        }

        if (currValueYOffsetObj.getClass().toString().toLowerCase().contains("long")) {
            currValue += (Long) currValueYOffsetObj;
        } else {
            currValue += Math.round((Double) currValueYOffsetObj);
        }

        if (docHeightObj.getClass().toString().toLowerCase().contains("long")) {
            docHeight = (Long) docHeightObj;
        } else {
            docHeight = Math.round((Double) docHeightObj);
        }
        currValue++;
        System.out.println();
        System.out.println("currValue: " + currValue);
        System.out.println("docHeight: " + docHeight);
        return currValue >= docHeight;
    }

    public static String getNetworkTabDetails() {
        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
        String netData = ((JavascriptExecutor) getDriver()).executeScript(scriptToExecute).toString();
        System.out.println(netData);
        return  netData;
    }

   public static void  SetChromeBrowserLanguage(String language)
   {
       setChromePrefrences();
       setChromeDriverLanguage(language);
       relaunchBrowser();
   }
   public static void relaunchBrowser()
   {
       BrowserActions.closeBrowser();
       BrowserActions.quitBrowser();
       getChromeDriver();
   }
}
