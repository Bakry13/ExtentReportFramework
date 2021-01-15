package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = {"src/test/java/features/FE"}, glue = {"stepDefinition/fe", "utilities"}
        //,tags = ("@THOR-229")
        ,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html"
        //,"json:test-output/jsonReport/jsonReport.json"
        //,"junit:test-output/junitReport/jsonReport.xml"
        //,"com.cucumber.listener.ExtentCucumberFormatter:"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        //,plugin = {"pretty","html:cucumber-reports/DefaultReport.html"}
)

public class FunctionalTestRunner extends TestBase {
}