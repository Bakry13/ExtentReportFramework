package utilities;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeTest;
import utilities.common.Paths;
import utilities.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static String captureScreenShot(String screenshotName)
    {
        TakesScreenshot ts = (TakesScreenshot) TestBase.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = Paths.TEST_SCREENSHOTS+screenshotName+".png";
        //Adding time stamp else it will replace the previous screenshots
        try
        {
            FileUtils.copyFile(src, new File(dest));
        }
        catch (IOException e) {
            System.out.println("Failed to get screenshot"+e.getMessage());
            e.printStackTrace();
        }
        return dest;
    }

    @After
    public void takeScreenshot(Scenario scenario) {
        byte[] src = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
        //scenario.embed(src,"image/png");
        scenario.attach(src,"image/png", scenario.getName()+ ".png" );
    }


//    public static String captureScreenShotVisualTest(String testContext)
//    {
//        TakesScreenshot ts = (TakesScreenshot) TestBase.getDriver();
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        String dest = Paths.TEST_ACTUAL_SCREENSHOTS+testContext;
//        //Adding time stamp else it will replace the previous screenshots
//        try
//        {
//            FileUtils.copyFile(src, new File(dest));
//        }
//        catch (IOException e) {
//            System.out.println("Failed to get screenshot"+e.getMessage());
//            e.printStackTrace();
//        }
//        return dest;
//    }
}
