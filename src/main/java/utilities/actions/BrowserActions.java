package utilities.actions;

import utilities.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BrowserActions {

    public static void maximizeWindow() {
        TestBase.getDriver().manage().window().maximize();
    }

    public static void refreshPage() {
        TestBase.getDriver().navigate().refresh();
    }

    public static void closeBrowser() {
        TestBase.getDriver().close();

    }

    public static void quitBrowser() {
        TestBase.quitDriver();

    }

    public static void restoreView() {
        TestBase.getDriver().manage().window().maximize();
        TestBase.getDriver().navigate().refresh();
    }

    public static void navigateToPage(String url) {
        System.out.println(url);
        TestBase.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        TestBase.getDriver().navigate().to(url);
        try {
            TestBase.getDriver().switchTo().alert().accept();
        }
        catch (NoAlertPresentException Ex) {
            System.out.println("no alerts appear");
        }
    }


    //Scrolling
    public static void scrollDownToView(WebElement element) {
        ((JavascriptExecutor) TestBase.getDriver()).
                executeScript("arguments[0].scrollIntoView({behavior:'smooth',block: 'center'});",
                        element);
    }

    public static void scrollToTop() {
        ((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public static void zoomOutOrIn(double percentageIndex) {
        ((JavascriptExecutor) TestBase.getDriver()).executeScript("document.body.style.zoom='" + percentageIndex + "'");
    }

    public static void scrollVertically(int pixels) {
        ((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollBy(0," + pixels + ")", "");

    }

    public static void scrollHorizontally(int pixels) {
        ((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollBy(" + pixels + ",0)");
    }

    public static void scrollDownToBottomOfPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) TestBase.getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Alerts
    public static void approveAlert() {
        TestBase.getDriver().switchTo().alert().accept();
    }

    public static boolean checkIfAlertIsPresent() {
        try {
            TestBase.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //check if window is scrolled up or not (Used to test the back to top button)
    public static boolean isWindowScrolledUp() {
        JavascriptExecutor executor = (JavascriptExecutor) TestBase.getDriver();
        Long value = (Long) executor.executeScript("return window.pageYOffset;");
        if (value == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Get Browser Title
    public static String getBrowserTitle() {
        return TestBase.getDriver().getTitle();
    }

    //Check if window is scrolled down or not
    public static boolean isWindowScrolledDown() {
        JavascriptExecutor executor = (JavascriptExecutor) TestBase.getDriver();
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
        String netData = ((JavascriptExecutor) TestBase.getDriver()).executeScript(scriptToExecute).toString();
        System.out.println(netData);
        return  netData;
    }

   public static void  SetChromeBrowserLanguage(String language)
   {
       TestBase.setChromeDriverPrefrences();
       TestBase.setChromeDriverLanguage(language);
       relaunchBrowser();
   }
   public static void relaunchBrowser()
   {
       BrowserActions.closeBrowser();
       BrowserActions.quitBrowser();
       TestBase.getChromeDriver();
   }
}
