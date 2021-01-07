package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.base.BrowserType;
import utilities.base.TestBase;
import utilities.ConfigUtil;
import utilities.actions.BrowserActions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.common.Paths;

@CucumberOptions(features = {"src/test/java/features/FE"}, glue = {"stepDefinition/fe", "utilities"},
        tags = ("@Test")
        ,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html",
        //"json:test-output/jsonReport/jsonReport.json",
        //"junit:test-output/junitReport/jsonReport.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
       //,plugin = {"pretty","html:cucumber-reports/DefaultReport.html"}
        )

public class FunctionalTestRunner extends TestBase {

//    @BeforeTest
//    public void initialization() {
//        ConfigUtil.loadTestConfigurations();
//        TestBase.setBrowserType(BrowserType.CHROME);
//        BrowserActions.maximizeWindow();
//    }

//    @AfterTest
//    public void tearDown() {
//        BrowserActions.closeBrowser();
//        BrowserActions.quitBrowser();
//    }
}

