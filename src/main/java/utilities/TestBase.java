package utilities;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utilities.actions.BrowserActions;
import utilities.common.Paths;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static String browserType = "";
    public static WebDriver driver;
    static ChromeOptions chromeOptions = new ChromeOptions();
    static FirefoxOptions firefoxOptions = new FirefoxOptions();
    static DesiredCapabilities ieCapabilities = new DesiredCapabilities();
    static InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//===================================Set Drivers Options and capabilities===========================
    //--------------------------------Driver Options------------------------------------
    public static void setChromeDriverLanguage(String language) {
        switch (language) {
            case "English":
                chromeOptions.addArguments("--lang=en");
                break;
            case "Deutsch":
                chromeOptions.addArguments("--lang=de");
                break;
            case "Arabic":
                chromeOptions.addArguments("--lang=ar");
                break;
            default:
                System.out.println("Undefined language");
        }
    }

    public static void setChromePrefrences() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", Paths.TEST_DOWNLOAD_DIRECTORY);
        chromeOptions.setCapability("prefs", chromePrefs);
        //CICD Integration Properties
        if (ConfigUtil.HEADLESS) chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();
    }

    public static void getChromeDriver() {
        driver = new ChromeDriver(chromeOptions);
    }
//------------------------------------------Firefox options---------------------------------
    public static void setFirefoxCapabilities() {
        WebDriverManager.firefoxdriver().clearPreferences();
        WebDriverManager.firefoxdriver().setup();
    }

    public static void getFirefoxDriver() {
        driver = new FirefoxDriver(chromeOptions);
    }

    //-----------------------------------ie Cababilities-----------------------------------------
    public static void setIeCapabilities() {
        ieCapabilities.setCapability("EnableNativeEvents", true);
        ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ieCapabilities.setCapability("disable-popup-blocking", true);
        ieCapabilities.setCapability("enablePersistentHover", true);
        ieCapabilities.setCapability("ignoreZoomSetting", true);
        ieCapabilities.setCapability("RequireWindowFocus", true);
        ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        WebDriverManager.iedriver().clearPreferences();
        WebDriverManager.iedriver().setup();
    }

    public static void getIeDriver() {
        driver = new InternetExplorerDriver(ieCapabilities);
    }
    //---------------------------------BrowserType-------------------------------------
    @BeforeTest
    @Parameters("Browser")
    public static void setBrowserType(@Optional("Chrome") String Browser) {
        if (Browser.equalsIgnoreCase("Chrome")) {
            setChromePrefrences();
            getChromeDriver();
            browserType ="Chrome";
        } else if (Browser.equalsIgnoreCase("Firefox")) {
            setFirefoxCapabilities();
            getFirefoxDriver();
            browserType ="Firefox";
        }
        else if (Browser.equalsIgnoreCase("IE")) {
            setIeCapabilities();
            getIeDriver();
            browserType ="IE";
        }
        BrowserActions.maximizeWindow();
        ConfigUtil.loadTestConfigurations();
        getDriver().manage().deleteAllCookies();
       // getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public static WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver;
    }
//-----------------------------------Test Cases Annotations--------------------------------
    //@Before
    public static void initialization() {
        BrowserActions.navigateToPage(ConfigUtil.WebSTURL);//get URL
    }


    @AfterTest
    public static void quitDriver() // call this method to get the driver object and launch the browser
    {
        getDriver().quit();
    }
}
