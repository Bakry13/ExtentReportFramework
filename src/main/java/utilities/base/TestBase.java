package utilities.base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.actions.BrowserActions;
import utilities.common.Paths;
import utilities.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    static ChromeOptions options = new ChromeOptions();

//    private TestBase() {
//        // Do-nothing..Do not allow to initialize this class from outside
//    }
//
//    private static TestBase instance = new TestBase();
//
//    public static TestBase getInstance() {
//        //   if (instance == null) instance = new WebDriverSingleton();
//        return instance;
//    }

    public static void focusWindow() {
        driver.switchTo().window(driver.getWindowHandle());
    }

    public static void setChromeDriverLanguage(String language) {
        switch (language) {
            case "English":
                options.addArguments("--lang=en");
                break;
            case "Deutsch":
                options.addArguments("--lang=de");
                break;
            case "Arabic":
                options.addArguments("--lang=ar");
                break;
            default:
                System.out.println("Undefined language");
        }

    }

    public static void setChromeDriverPrefrences() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", Paths.TEST_DOWNLOAD_DIRECTORY);
        options.setCapability("prefs", chromePrefs);
        //CICD Integration Properties
        if (ConfigUtil.HEADLESS) options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();
    }

    public static void getChromeDriver() {
        driver = new ChromeDriver(options);
    }

    public static void setBrowserType(BrowserType type) {
        switch (type) {
            case CHROME:
                String downloadFilepath = "/path/to/download";
                setChromeDriverPrefrences();
                getChromeDriver();
                System.out.println(driver);
                break;

            case IE:
                WebDriverManager.iedriver().clearPreferences();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case EDGE:
                WebDriverManager.iedriver().clearPreferences();
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    @BeforeTest
    public static void initialization() {
        ConfigUtil.loadTestConfigurations();
        TestBase.setBrowserType(BrowserType.CHROME);
        BrowserActions.maximizeWindow();
    }

    public static WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        //String browser = context.getCurrentXmlTest().getParameter("browser");
        //if (browser.equalsIgnoreCase("edge")) return edge.get();
        //else
        //return getInstance().driver;
        return driver;
    }

    @AfterTest
    public static void quitDriver() // call this method to get the driver object and launch the browser
    {
        //String browser = context.getCurrentXmlTest().getParameter("browser");
        //if (browser.equalsIgnoreCase("edge")) return edge.get();
        //else
        getDriver().quit();
        //driver= null;
    }
}
