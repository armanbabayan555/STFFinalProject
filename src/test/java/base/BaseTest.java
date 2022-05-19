package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import setup.DriverUtils;

import java.io.File;
import java.io.IOException;

public abstract class BaseTest {

    @BeforeMethod
    @Parameters("browserName")
    public void startDriver(String browserName) {
        DriverUtils.setDriver(browserName);
        DriverUtils.getDriver().get("https://chronograph.am/");
    }

    @AfterMethod
    protected static void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            var camera = (TakesScreenshot) DriverUtils.getDriver();
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/main/resources/snapshots/" + testResult.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverUtils.quitDriver();
    }
}
