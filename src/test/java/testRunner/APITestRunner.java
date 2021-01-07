package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = {"src/test/java/FeatureFile/API"}, glue = "stepDefinition/api",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"})

public class APITestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void initialization() {
        ConfigUtil.loadTestConfigurations();
    }

    @AfterClass
    public void tearDown() {
    }

}

